package sut.se.G09.Backend.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.*;
@Entity  //บอกว่าเป็น class com.okta.developer.demo.Entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name="MoneyMaximum") //ชื่อตาราง
public class MoneyMaximum { //เงินชดเชยสูงสุด
    @Id
    @SequenceGenerator(name = "MoneyMaximum_seq", sequenceName = "MoneyMaximum_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MoneyMaximum_seq")
    @Column(name = "MoneyMaximumId", unique = true, nullable = false, length = 100)
    private Long iD;

    @NotNull(message = "moneyName Not Null")
    private Long moneyName;

    public Long getId() {
        return iD;
    }

    public void setId(Long id) {
        this.iD = id;
    }

    public Long getmoneyName() {
        return moneyName;
    }

    public void setmoneyName(Long moneyName) {
        this.moneyName = moneyName;
    }



public MoneyMaximum() {}
public MoneyMaximum(long moneyName){  //constructor
    this.moneyName = moneyName;
}
}