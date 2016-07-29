package org.bhc.web.controllers;

import org.bhc.persistance.models.Walk;
import org.bhc.persistance.repository.WalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Created by careys on 11/07/2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    public static final String ROOT = "upload-dir";

    @Autowired
    private WalkRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    String landingPage() {
        return "admin/index";
    }

    @RequestMapping("/addwalk")
    String addWalkPage(Model model)
    {
        Walk walk = new Walk();

        model.addAttribute("walk",walk);
        return "admin/addwalk";
    }

    @RequestMapping(value = "/processWalk", method=RequestMethod.POST)
    public String processForm(@ModelAttribute(value="walk") Walk walk) {

        repository.save(walk);

        return "admin/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/uploadForm")
    public String provideUploadInfo(Model model) throws IOException {
        return "admin/uploadForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/uploadForm")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (!file.isEmpty()) {
            try {
                Files.copy(file.getInputStream(), Paths.get(ROOT, file.getOriginalFilename()));
                redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded " + file.getOriginalFilename() + "!");
            } catch (IOException |RuntimeException e) {
                redirectAttributes.addFlashAttribute("message", "Failued to upload " + file.getOriginalFilename() + " => " + e.getMessage());
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "Failed to upload " + file.getOriginalFilename() + " because it was empty");
        }

        return "redirect:/admin/uploadForm";
    }
}
