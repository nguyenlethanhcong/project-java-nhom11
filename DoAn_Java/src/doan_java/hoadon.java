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
public class hoadon {

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
    private String maHD;
    private String tenNV;
    private String tenKH;

    public hoadon() {
    }

    public hoadon(int id, String maHD, String tenNV, String tenKH) {
        this.id = id;
        this.maHD = maHD;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    @Override
    public String toString() {
        return "hoadon{" + "id=" + id + ", maHD=" + maHD + ", tenNV=" + tenNV + ", tenKH=" + tenKH + '}';
    }

 


}
