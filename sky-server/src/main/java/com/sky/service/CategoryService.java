package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

public interface CategoryService {
    void add(CategoryDTO categoryDTO);

    PageResult pageQuery(CategoryPageQueryDTO categoryDTO);

    void changeStatus(Integer status, Long id);

    List<Category> list(Integer type);

    void deleteById(Long id);

    void update(CategoryDTO categoryDTO);
}
