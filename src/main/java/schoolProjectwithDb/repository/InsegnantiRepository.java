package schoolProjectwithDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import schoolProjectwithDb.data.model.Insegnanti;

@Repository
public interface InsegnantiRepository extends JpaRepository<Insegnanti, Long> {

}
