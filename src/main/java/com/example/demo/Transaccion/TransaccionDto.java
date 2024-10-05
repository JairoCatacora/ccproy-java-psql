package com.example.demo.Transaccion;

import com.example.demo.TipoTransaccion.TipoTransaccion;
import com.example.demo.TipoTransaccion.TipoTransaccionDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransaccionDto {
    private Long id;
    private double monto;
    private LocalDateTime fecha;
    private String estado;
    private TipoTransaccionDto tipoTransaccionDto;
}
