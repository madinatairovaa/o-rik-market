package com.backend.marketpractisetesting.Service;

import com.backend.marketpractisetesting.Module.MarketPractiseTestingModule;
import com.backend.marketpractisetesting.Repository.MarketPractiseTestingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketPractiseTestingService {
    private final MarketPractiseTestingRepository marketPractiseTestingRepository;

    public MarketPractiseTestingService(MarketPractiseTestingRepository marketPractiseTestingRepository) {
        this.marketPractiseTestingRepository = marketPractiseTestingRepository;
    }

    public String addProduct(MarketPractiseTestingModule marketPractiseTestingModuleAdding) {
        marketPractiseTestingRepository.save(marketPractiseTestingModuleAdding);
        return "added successfully!";
    }

    public List<MarketPractiseTestingModule> getProducts() {
        return marketPractiseTestingRepository.findAll();
    }

    public String updateProduct(Integer id,MarketPractiseTestingModule marketPractiseTestingModuleUpdating) {
        MarketPractiseTestingModule oldProduct = marketPractiseTestingRepository.findById(id).orElse(null);

        if (oldProduct == null) return "Product not found!";

        if (marketPractiseTestingModuleUpdating.getTitle() != null) {
            oldProduct.setTitle(marketPractiseTestingModuleUpdating.getTitle());
        }

        if (marketPractiseTestingModuleUpdating.getCost() != null) {
            oldProduct.setCost(marketPractiseTestingModuleUpdating.getCost());
        }

        marketPractiseTestingRepository.save(oldProduct);
        return "updated successfully";
    }

    public String deleteProduct(Integer id) {
        MarketPractiseTestingModule product = marketPractiseTestingRepository.findById(id).orElse(null);

        if (product == null) return "Product not found!";

        marketPractiseTestingRepository.deleteById(id);
        return "deleted successfully!";
    }
}