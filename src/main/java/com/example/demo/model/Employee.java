package com.example.demo.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Employee {

    // 1. Kiểm tra Tên: Không rỗng, tối thiểu 5 ký tự
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, message = "Tên phải có ít nhất 5 ký tự")
    private String name;

    // 2. Kiểm tra Email: Phải đúng định dạng
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    // 3. Kiểm tra Lương: Tối thiểu 100
    @Min(value = 100, message = "Lương phải lớn hơn hoặc bằng 100")
    private double salary;

    // Constructor, Getter, Setter (Bắt buộc)
    public Employee() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
