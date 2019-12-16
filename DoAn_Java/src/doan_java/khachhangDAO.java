/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan_java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class khachhangDAO {

    public int add(khachhang ee) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert into tblKhachHang(MaKH,TenKH,DiaChi,SDT)values (?,?,?,?)";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, ee.getMaKH());
            sttm.setString(2, ee.getTenKH());
            sttm.setString(3, ee.getdC());
            sttm.setString(4, ee.getSdt());
            if (sttm.executeUpdate() > 0) {
                System.out.println("add thanh cong");
                return 1;

            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        } finally {
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {

            }
        }
        return -1;
    }

    public int edit(khachhang ee) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update tblKhachHang set TenKH=?,DiaChi=?,SDT=? where id = ? ";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            /*   sttm.setString(1, ee.getMaKH());*/
            sttm.setString(1, ee.getTenKH());
            sttm.setString(2, ee.getdC());
            sttm.setString(3, ee.getSdt());
            sttm.setInt(4, ee.getId());
            if (sttm.executeUpdate() > 0) {
                System.out.println("edit thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        } finally {
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {

            }
        }
        return -1;// neu them khong thanh cong
    }

    public int del(int id) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "delete tblKhachHang where id = ?";

            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, id);
            if (sttm.executeUpdate() > 0) {
                System.out.println("del thanh cong");
                return 1;

            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        } finally {
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {

            }
        }
        return -1;// neu them khong thanh cong
    }

    public List<khachhang> getAllkhachhang() {
        List<khachhang> ls = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "select id,MaKH,TenKH,DiaChi,SDT from tblKhachHang order by id asc";

            conn = DatabaseUtils.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                khachhang ee = new khachhang();
                ee.setId(rs.getInt(1));
                ee.setMaKH(rs.getString(2));
                ee.setTenKH(rs.getString(3));
                ee.setdC(rs.getString(4));
                ee.setSdt(rs.getString(5));
                ls.add(ee);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        } finally {
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e) {

            }
        }
        return ls;
    }

    public khachhang getkhachhangByID(int id) {
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        khachhang ee = new khachhang();
        try {
            String sSQL = "select id,MaKH,TenKH,DiaChi,SDT from tblKhachHang where id=? ";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, id);
            rs = sttm.executeQuery();
            while (rs.next()) {
                ee.setId(rs.getInt(1));
                ee.setMaKH(rs.getString(2));
                ee.setTenKH(rs.getString(3));
                ee.setdC(rs.getString(4));
                ee.setSdt(rs.getString(5));
                return ee;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        } finally {
            try {

            } catch (Exception e) {

            }
        }
        return null;
    }

    public static void main(String[] args) {
        khachhangDAO dao = new khachhangDAO();
        khachhang ee = new khachhang(1, "121", "dai", "ninh thuan", "456");
        // dao.add(ee);
        // dao.edit(ee);
        //dao.del(3);
        System.out.println("=>" + dao.getkhachhangByID(3));
    }
}
