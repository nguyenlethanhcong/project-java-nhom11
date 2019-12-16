/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan_java;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class khachhang {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */

    /**
     *
     * @author ADMIN
     */
    private int id;
    private String maKH;
    private String tenKH;
    private String dC;
    private String sdt;

    public khachhang() {
    }

    public khachhang(int id, String maKH, String tenKH, String dC, String sdt) {
        this.id = id;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.dC = dC;
        this.sdt = sdt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getdC() {
        return dC;
    }

    public void setdC(String dC) {
        this.dC = dC;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "khachhang{" + "id=" + id + ", maKH=" + maKH + ", tenKH=" + tenKH + ", dC=" + dC + ", sdt=" + sdt + '}';
    }

   
}
