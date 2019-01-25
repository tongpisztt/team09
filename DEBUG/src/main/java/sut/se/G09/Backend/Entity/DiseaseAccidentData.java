package sut.se.G09.Backend.Entity;
import lombok.*;
import javax.persistence.*;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter @Setter

@ToString
@Table(name="DiseaseAccidentData") //ชื่อตาราง
public class DiseaseAccidentData {

  @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
@SequenceGenerator(name="DiseaseAccidentData_seq",sequenceName="DiseaseAccidentData_seq")
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DiseaseAccidentData_seq")
@Column(name="DiseaseAccidentData_ID",unique = true, nullable = true)
private @NonNull long id;
private @NonNull String DataName;


  public DiseaseAccidentData(){}

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = DiseaseAccidentLevel.class)
  @JoinColumn(name = "Level_ID", insertable = true)
  private  DiseaseAccidentLevel diseaseAccidentLevel;
  
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = DiseaseAccidentType.class)
  @JoinColumn(name = "Type_ID", insertable = true)
  private  DiseaseAccidentType diseaseAccidentType;
  
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = MedicalFee.class)
  @JoinColumn(name = "MedicalFee_ID", insertable = true)
  private  MedicalFee medicalFee;


	public void setDiseaseAccidentData(String DataName) {
    this.DataName = DataName;
	}
	
	public void setDiseaseAccidentLevel(DiseaseAccidentLevel diseaseAccidentLevel) {
    this.diseaseAccidentLevel = diseaseAccidentLevel;
	}
	
	public void setDiseaseAccidentType(DiseaseAccidentType diseaseAccidentType) {
    this.diseaseAccidentType = diseaseAccidentType;
	}
	
	public void setMedicalFee(MedicalFee medicalFee) {
    this.medicalFee = medicalFee;
	}
}