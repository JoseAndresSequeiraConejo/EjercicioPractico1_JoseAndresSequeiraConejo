package com.farmacia.controller;

import com.farmacia.domain.Farmacia.Categoria;
import com.farmacia.domain.Farmacia.Medicamento;
import com.farmacia.domain.Farmacia.Sugerencia;
import com.farmacia.service.FarmaciaService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class FarmaciaController {

    @Autowired
    private FarmaciaService farmaciaService;

    // Página de inicio con info y video
    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("mensaje", "Bienvenido a Farmacia La Salud");
        return "inicio";  // Thymeleaf: inicio.html
    }

    // ----- Medicamentos -----
    @GetMapping("/medicamentos")
    public String listarMedicamentos(Model model) {
        model.addAttribute("medicamentos", farmaciaService.getMedicamentos());
        return "medicamento/listado";
    }

    @GetMapping("/medicamento/nuevo")
    public String nuevoMedicamento(Medicamento medicamento, Model model) {
        model.addAttribute("categorias", farmaciaService.getCategorias());
        return "medicamento/modifica";
    }

    @PostMapping("/medicamento/guardar")
    public String guardarMedicamento(@Valid Medicamento medicamento, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categorias", farmaciaService.getCategorias());
            return "medicamento/modifica";
        }
        farmaciaService.saveMedicamento(medicamento);
        return "redirect:/medicamentos";
    }

    @GetMapping("/medicamento/modificar/{id}")
    public String modificarMedicamento(@PathVariable Long id, Model model) {
        Medicamento med = farmaciaService.getMedicamentoById(id);
        model.addAttribute("medicamento", med);
        model.addAttribute("categorias", farmaciaService.getCategorias());
        return "medicamento/modifica";
    }

    @GetMapping("/medicamento/eliminar/{id}")
    public String eliminarMedicamento(@PathVariable Long id) {
        farmaciaService.deleteMedicamentoById(id);
        return "redirect:/medicamentos";
    }

    // ----- Categorías -----
    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", farmaciaService.getCategorias());
        return "categoria/listado";
    }

    @GetMapping("/categoria/nuevo")
    public String nuevaCategoria(Categoria categoria) {
        return "categoria/modifica";
    }

    @PostMapping("/categoria/guardar")
    public String guardarCategoria(@Valid Categoria categoria, BindingResult result) {
        if (result.hasErrors()) {
            return "categoria/modifica";
        }
        farmaciaService.saveCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/categoria/modificar/{id}")
    public String modificarCategoria(@PathVariable Long id, Model model) {
        Categoria cat = farmaciaService.getCategoriaById(id);
        model.addAttribute("categoria", cat);
        return "categoria/modifica";
    }

    @GetMapping("/categoria/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        farmaciaService.deleteCategoriaById(id);
        return "redirect:/categorias";
    }

    // ----- Formulario de Quejas/Sugerencias -----
    @GetMapping("/contacto")
    public String contacto(Sugerencia sugerencia) {
        return "contacto";
    }

    @PostMapping("/contacto/enviar")
    public String enviarSugerencia(@Valid Sugerencia sugerencia, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "contacto";
        }
        farmaciaService.saveSugerencia(sugerencia);
        model.addAttribute("mensajeExito", "Gracias por contactarnos, responderemos pronto.");
        return "contacto";
    }
}
