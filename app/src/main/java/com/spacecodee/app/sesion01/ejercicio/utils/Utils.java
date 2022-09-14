package com.spacecodee.app.sesion01.ejercicio.utils;

import android.os.Bundle;
import com.spacecodee.app.sesion01.ejercicio.dto.UserDto;

public class Utils {

    //get extras by intent
    public static UserDto getUserDto(Bundle extras) {
        UserDto userDto = null;
        if (extras != null) {
            userDto = new UserDto(
                    extras.getString("user"),
                    extras.getString("password"),
                    extras.getString("name"),
                    extras.getString("lastname")
            );
        }

        return userDto;
    }

    //validate not empty strings
    public static boolean validateEmpty(String... strings) {
        for (String string : strings) {
            if (string.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
