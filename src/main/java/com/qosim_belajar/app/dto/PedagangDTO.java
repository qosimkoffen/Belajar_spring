package com.qosim_belajar.app.dto;

import java.util.List;

public record PedagangDTO(Long id, String name, List<TokoDTO> tokos) {
}
