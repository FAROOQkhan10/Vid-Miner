<div align="center">

# ⛏️ Vid Miner

**Crack open any YouTube video.**

Paste a link and pull out the title, view count, likes, comments, and thumbnail — in one go. No sign-in, no API key of your own.

[![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=flat-square&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat-square&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=flat-square&logo=thymeleaf&logoColor=white)](https://www.thymeleaf.org/)
[![YouTube Data API](https://img.shields.io/badge/YouTube%20Data%20API-v3-FF0000?style=flat-square&logo=youtube&logoColor=white)](https://developers.google.com/youtube/v3)
[![License](https://img.shields.io/badge/license-MIT-black?style=flat-square)](#license)

</div>

---

## What it does

Vid Miner takes any public YouTube video URL and digs up everything worth knowing about it — title, channel, description, view count, likes, comments, and the max-res thumbnail — rendered on a clean results page. No Google sign-in, no OAuth flow, no need to bring your own API key. Paste a link, hit **Dig In**, done.

<div align="center">
<img src="https://raw.githubusercontent.com/FAROOQkhan10/Vid-Miner/main/assets/img1.png" width="85%" alt="Vid Miner home screen" />
<br/><em>Home — paste a link and dig</em>
<br/><br/>
<img src="https://raw.githubusercontent.com/FAROOQkhan10/Vid-Miner/main/assets/img2.png" width="85%" alt="Vid Miner result screen" />
<br/><em>Result — everything pulled out in one card</em>
</div>

---

## ✨ Features

- 🔗 **One-paste lookup** — drop in any YouTube video URL, no formatting required
- ⛏️ **Full metadata dig** — title, channel name, description, view/like/comment counts
- 🖼️ **Max-res thumbnail** — viewable and downloadable straight from the result card
- 📋 **Copy description** — one click to copy the full video description to your clipboard
- 🔢 **Human-readable stats** — large numbers auto-abbreviate (e.g. `1.2M`, `48K`)
- 🔁 **Dig again** — search another link directly from the results page, no need to go back
- ⚡ **Zero setup for users** — no sign-in, no personal API key required
- 🎨 **Neubrutalist UI** — bold borders, hard drop-shadows, and loud color blocking throughout
- 🚫 **Graceful failures** — dedicated 404 and error states when a link doesn't resolve

---

## 🛠️ Tech Stack

| Layer       | Tech |
|-------------|------|
| Backend     | Java, Spring Boot |
| Templating  | Thymeleaf |
| Data Source | YouTube Data API v3 |
| Frontend    | HTML, CSS, vanilla JS |
| Icons       | [Ionicons](https://ionic.io/ionicons) |
| Fonts       | [Anton](https://fonts.google.com/specimen/Anton) & [Space Grotesk](https://fonts.google.com/specimen/Space+Grotesk) (Google Fonts) |

---

## 📂 Project Structure

```
vid-miner/
├── src/main/java/com/farooq/vid_miner/
│   ├── controller/
│   │   └── YoutubeController.java     # Handles / and /video routes
│   ├── model/
│   │   ├── dto/
│   │   │   └── RequestUrl.java        # Incoming video URL payload
│   │   └── VideoResponse.java         # Mapped YouTube API response
│   ├── service/
│   │   └── YoutubeService.java        # Talks to the YouTube Data API
│   └── VidMinerApplication.java       # Spring Boot entry point
├── src/main/resources/
│   ├── static/
│   │   ├── home.css / home.js
│   │   ├── result.css / result.js
│   │   ├── 404.css
│   │   └── apple-touch-icon.png
│   ├── templates/
│   │   ├── home.html                  # Landing page
│   │   ├── result.html                # Results page
│   │   ├── 404.html                   # No results found (fragment)
│   │   └── error.html                 # Generic error page
│   └── application.properties
└── pom.xml
```

---

## 🚀 Getting Started

### Prerequisites

- Java 17 or later
- Maven
- A [YouTube Data API v3](https://console.cloud.google.com/apis/library/youtube.googleapis.com) key

### 1. Clone the repo

```bash
git clone https://github.com/FAROOQkhan10/vid-miner.git
cd vid-miner
```

### 2. Add your API key

In `src/main/resources/application.properties`:

```properties
youtube.api.key=YOUR_YOUTUBE_DATA_API_KEY
```

> Get a free key from the [Google Cloud Console](https://console.cloud.google.com/) — enable the **YouTube Data API v3** on your project first.

### 3. Run it

```bash
./mvnw spring-boot:run
```

The app will start on **http://localhost:8080**.

### 4. Dig in

Open the app in your browser, paste a YouTube video URL, and hit **Dig In**.

---

## 🔍 How it works

1. You paste a video URL and submit the form (`POST /video`), captured as a `RequestUrl` DTO.
2. `YoutubeController` passes the URL to `YoutubeService`, which extracts the video ID and calls the YouTube Data API.
3. Snippet and statistics data (title, channel, description, thumbnails, views, likes, comments) come back mapped into a `VideoResponse`.
4. Thymeleaf renders the result cards from that response; if nothing is found, the app falls back to a friendly 404 state.

---

## 🗺️ Roadmap

- [ ] Batch lookups — mine multiple links at once
- [ ] Export results as JSON / CSV
- [ ] Playlist support
- [ ] Dark mode

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome. Feel free to check the [issues page](https://github.com/FAROOQkhan10/vid-miner/issues) or open a PR.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/amazing-thing`)
3. Commit your changes (`git commit -m 'Add amazing thing'`)
4. Push to the branch (`git push origin feature/amazing-thing`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.

---

## 👤 Author

**Mohammad Farooq**

[![GitHub](https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=github&logoColor=white)](https://github.com/FAROOQkhan10)
[![YouTube](https://img.shields.io/badge/YouTube-FF0000?style=flat-square&logo=youtube&logoColor=white)](https://www.youtube.com/@CodeZipper12)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?style=flat-square&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/mohammad-farooq-a40b891b3/)

<div align="center">
<sub>If Vid Miner helped you dig something up, consider ⭐ starring the repo.</sub>
</div>
