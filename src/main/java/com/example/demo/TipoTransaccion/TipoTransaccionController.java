package com.example.demo.TipoTransaccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipoTransaccion")
public class TipoTransaccionController {
    @Autowired
    private TipoTransaccionService tipoTransaccionService;

    @GetMapping("/all")
    public List<String> getAllTipos(){
        return tipoTransaccionService.getAllTipos();
    }
}
