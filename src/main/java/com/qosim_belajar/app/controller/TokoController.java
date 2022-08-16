package com.qosim_belajar.app.controller;

import com.qosim_belajar.app.dto.TokoDTO;
import com.qosim_belajar.app.model.Toko;
import com.qosim_belajar.app.service.TokoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toko")
public class TokoController {

    @Autowired
    TokoService tokoService;

    @PostMapping("/add/{pedagangId}")
    public TokoDTO addTokoToPedagang(@PathVariable Long pedagangId, @RequestBody TokoDTO request){
        final Toko toko = tokoService.mapToEntity(request);
        final Toko result = tokoService.addToko(pedagangId, toko);
        return tokoService.mapToDto(result);
    }
}
