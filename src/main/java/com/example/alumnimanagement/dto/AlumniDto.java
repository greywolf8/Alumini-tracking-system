package com.example.alumnimanagement.dto;

public class AlumniDto {
    private Long id;
    private String name;
    private String email;
    private Integer batchYear;
    private String department;
    
    public AlumniDto() {
    }
    
    public AlumniDto(Long id, String name, String email, Integer batchYear, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.batchYear = batchYear;
        this.department = department;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Integer getBatchYear() {
        return batchYear;
    }
    
    public void setBatchYear(Integer batchYear) {
        this.batchYear = batchYear;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public String toString() {
        return "AlumniDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", batchYear=" + batchYear +
                ", department='" + department + '\'' +
                '}';
    }
    
    // Validation method
    public void validate() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Email should be valid");
        }
        if (batchYear == null) {
            throw new IllegalArgumentException("Batch year is required");
        }
        if (batchYear <= 0) {
            throw new IllegalArgumentException("Batch year must be a positive number");
        }
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department is required");
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumniDto alumniDto = (AlumniDto) o;
        return id != null && id.equals(alumniDto.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
