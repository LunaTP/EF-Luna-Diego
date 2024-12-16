package pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.response;

import pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.dto.CarDto;

import java.util.List;

public record FindCarsResponse(String code,
                               String error,
                               List<CarDto> cars) {
}
