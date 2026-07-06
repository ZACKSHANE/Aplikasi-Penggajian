package tampilan;
import java.io.InputStream;
import java.util.HashMap;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.*;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.view.JasperViewer;
import utils.formatUang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;
public class Frame06GajiKaryawan extends javax.swing.JFrame {
      private int selectedIdGaji = 0;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frame06GajiKaryawan.class.getName());
     Connection conn = Koneksi.connect();
    DefaultTableModel model;
    
  
    public Frame06GajiKaryawan() {
             initComponents();
         loadBulan();
        loadTahun();
        datatable();
        System.out.println(conn);
        btnhapus.setText("Hapus");
        tblgaji.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        tblgajiMouseClicked(evt);
    }
});

    }
      private void loadBulan() {
        cbbulan.setModel(new DefaultComboBoxModel<>(new String[]{
            "Januari", "Februari", "Maret", "April",
            "Mei", "Juni", "Juli", "Agustus",
            "September", "Oktober", "November", "Desember"
        }));
    }
      
       private void loadTahun() {
        cbtahun.setModel(new DefaultComboBoxModel<>(new String[]{
            "2024", "2025", "2026"
        }));
    }
private int bulanKeAngka(String bulan) {
    String[] data = {
        "Januari","Februari","Maret","April","Mei","Juni",
        "Juli","Agustus","September","Oktober","November","Desember"
    };

    for (int i = 0; i < data.length; i++) {
        if (data[i].equals(bulan)) {
            return i + 1;
        }
    }
    return 1;
}
      
       private void datatable() {

    Object[] header = {
        "ID Gaji",
        "ID Karyawan",
        "Nama Karyawan",
        "Jabatan",
        "Departemen",
        "Bulan",
        "Total Hadir",
        "Bonus",
        "Potongan",
        "Total Gaji"
    };

    model = new DefaultTableModel(null, header);
    tblgaji.setModel(model);

    try {
        String sql = "SELECT * FROM detail_gaji";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("id_gaji"),
                rs.getInt("id_karyawan"),
                rs.getString("nama_karyawan"),
                rs.getString("nama_jabatan"),
                rs.getString("nama_departement"),
                rs.getString("bulan"),
                rs.getInt("total_hadir"),
                 formatUang.format(rs.getDouble("bonus")),
    formatUang.format(rs.getDouble("potongan")),
    formatUang.format(rs.getDouble("total_gaji"))
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
         
         
       private double hitungGaji(int hadir, double bonus, double potongan) {
        return (hadir * 50000) + bonus - potongan;
    }
    private void TampilGaji() {

    String bulan = cbbulan.getSelectedItem().toString();
    String tahun = cbtahun.getSelectedItem().toString();
    int bulanAngka = bulanKeAngka(bulan);

    try {

        
        PreparedStatement clear = conn.prepareStatement(
            "DELETE FROM detail_gaji WHERE bulan = ?"
        );
        clear.setString(1, bulan + " " + tahun);
        clear.executeUpdate();

       
        String sql =
            "SELECT k.id_karyawan, k.nama_karyawan, " +
            "j.nama_jabatan, j.gaji_pokok, " +
            "d.nama_departement, COUNT(a.id_absen) AS hadir " +
            "FROM karyawan k " +
            "JOIN jabatan j ON k.id_jabatan = j.id_jabatan " +
            "JOIN departement d ON k.id_departement = d.id_departement " +
            "LEFT JOIN absensi a ON k.id_karyawan = a.id_karyawan " +
            "AND MONTH(a.tanggal)=? AND YEAR(a.tanggal)=? AND UPPER(a.status)='HADIR' " +
            "GROUP BY k.id_karyawan";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, bulanAngka);
        ps.setInt(2, Integer.parseInt(tahun));

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            int id = rs.getInt("id_karyawan");
            String nama = rs.getString("nama_karyawan");
            String jabatan = rs.getString("nama_jabatan");
            String dept = rs.getString("nama_departement");

            int hadir = rs.getInt("hadir");
            double gajiPokok = rs.getDouble("gaji_pokok");

           

            double bonus = txtbonus2.getText().isEmpty()
        ? 0
        : Double.parseDouble(txtbonus2.getText());

double potongan = txtpotong.getText().isEmpty()
        ? 0
        : Double.parseDouble(txtpotong.getText());
            double total = (hadir / 26.0) * gajiPokok + bonus - potongan;

            
            String insert =
                "INSERT INTO detail_gaji " +
                "(id_karyawan, nama_karyawan, nama_jabatan, nama_departement, bulan, total_hadir, bonus, potongan, total_gaji) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(insert);

            pst.setInt(1, id);
            pst.setString(2, nama);
            pst.setString(3, jabatan);
            pst.setString(4, dept);
            pst.setString(5, bulan + " " + tahun);
            pst.setInt(6, hadir);
            pst.setDouble(7, bonus);
            pst.setDouble(8, potongan);
            pst.setDouble(9, total);

            pst.executeUpdate();
        }

        JOptionPane.showMessageDialog(this, "Generate gaji berhasil!");
        datatable();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
     private void hapusData() {

    int row = tblgaji.getSelectedRow();

    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data dulu!");
        return;
    }

    int idGaji = Integer.parseInt(tblgaji.getValueAt(row, 0).toString());

    try {
        String sql = "DELETE FROM detail_gaji WHERE id_gaji=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idGaji);

        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
        datatable();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
      
     private void generateDummyAbsensi() {
    try {
        Connection conn = Koneksi.connect();

        for (int id = 1; id <= 2; id++) {

            for (int i = 1; i <= 15; i++) {

                java.sql.Date tanggal =
                    java.sql.Date.valueOf("2026-05-" + String.format("%02d", i));

                String cekSql =
                    "SELECT COUNT(*) FROM absensi WHERE id_karyawan=? AND tanggal=?";

                PreparedStatement cek = conn.prepareStatement(cekSql);
                cek.setInt(1, id);
                cek.setDate(2, tanggal);

                ResultSet rs = cek.executeQuery();
                rs.next();

                if (rs.getInt(1) > 0) continue;

                String jamMasuk = "08:" + (int)(Math.random() * 30) + ":00";
                String jamKeluar = "16:" + (30 + (int)(Math.random() * 60)) + ":00";

                String sql =
                    "INSERT INTO absensi (id_karyawan, tanggal, jam_masuk, jam_keluar, status) " +
                    "VALUES (?, ?, ?, ?, ?)";

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setDate(2, tanggal);
                ps.setString(3, jamMasuk);
                ps.setString(4, jamKeluar);
                ps.setString(5, "HADIR");

                ps.executeUpdate();
            }
        }

        JOptionPane.showMessageDialog(this, "Dummy berhasil masuk DB");

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnlogo3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
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
        tblgaji = new javax.swing.JTable();
        btntampil = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbbulan = new javax.swing.JComboBox<>();
        cbtahun = new javax.swing.JComboBox<>();
        btnhapus = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtjabatan = new javax.swing.JTextField();
        txthadir = new javax.swing.JTextField();
        txtbonus2 = new javax.swing.JTextField();
        txtpotong = new javax.swing.JTextField();
        btnedit = new javax.swing.JButton();
        btncetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        btnlogo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/logoo.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("MingLiU-ExtB", 1, 22)); // NOI18N
        jLabel13.setText("Rekapitulasi Absensi");

        jLabel14.setFont(new java.awt.Font("MingLiU-ExtB", 1, 22)); // NOI18N
        jLabel14.setText("Karyawan");

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
                        .addComponent(jLabel14)))
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
                    .addComponent(jLabel13)
                    .addComponent(btndash3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnlogo3)
                .addGap(24, 24, 24)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
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
        jLabel5.setText("GAJI KARYAWAN");

        tblgaji.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama", "ID Karyawan", "Jabatan", "Departemen", "Gaji Pokok", "Bonus", "Potongan", "Total Gaji"
            }
        ));
        tblgaji.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblgajiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblgaji);

        btntampil.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btntampil.setText("Tampilkan");
        btntampil.addActionListener(this::btntampilActionPerformed);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("Bulan:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setText("Tahun:");

        cbbulan.addActionListener(this::cbbulanActionPerformed);

        cbtahun.addActionListener(this::cbtahunActionPerformed);

        btnhapus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(this::btnhapusActionPerformed);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel8.setText("Nama");

        txtnama.addActionListener(this::txtnamaActionPerformed);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setText("Jabatan");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel10.setText("Kehadiran");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel11.setText("Bonus");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel12.setText("Potongan");

        txtjabatan.addActionListener(this::txtjabatanActionPerformed);

        txthadir.addActionListener(this::txthadirActionPerformed);

        txtbonus2.addActionListener(this::txtbonus2ActionPerformed);

        txtpotong.addActionListener(this::txtpotongActionPerformed);

        btnedit.setText("Edit");
        btnedit.addActionListener(this::btneditActionPerformed);

        btncetak.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btncetak.setText("Cetak Laporan");
        btncetak.addActionListener(this::btncetakActionPerformed);

        javax.swing.GroupLayout krypanelLayout = new javax.swing.GroupLayout(krypanel);
        krypanel.setLayout(krypanelLayout);
        krypanelLayout.setHorizontalGroup(
            krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(krypanelLayout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jLabel5)
                .addGap(80, 337, Short.MAX_VALUE))
            .addGroup(krypanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, krypanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addGroup(krypanelLayout.createSequentialGroup()
                                .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, krypanelLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(27, 27, 27))
                                    .addGroup(krypanelLayout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)))
                                .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txthadir, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtbonus2)
                                            .addComponent(txtpotong, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(krypanelLayout.createSequentialGroup()
                            .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbbulan, 0, 179, Short.MAX_VALUE)
                                .addComponent(cbtahun, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btntampil, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                        .addComponent(btnedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncetak, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        krypanelLayout.setVerticalGroup(
            krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(krypanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel5)
                .addGap(60, 60, 60)
                .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(krypanelLayout.createSequentialGroup()
                        .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbbulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbtahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txthadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbonus2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(6, 6, 6)
                        .addGroup(krypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtpotong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(btnedit)
                        .addGap(18, 18, 18)
                        .addComponent(btntampil, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncetak, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(krypanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(krypanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    private void tblgajiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblgajiMouseClicked
        int row = tblgaji.getSelectedRow();

        selectedIdGaji = Integer.parseInt(model.getValueAt(row, 0).toString());

        txtnama.setText(model.getValueAt(row, 2).toString());
        txtjabatan.setText(model.getValueAt(row, 3).toString());
        txthadir.setText(model.getValueAt(row, 6).toString());

        txtbonus2.setText(model.getValueAt(row, 7).toString().replace("Rp", "").replace(".", ""));
        txtpotong.setText(model.getValueAt(row, 8).toString().replace("Rp", "").replace(".", ""));
    }//GEN-LAST:event_tblgajiMouseClicked

    private void btntampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntampilActionPerformed
        TampilGaji();
    }//GEN-LAST:event_btntampilActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        hapusData();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void txtjabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjabatanActionPerformed

    private void txthadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthadirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthadirActionPerformed

    private void txtbonus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbonus2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbonus2ActionPerformed

    private void txtpotongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpotongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpotongActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        if (selectedIdGaji == 0) {
            JOptionPane.showMessageDialog(this, "Pilih data dulu!");
            return;
        }

        try {
            int hadir = Integer.parseInt(txthadir.getText());
            double bonus = txtbonus2.getText().isEmpty() ? 0 : Double.parseDouble(txtbonus2.getText());
            double potongan = txtpotong.getText().isEmpty() ? 0 : Double.parseDouble(txtpotong.getText());

            String sqlGet = "SELECT j.gaji_pokok " +
            "FROM detail_gaji d " +
            "JOIN jabatan j ON d.nama_jabatan = j.nama_jabatan " +
            "WHERE d.id_gaji=?";

            PreparedStatement psGet = conn.prepareStatement(sqlGet);
            psGet.setInt(1, selectedIdGaji);

            ResultSet rs = psGet.executeQuery();

            double gajiPokok = 0;
            if (rs.next()) {
                gajiPokok = rs.getDouble("gaji_pokok");
            }

            double total = (hadir / 26.0) * gajiPokok + bonus - potongan;

            String sql = "UPDATE detail_gaji SET total_hadir=?, bonus=?, potongan=?, total_gaji=? WHERE id_gaji=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, hadir);
            ps.setDouble(2, bonus);
            ps.setDouble(3, potongan);
            ps.setDouble(4, total);
            ps.setInt(5, selectedIdGaji);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
            datatable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            System.out.println(
                net.sf.jasperreports.engine.JasperCompileManager.class
                .getPackage()
                .getImplementationVersion()
            );
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void btncetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetakActionPerformed
        try {
            Connection conn = Koneksi.connect();

            InputStream report = getClass().getResourceAsStream("/tampilan/gaji.jasper");

            HashMap<String, Object> parameters = new HashMap<>();

            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);

            JasperViewer.viewReport(print, false);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btncetakActionPerformed

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

    private void cbtahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbtahunActionPerformed

    private void cbbulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbulanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbulanActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Frame06GajiKaryawan().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnabsen1;
    private javax.swing.JButton btncetak;
    private javax.swing.JButton btndash3;
    private javax.swing.JButton btndepartement1;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btngaji1;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnjabatan3;
    private javax.swing.JButton btnkaryawan1;
    private javax.swing.JButton btnlogo3;
    private javax.swing.JButton btnlogout1;
    private javax.swing.JButton btntampil;
    private javax.swing.JComboBox<String> cbbulan;
    private javax.swing.JComboBox<String> cbtahun;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel krypanel;
    private javax.swing.JTable tblgaji;
    private javax.swing.JTextField txtbonus2;
    private javax.swing.JTextField txthadir;
    private javax.swing.JTextField txtjabatan;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtpotong;
    // End of variables declaration//GEN-END:variables
}
