package at.ac.htlstp.et.sj.webserver_dynamisch.controller;

import at.ac.htlstp.et.sj.webserver_dynamisch.model.PriceDataDto;
import at.ac.htlstp.et.sj.webserver_dynamisch.model.PriceFormDto;
import at.ac.htlstp.et.sj.webserver_dynamisch.model.PriceResponseDto;
import at.ac.htlstp.et.sj.webserver_dynamisch.model.awattar.PriceResponse;
import at.ac.htlstp.et.sj.webserver_dynamisch.service.AwattarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class PriceController {

    private final AwattarService awattarService;

    public PriceController(AwattarService awattarService) {
        this.awattarService = awattarService;
    }

    @GetMapping("/prices")
    public String showPriceForm(Model model) {
        model.addAttribute("priceForm", new PriceFormDto());
        return "prices";
    }

    @PostMapping("/prices")
    public String getPriceData(@ModelAttribute("priceForm") PriceFormDto priceForm, Model model) {
        try {
            Instant from = parseDateTime(priceForm.getFrom());
            Instant to =parseDateTime(priceForm.getTo());
            PriceResponse response = awattarService.getPrices(from, to);
            PriceResponseDto responseDto = new PriceResponseDto();
            List<PriceDataDto> dataDto = response.getData().stream()
                    .map(priceData -> {
                        PriceDataDto priceDataDto = new PriceDataDto();
                        priceDataDto.setStartTimestamp(priceData.getStartTimestamp().getEpochSecond());
                        priceDataDto.setEndTimestamp(priceData.getEndTimestamp().getEpochSecond());
                        priceDataDto.setMarketprice(priceData.getMarketprice());
                        return priceDataDto;
                    })
                    .toList();
            responseDto.setData(dataDto);
            model.addAttribute("prices", responseDto.getData());
        } catch (Exception e) {
            model.addAttribute("error", "Error retrieving price data: " + e.getMessage());
        }
        return "prices";
    }
    
    private Instant parseDateTime(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
        return localDateTime.atZone(ZoneId.of("UTC")).toInstant();
    }
}