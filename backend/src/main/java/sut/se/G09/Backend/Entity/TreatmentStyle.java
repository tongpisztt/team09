package sut.se.G09.Backend.Entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter @Setter

@ToString
@Table(name="TreatmentStyle")
public class TreatmentStyle {

    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="TreatmentStyle_seq",sequenceName="TreatmentStyle_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TreatmentStyle_seq")
    @Column(name="TreatmentStyle_ID",unique = true, nullable = true)
    private @NonNull long id;

    @NotNull(message = "styleName Not null")
    @Pattern(regexp = "^[^A-Za-z]+$" ,message = "styleName Not English")
    private String styleName;

    public TreatmentStyle(){}

    public void setStyleName(String styleName) {
        this.styleName = styleName;
        }

}
