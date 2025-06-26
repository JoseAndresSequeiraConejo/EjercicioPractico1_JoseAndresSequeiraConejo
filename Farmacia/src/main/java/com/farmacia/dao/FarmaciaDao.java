package com.farmacia.dao;

import com.farmacia.domain.Farmacia.Categoria;
import com.farmacia.domain.Farmacia.Medicamento;
import com.farmacia.domain.Farmacia.Cliente;
import com.farmacia.domain.Farmacia.Factura;
import com.farmacia.domain.Farmacia.FacturaDetalle;
import com.farmacia.domain.Farmacia.Sugerencia;

import org.springframework.data.jpa.repository.JpaRepository;

public class FarmaciaDao {

    public interface CategoriaDao extends JpaRepository<Categoria, Long> {}

    public interface MedicamentoDao extends JpaRepository<Medicamento, Long> {}

    public interface ClienteDao extends JpaRepository<Cliente, Long> {}

    public interface FacturaDao extends JpaRepository<Factura, Long> {}

    public interface FacturaDetalleDao extends JpaRepository<FacturaDetalle, Long> {}

    public interface SugerenciaDao extends JpaRepository<Sugerencia, Long> {}

}
