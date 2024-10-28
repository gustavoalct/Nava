package nava.avaliation.nava.db;

import nava.avaliation.nava.ObjectParser;
import nava.avaliation.nava.db.model.CepModel;
import nava.avaliation.nava.db.output.CepDataBaseOutput;
import nava.avaliation.nava.db.output.domain.CepOutputDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepDatabaseService implements CepDataBaseOutput {

    @Autowired
    private CepRepository cepRepository;

    public CepDatabaseService(CepRepository cepRepository){
        this.cepRepository = cepRepository;
    }

    @Override
    public CepOutputDb save(CepOutputDb cepOutputDto) {
        return ObjectParser.parser(cepRepository.save(ObjectParser.parser(cepOutputDto, CepModel.class)), CepOutputDb.class);

    }
}
