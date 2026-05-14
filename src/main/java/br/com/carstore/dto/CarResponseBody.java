package br.com.carstore.dto;

import java.util.List;

public class CarResponseBody {
    private List<CarDTO> carDTOList;

    public CarResponseBody(List<CarDTO> carDTOList) {
        this.carDTOList = carDTOList;
    }

    public List<CarDTO> getCarDTOList() {
        return carDTOList;
    }

    public void setCarDTOList(List<CarDTO> carDTOList) {
        this.carDTOList = carDTOList;
    }
}
