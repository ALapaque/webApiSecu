package be.tftic.webapisecu.dal.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(nullable = false)
    public String name;
    @Column(nullable = false)
    public double prix;
}
