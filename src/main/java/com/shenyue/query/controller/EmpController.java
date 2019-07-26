package com.shenyue.query.controller;

import com.shenyue.query.entity.EDInfo;
import com.shenyue.query.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private IEmpService iEmpService;

    @RequestMapping("/findAll")
    public String FindAll(Model model){
        List<EDInfo> list = iEmpService.selectAll();
        model.addAttribute("EDInfo",list);
        return "EDInfo";
    }
}
