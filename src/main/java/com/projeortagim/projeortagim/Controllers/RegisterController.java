package com.projeortagim.projeortagim.Controllers;

import com.projeortagim.projeortagim.Base.BaseResponse;
import com.projeortagim.projeortagim.Models.Users;
import com.projeortagim.projeortagim.Request.UserDTO;
import com.projeortagim.projeortagim.Services.RegisterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class RegisterController{

    @Autowired
    RegisterServices registerServices;

    @PostMapping("createuser")
    public ResponseEntity<BaseResponse<Users>> createUser(@RequestBody UserDTO newUserDto){
       Users createdUser = registerServices.servicesCreateUser(newUserDto);
       BaseResponse<Users> response = new BaseResponse<>();
        response.setData(createdUser);
        response.setSuccess(true);
        response.setMessages("Kayıt başarılı");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
