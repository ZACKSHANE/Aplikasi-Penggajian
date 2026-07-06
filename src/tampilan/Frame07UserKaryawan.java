package tampilan;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;
import java.util.Locale;
import koneksi.Koneksi;

public class Frame07UserKaryawan extends javax.swing.JFrame {
      Connection conn = Koneksi.connect();
    private int idKaryawan;
    private String mode = "ABSENSI";
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frame07UserKaryawan.class.getName());
    
 public Frame07UserKaryawan(int idKaryawan) {
    this.idKaryawan = idKaryawan;

    initComponents();

    cbbulan.setSelectedIndex(0);
    cbtahun.setSelectedIndex(0);

    loadDataAbsensi();
}
 public Frame07UserKaryawan() {
    initComponents();
}

   
    private String rupiah(double angka) {
        return NumberFormat.getCurrencyInstance(new Locale("id", "ID")).format(angka);
    }

    private String getBulan() {
        if (cbbulan.getSelectedItem() == null) return "Januari";
        return cbbulan.getSelectedItem().toString();
    }

    private String getTahun() {
        if (cbtahun.getSelectedItem() == null) return "2025";
        return cbtahun.getSelectedItem().toString();
    }

    private String convertBulan(String bulan) {
        switch (bulan) {
            case "Januari": return "01";
            case "Februari": return "02";
            case "Maret": return "03";
            case "April": return "04";
            case "Mei": return "05";
            case "Juni": return "06";
            case "Juli": return "07";
            case "Agustus": return "08";
            case "September": return "09";
            case "Oktober": return "10";
            case "November": return "11";
            case "Desember": return "12";
            default: return "01";
        }
    }

    // ================= TABLE MODEL =================
    private void setModelAbsensi() {
        tblgaji.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Tanggal", "Masuk", "Keluar", "Status"}
        ));
    }

    private void setModelGaji() {
        tblgaji.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Nama", "Jabatan", "Bulan", "Hadir", "Bonus", "Potongan", "Total"}
        ));
    }

   private void loadDataAbsensi() {
    try {
        setModelAbsensi();

        int bulan = cbbulan.getSelectedIndex() + 1;
        int tahun = Integer.parseInt(getTahun());

        String sql =
        "SELECT tanggal, jam_masuk, jam_keluar, status " +
        "FROM absensi " +
        "WHERE id_karyawan=? AND YEAR(tanggal)=? AND MONTH(tanggal)=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idKaryawan);
        ps.setInt(2, tahun);
        ps.setInt(3, bulan);

        ResultSet rs = ps.executeQuery();

        DefaultTableModel model = (DefaultTableModel) tblgaji.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getDate("tanggal"),
                rs.getTime("jam_masuk"),
                rs.getTime("jam_keluar"),
                rs.getString("status")
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}

  
   private void loadDataGaji() {
    try {
          System.out.println("ID Karyawan = " + idKaryawan);
        System.out.println("Bulan = " + getBulan() + " " + getTahun());
        setModelGaji();

        String bulan = getBulan() + " " + getTahun(); // FIX UTAMA

        String sql =
        "SELECT nama_karyawan, nama_jabatan, bulan, total_hadir, bonus, potongan, total_gaji " +
        "FROM detail_gaji " +
        "WHERE id_karyawan=? AND bulan=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idKaryawan);
        ps.setString(2, bulan);

        ResultSet rs = ps.executeQuery();

        DefaultTableModel model = (DefaultTableModel) tblgaji.getModel();
        model.setRowCount(0);

        int count = 0;

        while (rs.next()) {
            count++;
            model.addRow(new Object[]{
                rs.getString("nama_karyawan"),
                rs.getString("nama_jabatan"),
                rs.getString("bulan"),
                rs.getInt("total_hadir"),
                rupiah(rs.getDouble("bonus")),
                rupiah(rs.getDouble("potongan")),
                rupiah(rs.getDouble("total_gaji"))
            });
        }
          System.out.println("Jumlah Data = " + count);
        if (count == 0) {
            JOptionPane.showMessageDialog(this, "Data gaji kosong!");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "ERROR: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnlogo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btndash = new javax.swing.JButton();
        btnabsen = new javax.swing.JButton();
        btngaji = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();
        krypanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblgaji = new javax.swing.JTable();
        cbbulan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbtahun = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        btnlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/logoo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("MingLiU-ExtB", 1, 22)); // NOI18N
        jLabel1.setText("Rekapitulasi Absensi");

        jLabel3.setFont(new java.awt.Font("MingLiU-ExtB", 1, 22)); // NOI18N
        jLabel3.setText("Karyawan");

        btndash.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btndash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/dsh 2_1.png"))); // NOI18N
        btndash.setText("Dashboard");

        btnabsen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnabsen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/absensi.jpg"))); // NOI18N
        btnabsen.setText("Absensi");
        btnabsen.addActionListener(this::btnabsenActionPerformed);

        btngaji.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btngaji.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/gajii.png"))); // NOI18N
        btngaji.setText("Gaji");
        btngaji.addActionListener(this::btngajiActionPerformed);

        btnlogout.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/logout.png"))); // NOI18N
        btnlogout.setText("Logout");
        btnlogout.addActionListener(this::btnlogoutActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel3)))
                .addContainerGap(91, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btngaji, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnabsen, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btndash, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnlogo)
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btndash, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnabsen, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btngaji, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(btnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        krypanel.setBackground(new java.awt.Color(0, 204, 204));
        krypanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setText("DASHBOARD KARYAWAN");

        tblgaji.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tanggal", "Jam Masuk", "Jam Keluar", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblgaji);

        cbbulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Bulan ");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Tahun");

        cbtahun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2026", "2025", "2024", " ", " " }));

        jButton1.setText("Tampilkan");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout krypanelLayout = new javax.swing.GroupLayout(krypanel);
        krypanel.setLayout(krypanelLayout);
        krypanelLayout.setHorizontalGroup(
            krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(krypanelLayout.createSequentialGroup()
                .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(krypanelLayout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel5))
                    .addGroup(krypanelLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(krypanelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbulan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbtahun, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        krypanelLayout.setVerticalGroup(
            krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(krypanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addGap(50, 50, 50)
                .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(cbtahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(krypanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(krypanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnabsenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnabsenActionPerformed
        mode = "ABSENSI";
setModelAbsensi();
loadDataAbsensi();
    }//GEN-LAST:event_btnabsenActionPerformed

    private void btngajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngajiActionPerformed
        mode = "GAJI";
setModelGaji();
loadDataGaji();
    }//GEN-LAST:event_btngajiActionPerformed

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed

        int dialogresult = JOptionPane.showConfirmDialog(
            null,
            "Anda yakin akan keluar?",
            "Peringatan",
            JOptionPane.YES_NO_OPTION
        );

        if (dialogresult == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnlogoutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if ("ABSENSI".equals(mode)) {
            loadDataAbsensi();
        } else {
            
            loadDataGaji();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Frame07UserKaryawan().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnabsen;
    private javax.swing.JButton btndash;
    private javax.swing.JButton btngaji;
    private javax.swing.JButton btnlogo;
    private javax.swing.JButton btnlogout;
    private javax.swing.JComboBox<String> cbbulan;
    private javax.swing.JComboBox<String> cbtahun;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel krypanel;
    private javax.swing.JTable tblgaji;
    // End of variables declaration//GEN-END:variables
}
