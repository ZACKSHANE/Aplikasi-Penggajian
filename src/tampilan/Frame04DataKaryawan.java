package tampilan;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

public class Frame04DataKaryawan extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frame04DataKaryawan.class.getName());
    private Connection conn = Koneksi.connect();
    private int selectedRow = -1;
    private DefaultTableModel tabmode;
    private int id_karyawan;

    public Frame04DataKaryawan() {
        initComponents();
        datatable();
    }

    public void datatable() {
        Object[] header = {
            "ID Karyawan",
            "ID Jabatan",
            "Nama Jabatan",
            "ID Departemen",
            "Nama Departemen",
            "Nama",
            "No HP",
            "Alamat",
            "Username",
            "Password"
        };

        tabmode = new DefaultTableModel(null, header);
        tblkaryawan.setModel(tabmode);

        try {

            String sql
                    = "SELECT k.id_karyawan, "
                    + "       k.id_jabatan, j.nama_jabatan, "
                    + "       k.id_departement, d.nama_departement, "
                    + "       k.nama_karyawan, k.no_hp, k.alamat, k.username, k.password "
                    + "FROM karyawan k "
                    + "JOIN jabatan j ON k.id_jabatan = j.id_jabatan "
                    + "JOIN departement d ON k.id_departement = d.id_departement "
                    + "ORDER BY k.id_karyawan";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                tabmode.addRow(new Object[]{
                    rs.getInt("id_karyawan"),
                    rs.getInt("id_jabatan"),
                    rs.getString("nama_jabatan"),
                    rs.getInt("id_departement"),
                    rs.getString("nama_departement"),
                    rs.getString("nama_karyawan"),
                    rs.getString("no_hp"),
                    rs.getString("alamat"),
                    rs.getString("username"),
                    rs.getString("password")

                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnlogo3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btndash3 = new javax.swing.JButton();
        btnjabatan3 = new javax.swing.JButton();
        btndepartement1 = new javax.swing.JButton();
        btnkaryawan1 = new javax.swing.JButton();
        btnabsen1 = new javax.swing.JButton();
        btngaji1 = new javax.swing.JButton();
        btnlogout1 = new javax.swing.JButton();
        krypanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblkaryawan = new javax.swing.JTable();
        btntambah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        btnlogo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/logoo.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("MingLiU-ExtB", 1, 22)); // NOI18N
        jLabel8.setText("Rekapitulasi Absensi");

        jLabel9.setFont(new java.awt.Font("MingLiU-ExtB", 1, 22)); // NOI18N
        jLabel9.setText("Karyawan");

        btndash3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btndash3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icon dsh.png"))); // NOI18N
        btndash3.setText("Dashboard");

        btnjabatan3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnjabatan3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icon jabatan.jpg"))); // NOI18N
        btnjabatan3.setText("Jabatan");
        btnjabatan3.addActionListener(this::btnjabatan3ActionPerformed);

        btndepartement1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btndepartement1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icon dprtm.jpg"))); // NOI18N
        btndepartement1.setText("Departement");
        btndepartement1.addActionListener(this::btndepartement1ActionPerformed);

        btnkaryawan1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnkaryawan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/karyawan.png"))); // NOI18N
        btnkaryawan1.setText("Karyawan");
        btnkaryawan1.addActionListener(this::btnkaryawan1ActionPerformed);

        btnabsen1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnabsen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/absensi.jpg"))); // NOI18N
        btnabsen1.setText("Absensi");
        btnabsen1.addActionListener(this::btnabsen1ActionPerformed);

        btngaji1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btngaji1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/gajii.png"))); // NOI18N
        btngaji1.setText("Gaji");
        btngaji1.addActionListener(this::btngaji1ActionPerformed);

        btnlogout1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnlogout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/logout.png"))); // NOI18N
        btnlogout1.setText("Logout");
        btnlogout1.addActionListener(this::btnlogout1ActionPerformed);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnlogo3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel9)))
                .addContainerGap(91, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnlogout1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btngaji1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnabsen1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnkaryawan1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndepartement1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnjabatan3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btndash3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnlogo3)
                .addGap(24, 24, 24)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(btndash3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnjabatan3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btndepartement1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnkaryawan1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnabsen1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btngaji1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnlogout1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        krypanel.setBackground(new java.awt.Color(0, 204, 204));
        krypanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setText("DATA KARYAWAN");

        tblkaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Karyawan", "ID Jabatan", "Nama Jabatan", "ID Departement", "Nama Departement", "Nama", "No Hp", "Alamat", "Username", "Password"
            }
        ));
        tblkaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkaryawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblkaryawan);

        btntambah.setText("Tambah Data");
        btntambah.addActionListener(this::btntambahActionPerformed);

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(this::btnhapusActionPerformed);

        btnubah.setText("Ubah");
        btnubah.addActionListener(this::btnubahActionPerformed);

        javax.swing.GroupLayout krypanelLayout = new javax.swing.GroupLayout(krypanel);
        krypanel.setLayout(krypanelLayout);
        krypanelLayout.setHorizontalGroup(
            krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(krypanelLayout.createSequentialGroup()
                .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(krypanelLayout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(jLabel5))
                    .addGroup(krypanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(krypanelLayout.createSequentialGroup()
                                .addComponent(btntambah)
                                .addGap(18, 18, 18)
                                .addComponent(btnhapus)
                                .addGap(18, 18, 18)
                                .addComponent(btnubah)))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        krypanelLayout.setVerticalGroup(
            krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(krypanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel5)
                .addGap(74, 74, 74)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntambah)
                    .addComponent(btnhapus)
                    .addComponent(btnubah))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(krypanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(krypanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblkaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkaryawanMouseClicked
        selectedRow = tblkaryawan.getSelectedRow();
        tblkaryawan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblkaryawan.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblkaryawan.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblkaryawan.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblkaryawan.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblkaryawan.getColumnModel().getColumn(4).setPreferredWidth(150);
        tblkaryawan.getColumnModel().getColumn(5).setPreferredWidth(150);
        tblkaryawan.getColumnModel().getColumn(6).setPreferredWidth(120);
        tblkaryawan.getColumnModel().getColumn(7).setPreferredWidth(300);
        tblkaryawan.setRowHeight(25);
        tblkaryawan.getColumnModel().getColumn(8).setPreferredWidth(120);
        tblkaryawan.getColumnModel().getColumn(9).setPreferredWidth(120);

        if (selectedRow != -1) {
        }
        jScrollPane1.setHorizontalScrollBarPolicy(
                javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );

    }//GEN-LAST:event_tblkaryawanMouseClicked

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        frametambahdata n = new frametambahdata(this);
        n.setVisible(true);
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data dulu di tabel!");
            return;
        }

        frametambahdata form = new frametambahdata(this);

        form.setEditData(
                tblkaryawan.getValueAt(selectedRow, 0).toString(),
                tblkaryawan.getValueAt(selectedRow, 1).toString(),
                tblkaryawan.getValueAt(selectedRow, 3).toString(),
                tblkaryawan.getValueAt(selectedRow, 5).toString(),
                tblkaryawan.getValueAt(selectedRow, 6).toString(),
                tblkaryawan.getValueAt(selectedRow, 7).toString(),
                tblkaryawan.getValueAt(selectedRow, 8).toString(),
                tblkaryawan.getValueAt(selectedRow, 9).toString()
        );

        form.setVisible(true);

        form.setVisible(true);
    }//GEN-LAST:event_btnubahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(
                this,
                "Yakin ingin menghapus data ini?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            try {

                String id = tblkaryawan.getValueAt(selectedRow, 0).toString();

                String sql = "DELETE FROM karyawan WHERE id_karyawan=?";

                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, id);

                pst.executeUpdate();
                pst.close();

                JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");

                selectedRow = -1;
                datatable();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data!\n" + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnjabatan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnjabatan3ActionPerformed
        new Frame02JabatanKaryawan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnjabatan3ActionPerformed

    private void btndepartement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndepartement1ActionPerformed
        new Frame03DepartementKaryawan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btndepartement1ActionPerformed

    private void btnkaryawan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkaryawan1ActionPerformed
        new Frame04DataKaryawan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnkaryawan1ActionPerformed

    private void btnabsen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnabsen1ActionPerformed
        new Frame05AbsenKaryawan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnabsen1ActionPerformed

    private void btngaji1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngaji1ActionPerformed
        new Frame06GajiKaryawan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btngaji1ActionPerformed

    private void btnlogout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogout1ActionPerformed

        int dialogresult = JOptionPane.showConfirmDialog(
                null,
                "Anda yakin akan keluar?",
                "Peringatan",
                JOptionPane.YES_NO_OPTION
        );

        if (dialogresult == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnlogout1ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Frame04DataKaryawan().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnabsen1;
    private javax.swing.JButton btndash3;
    private javax.swing.JButton btndepartement1;
    private javax.swing.JButton btngaji1;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnjabatan3;
    private javax.swing.JButton btnkaryawan1;
    private javax.swing.JButton btnlogo3;
    private javax.swing.JButton btnlogout1;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btnubah;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel krypanel;
    private javax.swing.JTable tblkaryawan;
    // End of variables declaration//GEN-END:variables
}
