package com.qosim_belajar.app.service;

import com.qosim_belajar.app.dto.TokoDTO;
import com.qosim_belajar.app.model.Toko;

public interface TokoService {

    Toko addToko(Long pedagangId, Toko toko);

    Toko mapToEntity(TokoDTO tokoDTO);

    TokoDTO mapToDto(Toko toko);
}
