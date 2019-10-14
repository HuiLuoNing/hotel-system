package com.hln.hotel.system.web.admin.service.impl;

import com.hln.hotel.system.domain.TbUser;
import com.hln.hotel.system.web.admin.dao.TbUserDao;
import com.hln.hotel.system.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;


    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = null;
        tbUser = tbUserDao.getByEmail(email);
        //进行判断tbUser是否为空，为空则email错误
        if (tbUser != null) {
            String passwordToTbUser = tbUser.getPassword();
            //将客户端传来的password加密与数据库中获取到的密码进行比较
            boolean equals = passwordToTbUser.equals(
                    DigestUtils.md5DigestAsHex(password.getBytes()));
            if (equals != false) {
                return tbUser;
            } else {
                return null;
            }
        }
        return tbUser;
    }
}
