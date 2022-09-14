package com.spacecodee.app.sesion01.ejercicio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDto {

    private String user;
    private String password;
    private String name;
    private String lastName;
}
