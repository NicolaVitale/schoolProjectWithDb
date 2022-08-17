package schoolProjectwithDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import schoolProjectwithDb.data.model.Alunni;

@Repository
public interface AlunniRepository extends JpaRepository<Alunni, Long> {

}
