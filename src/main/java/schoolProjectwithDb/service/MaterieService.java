package schoolProjectwithDb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import schoolProjectwithDb.data.model.Materie;
import schoolProjectwithDb.data.response.GenericResponse;
import schoolProjectwithDb.repository.MaterieRepository;

@Service
public class MaterieService {

  MaterieRepository materieRepository;

  public MaterieService (MaterieRepository materieRepository) {
    this.materieRepository = materieRepository;
  }

  public Materie getById(Long idMateria) {
    Optional<Materie> materie = materieRepository.findById(idMateria);
    if(materie.isPresent()) {
      return materie.get();
    } else {
      return null;
    }
  }

  public List<Materie> getAll() {
    return materieRepository.findAll();
  }

  public GenericResponse insert(Materie materia) {

    GenericResponse response = new GenericResponse();
    Optional<Materie> materie = materieRepository.findById(materia.getId());

    if(materie.isPresent()) {
      response.setHttpStatus(HttpStatus.NOT_FOUND);
      response.setMessage("Materia già esistente");
    } else {
      materieRepository.save(materia);
      response.setHttpStatus(HttpStatus.CREATED);
      response.setMessage("Materia inserita correttamente");
    }
    return response;
  }

  public GenericResponse deleteById(Long idMateria) {
    GenericResponse response = new GenericResponse();

    if(materieRepository.findById(idMateria).isPresent()) {
      materieRepository.deleteById(idMateria);
      response.setHttpStatus(HttpStatus.OK);
      response.setMessage("Materia cancellata correttamente");
    } else {
      response.setHttpStatus(HttpStatus.NOT_FOUND);
      response.setMessage("Materia non trovata");
    }
    return response;
  }

  public GenericResponse deleteAll() {

    GenericResponse response = new GenericResponse();
    materieRepository.deleteAll();
    response.setHttpStatus(HttpStatus.OK);
    response.setMessage("Tabella materie eliminata correttamente");
    return response;
  }
}
