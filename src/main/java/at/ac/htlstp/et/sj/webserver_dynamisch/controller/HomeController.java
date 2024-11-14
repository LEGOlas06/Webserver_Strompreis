package at.ac.htlstp.et.sj.webserver_dynamisch.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import at.ac.htlstp.et.sj.webserver_dynamisch.model.IndexFormDto;
import at.ac.htlstp.et.sj.webserver_dynamisch.model.IndexFormDto2;
import at.ac.htlstp.et.sj.webserver_dynamisch.model.IndexFormDto3;
import at.ac.htlstp.et.sj.webserver_dynamisch.model.CombinedData;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/index.html")
    public String root(Model model) {
        return home(model);
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("data", new CombinedData());
        return "index";
    }

    @GetMapping("/abc")
    public String home(Model model) {
        model.addAttribute("msg", "Hello World!");
        model.addAttribute("data", new IndexFormDto("xx"));
        model.addAttribute("msg2", "Hello World!");
        model.addAttribute("data2", new IndexFormDto2("yy"));
        model.addAttribute("msg3", "Hello World!");
        model.addAttribute("data3", new IndexFormDto3("zz"));

        return "index";

    }

    @PostMapping("/res")
    public String handleForm(@ModelAttribute CombinedData data, Model model) {
        // Process the data
        System.out.println("Feld: " + data.getFeld());
        System.out.println("Feld2: " + data.getFeld2());
        System.out.println("Feld3: " + data.getFeld3());

        model.addAttribute("msg", "Form submitted");
        model.addAttribute("data", data);
        return "index";
    }


}
