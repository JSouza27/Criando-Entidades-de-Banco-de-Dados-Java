package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToMany(mappedBy = "candidateId.company", cascade = CascadeType.ALL)
    @NotNull
    private List<Candidate> candidates;

    @NotNull
    @Size(max = 100)
    String name;

    @NotNull
    @Size(max = 50)
    String slug;

    @CreatedDate
    @Column(name = "created_at")
    Timestamp createdAt;
}
