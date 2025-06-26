package com.farmacia.dao;

import com.farmacia.domain.Farmacia.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDao extends JpaRepository<Factura, Long> {
}
