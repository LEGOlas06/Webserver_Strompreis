package at.ac.htlstp.et.sj.webserver_dynamisch.model;

import at.ac.htlstp.et.sj.webserver_dynamisch.model.awattar.PriceData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PriceResponseDto {
    @JsonProperty("data")
    private List<PriceDataDto> data;
}
