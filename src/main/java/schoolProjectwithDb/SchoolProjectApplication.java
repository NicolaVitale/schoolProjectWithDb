package schoolProjectwithDb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import schoolProjectwithDb.data.model.Alunni;
import schoolProjectwithDb.repository.AlunniRepository;
import schoolProjectwithDb.service.AlunniService;

@SpringBootApplication
public class SchoolProjectApplication {

  public static void main(String[] args) throws ParseException {
    ConfigurableApplicationContext context = SpringApplication.run(SchoolProjectApplication.class, args);

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Alunni alunnoDaInserire = Alunni.builder().id(1L).nome("Luca").cognome("Rossi")
        .data_nascita(dateFormat.parse("01/01/1986")).build();

    AlunniService alunniService = context.getBean(AlunniService.class);
    alunniService.insert(alunnoDaInserire);
  }

}
