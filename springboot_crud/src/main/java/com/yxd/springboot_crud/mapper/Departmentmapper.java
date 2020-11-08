package com.yxd.springboot_crud.mapper;

import com.yxd.springboot_crud.entities.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface Departmentmapper {
    @Select("select * from department")
    List<Department> selectAll();
}
