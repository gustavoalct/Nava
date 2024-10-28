package nava.avaliation.nava.usecase;

import nava.avaliation.nava.ObjectParser;
import nava.avaliation.nava.cep.client.CepOutput;
import nava.avaliation.nava.cep.client.domain.CepOutputDto;
import nava.avaliation.nava.db.output.CepDataBaseOutput;
import nava.avaliation.nava.db.output.domain.CepOutputDb;
import nava.avaliation.nava.domain.CepEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepSearchUseCase implements CepSearchInput{

    @Autowired
    private CepOutput cepOutput;
    @Autowired
    private CepDataBaseOutput cepDataBaseOutput;


    @Override
    public CepInputResponse getCep(String cepCode) throws Exception {

       CepEntity cepEntity = ObjectParser.parser(cepOutput.getCep(cepCode), CepEntity.class);

        cepDataBaseOutput.save(ObjectParser.parser(cepEntity, CepOutputDb.class));


        return ObjectParser.parser(cepEntity, CepInputResponse.class);

    }

}
