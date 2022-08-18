package schoolProjectwithDb.data.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import schoolProjectwithDb.data.model.Alunni;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlunniDTO {

  private Long id;
  private String nome;
  private String cognome;
  private Date data_nascita;

  public String getNomeCognome() {
    return nome + " " + cognome;
  }

  public Alunni toModel() {
    return Alunni.builder().id(id).nome(nome).cognome(cognome).data_nascita(data_nascita).build();
  }
}
