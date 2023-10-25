/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankaccountmanagement;

import java.util.Scanner;

/**
 *
 * @author Thiên Tú
 */
public class TaiKhoanKhongKyHan extends TaiKhoan {


    public TaiKhoanKhongKyHan() {
    }

    public TaiKhoanKhongKyHan(String soTk, String tenTk, double soTien, KhachHang maSoKhachHang) {
        super(soTk, tenTk, soTien, maSoKhachHang);
    }
    
    public void chuyenTienVaoTKC (double tienNap){
        soTien += tienNap;
    }


    @Override
    public void nopTien() {
        System.out.print("Nhap so tien nap: ");
        double soTienNap = CauHinh.sc.nextDouble();
        soTien += soTienNap;
        System.out.println("Nap tien thanh cong.");
    }

@Override
public void rutTien() {
    System.out.print("Nhap so tien muon rut: ");
    double soTienRut = CauHinh.sc.nextDouble();
    if (soTienRut > soTien) {
        System.out.println("So tien vuot qua so du trong tai khoan.");
    } else {
        soTien -= soTienRut;
        System.out.println("Rut tien thanh cong.");
    }
}
    @Override
    public void nhapTaiKhoan() {
        System.out.print("\n=====Mo Tai Khoan=====\n");
        super.nhapTaiKhoan();
    }

    @Override
    public void hienThiTaiKhoan() {
        System.out.println("================================");
        System.out.print("=====Tai Khoan Khong Ky Han=====\n");
        super.hienThiTaiKhoan();
    }

    @Override
    public double tinhLai() {
        double lai = (this.soTien * 0.2) / 1200;
        System.out.println("Lai suat la: 0.2%/nam");
        System.out.println("Lai la: " + lai);
        return lai;
    }

    @Override
    public boolean isDaoHan() {
        return true;
    }
}
