package sut.se.G09.Backend.Entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import sut.se.G09.Backend.Entity.*;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode

@Table(name="PaymentHistory")
public class PaymentHistory {

 @Id
 @SequenceGenerator(name="ph_seq",sequenceName="ph_seq")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ph_seq")
 @Column(name = "PHID")
 private @NonNull Long iD;
 @Column(unique = true)
 private String code;
 private Long amount;
 private Date date;



 @ManyToOne(fetch = FetchType.EAGER, targetEntity = MemberData.class)
 @OnDelete(action = OnDeleteAction.CASCADE)
 @JoinColumn(name = "MID", insertable = true)
 private MemberData memberData;



 public PaymentHistory() {}


}