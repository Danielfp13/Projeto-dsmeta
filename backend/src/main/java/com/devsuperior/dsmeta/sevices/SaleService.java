package com.devsuperior.dsmeta.sevices;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SaleService {

    private SaleRepository repository;

    public List<Sale> findSales(){
        return repository.findAll();
    }
}
