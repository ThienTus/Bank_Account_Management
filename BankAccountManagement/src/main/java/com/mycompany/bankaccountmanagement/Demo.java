package com.mycompany.bankaccountmanagement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Thiên Tú
 */
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws IOException {
        KhachHang kh1 = new KhachHang();
        kh1.nhapKhachHang();
        kh1.hienThiKhachHang();
        
        TaiKhoanKhongKyHan tkc = new TaiKhoanKhongKyHan();
        tkc.setChuSoHuu(kh1.getMaSoKhachHang());
        tkc.nhapTaiKhoan();
        tkc.hienThiTaiKhoan();
        
        TaiKhoanDangNhap tkdn = new TaiKhoanDangNhap(kh1);
        tkdn.hienThiThongTinTaiKhoan();
        tkdn.doiMatKhau();
        tkdn.kiemTraDangNhap();
        
        KhachHang kh2 = new KhachHang();//them khach hang
        
        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        qlkh.themKh(kh1/*,kh2*/);
        
        TaiKhoanKyHan tkkh1 = new TaiKhoanKyHan();
        tkkh1.setChuSoHuu(kh1.getMaSoKhachHang());
        
        TaiKhoanKyHan tkkh2 = new TaiKhoanKyHan();
        tkkh2.setChuSoHuu(kh2.getMaSoKhachHang());
        
        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        qltk.themTk(tkc, tkkh1, tkkh2);
        int chon;
        do {
            System.out.println("\n***** MENU *****");
            System.out.println("1. Mo tai khoan co ky han");
            System.out.println("2. Tinh lai tai khoan");
            System.out.println("3. Gui tien (ap dung cho tai khoan khong ky han)");
            System.out.println("4. Rut tien (ap dung cho tai khoan khong ky han)");
            System.out.println("5. Rut tien (tai khoan co ky han truoc ngay dao han)");
            System.out.println("6. Tra cuu khach hang (theo ho ten va ma so khach hang)");
            System.out.println("7. Tra cuu danh sach tai khoan cua mot khach hang (theo ma so khach hang)");
            System.out.println("8. Sap xep danh sach khach hang co tong so tien giam dan");
            System.out.println("9. Them khach hang");
            System.out.println("10. Thoat");
            System.out.println("===========================================================");
            System.out.print("Nhap lua chon cua ban: ");
            chon = CauHinh.sc.nextInt();
            CauHinh.sc.nextLine();
            switch (chon) {
                case 1 -> {
                    System.out.println("========================");
                    System.out.println("Tai Khoan ky han thu 1: ");
                    tkkh1.nhapTaiKhoan();
                    tkkh1.hienThiTaiKhoan();
                    System.out.println("========================");
                    System.out.println("Tai Khoan ky han thu 2: ");
                    tkkh2.nhapTaiKhoan();
                    tkkh2.hienThiTaiKhoan();
                    break;
                }
                case 2 -> {
                    String soTK;
                    while (true) {
                        System.out.print("Nhap so tai khoan: ");
                        soTK = CauHinh.sc.nextLine();
                        if (soTK.equals(KhachHang.maSoKhachHang)) {
                            break;
                        } else {
                            System.out.println("So tai khoan khong hop le! Vui long nhap lai!");
                            System.out.println("LUU Y: So tai khoan la ma so khach hang!!!");
                        }
                    }
                    TaiKhoan taiKhoan = qltk.traCuuTaiKhoanTheoSoTaiKhoan(KhachHang.maSoKhachHang);
                    if (taiKhoan != null) {
                        System.out.println("Thong tin tai khoan:");
                        taiKhoan.hienThiTaiKhoan();
                        double tienlai = taiKhoan.tinhLai();
                        System.out.println("Tien Lai: " + tienlai);
                    } else {
                        System.out.println("Khong tim thay tai khoan co so tai khoan la " + soTK);
                    }
                    break;
                }

                case 3 -> {
                    tkc.nopTien();
                    tkc.hienThiTaiKhoan();
                }
                case 4 -> {
                    tkc.rutTien();
                    tkc.hienThiTaiKhoan();
                }
                case 5 -> {
                    tkkh1.rutTienTruocNgayDaoHan(tkc);
                    tkc.hienThiTaiKhoan();
                }
                case 6 -> {
                    qlkh.traCuuKhachHang();
                }
                case 7 -> {
                    System.out.print("Nhap ma so khach hang: ");
                    String maKh = CauHinh.sc.nextLine();
                    qltk.traCuuDanhSachTaiKhoanTheoMaSoKhachHang(maKh);
                }
                case 8 -> {
                    qlkh.sapXepGiamTheoTien();
                    qlkh.hienThi();
                }
                case 9 -> {
                    kh2.nhapKhachHang();
                    kh2.hienThiKhachHang();
                    qlkh.themKhachHang(kh2);
                }
                case 10 ->
                {
                    System.out.println("Cam on ban da su dung dich vu!");
                    break;
                }
                default ->
                    System.err.println("Lua chon khong hop le. Vui long chon lai!");
            }
            if(chon == 10) {
                break;
            }
        } while (chon > 0 && chon < 11);
    }
}
