package br.com.carstore.controller;

import br.com.carstore.dto.CarDTO;
import br.com.carstore.service.CarServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarController {
    @Autowired
    CarServiceImp service;

    @GetMapping("/admin")
    public String home(Model model){
        model.addAttribute("carDTO", new CarDTO());
        return "index";
    }

    @PostMapping("/cars")
    public String cadastrarCarro(CarDTO carDTO, BindingResult result){
        service.save(carDTO);

        return "redirect:/admin/cars";
    }

    @GetMapping("/admin/cars")
    public String dashboard(Model model){
        model.addAttribute("cars", service.findAll());
        return "dashboard";
    }
}
