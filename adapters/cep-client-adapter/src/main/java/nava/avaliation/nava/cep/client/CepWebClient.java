package nava.avaliation.nava.cep.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import nava.avaliation.nava.cep.client.dto.CepResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@Component
public class CepWebClient {

    @Qualifier("RestTemplate")
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public CepWebClient(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public CepResponseDTO getCep(String cepCode) throws Exception{

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = "https://viacep.com.br/ws/"+cepCode+"/json/";

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> responseEntity = restTemplate
                    .exchange(url, HttpMethod.GET, entity, String.class);

            String body = responseEntity.getBody();


            return objectMapper.readValue(responseEntity.getBody(), new TypeReference<CepResponseDTO>() {
            });
        } catch (HttpClientErrorException exception) {
            throw new Exception(
                    "Get cep failed"
            );
        }

    }


}
