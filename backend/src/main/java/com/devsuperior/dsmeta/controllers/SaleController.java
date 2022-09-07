package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.sevices.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/sales")
public class SaleController {

    private SaleService service;

    @GetMapping
    private ResponseEntity<Page<Sale>> findSales(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        return ResponseEntity.ok(service.findSales(minDate, maxDate, pageable));
    }
}
