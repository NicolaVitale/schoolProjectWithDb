package schoolProjectwithDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import schoolProjectwithDb.data.model.Materie;

@Repository
public interface MaterieRepository extends JpaRepository<Materie, Long> {

}
