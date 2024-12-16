package pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.response;

import pe.edu.cibertec.DAWI_EF_Luna_Tarapa_Diego_Alejandro.dto.CarDetailDto;

public record FindCarResponse(String code,
                              String error,
                              CarDetailDto carDetailDto) {
}
