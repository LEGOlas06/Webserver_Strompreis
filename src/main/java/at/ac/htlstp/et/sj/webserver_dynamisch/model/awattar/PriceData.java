package at.ac.htlstp.et.sj.webserver_dynamisch.model.awattar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class PriceData {
    @JsonProperty("start_timestamp")
    private Instant startTimestamp;

    @JsonProperty("end_timestamp")
    private Instant endTimestamp;

    @JsonProperty("marketprice")
    private double marketprice;

}
