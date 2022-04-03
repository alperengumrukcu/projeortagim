package com.projeortagim.projeortagim.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.projeortagim.projeortagim.Base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Project extends BaseEntity {
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonBackReference
    private Users admin;
    @ManyToMany(mappedBy = "projectList")
    private List<Users> member = new ArrayList <Users> ();
}
