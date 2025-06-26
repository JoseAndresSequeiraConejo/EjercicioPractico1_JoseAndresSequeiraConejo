package com.farmacia.service;

import com.farmacia.domain.Farmacia.Categoria;
import com.farmacia.domain.Farmacia.Medicamento;
import com.farmacia.domain.Farmacia.Sugerencia;

import java.util.List;

public interface FarmaciaService {

    // Medicamentos
    List<Medicamento> getMedicamentos(boolean activo); // activo en caso que quieras filtrar, si no usa solo getMedicamentos()
    Medicamento getMedicamento(Medicamento medicamento);
    void saveMedicamento(Medicamento medicamento);
    void deleteMedicamento(Medicamento medicamento);

    // Categorías
    List<Categoria> getCategorias(boolean activo);
    Categoria getCategoria(Categoria categoria);
    void saveCategoria(Categoria categoria);
    void deleteCategoria(Categoria categoria);

    // Sugerencias
    List<Sugerencia> getSugerencias();
    Sugerencia getSugerencia(Sugerencia sugerencia);
    void saveSugerencia(Sugerencia sugerencia);
    void deleteSugerencia(Sugerencia sugerencia);
}
