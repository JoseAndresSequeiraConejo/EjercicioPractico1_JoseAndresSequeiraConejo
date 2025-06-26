package com.farmacia.dao;

import com.farmacia.domain.Farmacia.FacturaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDetalleDao extends JpaRepository<FacturaDetalle, Long> {
}
