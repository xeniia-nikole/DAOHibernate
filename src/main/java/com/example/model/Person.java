package com.example.model;

import lombok.*;
import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Person {
    @EmbeddedId
    private PersonId personId;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String cityOfLiving;

}
