package at.ac.htlstp.et.sj.webserver_dynamisch.service;

import at.ac.htlstp.et.sj.webserver_dynamisch.model.awattar.PriceResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Service
public class AwattarService {

    private static final String API_URL = "https://api.awattar.at/v1/marketdata";
    private final RestTemplate restTemplate = new RestTemplate();
    
    public PriceResponse getPrices(Instant from, Instant to) {
        long fromEpoch = from.toEpochMilli();
        long toEpoch = to.toEpochMilli();
        String url = API_URL + "?start=" + fromEpoch + "&end=" + toEpoch;
        return restTemplate.getForObject(url, PriceResponse.class);
    }
}
