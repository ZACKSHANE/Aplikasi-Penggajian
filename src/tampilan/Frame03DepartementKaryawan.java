package tampilan;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

public class Frame03DepartementKaryawan extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frame03DepartementKaryawan.class.getName());
    private Connection conn = Koneksi.connect();
    private DefaultTableModel tabmode;
    private String selectedId = "";
    
    public Frame03DepartementKaryawan() {
        initComponents();
        datatable();
    }

    protected void datatable() {
        Object[] header = {"ID_Departement", "Nama_Departement",};
        tabmode = new DefaultTableModel(null, header);
        tbldepart.setModel(tabmode);

        try {
            String sql = "SELECT * FROM departement ORDER BY id_departement";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                tabmode.addRow(new Object[]{
                    rs.getString("id_departement"),
                    rs.getString("nama_departement"),
                   
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldepart = new javax.swing.JTable();
        btnhps = new javax.swing.JButton();
        btntmbh = new javax.swing.JButton();
        btnubh = new javax.swing.JButton();
        txtcari1 = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();

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

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel6.setText("DEPARTEMEN");

        tbldepart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nama Departemen", "ID Departemen"
            }
        ));
        tbldepart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldepartMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbldepart);

        btnhps.setText("Hapus");
        btnhps.addActionListener(this::btnhpsActionPerformed);

        btntmbh.setText("Tambah Data");
        btntmbh.addActionListener(this::btntmbhActionPerformed);

        btnubh.setText("Ubah");
        btnubh.addActionListener(this::btnubhActionPerformed);

        btncari.setText("Cari");
        btncari.addActionListener(this::btncariActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btntmbh)
                        .addGap(18, 18, 18)
                        .addComponent(btnhps)
                        .addGap(18, 18, 18)
                        .addComponent(btnubh))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtcari1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntmbh)
                    .addComponent(btnhps)
                    .addComponent(btnubh))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void tbldepartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldepartMouseClicked
        int row = tbldepart.getSelectedRow();

        if (row == -1) return;

        selectedId = tbldepart.getValueAt(row, 0).toString();
        txtcari1.setText(tbldepart.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tbldepartMouseClicked

    private void btnhpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhpsActionPerformed
        try {
            // cek apakah ada baris yang dipilih
            int baris = tbldepart.getSelectedRow();

            if (baris == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!");
                return;
            }

            
            String id = tbldepart.getValueAt(baris, 0).toString();

            
            int konfirmasi = JOptionPane.showConfirmDialog(
                this,
                "Yakin ingin menghapus data ini?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION
            );

            if (konfirmasi == JOptionPane.YES_OPTION) {

                String sql = "DELETE FROM departement WHERE id_departement=?";
                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, id);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(this, "Data berhasil dihapus");

                datatable(); 
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal hapus: " + e);
        }
    }//GEN-LAST:event_btnhpsActionPerformed

    private void btntmbhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntmbhActionPerformed
         Frame09TmbhDepart frm = new Frame09TmbhDepart(this);
    frm.setLocationRelativeTo(this);
    frm.setVisible(true);

    }//GEN-LAST:event_btntmbhActionPerformed

    private void btnubhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubhActionPerformed
            int row = tbldepart.getSelectedRow();

    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah!");
        return;
    }

    String id = tbldepart.getValueAt(row, 0).toString();
    String nama = tbldepart.getValueAt(row, 1).toString();

    Frame09TmbhDepart frm = new Frame09TmbhDepart(this);
    frm.setEditData(id, nama);
    frm.setLocationRelativeTo(this);
    frm.setVisible(true);


    }//GEN-LAST:event_btnubhActionPerformed

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

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
 Object[] header = {"ID_Departement", "Nama_Departement"};
    tabmode = new DefaultTableModel(null, header);
    tbldepart.setModel(tabmode);

    try {
        String sql = "SELECT * FROM departement "
                   + "WHERE id_departement LIKE ? "
                   + "OR nama_departement LIKE ? "
                   + "ORDER BY id_departement";

        PreparedStatement pst = conn.prepareStatement(sql);

        String cari = "%" + txtcari1.getText().trim() + "%";

        pst.setString(1, cari);
        pst.setString(2, cari);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            tabmode.addRow(new Object[]{
                rs.getString("id_departement"),
                rs.getString("nama_departement")
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
    }        
    }//GEN-LAST:event_btncariActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Frame03DepartementKaryawan().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnabsen1;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btndash3;
    private javax.swing.JButton btndepartement1;
    private javax.swing.JButton btngaji1;
    private javax.swing.JButton btnhps;
    private javax.swing.JButton btnjabatan3;
    private javax.swing.JButton btnkaryawan1;
    private javax.swing.JButton btnlogo3;
    private javax.swing.JButton btnlogout1;
    private javax.swing.JButton btntmbh;
    private javax.swing.JButton btnubh;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbldepart;
    private javax.swing.JTextField txtcari1;
    // End of variables declaration//GEN-END:variables
}
