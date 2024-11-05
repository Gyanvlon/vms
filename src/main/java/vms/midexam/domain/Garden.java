package vms.midexam.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "garden")
public class Garden {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double size;
    @ToString.Exclude
    @OneToMany(mappedBy = "garden")
    List<Plant> plants = new ArrayList<>();
}
