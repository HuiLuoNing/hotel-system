package com.hln.hotel.system.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"user"})
@Transactional(readOnly = true)
public class UserController {





}
