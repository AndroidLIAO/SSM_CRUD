package com.crud.service.impl;

import com.crud.bean.Employee;
import com.crud.dao.EmployeeMapper;
import com.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    public List<Employee> getAll(){
        /**
         * 查询所有员工
         */
        return employeeMapper.selectByExampleWithDept(null);
    }
}
