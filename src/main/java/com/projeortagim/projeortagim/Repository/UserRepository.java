package com.projeortagim.projeortagim.Repository;

import com.projeortagim.projeortagim.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
     Users findByEmail(String email);
      Users deleteByEmail(Users deletedUser);
}