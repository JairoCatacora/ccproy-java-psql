package com.example.demo.Transaccion;

import com.example.demo.TipoTransaccion.TipoTransaccion;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double monto;
    private LocalDateTime fecha;
    private String estado;

    @OneToOne
    @JoinColumn(name = "id_tipo_transaccion")
    private TipoTransaccion tipoTransaccion;
}
