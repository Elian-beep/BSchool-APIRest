package br.com.kihan.BSchool.httpClient;

import br.com.kihan.BSchool.entity.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cep-client", url = "https://brasilapi.com.br/api")
public interface CepHttpClient {
    @GetMapping("/cep/v2/{cep}")
    public Address getAddressByCep(@PathVariable("cep") String cep);
}
