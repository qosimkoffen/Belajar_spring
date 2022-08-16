package com.qosim_belajar.app.repository;

import com.qosim_belajar.app.model.Toko;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokoRepository extends JpaRepository<Toko, Long> {
}
