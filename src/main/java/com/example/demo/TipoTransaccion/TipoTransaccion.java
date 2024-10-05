package com.example.demo.TipoTransaccion;

import com.example.demo.Transaccion.Transaccion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class TipoTransaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String descripcion;

    @OneToOne(mappedBy = "tipoTransaccion")
    private Transaccion transaccion;
}
