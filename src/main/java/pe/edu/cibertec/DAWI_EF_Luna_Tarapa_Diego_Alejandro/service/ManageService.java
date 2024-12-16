package pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.service;

import pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.dto.CarDetailDto;
import pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.dto.CarDto;
import pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.dto.CarUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarUpdateDto carUpdateDto) throws Exception;

}
