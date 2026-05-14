package br.com.carstore.service;

import br.com.carstore.dto.CarDTO;

import java.util.List;

public interface CarService {
    List<CarDTO> findAll();

    void save(CarDTO carDTO);

    void update(String id, CarDTO carDTO);

    void delete(String id);

    CarDTO findById(String id);
}
