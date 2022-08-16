package com.qosim_belajar.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qosim_belajar.app.dto.TokoDTO;
import com.qosim_belajar.app.model.Pedangang;
import com.qosim_belajar.app.model.Toko;
import com.qosim_belajar.app.repository.TokoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TokoServiceImpl implements TokoService{

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    PedagangService pedagangService;

    @Autowired
    TokoRepository tokoRepository;

    @Override
    public Toko addToko(Long pedagangId, Toko toko) {
        final Pedangang pedagang = pedagangService.findById(pedagangId);
        if (pedagang != null) {
            // add Toko to DB
            toko = tokoRepository.save(toko);
            if (pedagang.getTokos() != null) {
                List<Toko> tokos = pedagang.getTokos();
                tokos.add(toko);
                pedagang.setTokos(tokos);
            } else{
              pedagang.setTokos(Collections.singletonList(toko));
            }
            pedagangService.create(pedagang);
            return toko;
        }
        return null;
    }

    @Override
    public Toko mapToEntity(TokoDTO tokoDTO) {
        return mapper.convertValue(tokoDTO, Toko.class);
    }

    @Override
    public TokoDTO mapToDto(Toko toko) {
        return mapper.convertValue(toko, TokoDTO.class);
    }
}
