package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.StatusConstant;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired private CategoryMapper categoryMapper;

    @Override
    //新增分类
    public void add(CategoryDTO categoryDTO) {
        log.info("新增分类接口");
        Category category = new Category();
        //拷贝
        BeanUtils.copyProperties(categoryDTO, category);
        //其他属性自己设置
        category.setStatus(StatusConstant.DISABLE);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateUser(BaseContext.getCurrentId());
        category.setUpdateUser(BaseContext.getCurrentId());
        categoryMapper.add(category);
    }

    @Override
    //分页查询
    public PageResult pageQuery(CategoryPageQueryDTO categoryDTO) {
        log.info("分页查询接口");
        //PageHelper分页查询插件
        PageHelper.startPage(categoryDTO.getPage(), categoryDTO.getPageSize());
        Page<Category> page=categoryMapper.pageQuery(categoryDTO);
        long total = page.getTotal();
        List records = page.getResult();
        return new PageResult(total, records);
    }

    @Override
    //修改状态
    public void changeStatus(Integer status, Long id) {
        log.info("修改状态接口{},{}",status,id);
        Category category = Category.builder()
                .id(id)
                .status(status)
                .updateTime(LocalDateTime.now())
                .updateUser(BaseContext.getCurrentId())
                .build();
                categoryMapper.update(category);
    }

    @Override
    //根据id查询分类
    public List<Category> list(Integer type) {
        log.info("根据id查询接口{}",type);
        return categoryMapper.list(type);
    }


    @Override
    //根据id删除分类
    public void deleteById(Long id) {
        log.info("根据id删除分类{}",id);
        categoryMapper.deleteById(id);
    }

    @Override
    //修改分类
    public void update(CategoryDTO categoryDTO) {
        log.info("修改分类接口{}",categoryDTO);
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        category.setUpdateTime(LocalDateTime.now());
        category.setUpdateUser(BaseContext.getCurrentId());
        categoryMapper.update(category);
    }

}
