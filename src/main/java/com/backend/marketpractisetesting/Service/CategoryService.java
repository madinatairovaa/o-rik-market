package com.backend.marketpractisetesting.Service;

import com.backend.marketpractisetesting.Module.CategoryTable;
import com.backend.marketpractisetesting.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryTable> getCategories() {
        return categoryRepository.findAll();
    }

    public String addCategory(CategoryTable categoryTable) {
        categoryRepository.save(categoryTable);
        return "added";
    }

    public String updateCategory(Integer id, CategoryTable categoryTable) {
        CategoryTable oldCategory = categoryRepository.findById(id).orElse(null);

        if (oldCategory == null) {
            return "Category not found!";
        }

        if (categoryTable.getId() != null) {
            oldCategory.setId(oldCategory.getId());
        }
        if (categoryTable.getName() != null) {
            oldCategory.setName(categoryTable.getName());
        }

        categoryRepository.save(oldCategory);
        return "updated!";
    }

    public String deleteCategory(Integer id) {
        CategoryTable category = categoryRepository.findById(id).orElse(null);

        if (category == null) {
            return "Category not found!";
        }

        categoryRepository.deleteById(id);
        return "deleted";
    }
}