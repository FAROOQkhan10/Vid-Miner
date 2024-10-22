package com.farooq.vid_miner.service;

import com.farooq.vid_miner.model.VideoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YoutubeService {

    private final String API_KEY = "AIzaSyCrryL0X98vmx0_MxF0A6XD109Fezu-wSo";


    public VideoResponse getInfo(String videoUrl) {
        String videoId = extractVideoId(videoUrl);
        String url = String.format("https://www.googleapis.com/youtube/v3/videos?id=%s&key=%s&part=snippet,statistics&fields=items(id,snippet,statistics)", videoId, API_KEY);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, VideoResponse.class);
    }


    private String extractVideoId(String videoUrl) {
        return videoUrl.substring(videoUrl.lastIndexOf('=')+1);
    }

}
