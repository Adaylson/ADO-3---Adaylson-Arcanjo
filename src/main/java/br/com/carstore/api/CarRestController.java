package br.com.carstore.api;

import br.com.carstore.dto.CarDTO;
import br.com.carstore.dto.CarResponseBody;
import br.com.carstore.service.CarServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CarRestController {
    @Autowired
    CarServiceImp service;

    @GetMapping("/cars")
    public ResponseEntity<CarResponseBody> todosCarros(){
        return ResponseEntity.ok(new CarResponseBody(service.findAll()));
    }

    @PostMapping("/cars")
    public ResponseEntity<CarDTO> cadastrarCarro(@RequestBody CarDTO carDTO){
        service.save(carDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("cars/{id}")
    public ResponseEntity<CarDTO> deletarCarro(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("cars/{id}")
    public ResponseEntity<CarDTO> atualizarCarro(@PathVariable String id, CarDTO carDTO){
        carDTO.setId(id);
        service.update(id, carDTO);
        return ResponseEntity.ok(carDTO);
    }
}
