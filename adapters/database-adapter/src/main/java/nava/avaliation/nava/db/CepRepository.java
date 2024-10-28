package nava.avaliation.nava.db;

import nava.avaliation.nava.db.model.CepModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CepRepository  extends JpaRepository<CepModel, String> {
}
