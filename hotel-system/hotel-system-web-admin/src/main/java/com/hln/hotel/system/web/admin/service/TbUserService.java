package com.hln.hotel.system.web.admin.service;

import com.hln.hotel.system.domain.TbUser;

public interface TbUserService {

    /**
     * 登录
     *
     * @param email    邮箱
     * @param password 密码
     * @return
     */
    TbUser login(String email, String password);

}
