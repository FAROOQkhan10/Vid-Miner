package com.farooq.vid_miner.service;

import com.farooq.vid_miner.model.VideoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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


    private String extractVideoId(String url) {

        // Handle youtu.be format
        if (url.contains("youtu.be/")){
            int index = url.lastIndexOf("/");
            return url.substring(index + 1).split("[?&#]")[0];
        }

        // Handle youtube.com/watch?v= format
        int vIndex = url.indexOf("v=");
        return url.substring(vIndex + 2).split("[&?#]")[0];
    }

}
