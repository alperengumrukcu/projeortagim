package com.projeortagim.projeortagim.Request;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String surname;
    private String email;
    private String password;

    public boolean isValid(){
        if(this.name == null ||
                this.password == null ||
                this.email == null ||
                this.surname == null){
            return false;
        }
        return true;
    }
}
