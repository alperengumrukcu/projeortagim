package com.projeortagim.projeortagim.Controllers;

import com.projeortagim.projeortagim.Base.BaseResponse;
import com.projeortagim.projeortagim.Models.Users;
import com.projeortagim.projeortagim.Request.UserDTO;
import com.projeortagim.projeortagim.Services.RegisterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/")
public class UserController {

    @Autowired
    private RegisterServices registerServices;

    @PostMapping("createuser")
    public ResponseEntity<BaseResponse<Users>> createUser(@RequestBody UserDTO newUserDto) {
        Users createdUser = registerServices.servicesCreateUser(newUserDto);
        BaseResponse<Users> response = new BaseResponse<>();
        response.setData(createdUser);
        response.setSuccess(true);
        response.setMessages("Kullanıcı kaydedildi.");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("all")
    public ResponseEntity<BaseResponse<List<Users>>> getAllUsers() {
        List<Users> allUserList = registerServices.getAllUser();
        BaseResponse<List<Users>> response = new BaseResponse<>();
        if (allUserList == null) {
            response.setData(null);
            response.setSuccess(false);
            response.setMessages("İstek başarısız.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            response.setData(allUserList);
            response.setSuccess(true);
            response.setMessages("Kullanıcıların listesi getirildi.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    /*@DeleteMapping("delete")
    public ResponseEntity<BaseResponse<Users>> deleteUser(@RequestParam String email) {
        Users deletedUser = registerServices.findByEmail(email);
        BaseResponse<Users> response = new BaseResponse<>();
        if (deletedUser == null) {
            response.setData(null);
            response.setSuccess(false);
            response.setMessages("Kullanıcı bulunamadı.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            registerServices.deleteUser(deletedUser);
            response.setData(deletedUser);
            response.setSuccess(true);
            response.setMessages("Kullanıcı silindi");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }*/

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse<Users>> getUserId(@PathVariable int id) {
        Users userById = registerServices.getByUserId(id);
        BaseResponse<Users> response = new BaseResponse<>();
        if (userById == null) {
            response.setData(null);
            response.setSuccess(false);
            response.setMessages("Kullanıcı bulunamadı.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            response.setData(userById);
            response.setSuccess(true);
            response.setMessages("Kullanıcı Getirildi.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PutMapping("{userİd}")
    public ResponseEntity<BaseResponse<Users>> updateByUser(@PathVariable int userİd, @RequestBody Users updateNewUser){
        Users getUser=registerServices.updateByUser(userİd);
        BaseResponse<Users> response = new BaseResponse<>();
        if(getUser==null){
            response.setData(null);
            response.setSuccess(false);
            response.setMessages("Kullanıcı bulunamadı.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        else {
            getUser.setEmail(updateNewUser.getEmail());
            getUser.setName(updateNewUser.getName());
            getUser.setPassword(updateNewUser.getPassword());
            getUser.setSurname(updateNewUser.getSurname());
            registerServices.saveUser(getUser);
            response.setData(getUser);
            response.setSuccess(true);
            response.setMessages("Kullanıcı Güncellendi.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}