package com.projeortagim.projeortagim.Services;

import com.projeortagim.projeortagim.Exception.ValidationException;
import com.projeortagim.projeortagim.Models.Users;
import com.projeortagim.projeortagim.Repository.UserRepository;
import com.projeortagim.projeortagim.Request.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServices {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    public Users servicesCreateUser(UserDTO newUserDto) {
        if (!newUserDto.isValid()) throw new ValidationException();
        Users user1 = modelMapper.map(newUserDto, Users.class);
        if (userRepository.findByEmail(user1.getEmail())!= null) {
        } else {
            Users savedUser = userRepository.save(user1);
            return savedUser;
        }
        return user1;
    }

    public List<Users> getAllUser() {
        return userRepository.findAll();
    }

    public Users deleteUser(Users deletedUser) {
       return userRepository.deleteByEmail(deletedUser);
    }

    public Users getByUserId(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public Users updateByUser(int userİd) {
        return  userRepository.findById(userİd).orElse(null);
    }
    public Users saveUser(Users savedUser){
        return userRepository.save(savedUser);
    }

    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}