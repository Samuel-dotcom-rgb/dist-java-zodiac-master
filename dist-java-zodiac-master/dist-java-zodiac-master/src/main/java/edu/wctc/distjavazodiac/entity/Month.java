package edu.wctc.distjavazodiac.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "calendar_month")
public class Month {
    @Id
    @Column(name = "num")
    private int number;

    @Column(name = "nm", nullable = false)
    private String name;
}
