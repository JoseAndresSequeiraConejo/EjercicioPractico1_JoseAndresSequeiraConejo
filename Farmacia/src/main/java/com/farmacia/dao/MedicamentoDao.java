package com.farmacia.dao;

import com.farmacia.domain.Farmacia.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoDao extends JpaRepository<Medicamento, Long> {
}
