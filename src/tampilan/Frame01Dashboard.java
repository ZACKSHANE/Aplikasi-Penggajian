package tampilan;
import javax.swing.JOptionPane;
import java.awt.CardLayout;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import koneksi.Koneksi;

public class Frame01Dashboard extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frame01Dashboard.class.getName());
       private Connection conn = Koneksi.connect();
    public Frame01Dashboard() {
        initComponents();
        
    tampilDataDashboard();
    tampilPieChart();
    tampilBarChart();
    }

    public javax.swing.JPanel getDshpanel() {
        return dshpanel;
        }
        private void tampilDataDashboard() {

    try {

        Statement st = conn.createStatement();

       
        ResultSet rsJabatan = st.executeQuery(
            "SELECT COUNT(*) AS total FROM jabatan"
        );

        if(rsJabatan.next()){
            lblangka.setText(rsJabatan.getString("total"));
        }

        
        ResultSet rsDepartemen = st.executeQuery(
            "SELECT COUNT(*) AS total FROM departement"
        );

        if(rsDepartemen.next()){
            lblangka1.setText(rsDepartemen.getString("total"));
        }

        
        ResultSet rsKaryawan = st.executeQuery(
            "SELECT COUNT(*) AS total FROM karyawan"
        );

        if(rsKaryawan.next()){
            lblangka2.setText(rsKaryawan.getString("total"));
        }

        
        ResultSet rsAbsensi = st.executeQuery(
            "SELECT COUNT(*) AS total FROM absensi"
        );

        if(rsAbsensi.next()){
            lblangka3.setText(rsAbsensi.getString("total"));
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
        private void tampilPieChart() {

    DefaultPieDataset dataset = new DefaultPieDataset();

    dataset.setValue("Hadir", 80);
    dataset.setValue("Izin", 10);
    dataset.setValue("Sakit", 5);
    dataset.setValue("Alpha", 5);

    JFreeChart chart = ChartFactory.createPieChart(
            "Statistik Absensi",
            dataset,
            true,
            true,
            false
    );

   ChartPanel chartPanel = new ChartPanel(chart);

chartPanel.setPreferredSize(new java.awt.Dimension(450,350));

panelpiechart.setLayout(new java.awt.BorderLayout());
panelpiechart.removeAll();
panelpiechart.add(chartPanel, java.awt.BorderLayout.CENTER);
panelpiechart.revalidate();
panelpiechart.repaint(); 
}
private void tampilBarChart() {

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    dataset.setValue(20, "Absensi", "Sen");
    dataset.setValue(35, "Absensi", "Sel");
    dataset.setValue(40, "Absensi", "Rab");
    dataset.setValue(25, "Absensi", "Kam");
    dataset.setValue(50, "Absensi", "Jum");

    JFreeChart chart = ChartFactory.createBarChart(
            "Aktivitas Absensi",
            "Hari",
            "Jumlah",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
    );

   ChartPanel barChart = new ChartPanel(chart);

barChart.setPreferredSize(new java.awt.Dimension(400,350));



    panelactivity.setLayout(new java.awt.BorderLayout());
    panelactivity.removeAll();
    panelactivity.add(barChart, java.awt.BorderLayout.CENTER);
    panelactivity.validate();
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
        btnjabatan = new javax.swing.JButton();
        btndepartement = new javax.swing.JButton();
        btnkaryawan = new javax.swing.JButton();
        btnabsen = new javax.swing.JButton();
        btngaji = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();
        dshpanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        paneljabatan = new javax.swing.JPanel();
        lblangka = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        paneldepartement = new javax.swing.JPanel();
        lblangka1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelkaryawan = new javax.swing.JPanel();
        lblangka2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelabsen = new javax.swing.JPanel();
        lblangka3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelpiechart = new javax.swing.JPanel();
        panelactivity = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        btnlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/logoo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("MingLiU-ExtB", 1, 22)); // NOI18N
        jLabel1.setText("Rekapitulasi Absensi");

        jLabel3.setFont(new java.awt.Font("MingLiU-ExtB", 1, 22)); // NOI18N
        jLabel3.setText("Karyawan");

        btndash.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btndash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/dsh 2.png"))); // NOI18N
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
                .addGap(87, 87, 87)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 41, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnlogo)
                .addGap(18, 18, 18)
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

        dshpanel.setBackground(new java.awt.Color(0, 204, 204));
        dshpanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("DASHBOARD ADMIN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(309, 309, 309))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        paneljabatan.setBackground(new java.awt.Color(102, 255, 255));
        paneljabatan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblangka.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        lblangka.setText("10");
        paneljabatan.add(lblangka, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 32, -1, 67));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Jabatan");
        paneljabatan.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 32, 107, 55));

        paneldepartement.setBackground(new java.awt.Color(102, 255, 255));

        lblangka1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        lblangka1.setText("10");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Departement");

        javax.swing.GroupLayout paneldepartementLayout = new javax.swing.GroupLayout(paneldepartement);
        paneldepartement.setLayout(paneldepartementLayout);
        paneldepartementLayout.setHorizontalGroup(
            paneldepartementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldepartementLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblangka1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        paneldepartementLayout.setVerticalGroup(
            paneldepartementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldepartementLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(paneldepartementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblangka1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelkaryawan.setBackground(new java.awt.Color(102, 255, 255));

        lblangka2.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        lblangka2.setText("10");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Karyawan");

        javax.swing.GroupLayout panelkaryawanLayout = new javax.swing.GroupLayout(panelkaryawan);
        panelkaryawan.setLayout(panelkaryawanLayout);
        panelkaryawanLayout.setHorizontalGroup(
            panelkaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelkaryawanLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblangka2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelkaryawanLayout.setVerticalGroup(
            panelkaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelkaryawanLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelkaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblangka2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelabsen.setBackground(new java.awt.Color(102, 255, 255));

        lblangka3.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        lblangka3.setText("10");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Absensi");

        javax.swing.GroupLayout panelabsenLayout = new javax.swing.GroupLayout(panelabsen);
        panelabsen.setLayout(panelabsenLayout);
        panelabsenLayout.setHorizontalGroup(
            panelabsenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelabsenLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblangka3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelabsenLayout.setVerticalGroup(
            panelabsenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelabsenLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelabsenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblangka3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelpiechartLayout = new javax.swing.GroupLayout(panelpiechart);
        panelpiechart.setLayout(panelpiechartLayout);
        panelpiechartLayout.setHorizontalGroup(
            panelpiechartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        panelpiechartLayout.setVerticalGroup(
            panelpiechartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelactivityLayout = new javax.swing.GroupLayout(panelactivity);
        panelactivity.setLayout(panelactivityLayout);
        panelactivityLayout.setHorizontalGroup(
            panelactivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );
        panelactivityLayout.setVerticalGroup(
            panelactivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dshpanelLayout = new javax.swing.GroupLayout(dshpanel);
        dshpanel.setLayout(dshpanelLayout);
        dshpanelLayout.setHorizontalGroup(
            dshpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dshpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dshpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dshpanelLayout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(panelpiechart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelactivity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dshpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paneljabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paneldepartement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelabsen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        dshpanelLayout.setVerticalGroup(
            dshpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dshpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(dshpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paneljabatan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneldepartement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelkaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelabsen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dshpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelpiechart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelactivity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dshpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dshpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnjabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnjabatanActionPerformed
        new Frame02JabatanKaryawan().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnjabatanActionPerformed

    private void btnabsenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnabsenActionPerformed
        new Frame05AbsenKaryawan().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnabsenActionPerformed

    private void btnkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkaryawanActionPerformed
            new Frame04DataKaryawan().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnkaryawanActionPerformed

    private void btndepartementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndepartementActionPerformed
       new Frame03DepartementKaryawan().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btndepartementActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Frame01Dashboard().setVisible(true));
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
    private javax.swing.JPanel dshpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblangka;
    private javax.swing.JLabel lblangka1;
    private javax.swing.JLabel lblangka2;
    private javax.swing.JLabel lblangka3;
    private javax.swing.JPanel panelabsen;
    private javax.swing.JPanel panelactivity;
    private javax.swing.JPanel paneldepartement;
    private javax.swing.JPanel paneljabatan;
    private javax.swing.JPanel panelkaryawan;
    private javax.swing.JPanel panelpiechart;
    // End of variables declaration//GEN-END:variables
}
