package com.example.demo.Transaccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController {
    @Autowired
    private TransaccionService transaccionService;

    @GetMapping("/all")
    public ResponseEntity<List<TransaccionDto>> getTransacciones(){
        List<TransaccionDto> transacciones = transaccionService.getTransaccionesDto(null);
        return new ResponseEntity<>(transacciones, HttpStatus.OK);
    }

    @GetMapping("/me")
    public ResponseEntity<List<TransaccionDto>> getTransaccionesById(@RequestBody List<Long> ids){
        List<TransaccionDto> transacciones = transaccionService.getTransaccionesDto(ids);
        return new ResponseEntity<>(transacciones, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<TransaccionDto> createTransaccion(@RequestBody TransaccionDto transaccionDto){
        transaccionService.createTransaccion(transaccionDto);
        return new ResponseEntity<>(transaccionDto, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<TransaccionDto> updateTransaccion(@RequestBody TransaccionDto transaccionDto){
        transaccionService.updateTransaccion(transaccionDto);
        return new ResponseEntity<>(transaccionDto, HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteTransaccion(@RequestBody Long id){
        transaccionService.deleteTransaccion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
