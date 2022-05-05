package com.projeortagim.projeortagim.Models;

import com.projeortagim.projeortagim.Base.BaseEntity;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Users extends BaseEntity {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Boolean emailStatus = false;
    @OneToMany
    private List<Project> projectAdmin = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "project_users", joinColumns = @JoinColumn(name = "users_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> projectList = new ArrayList<>();

}
