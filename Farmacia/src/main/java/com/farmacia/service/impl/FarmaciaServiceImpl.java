package com.farmacia.service.impl;

import com.farmacia.dao.FarmaciaDao.*;
import com.farmacia.domain.FarmaciaEntities.*;
import com.farmacia.service.FarmaciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmaciaServiceImpl implements FarmaciaService {

    @Autowired
    private MedicamentoDao medicamentoDao;

    @Autowired
    private CategoriaDao categoriaDao;

    @Autowired
    private SugerenciaDao sugerenciaDao;

    // Medicamentos
    @Override
    public List<Medicamento> getMedicamentos(boolean activo) {
        // Si quieres filtrar por activo, implementa aquí. 
        // Por ahora devuelve todos (sin filtro) porque Medicamento no tiene campo activo en el ejemplo.
        return medicamentoDao.findAll();
    }

    @Override
    public Medicamento getMedicamento(Medicamento medicamento) {
        return medicamentoDao.findById(medicamento.getId()).orElse(null);
    }

    @Override
    public void saveMedicamento(Medicamento medicamento) {
        medicamentoDao.save(medicamento);
    }

    @Override
    public void deleteMedicamento(Medicamento medicamento) {
        medicamentoDao.delete(medicamento);
    }

    // Categorías
    @Override
    public List<Categoria> getCategorias(boolean activo) {
        // Similar, devuelve todos (no filtro activo en ejemplo)
        return categoriaDao.findAll();
    }

    @Override
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getId()).orElse(null);
    }

    @Override
    public void saveCategoria(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    public void deleteCategoria(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    // Sugerencias
    @Override
    public List<Sugerencia> getSugerencias() {
        return sugerenciaDao.findAll();
    }

    @Override
    public Sugerencia getSugerencia(Sugerencia sugerencia) {
        return sugerenciaDao.findById(sugerencia.getId()).orElse(null);
    }

    @Override
    public void saveSugerencia(Sugerencia sugerencia) {
        sugerenciaDao.save(sugerencia);
    }

    @Override
    public void deleteSugerencia(Sugerencia sugerencia) {
        sugerenciaDao.delete(sugerencia);
    }
}
