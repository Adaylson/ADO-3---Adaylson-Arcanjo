package br.com.carstore.controller;

import br.com.carstore.dto.CarDTO;
import br.com.carstore.service.CarServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {
    @Autowired
    CarServiceImp service;

    @GetMapping("/admin")
    public String home(Model model){
        model.addAttribute("carDTO", new CarDTO());
        return "index";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/cars")
    public String cadastrarCarro(CarDTO carDTO, BindingResult result){
        service.save(carDTO);

        return "redirect:/admin/cars";
    }

    @GetMapping("/admin/cars/edit")
    public String exibirFormularioEdicao(@RequestParam("id") String id, Model model) {
        // 1. Busca o carro existente no banco
        CarDTO carDTO = service.findById(id);

        // 2. Passa o objeto preenchido para a View
        model.addAttribute("carDTO", carDTO);

        // 3. Retorna o template (certifique-se que o 'index' ou 'form' suporte edição)
        return "index";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/cars/update")
    public String processarAtualizacao(@Valid CarDTO carDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }

        // Aqui sim você salva as alterações
        service.update(carDTO.getId(), carDTO);

        return "redirect:/admin/cars";
    }

    @GetMapping("/admin/cars")
    public String dashboard(Model model){
        model.addAttribute("cars", service.findAll());
        return "dashboard";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/cars/delete")
    public String deleteCar(@RequestParam("id") String id, Model model) {
        service.delete(id);

        return "redirect:/admin/cars";
    }
}
