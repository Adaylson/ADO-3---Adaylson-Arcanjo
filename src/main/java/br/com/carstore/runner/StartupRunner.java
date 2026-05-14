package br.com.carstore.runner;

import br.com.carstore.dao.CarDao;
import br.com.carstore.dto.CarDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final CarDao carDao;

    public StartupRunner(CarDao carDao) {

        this.carDao = carDao;

    }

    @Override
    public void run(String... args) throws Exception {

        CarDTO carOne = new CarDTO();
        carOne.setNome("Gol");
        carOne.setCor("Branco");
        carOne.setMarca("Volkswagen");
        carDao.save(carOne);

        CarDTO carTwo= new CarDTO();
        carTwo.setNome("Civic");
        carTwo.setCor("Civic");
        carTwo.setMarca("Honda");
        carDao.save(carTwo);

        System.out.println(carDao.findAll());

    }

}