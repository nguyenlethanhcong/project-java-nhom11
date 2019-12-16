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
public class hanghoa {

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
    private String maHH;
    private String tenHH;
    private String SL;
    private String dongia;

    public hanghoa() {
    }

    public hanghoa(int id, String maHH, String tenHH, String SL, String dongia) {
        this.id = id;
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.SL = SL;
        this.dongia = dongia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHH() {
        return maHH;
    }

    public void setMaHH(String maHH) {
        this.maHH = maHH;
    }

    public String getTenHH() {
        return tenHH;
    }

    public void setTenHH(String tenHH) {
        this.tenHH = tenHH;
    }

    public String getSL() {
        return SL;
    }

    public void setSL(String SL) {
        this.SL = SL;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    @Override
    public String toString() {
        return "hanghoa{" + "id=" + id + ", maHH=" + maHH + ", tenHH=" + tenHH + ", SL=" + SL + ", dongia=" + dongia + '}';
    }

   
}
