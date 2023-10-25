/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankaccountmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Thiên Tú
 */
public enum KyHan {

    MOT_TUAN(Calendar.DAY_OF_YEAR, 7, 2) {
        @Override
        public double tinhLai(double st) {
            return (st * this.laiSuat)/(4*1200);
        }
    },
    MOT_THANG(Calendar.MONTH, 1, 5.5) {
        @Override
        public double tinhLai(double st) {
            return (st * this.laiSuat)/(1200);
        }
    },

    SAU_THANG(Calendar.MONTH, 6, 7.5) {
        @Override
        public double tinhLai(double st) {
            return (st * this.laiSuat)/(6*1200);
        }
    },

    MOT_NAM(Calendar.YEAR, 1, 7.9) {
        @Override
        public double tinhLai(double st) {
            return (st * this.laiSuat)/100;
        }
    };


    private final int khoangTG;
    private final int loaiTG;
    protected final double laiSuat;

    private KyHan(int khoangTG, int loaiTG, double laiSuat) {
        this.khoangTG = khoangTG;
        this.loaiTG = loaiTG;
        this.laiSuat = laiSuat;
    }
    
    public Calendar tinhDaoHan(){
        Calendar c = new GregorianCalendar();
        c.add(this.loaiTG, this.khoangTG);
        return c;
    }
    
    public abstract double tinhLai(double soTien);

    public double getLaiSuat() {
        return laiSuat;
    }

    public int getKhoangTG() {
        return khoangTG;
    }

    public int getLoaiTG() {
        return loaiTG;
    }

}
