package com.projeortagim.projeortagim.Models;

import com.projeortagim.projeortagim.Base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Status extends BaseEntity {
    private String name;
}
