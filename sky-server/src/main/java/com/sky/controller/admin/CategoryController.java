package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类相关接口")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    //新增分类
    @PostMapping
    @ApiOperation("新增分类接口")
    public Result add(@RequestBody CategoryDTO categoryDTO){
        log.info("新增分类接口");
        categoryService.add(categoryDTO);
        return Result.success();
    }
    //分类分页查询
    @GetMapping("/page")
    @ApiOperation("分类分页查询接口")
    //Query 参数
    public Result<PageResult> page(CategoryPageQueryDTO categoryDTO){
        log.info("分类分页查询接口{}",categoryDTO);
        PageResult pageResult = categoryService.pageQuery(categoryDTO);
        return Result.success(pageResult);
    }
    //修改分类启用状态
    @PostMapping("/status/{status}")
    @ApiOperation("修改分类启用状态接口")
    public Result changeStatus(@PathVariable Integer status,Long id){
        log.info("修改分类启用状态接口{},{}",status,id);
        categoryService.changeStatus(status,id);
        return Result.success();
    }
    //根据类型查询分类
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类接口")
    public Result<List<Category>> list(Integer type){
        log.info("根据类型查询分类接口{}",type);
        List<Category> list=categoryService.list(type);
        return Result.success(list);
    }
    //根据id删除分类
    @DeleteMapping
    @ApiOperation("根据id删除分类接口")
    public Result deleteById(Long id){
        log.info("根据id删除分类{}",id);
        categoryService.deleteById(id);
        return Result.success();
    }
    //修改分类
    @PutMapping
    @ApiOperation("修改分类接口")
    public Result update(@RequestBody CategoryDTO categoryDTO){
        log.info("修改分类接口{}",categoryDTO);
        categoryService.update(categoryDTO);
        return Result.success();
    }
}
