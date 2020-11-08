package com.yxd.springboot_crud.mapper;


import com.yxd.springboot_crud.entities.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface Employeemapper {

    @Select("select * from employee,department where employee.d_id = department.did")
    @Results(id="empmapper",value ={
            @Result(column = "did",property = "department.did"),
            @Result(column = "departmentName",property = "department.departmentName")
    })
    List<Employee> selectAll();

    @Insert("insert into employee(lastName,email,gender,d_id,birth) values (#{lastName},#{email},#{gender},#{d_id},#{birth})")
    void addemp(Employee employee);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},birth=#{birth} where id = #{id}")
    void updateemp(Employee employee);

    @Delete("delete from employee where id = #{id}")
    void deleteemp(Integer id);

    @Select("select * from employee,department where employee.id=#{id} and employee.d_id = department.did")
    @ResultMap("empmapper")
    Employee findByid(Integer id);


}
