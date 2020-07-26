package com.crud.test;

import com.crud.bean.Employee;
import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * 使用Spring测试模块提供的测试请求功能，测试crud的正确性
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:springMVC.xml"})
public class MvcTest {
    //虚拟mvc请求，获取到处理结果
    MockMvc mockMvc;
    //传入SpringMVC的ioc容器
    @Autowired
    WebApplicationContext webApplicationContext;

    /**
     * 模拟传入SpringMVC的配置文件
     */
    @Before
    public void initMockMvc(){
        mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testPage() throws Exception {
        //模拟请求拿到返回值
        MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/emps")
                .param("page","1")).andReturn();
        //请求成功后，请求域中会有pageInfo；我们可以取出pageInfo进行验证
        MockHttpServletRequest request=result.getRequest();
        PageInfo attribute=(PageInfo)request.getAttribute("pageInfo");
        System.out.println("当前页码，"+attribute.getPageNum());
        System.out.println("总页码，"+attribute.getPages());
        System.out.println("总记录，"+attribute.getTotal());
        int[] nums=attribute.getNavigatepageNums();
        System.out.println("在页面需要连续显示的页码，");
        for(int i:nums){
            System.out.println("  "+i);
        }

        //获取员工数据
        List<Employee> emps=attribute.getList();
        for(Employee employee:emps){
            System.out.println("ID"+employee.getdId()+"==->name:"+employee.getEmpName());
        }
    }
}
