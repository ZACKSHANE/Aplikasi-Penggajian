package tampilan;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;
import utils.formatUang;

public class Frame02JabatanKaryawan extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frame02JabatanKaryawan.class.getName());
      private Connection conn = Koneksi.connect();
    private DefaultTableModel tabmode;
    private int id_jabatan;
    public Frame02JabatanKaryawan() {
        initComponents();
          datatable();
          jButton4.setText("Cari");
    }

  protected void datatable() {
        Object[] header = {"ID Jabatan", "Nama Jabatan", "Gaji Pokok"};
        tabmode = new DefaultTableModel(null, header);
        tbljabatan.setModel(tabmode);

        try {
            String sql = "SELECT * FROM jabatan ORDER BY id_jabatan";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                tabmode.addRow(new Object[]{
                    rs.getString("id_jabatan"),
                    rs.getString("nama_jabatan"),
                    formatUang.format(rs.getDouble("gaji_pokok")),
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
        krypanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbljabatan = new javax.swing.JTable();
        btntambah = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnlogo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btndash = new javax.swing.JButton();
        btnjabatan = new javax.swing.JButton();
        btndepartement = new javax.swing.JButton();
        btnkaryawan = new javax.swing.JButton();
        btnabsen = new javax.swing.JButton();
        btngaji = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setForeground(new java.awt.Color(0, 204, 204));

        krypanel.setBackground(new java.awt.Color(0, 204, 204));
        krypanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setText("JABATAN");

        tbljabatan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Jabatan", "Nama", "Gaji"
            }
        ));
        tbljabatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbljabatanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbljabatan);

        btntambah.setText("Tambah Data");
        btntambah.addActionListener(this::btntambahActionPerformed);

        btnubah.setText("Ubah");
        btnubah.addActionListener(this::btnubahActionPerformed);

        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        jButton4.setText("Cari");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        javax.swing.GroupLayout krypanelLayout = new javax.swing.GroupLayout(krypanel);
        krypanel.setLayout(krypanelLayout);
        krypanelLayout.setHorizontalGroup(
            krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(krypanelLayout.createSequentialGroup()
                .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(krypanelLayout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(jLabel5))
                    .addGroup(krypanelLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(krypanelLayout.createSequentialGroup()
                                .addComponent(btntambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnubah)))))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, krypanelLayout.createSequentialGroup()
                .addGap(0, 670, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        krypanelLayout.setVerticalGroup(
            krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(krypanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntambah)
                    .addComponent(btnubah))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        btnjabatan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnjabatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icon jabatan.jpg"))); // NOI18N
        btnjabatan.setText("Jabatan");
        btnjabatan.addActionListener(this::btnjabatanActionPerformed);

        btndepartement.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btndepartement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icon dprtm.jpg"))); // NOI18N
        btndepartement.setText("Departement");
        btndepartement.addActionListener(this::btndepartementActionPerformed);

        btnkaryawan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnkaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/karyawan.png"))); // NOI18N
        btnkaryawan.setText("Karyawan");
        btnkaryawan.addActionListener(this::btnkaryawanActionPerformed);

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
                    .addComponent(btnkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndepartement, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btndepartement, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnabsen, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btngaji, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(krypanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void tbljabatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbljabatanMouseClicked
 int baris = tbljabatan.getSelectedRow();

    if (baris != -1) {
        id_jabatan = Integer.parseInt(
                tbljabatan.getValueAt(baris, 0).toString());
    }
    }//GEN-LAST:event_tbljabatanMouseClicked

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        new Frame08TmbhJabatan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
        int baris = tbljabatan.getSelectedRow();

        if (baris == -1) {
            JOptionPane.showMessageDialog(this,
                "Pilih data dulu!");
            return;
        }

        int id = Integer.parseInt(
            tbljabatan.getValueAt(baris, 0).toString());

        String nama =
        tbljabatan.getValueAt(baris, 1).toString();

        String gaji =
        tbljabatan.getValueAt(baris, 2)
        .toString()
        .replace("Rp", "")
        .replace(".", "")
        .trim();

        new Frame08TmbhJabatan(
            id, nama, gaji)
        .setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnubahActionPerformed

    private void btnjabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnjabatanActionPerformed
        new Frame02JabatanKaryawan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnjabatanActionPerformed

    private void btndepartementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndepartementActionPerformed
        new Frame03DepartementKaryawan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btndepartementActionPerformed

    private void btnkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkaryawanActionPerformed
        new Frame04DataKaryawan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnkaryawanActionPerformed

    private void btnabsenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnabsenActionPerformed
        new Frame05AbsenKaryawan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnabsenActionPerformed

    private void btngajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngajiActionPerformed
        new Frame06GajiKaryawan().setVisible(true);
        this.dispose();
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         String cari = jTextField1.getText().trim();

    Object[] header = {"ID Jabatan", "Nama Jabatan", "Gaji Pokok"};
    tabmode = new DefaultTableModel(null, header);
    tbljabatan.setModel(tabmode);

    try {
        String sql = "SELECT * FROM jabatan "
                + "WHERE id_jabatan LIKE ? "
                + "OR nama_jabatan LIKE ? "
                + "ORDER BY id_jabatan";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + cari + "%");
        pst.setString(2, "%" + cari + "%");

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            tabmode.addRow(new Object[]{
                rs.getString("id_jabatan"),
                rs.getString("nama_jabatan"),
                formatUang.format(rs.getDouble("gaji_pokok"))
            });
        }

        if (tabmode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Data tidak ditemukan!");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

   
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(() -> new Frame02JabatanKaryawan().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnabsen;
    private javax.swing.JButton btndash;
    private javax.swing.JButton btndepartement;
    private javax.swing.JButton btngaji;
    private javax.swing.JButton btnjabatan;
    private javax.swing.JButton btnkaryawan;
    private javax.swing.JButton btnlogo;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btnubah;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel krypanel;
    private javax.swing.JTable tbljabatan;
    // End of variables declaration//GEN-END:variables
}
