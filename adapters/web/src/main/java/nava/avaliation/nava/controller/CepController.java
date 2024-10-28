package nava.avaliation.nava.controller;

import nava.avaliation.nava.usecase.CepInputResponse;
import nava.avaliation.nava.usecase.CepSearchInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private CepSearchInput cepSearchInput;

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Endpoint funcionando!");
    }

    @GetMapping
    public ResponseEntity<CepInputResponse> getCep(
            @RequestParam("cep") String cepCode
    ) throws Exception {

        CepInputResponse cepInputResponse = cepSearchInput.getCep(cepCode.toString());

        return new ResponseEntity(
                cepInputResponse,
                HttpStatus.OK
        );
    }

}
