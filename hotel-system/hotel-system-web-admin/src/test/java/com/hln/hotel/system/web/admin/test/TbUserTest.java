package com.hln.hotel.system.web.admin.test;

import com.hln.hotel.system.domain.TbUser;
import com.hln.hotel.system.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-context.xml","classpath*:spring-context-druid.xml","classpath*:spring-context-mybatis.xml"})
public class TbUserTest {
    @Autowired
    private TbUserService tbUserService;

    @Test
    public void Login(){
        TbUser tbUser = tbUserService.login("962750290@qq.com", "123456");
        System.out.println(tbUser);
    }

}
