package com.cron.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestControler {
    @GetMapping("/test")
    public ModelAndView testPage(){
        ModelAndView result = new ModelAndView("test/testPage");
        result.addObject("testPage", "Hello, World!");
        return result;
    }
}
