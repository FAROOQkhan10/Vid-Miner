(function () {
    function abbreviateNumber(n) {
        const units = [
            { value: 1e9, suffix: "B" },
            { value: 1e6, suffix: "M" },
            { value: 1e3, suffix: "K" }
        ];
        for (let idx = 0; idx < units.length; idx++) {
            const unit = units[idx];
            if (Math.abs(n) >= unit.value) {
                let scaled = n / unit.value;
                let display = scaled < 10 ? Math.round(scaled * 10) / 10 : Math.round(scaled);
                if (display >= 1000 && idx > 0) {
                    return abbreviateNumber(display * unit.value);
                }
                return (Number.isInteger(display) ? display : display.toFixed(1)) + unit.suffix;
            }
        }
        return String(n);
    }

    document.querySelectorAll(".card__subtitle .stat-item span").forEach(span => {
        const raw = span.textContent.trim();
        const num = Number(raw);
        if (!raw || Number.isNaN(num)) return;

        span.textContent = abbreviateNumber(num);
        span.setAttribute("title", num.toLocaleString());
    });
})();

document.querySelectorAll(".copy").forEach(copyButton => {
    copyButton.addEventListener("click", () => {
        const targetElement = document.querySelector(copyButton.dataset.copy);
        if (!targetElement) return;

        const textToCopy = targetElement.textContent.replace(/\s+/g, " ").trim();

        navigator.clipboard.writeText(textToCopy).then(() => {
            const label = copyButton.querySelector(".copy-label");
            const icon = copyButton.querySelector(".copy-icon");
            const originalText = label.textContent;
            const originalIcon = icon ? icon.getAttribute("name") : null;

            copyButton.disabled = true;
            label.textContent = "Copied";
            if (icon) icon.setAttribute("name", "checkmark-outline");

            setTimeout(() => {
                copyButton.disabled = false;
                label.textContent = originalText;
                if (icon && originalIcon) icon.setAttribute("name", originalIcon);
            }, 1200);
        });
    });
});

(function () {
    const overlay = document.getElementById("processingOverlay");
    const textEl = document.getElementById("processingText");
    const forms = document.querySelectorAll('form[action="/video"]');

    if (!overlay || forms.length === 0) return;

    const messages = [
        "Digging up the new link\u2026",
        "Pulling the title and stats\u2026",
        "Grabbing the thumbnail\u2026",
        "Almost there\u2026"
    ];

    forms.forEach(form => {
        form.addEventListener("submit", () => {
            const input = form.querySelector('input[name="videoUrl"]');
            if (input && !input.value.trim()) return;

            overlay.classList.add("is-active");
            let i = 0;
            const cycle = setInterval(() => {
                i = (i + 1) % messages.length;
                if (textEl) textEl.textContent = messages[i];
            }, 1100);

            setTimeout(() => clearInterval(cycle), 20000);
        });
    });
})();