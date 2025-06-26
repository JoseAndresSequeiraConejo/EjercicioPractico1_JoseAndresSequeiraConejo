package com.farmacia.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Farmacia {

    @Data
    @Entity
    @Table(name = "categoria")
    public static class Categoria implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;
        private String descripcion;
    }

    @Data
    @Entity
    @Table(name = "medicamentos")
    public static class Medicamento implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;
        private String descripcion;
        private double precio;
        private int stock;

        @ManyToOne
        @JoinColumn(name = "id_categoria")
        private Categoria categoria;
    }

    @Data
    @Entity
    @Table(name = "clientes")
    public static class Cliente implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;
        private String apellido;
        private String telefono;
        private String email;
        private String direccion;
    }

    @Data
    @Entity
    @Table(name = "facturas")
    public static class Factura implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Date fecha;
        private double total;

        @ManyToOne
        @JoinColumn(name = "id_cliente")
        private Cliente cliente;
    }

    @Data
    @Entity
    @Table(name = "factura_detalle")
    public static class FacturaDetalle implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private int cantidad;

        @Column(name = "precio_unitario")
        private double precioUnitario;

        private double subtotal;

        @ManyToOne
        @JoinColumn(name = "id_factura")
        private Factura factura;

        @ManyToOne
        @JoinColumn(name = "id_medicamento")
        private Medicamento medicamento;
    }

    @Data
    @Entity
    @Table(name = "sugerencias")
    public static class Sugerencia implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;
        private String email;
        private String mensaje;
    }

}
