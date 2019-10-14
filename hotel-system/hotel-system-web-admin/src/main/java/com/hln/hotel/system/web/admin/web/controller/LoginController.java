package com.hln.hotel.system.web.admin.web.controller;

import com.hln.hotel.system.commons.constant.ConstantUtils;
import com.hln.hotel.system.domain.TbUser;
import com.hln.hotel.system.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录管理
 */
@Controller
public class LoginController {

    @Autowired
    TbUserService tbUserService;

    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 根据邮箱和密码登录
     * @param email 邮箱
     * @param password 密码
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = {"login"},method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest request, Model model){
        TbUser tbUser = tbUserService.login(email, password);

        //登录失败
        if( tbUser == null){
            model.addAttribute("message","用户或密码错误，请重新输入");
            return login();
        }

        //登录成功
        else {
            //将登录信息放入会话
            request.getSession().setAttribute(ConstantUtils.SESSION_USER, tbUser);
            return "redirect:/main";
        }

    }

    /**
     * 注销
     * @return
     */
    @RequestMapping(value = {"loginOut"}, method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request){
        //清除session数据
        request.getSession().invalidate();
        return "redirect:/login";
    }
}
