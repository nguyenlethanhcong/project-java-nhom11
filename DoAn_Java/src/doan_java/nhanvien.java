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
public class nhanvien {

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
    private String maNV;
    private String tenNV;
    private String dC;
    private String sdt;

    public nhanvien() {
    }

    public nhanvien(int id, String maNV, String tenNV, String dC, String sdt) {
        this.id = id;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.dC = dC;
        this.sdt = sdt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
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
        return "nhanvien{" + "id=" + id + ", maNV=" + maNV + ", tenNV=" + tenNV + ", dC=" + dC + ", sdt=" + sdt + '}';
    }

}
