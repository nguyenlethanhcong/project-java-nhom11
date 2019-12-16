/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan_java;

import static doan_java.DatabaseUtils.connectionUrl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class JNhanVien extends javax.swing.JFrame {

    public static Connection getDBConnect() {

        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// khai bao driver
            con = DriverManager.getConnection(connectionUrl);
            return con;
        } catch (ClassNotFoundException ex) {
            System.out.println("where is Driver?");// xuat hien thong bao de biet loi di`
            System.out.println("Error:" + ex.toString());
        } catch (SQLException ex) {
            //loi ket nooi 
            System.out.println("Error:" + ex.toString());
        }
        return null;
    }
    String id_NV;
    nhanvienDAO dao = new nhanvienDAO();

    /**
     * Creates new form JNhanVien
     */
    public void filldataTable() {
        DefaultTableModel model = (DefaultTableModel) tblFormNV.getModel();
        model.setRowCount(0);
        for (nhanvien ee : dao.getAllnhanvien()) {
            Object dataRow[] = new Object[5];
            dataRow[0] = ee.getId();
            dataRow[1] = ee.getMaNV();
            dataRow[2] = ee.getTenNV();
            dataRow[3] = ee.getdC();
            dataRow[4] = ee.getSdt();
            model.addRow(dataRow);
        }
    }

    public JNhanVien() {
        initComponents();
        filldataTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDC = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFormNV = new javax.swing.JTable();
        btnsave = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txttimkiem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("JNhanVien"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nhân Viên");

        jLabel2.setText("Mã NV");

        jLabel3.setText("Tên NV");

        jLabel4.setText("Địa Chỉ");

        jLabel7.setText("Số Điện Thoại");

        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNVActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatMouseClicked(evt);
            }
        });
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        tblFormNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã NV", "Tên NV", "Địa Chỉ", "Số Điện Thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblFormNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFormNVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblFormNV);

        btnsave.setText("Lưu");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        jLabel5.setText("ID :");

        txtid.setDisabledTextColor(new java.awt.Color(110, 109, 109));

        txttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemActionPerformed(evt);
            }
        });
        txttimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttimkiemKeyReleased(evt);
            }
        });

        jLabel6.setText("Tìm Kiếm :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttimkiem)
                                .addGap(2, 2, 2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                                .addComponent(txtMaNV))
                                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtDC, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                        .addComponent(btnXoa)
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnsave)
                                                .addGap(36, 36, 36)
                                                .addComponent(btnThoat))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnSua)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(118, 118, 118)))))
                                .addGap(18, 18, 18)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnThoat)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnsave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNVActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int hoi = JOptionPane.showConfirmDialog(null, "BẠN CÓ MUỐN THOÁT KHỎI CHƯƠNG TRÌNH?", null, JOptionPane.YES_NO_OPTION);
        if (hoi == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);

    }//GEN-LAST:event_btnThoatMouseClicked
    private void resetForm() {
        txtid.setText("");
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtDC.setText("");
        txtSDT.setText("");
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_btnThemActionPerformed
    public nhanvien getModel() {
        nhanvien ee = new nhanvien();
        ee.setId(Integer.parseInt(txtid.getText()));
        ee.setMaNV(txtMaNV.getText());
        ee.setTenNV(txtTenNV.getText());
        ee.setdC(txtDC.getText());
        ee.setSdt(txtSDT.getText());
        return ee;
    }
    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        if (validateForm()) {
            nhanvien ee = getModel();
            try {
                if (dao.add(ee) > 0) {
                    JOptionPane.showMessageDialog(null, "Lưu thành công!!!","THÔNG BÁO",1);
                    filldataTable();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "LỖI:" + e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn hãy nhập đầy đủ thông tin!!!","THÔNG BÁO",1);
        }
    }//GEN-LAST:event_btnsaveActionPerformed
    public void setModel(nhanvien ee) {
        txtid.setText(String.valueOf(ee.getId()));
        txtMaNV.setText(ee.getMaNV());
        txtTenNV.setText(ee.getTenNV());
        txtDC.setText(ee.getdC());
        txtSDT.setText(ee.getSdt());

    }
    private void tblFormNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFormNVMouseClicked
        // TODO add your handling code here:
        int id = tblFormNV.rowAtPoint(evt.getPoint());
        id_NV = tblFormNV.getValueAt(id, 0).toString();
        nhanvien ee = dao.getnhanvienByID(Integer.parseInt(id_NV));
        setModel(ee);
    }//GEN-LAST:event_tblFormNVMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (validateForm()) {
            try {
                nhanvien eeNew = getModel();
                if (dao.edit(eeNew) > 0) {
                    JOptionPane.showMessageDialog(null, "Sửa thành công", "THÔNG BÁO",1);
                    filldataTable();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi :" + e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin!!!", "THÔNG BÁO",1);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (txtid.getText().isEmpty() || id_NV.length() == 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập ID để xóa!!!", "THÔNG BÁO",1);
        } else {
            try {
                if (id_NV.length() > 0) {
                    dao.del(Integer.parseInt(id_NV));
                } else {
                    dao.del(Integer.parseInt(txtid.getText()));
                }
                filldataTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi :" + e.toString());
            }

        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_txttimkiemActionPerformed

    private void txttimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimkiemKeyReleased
        // TODO add your handling code here:

        ArrayList<nhanvien> al = null;
        al = new ArrayList<nhanvien>();
        String val = txttimkiem.getText().toString();
        try {
            Connection conn = getDBConnect();
            String qry = "select * from tblNhanvien where Manv like '%" + val + "%'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(qry);
            nhanvien student;
            while (rs.next()) {
                student = new nhanvien(rs.getInt(1), rs.getString("Manv"),
                         rs.getString(3), rs.getString(4), rs.getString(5));
                al.add(student);
            }

            DefaultTableModel model = (DefaultTableModel) tblFormNV.getModel();
            model.setRowCount(0); // Empty/clear the table
            Object[] row = new Object[5];
            for (int i = 0; i < al.size(); i++) {
                row[0] = al.get(i).getId();
                row[1] = al.get(i).getMaNV();
                row[2] = al.get(i).getTenNV();
                row[3] = al.get(i).getdC();
                row[4] = al.get(i).getSdt();
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_txttimkiemKeyReleased
    public boolean validateForm() {
        if (txtid.getText().isEmpty() || txtMaNV.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblFormNV;
    private javax.swing.JTextField txtDC;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables

}