package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "candidateId.user", cascade = CascadeType.ALL)
    @NotNull
    private List<Candidate> candidates = new ArrayList<>();

    @OneToMany(mappedBy = "submissionId.user", cascade = CascadeType.ALL)
    @NotNull
    private List<Submission> submissions = new ArrayList<>();

    @NotNull
    @Size(max = 100)
    private String fullName;

    @NotNull
    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    @Size(max = 50)
    private String nickname;

    @NotNull
    @Size(max = 255)
    private String password;

    @CreatedDate
    @Column(name = "created_at")
    Timestamp createdAt;
}
