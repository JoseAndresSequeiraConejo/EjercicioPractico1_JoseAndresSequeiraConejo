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
@RequestMapping("/")
public class FarmaciaController {

    @Autowired
    private FarmaciaService farmaciaService;

    // Página de inicio
    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("mensaje", "Bienvenido a Farmacia La Salud");
        return "index";
    }

    // ----- Medicamentos -----
    @GetMapping("/medicamentos")
    public String listarMedicamentos(Model model) {
        model.addAttribute("medicamentos", farmaciaService.getMedicamentos(true));
        return "medicamento/listado";

    }

    @GetMapping("/medicamento/nuevo")
    public String nuevoMedicamento(Model model) {
        model.addAttribute("medicamento", new Medicamento());
        model.addAttribute("categorias", farmaciaService.getCategorias(true));
        return "medicamento/modifica";
    }

    @PostMapping("/medicamento/guardar")
    public String guardarMedicamento(@Valid @ModelAttribute Medicamento medicamento, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categorias", farmaciaService.getCategorias(true));
            return "medicamento/modifica";
        }
        farmaciaService.saveMedicamento(medicamento);
        return "redirect:/medicamentos";
    }

    @GetMapping("/medicamento/modificar/{id}")
    public String modificarMedicamento(@PathVariable Long id, Model model) {
        Medicamento med = farmaciaService.getMedicamento(new Medicamento() {{ setId(id); }});
        model.addAttribute("medicamento", med);
        model.addAttribute("categorias", farmaciaService.getCategorias(true));
        return "medicamento/modifica";
    }

    @GetMapping("/medicamento/eliminar/{id}")
    public String eliminarMedicamento(@PathVariable Long id) {
        farmaciaService.deleteMedicamento(new Medicamento() {{ setId(id); }});
        return "redirect:/medicamentos";
    }

    // ----- Categorías -----
    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", farmaciaService.getCategorias(true));
        return "categoria/listado";
    }

    @GetMapping("/categoria/nuevo")
    public String nuevaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria/modifica";
    }

    @PostMapping("/categoria/guardar")
    public String guardarCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/categoria/modifica";
        }
        farmaciaService.saveCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/categoria/modificar/{id}")
    public String modificarCategoria(@PathVariable Long id, Model model) {
        Categoria cat = farmaciaService.getCategoria(new Categoria() {{ setId(id); }});
        model.addAttribute("categoria", cat);
        return "categoria/modifica";
    }

    @GetMapping("/categoria/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        farmaciaService.deleteCategoria(new Categoria() {{ setId(id); }});
        return "redirect:/categorias";
    }

    // ----- Contacto / Sugerencias -----
    @GetMapping("/contacto")
    public String contacto(Model model) {
        model.addAttribute("sugerencia", new Sugerencia());
        return "contacto";
    }

    @PostMapping("/contacto/enviar")
    public String enviarSugerencia(@Valid @ModelAttribute Sugerencia sugerencia, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/contacto";
        }
        farmaciaService.saveSugerencia(sugerencia);
        model.addAttribute("mensajeExito", "Gracias por contactarnos, responderemos pronto.");
        model.addAttribute("sugerencia", new Sugerencia()); // limpia el formulario
        return "contacto";
    }
}
