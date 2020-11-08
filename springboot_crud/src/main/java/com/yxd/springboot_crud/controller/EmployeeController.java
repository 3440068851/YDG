package com.yxd.springboot_crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.yxd.springboot_crud.entities.Department;
import com.yxd.springboot_crud.entities.Employee;
import com.yxd.springboot_crud.mapper.Departmentmapper;
import com.yxd.springboot_crud.mapper.Employeemapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller

public class EmployeeController {
    @Autowired

   private Employeemapper employeemapper ;

    @Autowired
    private Departmentmapper departmentmapper;

    //查询所有员工返回页面

    @RequestMapping("/search")
    public String search(@RequestParam("id") Integer id,Model model){
        Employee emp = employeemapper.findByid(id);

        model.addAttribute("emp",emp);

        return "emp/listone";

    }


    @RequestMapping("/emps")
        public String show(Model model){
            List<Employee> emps =employeemapper.selectAll();

            model.addAttribute("emps",emps);
           /* //1.分页查询
            PageHelper.startPage(pageNo,pageSize);
            List<Employee> emps = employeemapper.selectAll();
            PageInfo<Employee> pageInfo = new PageInfo<>(emps);
            //2.存进model
            model.addAttribute("pageInfo",pageInfo);
            //3.跳转到users下的show页面
            //1.分页*/
        return "emp/list";
    }

    @GetMapping("/toaddemp")
    public String toAddpage(Model model){

        List<Department> dpms = departmentmapper.selectAll();
        model.addAttribute("dpms",dpms);

       /* List<Employee> emps =employeemapper.selectAll();

        model.addAttribute("emps",emps);*/
        return "emp/add";
    }

    @PostMapping("/emp")
    public String Addpage(Employee employee){
        employeemapper.addemp(employee);

        return "redirect:/emps";
    }
    //删除
    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id,Employee employee){

        employeemapper.deleteemp(id);
        return "redirect:/emps";
    }
    //来到修改界面
    @RequestMapping("/toupdate/{id}")
    public String toUpdatePage(@PathVariable Integer id,Model model){
        Employee emp = employeemapper.findByid(id);
        model.addAttribute("emp",emp);
        return "emp/update";
    }

    @RequestMapping("/update")
    public String upDate(Employee employee){

        employeemapper.updateemp(employee);

        return "redirect:/emps";
    }
    //来到员工添加页面
   /* @GetMapping("/emp")
    public String toAddpage(Model model){

        Collection<Department> departments = departmentDao.getDepartments();

        model.addAttribute("dpms",departments);
        return "emp/add";
    }

    //员工添加
    @PostMapping("/emp")
    public String addEmp(Employee employee){

       // System.out.println("增加的员工信息："+employee);
        employeeDao.save(employee);
       //redirect重定向
        //forward转发到一个地址
        return "redirect:/emps";//"/"当前项目下
    }

    //来到员工修改页面，查出当前员工信息并回写
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();

        model.addAttribute("dpms",departments);

        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updatePage(Employee employee){
        employeeDao.save(employee);
        System.out.println("修改后的数据："+employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);

        return "redirect:/emps";
    }*/


}
