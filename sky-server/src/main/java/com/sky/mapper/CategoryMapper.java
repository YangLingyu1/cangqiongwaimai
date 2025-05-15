package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Insert("insert into category (type, name, sort, status, create_time, update_time, create_user, update_user) values (#{type}, #{name}, #{sort}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void add(Category category);

    //分页
    Page<Category> pageQuery(CategoryPageQueryDTO categoryDTO);
    //更新
    void update(Category category);

    //根据类型查询
    @Select("select * from category where type = #{type}")
    List<Category> list(Integer type);

    //删除
    @Delete("delete from category where id = #{id}")
    void deleteById(Long id);
}
