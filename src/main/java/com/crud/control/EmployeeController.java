package com.crud.control;

import com.crud.bean.Employee;
import com.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 处理员工CRUD请求
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    /**
     * 查询员工数据（分页查询）
     * @return
     */
    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value="page",defaultValue = "1") Integer page, Model model){
       //为了实现分页查询，我们从前端传入一个参数page
        //在查询之前只需要调用，传入页码以及每页的大小
        PageHelper.startPage(page,5);
        List<Employee>emps= employeeService.getAll();
        //使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了
        PageInfo pageInfo=new PageInfo(emps,5);
        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }
}
