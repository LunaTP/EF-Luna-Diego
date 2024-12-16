package pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.dto.CarDetailDto;
import pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.dto.CarDto;
import pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.dto.CarUpdateDto;
import pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.entity.Car;
import pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.repository.CarRepository;
import pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.service.ManageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {

        List<CarDto> carsDtos = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();

        iterable.forEach(car ->{
            CarDto dto = new CarDto(
                    car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getLicensePlate(),
                    car.getColor()
            );
            carsDtos.add(dto);
        });
        return carsDtos;

    }

    @Override
    public Optional<CarDetailDto> getCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car ->
            new CarDetailDto(
                    car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getYear(),
                    car.getLicensePlate(),
                    car.getOwnerName(),
                    car.getEngineType(),
                    car.getColor(),
                    car.getInsuranceCompany(),
                    car.getRegistrationExpirationDate()
                    )
        );

    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {

        Optional<Car> optional =carRepository.findById(carDto.carId());
        return optional.map(car ->{
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setLicensePlate(carDto.licensePlate());
            car.setColor(carDto.color());
            carRepository.save(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean deleteCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean addCar(CarUpdateDto carUpdateDto) throws Exception {

        Optional<Car> optionalCar = carRepository.findById(carUpdateDto.id());
        if (optionalCar.isPresent()) {
            return false;
        } else{
            Car car = new Car();
            car.setMake(carUpdateDto.make());
            car.setModel(carUpdateDto.model());
            car.setYear(carUpdateDto.year());
            car.setVin(carUpdateDto.vin());
            car.setLicensePlate(carUpdateDto.licensePlate());
            car.setOwnerName(carUpdateDto.ownerName());
            car.setOwnerContact(carUpdateDto.ownerContact());
            car.setPurchaseDate(carUpdateDto.purchaseDate());
            car.setMileage(carUpdateDto.mileage());
            car.setEngineType(carUpdateDto.engineType());
            car.setColor(carUpdateDto.color());
            car.setInsuranceCompany(carUpdateDto.insuranceCompany());
            car.setInsurancePolicyNumber(carUpdateDto.insurancePolicyNumber());
            car.setRegistrationExpirationDate(carUpdateDto.registrationExpirationDate());
            car.setServiceDueDate(carUpdateDto.serviceDueDate());
            carRepository.save(car);
            return true;
        }

    }
}
