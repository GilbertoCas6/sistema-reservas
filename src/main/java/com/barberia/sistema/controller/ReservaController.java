package com.barberia.sistema.controller;

import com.barberia.sistema.domain.Reserva;
import com.barberia.sistema.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    // 🟩 Mostrar listado de reservas
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("reservas", reservaService.listarTodas());
        return "reservas"; // templates/reservas.html
    }

    // 🟩 Mostrar formulario para nueva reserva
    @GetMapping("/nueva")
    public String nuevaReserva(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "form-reserva"; // templates/form-reserva.html
    }

    // 🟩 Guardar reserva
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Reserva reserva) {
        reservaService.guardar(reserva);
        return "redirect:/reservas";
    }

    // 🟩 Editar reserva existente
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        Reserva reserva = reservaService.obtenerPorId(id);
        model.addAttribute("reserva", reserva);
        return "form-reserva";
    }

    // 🟩 Eliminar reserva
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        reservaService.eliminar(id);
        return "redirect:/reservas";
    }
}
