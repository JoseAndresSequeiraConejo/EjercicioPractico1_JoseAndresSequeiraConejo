package com.farmacia.service.impl;

import com.farmacia.dao.MedicamentoDao;
import com.farmacia.dao.CategoriaDao;
import com.farmacia.dao.SugerenciaDao;

import com.farmacia.domain.Farmacia.Medicamento;
import com.farmacia.domain.Farmacia.Categoria;
import com.farmacia.domain.Farmacia.Sugerencia;

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
        return medicamentoDao.findAll(); // sin filtro por "activo"
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
