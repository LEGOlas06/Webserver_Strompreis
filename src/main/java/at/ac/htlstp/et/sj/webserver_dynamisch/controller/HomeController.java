package at.ac.htlstp.et.sj.webserver_dynamisch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import at.ac.htlstp.et.sj.webserver_dynamisch.model.IndexFormDto;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/index.html")
        return home(model);
    }

    @GetMapping("/")
    }

    @GetMapping("/abc")
    public String home(Model model) {
        model.addAttribute("msg", "Hello World!");
        return "index";
    }

    @PostMapping("/res")
        model.addAttribute("data", data);
        return "index";
    }


}
