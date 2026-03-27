package com.backend.marketpractisetesting.Repository;

import com.backend.marketpractisetesting.Module.CategoryTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryTable, Integer> {
}