package schoolProjectwithDb.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "materie")
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Materie {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_insegnante")
  @JsonBackReference(value = "id_insegnante")
  private Insegnanti insegnante;

}
