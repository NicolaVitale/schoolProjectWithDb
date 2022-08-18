package schoolProjectwithDb.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schoolProjectwithDb.data.dto.AlunniDTO;
import schoolProjectwithDb.data.model.Alunni;
import schoolProjectwithDb.data.response.GenericResponse;
import schoolProjectwithDb.service.AlunniService;

@RestController
@RequestMapping("/alunni")
public class AlunniController {

  private AlunniService alunniService;

  public AlunniController(AlunniService alunniService) {
    this.alunniService = alunniService;
  }

  @GetMapping
  public List<Alunni> getAll() {
    return alunniService.getAll();
  }

  @GetMapping("/{idAlunno}")
  public Alunni getById(@PathVariable Long id) {
    return alunniService.getById(id);
  }

  @PostMapping
  public GenericResponse insert(@RequestBody AlunniDTO alunno) {
    return alunniService.insert(alunno.toModel());
  }

  @DeleteMapping
  public GenericResponse deleteAll() {
    return alunniService.deleteAll();
  }

  @DeleteMapping("/{idAlunno}")
  public GenericResponse deleteById(@PathVariable Long id){
    return alunniService.deleteById(id);
  }

}
