package com.crud.test;

import com.crud.dao.DepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 1、导入SpringTest模块
 * 2、@ContextConfiguration指定Spring配置文件的位置
 * 3、直接autowired组件即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    /**
     * 测试Department
     */
    @Test
    public void testCRUD(){

        System.out.println(departmentMapper);
    }
}
