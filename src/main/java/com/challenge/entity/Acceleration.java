package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Acceleration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToMany(mappedBy = "candidateId.acceleration", cascade = CascadeType.ALL)
    private List<Candidate> candidates = new ArrayList<>();

    @NotNull
    @Size(max = 100)
    String name;

    @NotNull
    @Size(max = 50)
    String slug;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenge;

    @CreatedDate
    @Column(name = "created_at")
    Timestamp createdAt;
}
