package tampilan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import koneksi.Koneksi;
import utils.formatUang;

public class PanelSlipGaji extends JPanel {

    JTable table;
    DefaultTableModel model;
    Connection conn = Koneksi.connect();

    public PanelSlipGaji(int idUser) {
        setLayout(new java.awt.BorderLayout());

        model = new DefaultTableModel(new Object[]{
            "Bulan", "Total Hadir", "Bonus", "Potongan", "Total Gaji"
        }, 0);

        table = new JTable(model);
        add(new JScrollPane(table), java.awt.BorderLayout.CENTER);

        loadData(idUser);
    }

    private void loadData(int idUser) {
        try {
            String sql = "SELECT * FROM detail_gaji WHERE id_karyawan=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUser);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
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
}