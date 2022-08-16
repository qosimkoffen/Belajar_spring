package com.qosim_belajar.app.service;

import com.qosim_belajar.app.dto.PedagangDTO;
import com.qosim_belajar.app.model.Pedangang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PedagangService {

    List<Pedangang> findAll();

    Pedangang create(Pedangang pedangang);

    Pedangang update(Long id,Pedangang pedangang);

    Boolean delete(Long id);

    Pedangang findById(Long id);

    Page<Pedangang> findAll(Pageable pageable);

    PedagangDTO mapToDto(Pedangang pedangang);
    Pedangang mapToEntity(PedagangDTO pedagangDTO);
}
