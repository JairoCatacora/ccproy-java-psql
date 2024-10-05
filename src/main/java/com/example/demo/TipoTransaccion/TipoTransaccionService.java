package com.example.demo.TipoTransaccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoTransaccionService {
    @Autowired
    private TipoTransaccionRepository tipoTransaccionRepository;

    public List<String> getAllTipos(){
        List<String> res = new ArrayList<>();

        List<TipoTransaccion> tiposTransaccion = (List<TipoTransaccion>) tipoTransaccionRepository.findAll();
        for (TipoTransaccion tipoTransaccion : tiposTransaccion) {
            if (res.contains(tipoTransaccion.getTipo())) {
                res.add(tipoTransaccion.getTipo());
            }
        }
        return res;
    }
}
