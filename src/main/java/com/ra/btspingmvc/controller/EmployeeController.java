package com.ra.btspingmvc.controller;


import com.ra.btspingmvc.model.entity.Employee;
import com.ra.btspingmvc.model.service.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployee iEmployee;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("employeeList", iEmployee.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String redirectAdd() {
        return "add";
    }

    @RequestMapping("/addemployee")
    public String add(@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phone") String phone, @RequestParam("status") Boolean status) {
        Employee employee = new Employee(null, name, address, phone, status);
        iEmployee.save(employee);
        return "redirect:/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        iEmployee.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String takeEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("employee", iEmployee.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phone") String phone, @RequestParam("status") Boolean status) {
        Employee employee = new Employee(id, name, address, phone, status);
        iEmployee.update(employee);
        return "redirect:/list";
    }
}

