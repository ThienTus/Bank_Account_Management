package com.mycompany.bankaccountmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Thiên Tú
 */
public class KhachHang {

    private static int dem;
    private String hoTen;
    private String gioiTinh;
    private String ngaySinh;
    private String queQuan;
    private String canCuocCongDan;
    private double soTienGui;
    protected static String maSoKhachHang;
    private String soThuTu;
    private Date ngayTao;

    public KhachHang() {
    }

    public KhachHang(String hoTen, String gioiTinh, String ngaySinh, String queQuan, String canCuocCongDan, double soTienGui, String maSoKhachHang) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.canCuocCongDan = canCuocCongDan;
        this.soTienGui = soTienGui;
        this.maSoKhachHang = maSoKhachHang;
    }

    {
        soThuTu = String.format("%04d", ++dem);
        ngayTao = new Date();
    }

    public void nhapKhachHang() {
//        System.out.print("Nhap so luong khach hang: ");
//        int n = CauHinh.sc.nextInt();
//        CauHinh.sc.nextLine();

//        for (int i = 0; i < n; i++) {
        while (true) {
            System.out.println("==========================");
            System.out.println("Nhap thong tin khach hang "/*thu + (i + 1)*/);
            System.out.print("Nhap ho va ten khach hang: ");
            String hoTen = CauHinh.sc.nextLine();
            System.out.print("Nhap gioi tinh: ");
            String gioiTinh = CauHinh.sc.nextLine();
            System.out.print("Nhap ngay sinh (ngay/thang/nam): ");
            String ngaySinh = CauHinh.sc.nextLine();
            System.out.print("Nhap que quan: ");
            String queQuan = CauHinh.sc.nextLine();
            System.out.print("Nhap so CCCD: ");
            String cccd = CauHinh.sc.nextLine();
            System.out.print("Nhap so tien gui (toi thieu 50.000 VND): ");
            Double soTienGui = CauHinh.sc.nextDouble();
            CauHinh.sc.nextLine();
            while (soTienGui < 50000) {
                System.out.println("Khong dat so tien gui toi thieu! Vui long nhap lai!");
                System.out.print("Nhap so tien gui (toi thieu 50.000 VND): ");
                soTienGui = CauHinh.sc.nextDouble();
                CauHinh.sc.nextLine();
            }

            this.hoTen = hoTen;
            this.gioiTinh = gioiTinh;
            this.ngaySinh = ngaySinh;
            this.queQuan = queQuan;
            this.canCuocCongDan = cccd;
            this.soTienGui = soTienGui;

            userName();

            break;
        }
    }

    public void hienThiKhachHang() {
        System.out.println("\n==================================");
        System.out.println("Thong tin khach hang: ");
        System.out.printf("Ho ten: %s", this.hoTen);
        System.out.printf("\nGioi tinh: %s", this.gioiTinh);
        System.out.printf("\nNgay sinh: %s", this.ngaySinh);
        System.out.printf("\nQue quan: %s", this.queQuan);
        System.out.printf("\nSo CCCD: %s", this.canCuocCongDan);
        System.out.printf("\nSo tien gui: %,.1f VND", this.soTienGui);
        System.out.printf("\nMa so khach hang: %s", this.maSoKhachHang);
    }

    public void userName() {
        String ns = ngaySinh;
        String[] a = ns.split("/");
        StringBuilder a1 = new StringBuilder();
        for (String a2 : a) {
            a1.append(a2);
        }
        maSoKhachHang = a1 + this.soThuTu;
//        System.out.println("Username: " + maSoKhachHang);
    }

    public String getHoTen() {
        return hoTen;
    }

    public static int getDem() {
        return dem;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public String getCanCuocCongDan() {
        return canCuocCongDan;
    }

    public double getSoTienGui() {
        return soTienGui;
    }

    public static String getMaSoKhachHang() {
        return maSoKhachHang;
    }

    public String getSoThuTu() {
        return soThuTu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public static void setDem(int dem) {
        KhachHang.dem = dem;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setCanCuocCongDan(String canCuocCongDan) {
        this.canCuocCongDan = canCuocCongDan;
    }

    public void setSoTienGui(double soTienGui) {
        this.soTienGui = soTienGui;
    }

    public static void setMaSoKhạchHang(String maSoKhachHang) {
        KhachHang.maSoKhachHang = maSoKhachHang;
    }

    public void setSoThuTu(String soThuTu) {
        this.soThuTu = soThuTu;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

}
