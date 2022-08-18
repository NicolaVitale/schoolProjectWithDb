package schoolProjectwithDb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import schoolProjectwithDb.data.model.Alunni;
import schoolProjectwithDb.data.response.GenericResponse;
import schoolProjectwithDb.repository.AlunniRepository;

@Service
public class AlunniService {

  private final AlunniRepository alunniRepository;

  public AlunniService(AlunniRepository alunniRepository) {
    this.alunniRepository = alunniRepository;
  }

  public Alunni getById(Long id) {
    Optional<Alunni> alunno = alunniRepository.findById(id);
    if (alunno.isPresent()) {
      return alunno.get();
    } else {
      return null;
    }
  }

  public List<Alunni> getAll() {
    return alunniRepository.findAll();
  }

  public GenericResponse insert(Alunni alunno) {

    GenericResponse response = new GenericResponse();
    Optional<Alunni> alunni = alunniRepository.findById(alunno.getId());

    if (alunni.isPresent()) {
      response.setHttpStatus(HttpStatus.FOUND);
      response.setMessage("Alunno gia' presente");
    } else {
      alunniRepository.save(alunno);
      response.setHttpStatus(HttpStatus.CREATED);
      response.setMessage("Alunno salvato correttamente");
    }

    return response;
  }

  public GenericResponse deleteById(Long idAlunno) {

    GenericResponse response = new GenericResponse();

    if (alunniRepository.findById(idAlunno).isPresent()) {
      alunniRepository.deleteById(idAlunno);
      response.setHttpStatus(HttpStatus.OK);
      response.setMessage("Alunno eliminato correttamente");
    } else {
      response.setHttpStatus(HttpStatus.NOT_FOUND);
      response.setMessage("Alunno non presente");
    }

    return response;
  }

  public GenericResponse deleteAll() {

    GenericResponse response = new GenericResponse();
    alunniRepository.deleteAll();
    response.setHttpStatus(HttpStatus.OK);
    response.setMessage("Tabella alunni eliminata correttamente");
    return response;
  }

}
