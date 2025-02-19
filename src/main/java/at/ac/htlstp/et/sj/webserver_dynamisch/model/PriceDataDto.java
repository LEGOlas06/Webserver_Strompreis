package at.ac.htlstp.et.sj.webserver_dynamisch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PriceDataDto {
    @JsonProperty("start_timestamp")
    private long startTimestamp;

    @JsonProperty("end_timestamp")
    private long endTimestamp;

    @JsonProperty("marketprice")
    private double marketprice;
}
