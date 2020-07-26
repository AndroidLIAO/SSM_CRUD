package com.crud.service;

import com.crud.bean.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * 查询员工所有
     */
    public List<Employee> getAll();
}
