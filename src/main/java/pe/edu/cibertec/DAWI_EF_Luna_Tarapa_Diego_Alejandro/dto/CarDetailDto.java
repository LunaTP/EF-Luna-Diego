package pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.dto;

import java.util.Date;

public record CarDetailDto(Integer carId,
                           String make,
                           String model,
                           Integer year,
                           String licensePlate,
                           String ownerName,
                           String engineType,
                           String color,
                           String insuranceCompany,
                           Date registrationExpirationDate) {
}
