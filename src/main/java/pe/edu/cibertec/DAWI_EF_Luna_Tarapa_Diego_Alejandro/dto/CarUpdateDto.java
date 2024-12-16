package pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.dto;

import java.util.Date;

public record CarUpdateDto(
        Integer id,
        String make,
        String model,
        Integer year,
        String vin,
        String licensePlate,
        String ownerName,
        String ownerContact,
        Date purchaseDate,
        Integer mileage,
        String engineType,
        String color,
        String insuranceCompany,
        String insurancePolicyNumber,
        Date registrationExpirationDate,
        Date serviceDueDate
) {
}
