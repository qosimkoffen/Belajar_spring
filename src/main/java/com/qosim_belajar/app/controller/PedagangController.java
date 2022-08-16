package com.qosim_belajar.app.controller;

import com.qosim_belajar.app.dto.PedagangDTO;
import com.qosim_belajar.app.model.Pedangang;
import com.qosim_belajar.app.service.PedagangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedagang")
public class PedagangController {

    @Autowired
    PedagangService pedagangService;


    @GetMapping("/all")
    public List<PedagangDTO> findAll(){
        return pedagangService.findAll().stream().map(pedangang -> pedagangService.mapToDto(pedangang))
                .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public Page<PedagangDTO> findAllWithPagination(@PageableDefault Pageable pageable){
        return pedagangService.findAll(pageable).map(pedangang -> pedagangService.mapToDto(pedangang));
    }

    @PostMapping("/create")
    public PedagangDTO create(@RequestBody PedagangDTO request){
        final Pedangang pedangang = pedagangService.mapToEntity(request);
        final Pedangang result = pedagangService.create(pedangang);
        return pedagangService.mapToDto(result);
    }

    @PutMapping("/update/{id}")
    public PedagangDTO update(@PathVariable Long id, @RequestBody PedagangDTO request){
        final Pedangang pedangang = pedagangService.mapToEntity(request);
        final Pedangang result = pedagangService.update(id, pedangang);
        return pedagangService.mapToDto(result);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return pedagangService.delete(id);
    }
}