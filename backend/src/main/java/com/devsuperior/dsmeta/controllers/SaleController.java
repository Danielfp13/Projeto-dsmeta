package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.sevices.SaleService;
import com.devsuperior.dsmeta.sevices.SmsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/sales")
public class SaleController {

    private SaleService service;
    private SmsService smsService;

    @GetMapping
    private ResponseEntity<Page<Sale>> findSales(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        return ResponseEntity.ok(service.findSales(minDate, maxDate, pageable));
    }

    @GetMapping("/{id}/notification")
    private ResponseEntity<Void> notifySms(@PathVariable Long id) {
        smsService.sendSms(id);
        return ResponseEntity.ok().build();
    }
}
