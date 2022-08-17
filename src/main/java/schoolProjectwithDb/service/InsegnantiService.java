package schoolProjectwithDb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import schoolProjectwithDb.data.model.Alunni;
import schoolProjectwithDb.data.model.Insegnanti;
import schoolProjectwithDb.data.response.GenericResponse;
import schoolProjectwithDb.repository.InsegnantiRepository;

@Service
public class InsegnantiService {

  private InsegnantiRepository insegnantiRepository;

  public InsegnantiService (InsegnantiRepository insegnantiRepository) {
    this.insegnantiRepository = insegnantiRepository;
  }

  public Insegnanti getById(Long id) {
    Optional<Insegnanti> insegnante = insegnantiRepository.findById(id);
    if (insegnante.isPresent()) {
      return insegnante.get();
    } else {
      return null;
    }
  }

  public List<Insegnanti> getAll() {
    return insegnantiRepository.findAll();
  }

  public GenericResponse insert(Insegnanti insegnante) {

    GenericResponse response = new GenericResponse();
    Optional<Insegnanti> alunni = insegnantiRepository.findById(insegnante.getId());

    if (alunni.isPresent()) {
      response.setHttpStatus(HttpStatus.NOT_FOUND);
      response.setMessage("Insegnante gia' presente");
    } else {
      insegnantiRepository.save(insegnante);
      response.setHttpStatus(HttpStatus.CREATED);
      response.setMessage("Insegnante salvato correttamente");
    }

    return response;
  }

  public GenericResponse deleteById(Long idInsegnante) {

    GenericResponse response = new GenericResponse();

    if (insegnantiRepository.findById(idInsegnante).isPresent()) {
      insegnantiRepository.deleteById(idInsegnante);
      response.setHttpStatus(HttpStatus.OK);
      response.setMessage("Insegnante eliminato correttamente");
    } else {
      response.setHttpStatus(HttpStatus.NOT_FOUND);
      response.setMessage("Insegnante non presente");
    }

    return response;
  }

  public GenericResponse deleteAll() {

    GenericResponse response = new GenericResponse();
    insegnantiRepository.deleteAll();
    response.setHttpStatus(HttpStatus.OK);
    response.setMessage("Tabella insegnanti eliminata correttamente");
    return response;
  }

}
