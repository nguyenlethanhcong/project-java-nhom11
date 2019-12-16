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
public class hoadonDAO {

    public int add(hoadon ee) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert into tblHoaDon(MaHD,TenNV,TenKH)values (?,?,?)";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, ee.getMaHD());
            sttm.setString(2, ee.getTenNV());
            sttm.setString(3, ee.getTenKH());
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

    public int edit(hoadon ee) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update tblHoaDon set  TenNV=?,TenKH=? where id = ? ";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
          /*  sttm.setString(1, ee.getMaHD());*/
            sttm.setString(1, ee.getTenKH());
            sttm.setString(2, ee.getTenNV());
            sttm.setInt(3, ee.getId());
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
            String sSQL = "delete tblHoaDon where id = ?";

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

    public List<hoadon> getAllhoadon() {
        List<hoadon> ls = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "select id,MaHD,TenNV,TenKH from tblHoaDon order by id asc";

            conn = DatabaseUtils.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                hoadon ee = new hoadon();
                ee.setId(rs.getInt(1));
                ee.setMaHD(rs.getString(2));
                ee.setTenKH(rs.getString(3));
                ee.setTenNV(rs.getString(4));
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

    public hoadon gethoadonByID(int id) {
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        hoadon ee = new hoadon();
        try {
            String sSQL = "select id,MaHD,TenNV,TenKH from tblHoaDon where id=? ";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, id);
            rs = sttm.executeQuery();
            while (rs.next()) {
                ee.setId(rs.getInt(1));
                ee.setMaHD(rs.getString(2));
                ee.setTenKH(rs.getString(3));
                ee.setTenNV(rs.getString(4));
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
        hoadonDAO dao = new hoadonDAO();
        hoadon ee = new hoadon(3, "125", "nhien", "ninh ");
        // dao.add(ee);
        // dao.edit(ee);
        //dao.del(3);
        System.out.println("=>" + dao.gethoadonByID(3));
    }
}
