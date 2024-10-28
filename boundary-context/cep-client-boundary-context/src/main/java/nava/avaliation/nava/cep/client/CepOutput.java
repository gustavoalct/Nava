package nava.avaliation.nava.cep.client;

import nava.avaliation.nava.cep.client.domain.CepOutputDto;

public interface CepOutput {

    CepOutputDto getCep(String cepCode) throws Exception;

}
