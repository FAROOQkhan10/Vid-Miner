package com.farooq.vid_miner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.farooq.vid_miner.model.VideoResponse;
import com.farooq.vid_miner.model.dto.RequestUrl;
import com.farooq.vid_miner.service.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Controller
public class YoutubeController {

     @Autowired
     private YoutubeService _youtubeService;

    @GetMapping("/")
    public String home() {
        return "home";
    }
     @PostMapping("/video")
     public String getInfo(@RequestParam("videoUrl") String videoUrl, Model model){
         try{
             VideoResponse response = _youtubeService.getInfo(videoUrl);
             model.addAttribute("response", response);
            // return new ResponseEntity<>(response,HttpStatus.OK);
             return "result";
         }
         catch (Exception e) {
            // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
             return "error";
         }
     }



}
