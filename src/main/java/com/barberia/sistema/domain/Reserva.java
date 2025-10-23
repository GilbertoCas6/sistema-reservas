package com.barberia.sistema.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reserva;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha; // 👈 IMPORTANTE: LocalDate, no String

    private String hora;
    private String servicio;
    private String estado;
    private String cliente;
}
