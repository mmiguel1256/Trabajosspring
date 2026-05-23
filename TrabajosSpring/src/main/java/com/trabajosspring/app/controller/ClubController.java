package com.trabajosspring.app.controller;

import com.trabajosspring.app.entity.*;
import com.trabajosspring.app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clubes")
public class ClubController {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private AsociacionRepository asociacionRepository;

    @Autowired
    private CompeticionRepository competicionRepository;

    // Listar todos los clubes
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clubes", clubRepository.findAll());
        return "club/listar";
    }

    // Formulario para crear un nuevo club
    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("club", new Club());
        model.addAttribute("entrenadores", entrenadorRepository.findAll());
        model.addAttribute("asociaciones", asociacionRepository.findAll());
        model.addAttribute("competiciones", competicionRepository.findAll());
        return "club/formulario";
    }

    // Guardar un nuevo club o actualizar uno existente
    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Club club,
            @RequestParam(required = false) Long entrenadorId,
            @RequestParam(required = false) Long asociacionId,
            @RequestParam(required = false) List<Long> competicionIds
    ) {
        if (entrenadorId != null) {
            club.setEntrenador(entrenadorRepository.findById(entrenadorId).orElse(null));
        }
        if (asociacionId != null) {
            club.setAsociacion(asociacionRepository.findById(asociacionId).orElse(null));
        }
        if (competicionIds != null && !competicionIds.isEmpty()) {
            club.setCompeticiones(competicionRepository.findAllById(competicionIds));
        }
        clubRepository.save(club);
        return "redirect:/clubes";
    }

    // Formulario para editar un club existente
    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Long id, Model model) {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Club no encontrado: " + id));
        model.addAttribute("club", club);
        model.addAttribute("entrenadores", entrenadorRepository.findAll());
        model.addAttribute("asociaciones", asociacionRepository.findAll());
        model.addAttribute("competiciones", competicionRepository.findAll());
        return "club/formulario";
    }

    // Eliminar un club
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        clubRepository.deleteById(id);
        return "redirect:/clubes";
    }

    // Ver detalle de un club
    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Long id, Model model) {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Club no encontrado: " + id));
        model.addAttribute("club", club);
        return "club/detalle";
    }
}