package com.farooq.vid_miner.service;

import com.farooq.vid_miner.model.VideoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class YoutubeService {

    @Value("${youtube.apiKey}")
    private String API_KEY;


    public VideoResponse getInfo(String videoUrl) {
        String videoId = extractVideoId(videoUrl);
        String url = String.format("https://www.googleapis.com/youtube/v3/videos?id=%s&key=%s&part=snippet,statistics&fields=items(id,snippet,statistics)", videoId, API_KEY);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, VideoResponse.class);
    }

    private static final Pattern YOUTUBE_VIDEO_ID_PATTERN = Pattern.compile(
            "(?:youtu\\.be/|youtube\\.com/(?:shorts/|v/|u/\\w/|embed/|watch\\?v=|&v=))([^#&?]{11})",
            Pattern.CASE_INSENSITIVE
    );

    private String extractVideoId(String url) {
        Matcher matcher = YOUTUBE_VIDEO_ID_PATTERN.matcher(url);
        return matcher.find()?matcher.group(1):"";
    }

}
