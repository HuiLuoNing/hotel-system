package com.hln.hotel.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hln.hotel.system.commons.utils.RegexpUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class TbUser {

    private Integer id;

    @Length(min = 6, max = 20, message = "用户名的有效长度6~20")
    private String username;

    @JsonIgnore
    @Length(min = 6, max = 20, message = "密码的有效长度6~20")
    private String password;

    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号格式错误")
    private String phone;

    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式错误")
    private String email;
    private boolean is_sys_admin;
    private Date created;
    private Date updated;
}
