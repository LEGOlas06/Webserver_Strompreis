package at.ac.htlstp.et.sj.webserver_dynamisch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import at.ac.htlstp.et.sj.webserver_dynamisch.model.CombinedData;
import at.ac.htlstp.et.sj.webserver_dynamisch.calculation.RechtwinkeligesDreieck;

import java.util.Locale;

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
        model.addAttribute("data", new CombinedData());
        return "index";
    }

    @PostMapping("/res")
    public String handleForm(@ModelAttribute CombinedData data, Model model, Locale locale) {
        try {
            int feld = Integer.parseInt(data.getFeld());
            int feld2 = Integer.parseInt(data.getFeld2());
            int feld3 = Integer.parseInt(data.getFeld3());

            if (feld < 0 || feld2 < 0 || feld3 < 0 || (feld == 0 && feld2 == 0) || (feld == 0 && feld3 == 0) || (feld2 == 0 && feld3 == 0) || feld3 < feld && feld2 == 0 || feld3 < feld2 && feld == 0) {
                model.addAttribute("msg", "Invalid input: Please enter positive numbers");
                model.addAttribute("data", data);
                return "index";
            }

            if (feld >= 0 && feld2 >= 0 && feld3 == 0) {
                double hypotenuse = RechtwinkeligesDreieck.calculateHypotenuse(feld, feld2);
                model.addAttribute("msg1", "Seite A : " + feld);
                model.addAttribute("msg2", "Seite B : " + feld2);
                model.addAttribute("msg3", "Seite C : " + hypotenuse);
                model.addAttribute("msg", "Calculation successful");
                model.addAttribute("data", data);
                return "index";
            } else if (feld >= 0 && feld2 == 0 && feld3 >= 0 && feld3 > feld) {
                double side1 = RechtwinkeligesDreieck.calculateSide(feld3, feld);
                model.addAttribute("msg1", "Seite A : " + feld);
                model.addAttribute("msg2", "Seite B : " + side1);
                model.addAttribute("msg3", "Seite C : " + feld3);
            } else if (feld == 0 && feld2 >= 0 && feld3 >= 0 && feld3 > feld2) {
                double side2 = RechtwinkeligesDreieck.calculateSide(feld3, feld2);
                model.addAttribute("msg1", "Seite A : " + side2);
                model.addAttribute("msg2", "Seite B : " + feld2);
                model.addAttribute("msg3", "Seite C : " + feld3);
            }

            model.addAttribute("msg", "Calculation successful");
        } catch (NumberFormatException e) {
            model.addAttribute("msg", "Invalid input: Please enter valid numbers");
        }
        model.addAttribute("data", data);
        return "index";
    }
}