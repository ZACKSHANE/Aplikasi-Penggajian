package tampilan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.Koneksi
        ;
public class frametambahdata extends javax.swing.JFrame {
     private Connection conn = Koneksi.connect();

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frametambahdata.class.getName());
private Frame04DataKaryawan parent2;
    public frametambahdata() {
        initComponents();
         loadJabatan();
    loadDepartement();
    }
    
    public frametambahdata(Frame04DataKaryawan parent) {
    initComponents();
    this.parent2 = parent;

    loadJabatan();
    loadDepartement();
}
    
    private void loadJabatan() {
    try {

        String sql =
                "SELECT id_jabatan, nama_jabatan FROM jabatan";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        cbjabatan.removeAllItems();
        cbjabatan.addItem("-- Pilih Jabatan --");

        while (rs.next()) {

            cbjabatan.addItem(
                    rs.getString("id_jabatan")
                    + " - "
                    + rs.getString("nama_jabatan")
            );
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
}

private void loadDepartement() {
    try {

        String sql =
                "SELECT id_departement, nama_departement FROM departement";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        cbdepartement.removeAllItems();
        cbdepartement.addItem("-- Pilih Departement --");

        while (rs.next()) {

            cbdepartement.addItem(
                    rs.getString("id_departement")
                    + " - "
                    + rs.getString("nama_departement")
            );
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
}
private String getID(String text) {
    return text.split(" - ")[0];
}

private boolean editMode = false;
private String idKaryawan;

public void setEditData(String id, String jabatan, String departemen,
                        String nama, String hp, String alamat,
                        String username, String password) {

    editMode = true;
    idKaryawan = id;

    txtnama.setText(nama);
    txthp.setText(hp);
    txtalamat.setText(alamat);
    txtusername.setText(username);
    txtpassword.setText(password);

    // IMPORTANT: harus sesuai format combo box
    cbjabatan.setSelectedItem(jabatan);
    cbdepartement.setSelectedItem(departemen);
}

    private void kosong() {

    txtnama.setText("");
    txtusername.setText("");
    txtpassword.setText("");
    txthp.setText("");
    txtalamat.setText("");

    cbjabatan.setSelectedIndex(0);
    cbdepartement.setSelectedIndex(0);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbjabatan = new javax.swing.JComboBox<>();
        cbdepartement = new javax.swing.JComboBox<>();
        txthp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        btnsimpan = new javax.swing.JButton();
        txtnama = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(176, 231, 220));

        jLabel1.setText("Nama Karyawan:");

        jLabel2.setText("ID Jabatan:");

        jLabel3.setText("ID Departemen:");

        jLabel5.setText("No HP:");

        jLabel6.setText("Alamat:");

        cbjabatan.addActionListener(this::cbjabatanActionPerformed);

        cbdepartement.addActionListener(this::cbdepartementActionPerformed);

        txtalamat.setColumns(20);
        txtalamat.setRows(5);
        jScrollPane1.setViewportView(txtalamat);

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(this::btnsimpanActionPerformed);

        txtnama.addActionListener(this::txtnamaActionPerformed);

        jLabel7.setText("Username:");

        jLabel8.setText("Password:");

        txtusername.addActionListener(this::txtusernameActionPerformed);

        txtpassword.addActionListener(this::txtpasswordActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnama))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txthp, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbjabatan, 0, 160, Short.MAX_VALUE)
                                            .addComponent(cbdepartement, 0, 160, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtpassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbdepartement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txthp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsimpan)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbdepartementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbdepartementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbdepartementActionPerformed

    private void cbjabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbjabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbjabatanActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
         try {

        if (!editMode) {

            // ===== INSERT =====
            String sql = "INSERT INTO karyawan (nama_karyawan, username, password, id_jabatan, id_departement, no_hp, alamat) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, txtnama.getText());
            pst.setString(2, txtusername.getText());
            pst.setString(3, txtpassword.getText());
            pst.setString(4, getID(cbjabatan.getSelectedItem().toString()));
            pst.setString(5, getID(cbdepartement.getSelectedItem().toString()));
            pst.setString(6, txthp.getText());
            pst.setString(7, txtalamat.getText());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil ditambah");

        } else {

            // ===== UPDATE =====
            String sql = "UPDATE karyawan SET nama_karyawan=?, username=?, password=?, id_jabatan=?, id_departement=?, no_hp=?, alamat=? WHERE id_karyawan=?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, txtnama.getText());
            pst.setString(2, txtusername.getText());
            pst.setString(3, txtpassword.getText());
            pst.setString(4, getID(cbjabatan.getSelectedItem().toString()));
            pst.setString(5, getID(cbdepartement.getSelectedItem().toString()));
            pst.setString(6, txthp.getText());
            pst.setString(7, txtalamat.getText());
            pst.setString(8, idKaryawan);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil diupdate");
        }

  if (parent2 != null) {
    parent2.datatable();
}
        dispose();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e);
    }
    }//GEN-LAST:event_btnsimpanActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> new frametambahdata().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> cbdepartement;
    private javax.swing.JComboBox<String> cbjabatan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtalamat;
    private javax.swing.JTextField txthp;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
