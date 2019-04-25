package com.okz.cip.controller;

import com.okz.cip.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huangyang
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2019/04/24 下午4:55
 */

@Controller
@RequestMapping
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("demo")
    public String demo(HttpServletRequest request){
        Integer one = demoService.findOne();
        return "index";
    }


}
