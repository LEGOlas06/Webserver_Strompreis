package at.ac.htlstp.et.sj.webserver_dynamisch.model.awattar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PriceResponse {
    @JsonProperty("data")
    private List<PriceData> data;
}
