package tampilan;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

public class Frame05AbsenKaryawan extends javax.swing.JFrame {
       private Connection conn = Koneksi.connect();
    private DefaultTableModel tabmode;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frame05AbsenKaryawan.class.getName());

    
    public Frame05AbsenKaryawan() {
         initComponents();
        datatable();
    loadKaryawan();
    txtnama5.setEditable(false);
    txttgl5.setEditable(false);
    }
    
       private void setTanggal() {
    java.time.LocalDate today = java.time.LocalDate.now();
    txttgl5.setText(today.toString());
}
      private void loadKaryawan() {
    try {
        String sql = "SELECT id_karyawan, nama_karyawan FROM karyawan";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        cbkaryawan5.removeAllItems();

        while (rs.next()) {
            cbkaryawan5.addItem(rs.getString("id_karyawan"));
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
      
      
private void datatable() {

    Object[] header = {
        "ID", "Nama", "ID Karyawan", "Tanggal", "Masuk", "Keluar", "Status"
    };

    tabmode = new DefaultTableModel(null, header);
    tblabsen5.setModel(tabmode);

    try {

        String sql =
        "SELECT a.id_absen, k.nama_karyawan, a.id_karyawan, a.tanggal, " +
        "a.jam_masuk, a.jam_keluar, a.status " +
        "FROM absensi a " +
        "JOIN karyawan k ON a.id_karyawan = k.id_karyawan " +
        "ORDER BY a.tanggal ASC";

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            tabmode.addRow(new Object[]{
                rs.getInt("id_absen"),
                rs.getString("nama_karyawan"),
                rs.getInt("id_karyawan"),
                rs.getDate("tanggal"),
                rs.getString("jam_masuk"),
                rs.getString("jam_keluar"),
                rs.getString("status")
            });

        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
private void searchData(String keyword) {
    Object[] header = {
        "ID", "Nama", "ID Karyawan", "Tanggal", "Masuk", "Keluar", "Status"
    };

    tabmode = new DefaultTableModel(null, header);
    tblabsen5.setModel(tabmode);

    try {
        String sql =
        "SELECT a.id_absen, k.nama_karyawan, a.id_karyawan, a.tanggal, " +
        "a.jam_masuk, a.jam_keluar, a.status " +
        "FROM absensi a " +
        "JOIN karyawan k ON a.id_karyawan = k.id_karyawan " +
        "WHERE k.nama_karyawan LIKE ? OR a.id_karyawan LIKE ? " +
        "ORDER BY a.tanggal ASC";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + keyword + "%");
        ps.setString(2, "%" + keyword + "%");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            tabmode.addRow(new Object[]{
                rs.getInt("id_absen"),
                rs.getString("nama_karyawan"),
                rs.getInt("id_karyawan"),
                rs.getDate("tanggal"),
                rs.getString("jam_masuk"),
                rs.getString("jam_keluar"),
                rs.getString("status")
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
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
        krypanel5 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblabsen5 = new javax.swing.JTable();
        btnmasuk5 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtnama5 = new javax.swing.JTextField();
        btnpulang5 = new javax.swing.JButton();
        cbkaryawan5 = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        txttgl5 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtsearch5 = new javax.swing.JTextField();

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

        krypanel5.setBackground(new java.awt.Color(0, 204, 204));
        krypanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel28.setText("ABSEN KARYAWAN");

        tblabsen5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Absen", "Nama Karyawan", "ID Karyawan ", "Tanggal", "Jam Masuk", "Jam Keluar", "Status"
            }
        ));
        tblabsen5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblabsen5MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblabsen5);

        btnmasuk5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnmasuk5.setText("Masuk");
        btnmasuk5.addActionListener(this::btnmasuk5ActionPerformed);

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel29.setText("Nama:");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel30.setText("ID Karyawan:");

        txtnama5.addActionListener(this::txtnama5ActionPerformed);

        btnpulang5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnpulang5.setText("Pulang");
        btnpulang5.addActionListener(this::btnpulang5ActionPerformed);

        cbkaryawan5.addActionListener(this::cbkaryawan5ActionPerformed);

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel31.setText("Tanggal");

        txttgl5.addActionListener(this::txttgl5ActionPerformed);

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel32.setText("Search");

        txtsearch5.addActionListener(this::txtsearch5ActionPerformed);

        javax.swing.GroupLayout krypanel5Layout = new javax.swing.GroupLayout(krypanel5);
        krypanel5.setLayout(krypanel5Layout);
        krypanel5Layout.setHorizontalGroup(
            krypanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(krypanel5Layout.createSequentialGroup()
                .addGroup(krypanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(krypanel5Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jLabel28))
                    .addGroup(krypanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(krypanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(krypanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnmasuk5, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                                .addComponent(btnpulang5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(krypanel5Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(krypanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(krypanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtnama5, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(cbkaryawan5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txttgl5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, krypanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsearch5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );
        krypanel5Layout.setVerticalGroup(
            krypanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(krypanel5Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel28)
                .addGap(10, 10, 10)
                .addGroup(krypanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsearch5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(krypanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(krypanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(krypanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbkaryawan5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(krypanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnama5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(krypanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttgl5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(btnmasuk5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnpulang5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(krypanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(krypanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void tblabsen5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblabsen5MouseClicked
        int row = tblabsen5.getSelectedRow();

        JOptionPane.showMessageDialog(this,
            "ID Absen: " + tabmode.getValueAt(row, 0) +
            "\nNama: " + tabmode.getValueAt(row, 1) +
            "\nTanggal: " + tabmode.getValueAt(row, 3));
    }//GEN-LAST:event_tblabsen5MouseClicked

    private void btnmasuk5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmasuk5ActionPerformed
        try {
            String sql = "INSERT INTO absensi (id_karyawan, tanggal, jam_masuk, status) " +
            "VALUES (?, ?, ?, ?) " +
            "ON DUPLICATE KEY UPDATE " +
            "jam_masuk = VALUES(jam_masuk), " +
            "status = VALUES(status)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, cbkaryawan5.getSelectedItem().toString());
            pst.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
            pst.setString(3, java.time.LocalTime.now().toString());
            pst.setString(4, "HADIR");

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Absen Masuk Berhasil");

            datatable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnmasuk5ActionPerformed

    private void txtnama5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnama5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnama5ActionPerformed

    private void btnpulang5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpulang5ActionPerformed
        try {
            String sql = "UPDATE absensi SET jam_keluar=? WHERE id_karyawan=? AND tanggal=?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, java.time.LocalTime.now().toString());
            pst.setString(2, cbkaryawan5.getSelectedItem().toString());
            pst.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Absen Pulang Berhasil");
            datatable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnpulang5ActionPerformed

    private void cbkaryawan5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkaryawan5ActionPerformed
        try {
            String sql = "SELECT nama_karyawan FROM karyawan WHERE id_karyawan=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cbkaryawan5.getSelectedItem().toString());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtnama5.setText(rs.getString("nama_karyawan"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_cbkaryawan5ActionPerformed

    private void txttgl5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttgl5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttgl5ActionPerformed

    private void txtsearch5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearch5ActionPerformed
        searchData(txtsearch5.getText());
    }//GEN-LAST:event_txtsearch5ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Frame05AbsenKaryawan().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnabsen1;
    private javax.swing.JButton btndash3;
    private javax.swing.JButton btndepartement1;
    private javax.swing.JButton btngaji1;
    private javax.swing.JButton btnjabatan3;
    private javax.swing.JButton btnkaryawan1;
    private javax.swing.JButton btnlogo3;
    private javax.swing.JButton btnlogout1;
    private javax.swing.JButton btnmasuk5;
    private javax.swing.JButton btnpulang5;
    private javax.swing.JComboBox<String> cbkaryawan5;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel krypanel5;
    private javax.swing.JTable tblabsen5;
    private javax.swing.JTextField txtnama5;
    private javax.swing.JTextField txtsearch5;
    private javax.swing.JTextField txttgl5;
    // End of variables declaration//GEN-END:variables
}
