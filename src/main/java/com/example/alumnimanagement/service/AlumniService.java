package com.example.alumnimanagement.service;

import com.example.alumnimanagement.dto.AlumniDto;
import com.example.alumnimanagement.entity.Alumni;
import com.example.alumnimanagement.exception.ResourceNotFoundException;
import com.example.alumnimanagement.repository.AlumniRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumniService {

    private final AlumniRepository alumniRepository;

    public AlumniService(AlumniRepository alumniRepository) {
        this.alumniRepository = alumniRepository;
    }

    public AlumniDto addAlumni(AlumniDto alumniDto) {
        // Validate the input
        alumniDto.validate();
        
        // Check if email already exists
        if (alumniRepository.existsByEmail(alumniDto.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }
        
        // Convert DTO to entity
        Alumni alumni = new Alumni();
        alumni.setName(alumniDto.getName());
        alumni.setEmail(alumniDto.getEmail());
        alumni.setBatchYear(alumniDto.getBatchYear());
        alumni.setDepartment(alumniDto.getDepartment());
        
        // Save the alumni entity
        Alumni savedAlumni = alumniRepository.save(alumni);
        
        // Convert entity back to DTO and return
        return convertToDto(savedAlumni);
    }

    public List<AlumniDto> getAllAlumni() {
        return alumniRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public AlumniDto getAlumniById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return alumniRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Alumni not found with id: " + id));
    }

    public AlumniDto updateAlumni(Long id, AlumniDto alumniDto) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        
        // Validate the input
        alumniDto.validate();
        
        // Check if alumni exists
        Alumni existingAlumni = alumniRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alumni not found with id: " + id));
        
        // Check if email is being changed and if the new email is already in use
        if (!existingAlumni.getEmail().equals(alumniDto.getEmail()) && 
            alumniRepository.existsByEmail(alumniDto.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }
        
        // Update the fields
        existingAlumni.setName(alumniDto.getName());
        existingAlumni.setEmail(alumniDto.getEmail());
        existingAlumni.setBatchYear(alumniDto.getBatchYear());
        existingAlumni.setDepartment(alumniDto.getDepartment());
        
        // Save and return updated alumni
        Alumni updatedAlumni = alumniRepository.save(existingAlumni);
        return convertToDto(updatedAlumni);
    }

    public void deleteAlumni(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (!alumniRepository.existsById(id)) {
            throw new ResourceNotFoundException("Alumni not found with id: " + id);
        }
        alumniRepository.deleteById(id);
    }
    
    private AlumniDto convertToDto(Alumni alumni) {
        if (alumni == null) {
            return null;
        }
        AlumniDto dto = new AlumniDto();
        dto.setId(alumni.getId());
        dto.setName(alumni.getName());
        dto.setEmail(alumni.getEmail());
        dto.setBatchYear(alumni.getBatchYear());
        dto.setDepartment(alumni.getDepartment());
        return dto;
    }
}
