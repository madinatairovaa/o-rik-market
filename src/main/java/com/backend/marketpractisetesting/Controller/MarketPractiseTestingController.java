package com.backend.marketpractisetesting.Controller;

import com.backend.marketpractisetesting.Module.CategoryTable;
import com.backend.marketpractisetesting.Module.MarketPractiseTestingModule;
import com.backend.marketpractisetesting.Service.CategoryService;
import com.backend.marketpractisetesting.Service.MarketPractiseTestingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MarketPractiseTestingController {
    private final MarketPractiseTestingService marketPractiseTestingService;
    private final CategoryService categoryService;

    public MarketPractiseTestingController(MarketPractiseTestingService marketPractiseTestingService, CategoryService categoryService) {
        this.marketPractiseTestingService = marketPractiseTestingService;
        this.categoryService = categoryService;
    }

    @GetMapping("/getProducts")
    public List<MarketPractiseTestingModule> getProducts() {
        return marketPractiseTestingService.getProducts();
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody MarketPractiseTestingModule marketPractiseTestingModule) {
        return marketPractiseTestingService.addProduct(marketPractiseTestingModule);
    }

    @PutMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable Integer id, @RequestBody MarketPractiseTestingModule marketPractiseTestingModule) {
        return marketPractiseTestingService.updateProduct(id, marketPractiseTestingModule);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        return marketPractiseTestingService.deleteProduct(id);
    }

    @GetMapping("/getCategories")
    public List<CategoryTable> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping("/addCategory")
    public String addCategory(@RequestBody CategoryTable categoryTable) {
        return categoryService.addCategory(categoryTable);
    }

    @PutMapping("/updateCategory/{id}")
    public String updateCategory(@PathVariable Integer id, @RequestBody CategoryTable categoryTable) {
        return categoryService.updateCategory(id, categoryTable);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        return categoryService.deleteCategory(id);
    }
}