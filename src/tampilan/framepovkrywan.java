package tampilan;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;
import java.util.Locale;
import koneksi.Koneksi;

public class framepovkrywan extends javax.swing.JFrame {
    Connection conn = Koneksi.connect();
    private int idKaryawan;
    private String mode = "ABSENSI";

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(framepovkrywan.class.getName());

    
    public framepovkrywan(int idKaryawan) {
        this.idKaryawan = idKaryawan;
        initComponents();

        cbbulan.setSelectedIndex(0);
        cbtahun.setSelectedIndex(0);

        loadDataAbsensi();
    }

    
    public framepovkrywan() {
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
        mainpanel = new javax.swing.JPanel();
        bdash = new javax.swing.JButton();
        babsen = new javax.swing.JButton();
        bgaji = new javax.swing.JButton();
        blogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
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

        jPanel1.setBackground(new java.awt.Color(176, 231, 220));

        mainpanel.setBackground(new java.awt.Color(176, 231, 220));
        mainpanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        bdash.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        bdash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/dsh 2_1.png"))); // NOI18N
        bdash.setText("Dashboard");
        bdash.setIconTextGap(10);
        bdash.addActionListener(this::bdashActionPerformed);

        babsen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        babsen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/absensi.jpg"))); // NOI18N
        babsen.setText("Absen");
        babsen.setIconTextGap(10);
        babsen.addActionListener(this::babsenActionPerformed);

        bgaji.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        bgaji.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/gajii.png"))); // NOI18N
        bgaji.setText("Gaji");
        bgaji.setIconTextGap(10);
        bgaji.addActionListener(this::bgajiActionPerformed);

        blogout.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        blogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/logout.png"))); // NOI18N
        blogout.setText("Logout");
        blogout.setIconTextGap(10);
        blogout.addActionListener(this::blogoutActionPerformed);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tampilan/logoo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("Selamat Datang");

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(babsen, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                        .addComponent(bgaji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(blogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(bdash, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(42, 42, 42))
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addComponent(bdash, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(babsen)
                .addGap(41, 41, 41)
                .addComponent(bgaji)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(blogout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        krypanel.setBackground(new java.awt.Color(176, 231, 220));
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(krypanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(krypanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void blogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blogoutActionPerformed

    }//GEN-LAST:event_blogoutActionPerformed

    private void bgajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgajiActionPerformed
     mode = "GAJI";
setModelGaji();
loadDataGaji();
    }//GEN-LAST:event_bgajiActionPerformed

    private void babsenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_babsenActionPerformed
   mode = "ABSENSI";
setModelAbsensi();
loadDataAbsensi();
    }//GEN-LAST:event_babsenActionPerformed

    private void bdashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bdashActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     if ("ABSENSI".equals(mode)) {
        loadDataAbsensi();
    } else {
        loadDataGaji();
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new framepovkrywan().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton babsen;
    private javax.swing.JButton bdash;
    private javax.swing.JButton bgaji;
    private javax.swing.JButton blogout;
    private javax.swing.JComboBox<String> cbbulan;
    private javax.swing.JComboBox<String> cbtahun;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel krypanel;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTable tblgaji;
    // End of variables declaration//GEN-END:variables
}
