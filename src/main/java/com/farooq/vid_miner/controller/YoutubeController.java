package com.farooq.vid_miner.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.farooq.vid_miner.model.VideoResponse;
import com.farooq.vid_miner.service.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Controller
public class YoutubeController {

     @Autowired
     private YoutubeService _youtubeService;

     @Autowired
     private HttpSession httpSession;

    @GetMapping("/")
    public String home() {
        return "home";
    }
    
    @PostMapping("/video")
    public String getInfo(@RequestParam("videoUrl") String videoUrl, Model model){
     try{
         VideoResponse response = _youtubeService.getInfo(videoUrl);
         model.addAttribute("response", response);
         httpSession.setAttribute("response",response);
         return "result";
     }
     catch (Exception e) {
         return "error";
     }
    }

    @GetMapping("/video")
    public String showInfo(Model model){
        try{
             VideoResponse response = (VideoResponse) httpSession.getAttribute("response");
             model.addAttribute("response", response);
             return "result";
         }
        catch (Exception e) {
             return "error";
        }
    }

}
