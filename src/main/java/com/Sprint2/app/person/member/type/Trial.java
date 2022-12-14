package com.Sprint2.app.person.member.type;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Inheritance
@DiscriminatorValue("trail")
@NoArgsConstructor
public class Trial extends MembershipType implements Membershipable{
    @Transient
    private Integer MEMBERSHIPDURATION = 30;

    public Trial(LocalDate startDate) {
        super(startDate);
        super.setName("Trial");
        super.setMembershipCost(0.00);
        super.setEndDate(getEndDate(startDate));
    }

    @Override
    public LocalDate getEndDate(LocalDate startDate) {
        return startDate.plusDays(this.MEMBERSHIPDURATION);
    }
}
