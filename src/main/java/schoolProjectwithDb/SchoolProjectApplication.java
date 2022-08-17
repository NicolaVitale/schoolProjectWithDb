package schoolProjectwithDb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import schoolProjectwithDb.data.model.Alunni;
import schoolProjectwithDb.data.model.Insegnanti;
import schoolProjectwithDb.data.model.Materie;
import schoolProjectwithDb.repository.AlunniRepository;
import schoolProjectwithDb.service.AlunniService;
import schoolProjectwithDb.service.InsegnantiService;
import schoolProjectwithDb.service.MaterieService;

@SpringBootApplication
public class SchoolProjectApplication {

  public static void main(String[] args) throws ParseException {
    ConfigurableApplicationContext context = SpringApplication.run(SchoolProjectApplication.class,
        args);

    /*Alunni alunnoDaInserire = alunnoInsert(1L, "Marco", "Bianchi",
        new Date(1986, Calendar.JANUARY, 17));
    AlunniService alunniService = context.getBean(AlunniService.class);
    alunniService.insert(alunnoDaInserire);*/

    /*Insegnanti insegnatiDaInserire1 = Insegnanti.builder().id(1L).nome("Paolo").cognome("Verdi").build();
    Insegnanti insegnatiDaInserire2 = Insegnanti.builder().id(2L).nome("Simone").cognome("Gialli").build();
    Insegnanti insegnatiDaInserire3 = Insegnanti.builder().id(3L).nome("Pippo").cognome("Rosa").build();
    InsegnantiService insegnantiService = context.getBean(InsegnantiService.class);
    insegnantiService.insert(insegnatiDaInserire1);
    insegnantiService.insert(insegnatiDaInserire2);
    insegnantiService.insert(insegnatiDaInserire3);*/

    Materie materiaDaInserire = Materie.builder().id(1L).name("Matematica").build();
    Materie materiaDaInserire2 = Materie.builder().id(2L).name("Inglese").build();
    MaterieService materieService = context.getBean(MaterieService.class);
    materieService.insert(materiaDaInserire);
    materieService.insert(materiaDaInserire2);

  }

  public static Alunni alunnoInsert(Long id, String nome, String cognome, Date data_nascita) {

    return Alunni.builder().id(id).nome(nome).cognome(cognome)
        .data_nascita(data_nascita).build();

  }

}
