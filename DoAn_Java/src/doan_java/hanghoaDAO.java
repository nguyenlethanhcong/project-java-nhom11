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
public class hanghoaDAO {

    public int add(hanghoa ee) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert into tblHanghoa(MaHH,TenHH,Soluong,Dongia) "
                    + "values (?,?,?,?)";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, ee.getMaHH());
            sttm.setString(2, ee.getTenHH());
            sttm.setString(3, ee.getSL());
            sttm.setString(4, ee.getDongia());
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

    public int edit(hanghoa ee) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update tblHanghoa set  TenHH=?,Soluong=?,Dongia=? where id = ? ";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
           /* sttm.setString(1, ee.getMaHH());*/
            sttm.setString(1, ee.getTenHH());
            sttm.setString(2, ee.getSL());
            sttm.setString(3, ee.getDongia());
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
            String sSQL = "delete tblHanghoa where id = ?";

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

    public List<hanghoa> getAllhanghoa() {
        List<hanghoa> ls = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "select id,MaHH,TenHH,Soluong,Dongia from tblHanghoa order by id asc";

            conn = DatabaseUtils.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                hanghoa ee = new hanghoa();
                ee.setId(rs.getInt(1));
                ee.setMaHH(rs.getString(2));
                ee.setTenHH(rs.getString(3));
                ee.setSL(rs.getString(4));
                ee.setDongia(rs.getString(5));
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

    public hanghoa gethanghoaByID(int id) {
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        hanghoa ee = new hanghoa();
        try {
            String sSQL = "select id,MaHH,TenHH,Soluong,Dongia from tblHanghoa where id=? ";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, id);
            rs = sttm.executeQuery();
            while (rs.next()) {
                ee.setId(rs.getInt(1));
                ee.setMaHH(rs.getString(2));
                ee.setTenHH(rs.getString(3));
                ee.setSL(rs.getString(4));
                ee.setDongia(rs.getString(5));
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
        hanghoaDAO dao = new hanghoaDAO();
        hanghoa ee = new hanghoa(5, "SP05", "keo", "15 ", "1500");
        // dao.add(ee);
        // dao.edit(ee);
        //dao.del(3);
        System.out.println("=>" + dao.gethanghoaByID(3));
    }
}
