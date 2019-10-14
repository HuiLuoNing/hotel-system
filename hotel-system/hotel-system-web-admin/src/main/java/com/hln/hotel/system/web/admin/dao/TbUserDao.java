package com.hln.hotel.system.web.admin.dao;

import com.hln.hotel.system.domain.TbUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUserDao {
    /**
     * 查询邮箱
     * @return
     */
    TbUser getByEmail(String email);
}
