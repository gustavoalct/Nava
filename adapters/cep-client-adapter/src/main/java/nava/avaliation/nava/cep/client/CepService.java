package nava.avaliation.nava.cep.client;

import nava.avaliation.nava.ObjectParser;
import nava.avaliation.nava.cep.client.domain.CepOutputDto;
import nava.avaliation.nava.cep.client.dto.CepResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CepService implements CepOutput{

    private CepWebClient cepWebClient;

    @Autowired
    public CepService(CepWebClient cepWebClient) {
        this.cepWebClient = cepWebClient;
    }


    @Override
    public CepOutputDto getCep(String cepCode) throws Exception {
        CepResponseDTO cepResponseDTO = cepWebClient.getCep(cepCode);

        return ObjectParser.parser(cepResponseDTO, CepOutputDto.class);
    }
}
