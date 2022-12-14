package com.Sprint2.app.person.member.type;

import com.Sprint2.app.person.member.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@Inheritance
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type")
@Entity
@Table(name = "membership_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class MembershipType {
    @Id
    @SequenceGenerator(name = "memtype_sequence", sequenceName = "memtype_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memtype_sequence")
    private Long id;
    @Column
    private String name;
    @Column
    private Double membershipCost;
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;

    @OneToOne(mappedBy = "membership")
    @JsonIgnore
    private Member member;



    public MembershipType(String name, Double membershipCost, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.membershipCost = membershipCost;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public MembershipType(LocalDate startDate) {
        this.startDate = startDate;
    }
}
