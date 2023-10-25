/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankaccountmanagement;

import java.util.Random;
import java.util.*;
import java.security.SecureRandom;

/**
 *
 * @author Thiên Tú
 */
import java.util.Random;
import java.util.Scanner;

public class TaiKhoanDangNhap {

    private final String username;
    private String password;

    public TaiKhoanDangNhap(KhachHang maSoKhachHang) {
        this.username = KhachHang.maSoKhachHang;
        this.password = taoMatKhau();
    }

    public String taoMatKhau() {
        Random rd = new Random();
        int password = rd.nextInt(100000, 999999);
        System.out.printf("Mat khau: %d\n", password);
        return String.valueOf(password);
    }

    public void hienThiThongTinTaiKhoan() {
        System.out.println("Thong tin tai khoan dang nhap:");
        System.out.println("Ten dand nhap: " + this.username);
        System.out.println("Mat khau: " + this.password);
    }

    public static boolean kiemTraMatKhau(String password) {
        if (password.length() < 6) {
            return false;
        }
        boolean hasLetter = false;
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
                break;
            }
        }
        if (!hasLetter) {
            return false;
        }

        boolean hasNumber = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
                break;
            }
        }
        return hasNumber;
    }

    public void doiMatKhau() {
        CauHinh.sc.nextLine();
        while (true) {
            System.out.print("Xac thuc mat khau cu: ");
            String mk = CauHinh.sc.nextLine();
            if (mk.equals(this.password)) {
                break;
            } else {
                System.out.println("Sai mat khau!");
            }
        }
        while(true) {
            System.out.println("Bat dau thiet lap mat khau moi");
            System.out.println("LUU Y: Mat khau co it nhat 6 ky tu, it nhat 1 chu cai, it nhat 1 chu so");
            System.out.println("Xin moi thiet lap mat khau moi: ");
            String newPassword = CauHinh.sc.nextLine();
            if (kiemTraMatKhau(newPassword)) {
                this.password = newPassword;
                System.out.println("Mat khau moi da duoc thiet lap");
                break;
            } else {
                System.out.println("Mat khau ban thiet lap khong hop le! Xin vui long nhap lai");
            }
        }
    }

    public boolean kiemTraDangNhap() {
        int dem = 0;
        String inputUsername;
        String inputPassword;
        System.out.println("=====DANG NHAP=====");
        while (dem < 5) {
            while (true) {
                System.out.print("Nhap ten dang nhap (ma so khach hang): ");
                inputUsername = CauHinh.sc.nextLine();
                if (inputUsername.equals(KhachHang.maSoKhachHang)) {
                    break;
                } else {
                    System.out.println("Ten dang nhap sai!");
                    System.out.println("LUU Y: Ten dang nhap la ma so khach hang!");
                }
            }
            while(true) {
                System.out.print("Nhap mat khau: ");
                inputPassword = CauHinh.sc.nextLine();
                if (this.username.equals(inputUsername) && this.password.equals(inputPassword)) {
                    System.out.println("Dang nhap thanh cong!");
                    return true;
                } else {
                    System.out.println("Ten dang nhap hoac mat khau khong dung.");
                    System.out.println("Ban con " + (5 - dem - 1) + " lan thu");
                    dem++;
                }
            }
        }
        System.out.println("Ban đa nhap sai thong tin đang nhap qua 5 lan, tai khoan cua ban da bi khoa!");
        System.exit(0);
        return false;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

}
