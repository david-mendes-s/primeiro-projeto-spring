package edu.projetocomjpa.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(
    @NotNull
    @NotBlank
    String name,
    @NotNull
    @NotBlank
    String userName,
    @NotNull
    @NotBlank
    String password
){

} 
    

