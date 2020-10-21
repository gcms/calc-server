package br.edu.ifg.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculadoraController {

    @GetMapping("/calcmvc/")
    public String soma(@RequestParam("a") int a, @RequestParam("b") int b, ModelMap model) {
        model.put("soma", a + b);

        return "calculadora/calc-mvc";
    }
}