package com.farmacia.dao;

import com.farmacia.domain.Farmacia.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente, Long> {
}
