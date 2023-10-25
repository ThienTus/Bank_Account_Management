/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankaccountmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Thiên Tú
 */
public class QuanLyTaiKhoan {

    private List<TaiKhoan> ds = new ArrayList<>();

    public void themTk(TaiKhoan... a) {
        this.getDs().addAll(Arrays.asList(a));
    }

    public void hienThi() {
        this.getDs().forEach(t -> t.hienThiTaiKhoan());
    }
    
    public TaiKhoan traCuuTaiKhoanTheoSoTaiKhoan(String soTk) {
        for (TaiKhoan taiKhoan : ds) {
            if (taiKhoan.getSoTk() != null && taiKhoan.getSoTk().equals(soTk)) {
                return taiKhoan;
            }
        }
        return null;
    }

    public double tinhLaiTheoSoTk(String soTk) {
        TaiKhoan taiKhoan = traCuuTaiKhoanTheoSoTaiKhoan(soTk);
        if (taiKhoan != null) {
            return taiKhoan.tinhLai();
        } else {
            return 0;
        }
    }

    public void traCuuDanhSachTaiKhoanTheoMaSoKhachHang(String maKh) {
        System.out.println("------DANH SACH TAI KHOAN------");
        boolean coTaiKhoan = false;
        for (TaiKhoan taiKhoan : ds) {
            if (taiKhoan.getChuSoHuu().equals(maKh)) {
                taiKhoan.hienThiTaiKhoan();
                coTaiKhoan = true;
                System.out.println(taiKhoan);
            }
        }
        if (!coTaiKhoan) {
            System.out.println("Khong tim thay tai khoan nao cho khach hang co ma so " + maKh);
        }
    }

    public List<TaiKhoan> getDs() {
        return ds;
    }

    public void setDs(List<TaiKhoan> ds) {
        this.ds = ds;
    }
    
}
