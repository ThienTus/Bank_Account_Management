/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankaccountmanagement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Thiên Tú
 */
public abstract class TaiKhoan {

    protected String soTk;
    protected String tenTk;
    protected double soTien;
    protected Calendar ngayTao;
    protected String chuSoHuu;
    protected KhachHang maSoKhachHang;

    public TaiKhoan(String soTk, String tenTk, double soTien, KhachHang maSoKhachHang) {
        this.soTk = soTk;
        this.tenTk = tenTk;
        this.soTien = soTien;
        ngayTao = Calendar.getInstance();
        this.chuSoHuu = KhachHang.maSoKhachHang;
    }

    public TaiKhoan() {
        ngayTao = Calendar.getInstance();
    }

    public void nhapTaiKhoan() {
        while(true) {
            System.out.print("Nhap so tai khoan: ");
            this.soTk = CauHinh.sc.nextLine();
            if (this.soTk.equals(KhachHang.maSoKhachHang)) {
//                System.out.println("So tai khoan hop le!");
                break;
            } else {
                System.out.println("So tai khoan khong hop le! Vui long nhap lai!");
                System.out.println("LUU Y: So tai khoan la ma so khach hang!!!");
            }
        }
        System.out.print("Nhap ten tai khoan: ");
        this.tenTk = CauHinh.sc.nextLine();
        System.out.print("Nhap so tien: ");
        this.soTien = CauHinh.sc.nextDouble();
        this.ngayTao = Calendar.getInstance();
    }

    public void hienThiTaiKhoan() {
        System.out.printf("So tai khoan: %s\n", this.getSoTk());
        System.out.printf("Ten tai khoan: %s\n", this.getTenTk());
        System.out.printf("So tien: %,.1f VND\n", this.getSoTien());
        System.out.printf("Ngay tao tai khoan: %s\n", CauHinh.F.format(this.getNgayTao().getTime()));
    }

    public abstract boolean isDaoHan();

    public void nopTien(double st) {
        if (this.isDaoHan()) {
            this.soTien += st;
        }
    }

    public void rutTien(double st) {
        if (this.isDaoHan() && this.soTien >= st) {
            this.soTien -= st;
        }
    }

    public void nopTien() {
    }

    public void rutTien() {
    }

    public abstract double tinhLai();

    
    
    public String getSoTk() {
        return soTk;
    }

    public void setSoTk(String soTk) {
        this.soTk = soTk;
    }

    public String getTenTk() {
        return tenTk;
    }

    public void setTenTk(String tenTk) {
        this.tenTk = tenTk;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public Calendar getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Calendar ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }
    
}
