package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    //查询员工
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);
    //新增员工
    @Insert("insert into employee (name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user) " +
            "values (#{name}, #{username}, #{password}, #{phone}, #{sex}, #{idNumber}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void add(Employee employee);

    //XML(员工分页)
    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);
    //XML(修改员工状态)
    void update(Employee employee);

    //根据id查询员工
    @Select("select * from employee where id = #{id}")
    Employee getById(Long id);
}
