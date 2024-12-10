package com.mrlaksus.lab8.Controller;

import com.mrlaksus.lab8.Service.PhotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("photos", photoService.getAllPhotos());
        return "index";
    }

    @PostMapping("/upload")
    public String uploadPhoto(@RequestParam("file") MultipartFile file) {
        try {
            photoService.uploadPhoto(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
