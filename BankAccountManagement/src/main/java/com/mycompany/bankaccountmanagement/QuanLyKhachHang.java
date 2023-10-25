/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankaccountmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Thiên Tú
 */
public class QuanLyKhachHang {

    private List<KhachHang> ds = new ArrayList<>();

    public void themKh(KhachHang... a) {
        this.getDs().addAll(Arrays.asList(a));
    }
    
    public void themKhachHang(KhachHang khachHang) {
        this.getDs().add(khachHang);
    }
    
    public void traCuuKhachHang() {
        System.out.print("Nhap ten khach hang: ");
        String HoTen = CauHinh.sc.nextLine();
        System.out.print("Nhap ma so khach hang: ");
        String MaSo = CauHinh.sc.nextLine();
        boolean timThay = false;
        for (KhachHang khachHang : ds) {
            String hoTen = khachHang.getHoTen();
            if (hoTen != null && khachHang.getHoTen().equals(HoTen) && khachHang.getMaSoKhachHang().equals(MaSo)) {
                khachHang.hienThiKhachHang();
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay khach hang nao voi ma so " + MaSo + " va ho ten la " + HoTen);
        }
    }

    public void hienThi() {
        System.out.println("Danh sach khach hang:");
        for (KhachHang kh : ds) {
            kh.hienThiKhachHang();
        }
    }
    
    public void sapXepGiamTheoTien() {
        this.getDs().sort(Comparator.comparing(KhachHang::getSoTienGui, Comparator.reverseOrder()));
    }
    
    public List<KhachHang> getDs() {
        return ds;
    }

    public void setDs(List<KhachHang> ds) {
        this.ds = ds;
    }
    
}
