package com.example.alumnimanagement.controller;

import com.example.alumnimanagement.dto.AlumniDto;
import com.example.alumnimanagement.service.AlumniService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alumni")
public class AlumniController {

    private final AlumniService alumniService;

    @Autowired
    public AlumniController(AlumniService alumniService) {
        this.alumniService = alumniService;
    }

    @PostMapping
    public ResponseEntity<AlumniDto> addAlumni(@Valid @RequestBody AlumniDto alumniDto) {
        AlumniDto savedAlumni = alumniService.addAlumni(alumniDto);
        return new ResponseEntity<>(savedAlumni, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AlumniDto>> getAllAlumni() {
        List<AlumniDto> alumniList = alumniService.getAllAlumni();
        return ResponseEntity.ok(alumniList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumniDto> getAlumniById(@PathVariable Long id) {
        AlumniDto alumniDto = alumniService.getAlumniById(id);
        return ResponseEntity.ok(alumniDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumniDto> updateAlumni(
            @PathVariable Long id,
            @Valid @RequestBody AlumniDto alumniDto) {
        AlumniDto updatedAlumni = alumniService.updateAlumni(id, alumniDto);
        return ResponseEntity.ok(updatedAlumni);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumni(@PathVariable Long id) {
        alumniService.deleteAlumni(id);
        return ResponseEntity.noContent().build();
    }
}
