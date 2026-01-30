package com.example.demo.controller;


import com.example.demo.model.Employee;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    // Hiển thị form
    @GetMapping("/add-employee")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    // Xử lý khi Submit
    @PostMapping("/add-employee")
    public String submitForm(
            @Valid @ModelAttribute("employee") Employee employee, // 1. Kích hoạt Validate
            BindingResult result,                                 // 2. Chứa kết quả lỗi (nếu có)
            Model model) {

        // Kiểm tra xem có lỗi nào không
        if (result.hasErrors()) {
            // Nếu có lỗi, quay lại trang nhập liệu để hiển thị thông báo
            return "add-employee";
        }

        // Nếu không có lỗi, chuyển sang trang kết quả
        model.addAttribute("message", "Thêm nhân viên thành công: " + employee.getName());
        return "result";
    }
}