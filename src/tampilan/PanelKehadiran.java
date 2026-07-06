package tampilan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import koneksi.Koneksi;

public class PanelKehadiran extends JPanel {

    JTable table;
    DefaultTableModel model;
    Connection conn = Koneksi.connect();

  public PanelKehadiran(int idUser, String bulan, String tahun) {
    setLayout(new java.awt.BorderLayout());

    model = new DefaultTableModel(new Object[]{
        "Tanggal", "Jam Masuk", "Jam Keluar", "Status"
    }, 0);

    table = new JTable(model);
    add(new JScrollPane(table), java.awt.BorderLayout.CENTER);

    loadDataFilter(idUser, bulan, tahun);
}
   
   private void loadDataFilter(int idUser, String bulan, String tahun) {
    try {
        String sql = "SELECT * FROM absensi WHERE id_karyawan=? AND MONTH(tanggal)=? AND YEAR(tanggal)=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, idUser);
        ps.setInt(2, convertBulan(bulan)); // convert ke angka
        ps.setInt(3, Integer.parseInt(tahun));

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
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
   private int convertBulan(String bulan) {
    switch (bulan) {
        case "Januari": return 1;
        case "Februari": return 2;
        case "Maret": return 3;
        case "April": return 4;
        case "Mei": return 5;
        case "Juni": return 6;
        case "Juli": return 7;
        case "Agustus": return 8;
        case "September": return 9;
        case "Oktober": return 10;
        case "November": return 11;
        case "Desember": return 12;
        default: return 1;
    }
}

    private void loadData(int idUser) {
        try {
            String sql = "SELECT * FROM absensi WHERE id_karyawan=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUser);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
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
}