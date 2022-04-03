package com.projeortagim.projeortagim.Services;

import com.projeortagim.projeortagim.Exception.ValidationException;
import com.projeortagim.projeortagim.Models.Users;
import com.projeortagim.projeortagim.Repository.UserRepository;
import com.projeortagim.projeortagim.Request.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServices {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepository userRepository;

    public Users servicesCreateUser(UserDTO newUserDto) {
        if(!newUserDto.isValid()) throw new ValidationException();
        Users user1 = modelMapper.map(newUserDto,Users.class);
        Users savedUser = userRepository.save(user1);
        return savedUser;
    }
}