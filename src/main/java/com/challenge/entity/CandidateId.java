package com.challenge.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class CandidateId implements Serializable {

    private static final long serialVersionUID = -8990215739341513151L;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "acceleration_id")
    private Acceleration acceleration;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
