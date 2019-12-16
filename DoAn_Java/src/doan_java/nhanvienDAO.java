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
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class nhanvienDAO {




    public int add(nhanvien ee) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert into tblNhanvien(Manv,Tennv,Diachi,Sodienthoai)values (?,?,?,?)";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, ee.getMaNV());
            sttm.setString(2, ee.getTenNV());
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

    public int edit(nhanvien ee) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update tblNhanvien set  Tennv=?,Diachi=?,Sodienthoai=? where id = ? ";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
         /*   sttm.setString(1, ee.getMaNV());*/
            sttm.setString(1, ee.getTenNV());
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
            String sSQL = "delete tblNhanvien where id = ?";

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

    public List<nhanvien> getAllnhanvien() {
        List<nhanvien> ls = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "select id,Manv,Tennv,Diachi,Sodienthoai from tblNhanvien order by id asc";

            conn = DatabaseUtils.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                nhanvien ee = new nhanvien();
                ee.setId(rs.getInt(1));
                ee.setMaNV(rs.getString(2));
                ee.setTenNV(rs.getString(3));
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

    public nhanvien getnhanvienByID(int id) {
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        nhanvien ee = new nhanvien();
        try {
            String sSQL = "select id,Manv,Tennv,Diachi,Sodienthoai from tblNhanvien where id=? ";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, id);
            rs = sttm.executeQuery();
            while (rs.next()) {
                ee.setId(rs.getInt(1));
                ee.setMaNV(rs.getString(2));
                ee.setTenNV(rs.getString(3));
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
        nhanvienDAO dao = new nhanvienDAO();
        nhanvien ee = new nhanvien(3, "125", "nhien", "ninh ", "7898934");
        // dao.add(ee);
        // dao.edit(ee);
        //dao.del(3);
        System.out.println("=>" + dao.getnhanvienByID(3));
    }
}
