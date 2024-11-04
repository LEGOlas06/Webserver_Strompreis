package at.ac.htlstp.et.sj.webserver_dynamisch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import at.ac.htlstp.et.sj.webserver_dynamisch.model.IndexFormDto;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

    @GetMapping("/index.html")
    public String index(Model model) {
        return home(model);
    }

    @GetMapping("/")
    public String root(Model model) {
        return home(model);
    }

    @GetMapping("/abc")
    public String home(Model model) {
        model.addAttribute("msg", "Hello World!");
        model.addAttribute("data", new IndexFormDto());
        return "index";
    }

    @PostMapping("/res")
    public String formAnser(Model model, @ModelAttribute IndexFormDto data) {
        String feld = data.getFeld();
        System.out.println("Feld: " + feld);
        model.addAttribute("msg", "Antwort auf die Frage");
        model.addAttribute("data", data);
        return "index";
    }


}
