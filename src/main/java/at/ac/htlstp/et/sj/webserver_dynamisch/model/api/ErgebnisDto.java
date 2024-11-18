package at.ac.htlstp.et.sj.webserver_dynamisch.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class ErgebnisDto {
    /** Ergebnis der Berechnung */
    private double ergebnis;
}
