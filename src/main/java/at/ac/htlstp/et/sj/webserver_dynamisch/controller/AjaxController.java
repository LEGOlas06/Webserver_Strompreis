package at.ac.htlstp.et.sj.webserver_dynamisch.controller;

import at.ac.htlstp.et.sj.webserver_dynamisch.model.api.AnfrageDto;
import at.ac.htlstp.et.sj.webserver_dynamisch.model.api.ErgebnisDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AjaxController {

    @PostMapping("/api/add")
    public ResponseEntity<ErgebnisDto> addiere(@RequestBody AnfrageDto a) {
        double summe = a.getWert1() + a.getWert2();
        ErgebnisDto ergebnis = new ErgebnisDto(summe);
        return ResponseEntity.ok(ergebnis);
    }
}
