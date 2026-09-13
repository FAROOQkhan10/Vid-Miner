(function () {
    const overlay = document.getElementById("processingOverlay");
    const textEl = document.getElementById("processingText");
    const forms = document.querySelectorAll('form[action="/video"]');

    if (!overlay || forms.length === 0) return;

    const messages = [
        "Cracking open the link\u2026",
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

            // safety net in case navigation stalls or fails silently
            setTimeout(() => clearInterval(cycle), 20000);
        });
    });
})();