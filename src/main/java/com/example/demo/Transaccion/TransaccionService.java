package com.example.demo.Transaccion;

import com.example.demo.TipoTransaccion.TipoTransaccion;
import com.example.demo.TipoTransaccion.TipoTransaccionDto;
import com.example.demo.TipoTransaccion.TipoTransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransaccionService {
    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private TipoTransaccionRepository tipoTransaccionRepository;

    public List<Transaccion> getTransacciones(){
        return transaccionRepository.findAll();
    }

    public List<TransaccionDto> getTransaccionesDto( List<Long> transaccionesids){
        List<TransaccionDto> res = new ArrayList<>();

        for (Long transaccionid : transaccionesids) {
            Transaccion transaccion = transaccionRepository.findById(transaccionid).get();
            TransaccionDto transaccionDto = new TransaccionDto();
            transaccionDto.setId(transaccion.getId());
            transaccionDto.setMonto(transaccion.getMonto());
            transaccionDto.setFecha(transaccion.getFecha());
            transaccionDto.setEstado(transaccion.getEstado());

            TipoTransaccion tipoTransaccion = transaccion.getTipoTransaccion();
            TipoTransaccionDto tipoTransaccionDto = new TipoTransaccionDto();
            tipoTransaccionDto.setId(tipoTransaccion.getId());
            tipoTransaccionDto.setTipo(tipoTransaccion.getTipo());
            tipoTransaccionDto.setDescripcion(tipoTransaccion.getDescripcion());

            transaccionDto.setTipoTransaccionDto(tipoTransaccionDto);
            res.add(transaccionDto);
        }

        return res;
    }

    public void createTransaccion(TransaccionDto transaccionDto){
        Transaccion transaccion = new Transaccion();
        transaccion.setId(transaccionDto.getId());
        transaccion.setMonto(transaccionDto.getMonto());
        transaccion.setFecha(transaccionDto.getFecha());

        TipoTransaccion tipoTransaccion = tipoTransaccionRepository.findById(transaccionDto.getTipoTransaccionDto().getId()).get();

        if (tipoTransaccion != null) {
            tipoTransaccion.setTipo(transaccionDto.getTipoTransaccionDto().getTipo());
            tipoTransaccion.setDescripcion(transaccionDto.getTipoTransaccionDto().getDescripcion());
            transaccion.setTipoTransaccion(tipoTransaccion);

            transaccionRepository.save(transaccion);
        }
        throw new IllegalArgumentException("El tipo de transaccion no existe");
    }

    public void updateTransaccion(TransaccionDto transaccionDto){
        Transaccion transaccion = transaccionRepository.findById(transaccionDto.getId()).get();
        transaccion.setMonto(transaccionDto.getMonto());
        transaccion.setFecha(transaccionDto.getFecha());
        transaccion.setEstado(transaccionDto.getEstado());

        TipoTransaccion tipoTransaccion = tipoTransaccionRepository.findById(transaccionDto.getTipoTransaccionDto().getId()).get();

        if (tipoTransaccion != null) {
            tipoTransaccion.setTipo(transaccionDto.getTipoTransaccionDto().getTipo());
            tipoTransaccion.setDescripcion(transaccionDto.getTipoTransaccionDto().getDescripcion());
            transaccion.setTipoTransaccion(tipoTransaccion);

            transaccionRepository.save(transaccion);
        }
        throw new IllegalArgumentException("El tipo de transaccion no existe");
    }

    public void deleteTransaccion(Long id){
        transaccionRepository.deleteById(id);
    }
}
