package com.devsuperior.dsmeta.sevices;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class SaleService {

    private SaleRepository repository;

    public Page<Sale> findSales( String minDate, String maxDate,Pageable pageable) {
        LocalDate min = LocalDate.parse(minDate);
        LocalDate max = LocalDate.parse(maxDate);
        return repository.findSales(min, max, pageable);
    }
}
