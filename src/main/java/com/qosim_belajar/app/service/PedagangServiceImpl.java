package com.qosim_belajar.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qosim_belajar.app.dto.PedagangDTO;
import com.qosim_belajar.app.model.Pedangang;
import com.qosim_belajar.app.repository.PedangangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PedagangServiceImpl implements PedagangService{

    @Autowired
    PedangangRepository pedangangRepository;

    @Override
    public List<Pedangang> findAll() {
        return pedangangRepository.findAll();
    }

    @Override
    public Page<Pedangang> findAll(Pageable pageable) {
        return pedangangRepository.findAll(pageable);
    }

    @Override
    public Pedangang create(Pedangang pedangang) {
        final Pedangang result = pedangangRepository.save(pedangang);
        return result;
    }

    @Override
    public Pedangang update(Long id, Pedangang pedangang) {
        Pedangang result = findById(id);
        if (result != null) {
            result.setName(pedangang.getName());
            return pedangangRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final Pedangang result = findById(id);
        if (result != null) {
            // Hard Delete
            pedangangRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Pedangang findById(Long id) {
        Optional<Pedangang> result = pedangangRepository.findById(id);
        if (result.isPresent()) {
            return  result.get();
        }
        return null;
    }

    // Mapper
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public PedagangDTO mapToDto(Pedangang pedangang) {
        return mapper.convertValue(pedangang, PedagangDTO.class);
    }

    @Override
    public Pedangang mapToEntity(PedagangDTO pedagangDTO) {
        return mapper.convertValue(pedagangDTO, Pedangang.class);
    }
}