package tampilan;
/**
 * @author https://github.com/llawliet1945
 */
import session.LoginSession;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
public class formtransaksi extends javax.swing.JFrame {
    public String nikpenjual,namapenjual,nikpembeli,namapembeli;
    private Connection conn = new koneksi().getKoneksi();
    PreparedStatement pst = null;
    ResultSet rs = null;
    private DefaultTableModel tabmode;
    public formtransaksi() {
        initComponents();
        autonumber();
        datatable();
        String KODE = LoginSession.getUserLogin();
        lusername.setText(KODE);
        txtid.setEnabled(false);
        txthn.setEnabled(false);
        txttotal.setEnabled(false);
        txtnikpem.setEnabled(false);
        txtnikpen.setEnabled(false);
    }
    public void print(){
        try{
            String File1 = "src/tampilan/transaksi.jasper";
            HashMap par = new HashMap();
            par.put("idtransaksi", txtid.getText());
            JasperPrint Print = JasperFillManager.fillReport (File1, par, conn);
            JasperViewer.viewReport(Print, false);
            //JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch(Exception f){
            JOptionPane.showMessageDialog(this, f.getMessage());
        }
    }
    protected void datatable(){
        Object[] Baris = {"Id Transaksi", "Username Admin", "NIK Pembeli", "NIK Penjual", "No Ajb", "Luas Tanah","NJOP","Tgl Transaksi","Harga","Harga Notaris","Total"};
        tabmode = new DefaultTableModel(null, Baris);
        table.setModel(tabmode);
        String sql = "SELECT * FROM transaksi WHERE idtransaksi LIKE '%" +txtcari.getText()+"%'or nik_pembeli like '%"+txtcari.getText()+"%' or nik_penjual like '%"+txtcari.getText()+"%'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery (sql);
            while(hasil.next()){
                String a = hasil.getString("idtransaksi");
                String b = hasil.getString("username_admin");
                String c = hasil.getString("nik_pembeli");
                String d = hasil.getString("nik_penjual");
                String e = hasil.getString("noajb");
                String f = hasil.getString("luas_tanah");
                String g = hasil.getString("njop");
                String h = hasil.getString("tgltransaksi");
                String i = hasil.getString("harga_transaksi");
                String j = hasil.getString("harga_notaris");
                String k = hasil.getString("harga_total");
                String[] data={a,b,c,d,e,f,g,h,i,j,k};
                tabmode.addRow(data);
            }
         }catch (Exception f){
             JOptionPane.showMessageDialog(this, "Data Gagal Dipanggil: "+f);
         }
    }
    protected void kosong(){
        txtno.setText("");
        txtluas.setText("");
        txtht.setText("");
        txthn.setText("");
        txttotal.setText("");
        txtnikpen.setText("");
        txtnampen.setText("");
        txtnikpem.setText("");
        txtnampen.setText("");
        txtnjop.setText("");
    }
    protected void hitung(){
        int ht = Integer.parseInt(txtht.getText());
        int hn = (ht/100)*10;
        txthn.setText(Integer.toString(hn));
        int total = ht+hn;
        txttotal.setText(Integer.toString(total));
    }
    
    protected void autonumber(){
        try{
            String Query = "Select idtransaksi from transaksi order by idtransaksi asc";
            Statement st = conn.createStatement();
            ResultSet Res = st.executeQuery(Query);
            txtid.setText("AJB0001");
            while(Res.next()){
                String Id_Transaksi = Res.getString("idtransaksi").substring(3);
                int AN = Integer.parseInt(Id_Transaksi)+1;
                String Nol = "";
                if (AN<10){Nol="000";
                } else if (AN<100){Nol="00";
                }else if (AN<1000){Nol="0";
                }else if (AN<10000){Nol="";
                }
                txtid.setText("AJB" + Nol + AN);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Auto Number Gagal"+ex);
        }
    }
    void pembeliTerpilih(){
        popuppembeli ini = new popuppembeli();
        ini.ft = this;
        txtnikpem.setText(nikpembeli);
        txtnampem.setText(namapembeli);
    }
    void penjualTerpilih(){
        popuppenjual itu = new popuppenjual();
        itu.fy = this;
        txtnikpen.setText(nikpenjual);
        txtnampen.setText(namapenjual);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lusername = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bsimpan = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtht = new javax.swing.JTextField();
        txtnjop = new javax.swing.JTextField();
        txtluas = new javax.swing.JTextField();
        txtnampen = new javax.swing.JTextField();
        txtnikpen = new javax.swing.JTextField();
        txtno = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        bcaripen = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtnikpem = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        txtnampem = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txthn = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        bcaripem = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jtgl = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(790, 735));
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(216, 76, 60));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ID TRANSAKSI");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("NOMOR AJB");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        lusername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(lusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 160, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("NAMA PENJUAL");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("LUAS TANAH");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 22));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("NJOP");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, 27));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("HARGA TRANSAKSI");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, 25));

        jPanel2.setBackground(new java.awt.Color(150, 40, 27));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("TRANSAKSI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(334, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(307, 307, 307))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 760, -1));

        bsimpan.setText("SAVE");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel3.add(bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 79, -1));

        bedit.setText("EDIT");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });
        jPanel3.add(bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 81, -1));

        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 88, -1));
        jPanel3.add(txtht, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 168, -1));
        jPanel3.add(txtnjop, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 168, -1));
        jPanel3.add(txtluas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 168, -1));
        jPanel3.add(txtnampen, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 168, -1));
        jPanel3.add(txtnikpen, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 90, -1));
        jPanel3.add(txtno, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 170, -1));
        jPanel3.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 170, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Transaksi", "Username Admin", "NIK Pembeli", "Nik Penjual", "No Ajb", "Luas Tanah", "NJOP", "Tgl Transaksi", "Harga", "Harga Notaris", "Total"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 700, 188));

        bcaripen.setText("Cari");
        bcaripen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaripenActionPerformed(evt);
            }
        });
        jPanel3.add(bcaripen, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 70, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("NIK PEMBELI");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, 25));
        jPanel3.add(txtnikpem, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 90, -1));

        jButton5.setText("Hitung");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, 70, -1));
        jPanel3.add(txtnampem, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 168, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("NAMA PEMBELI");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, -1));
        jPanel3.add(txthn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 90, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("HARGA NOTARIS");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, -1, 25));

        bcaripem.setText("Cari");
        bcaripem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaripemActionPerformed(evt);
            }
        });
        jPanel3.add(bcaripem, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 70, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("TANGGAL TRANSAKSI");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, 25));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("HARGA TOTAL");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, -1, 25));
        jPanel3.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 170, -1));

        jtgl.setModel(new javax.swing.SpinnerDateModel());
        jPanel3.add(jtgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 170, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("NIK PENJUAL");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, -1, 25));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("USERNAME ADMIN");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, 25));

        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcariKeyTyped(evt);
            }
        });
        jPanel3.add(txtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 140, -1));

        bcari.setText("Cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });
        jPanel3.add(bcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 110, -1));

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 770, 670);

        jMenu3.setText("Menu");
        jMenuBar1.add(jMenu3);

        jMenu1.setText("Form Master");

        jMenuItem1.setText("Form Admin");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Form Penjual");
        jMenu1.add(jMenuItem2);

        jMenuItem5.setText("Form Pembeli");
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Form Transaksi");

        jMenuItem3.setText("Form Transaksi");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "Hapus","Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if(ok==0){
            String sql ="DELETE FROM transaksi WHERE idtransaksi='"+txtid.getText()+"'";
            try{
                java.sql.PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                txtno.requestFocus();
                datatable();
                kosong();
                autonumber();
            }catch(SQLException f){
                  JOptionPane.showMessageDialog(null, "Data gagal dihapus"+f);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bcaripemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaripemActionPerformed
        popuppembeli ini = new popuppembeli();
        ini.ft = this;
        ini.setVisible(true);
        ini.setResizable(false);
    }//GEN-LAST:event_bcaripemActionPerformed

    private void bcaripenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaripenActionPerformed
        popuppenjual itu = new popuppenjual();
        itu.fy = this;
        itu.setVisible(true);
        itu.setResizable(false);
    }//GEN-LAST:event_bcaripenActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        SimpleDateFormat Date = new SimpleDateFormat("yyyy/MM/dd");
        String FormDate = Date.format(jtgl.getValue());
        String sql = "insert into transaksi values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement State = conn.prepareStatement(sql);
            State.setString(1, txtid.getText());
            State.setString(2, lusername.getText());
            State.setString(3, txtnikpem.getText());
            State.setString(4, txtnikpen.getText());
            State.setString(5, txtno.getText());
            State.setString(6, txtluas.getText());
            State.setString(7, txtnjop.getText());
            State.setString(8, FormDate);
            State.setString(9, txtht.getText());
            State.setString(10, txthn.getText());
            State.setString(11, txttotal.getText());
            State.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            print();
            datatable();
            kosong();
            txtno.requestFocus();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal Disimpan " + e);
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        hitung();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtcariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyTyped
        datatable();
    }//GEN-LAST:event_txtcariKeyTyped

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        datatable();
    }//GEN-LAST:event_bcariActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        SimpleDateFormat Date = new SimpleDateFormat("yyyy/MM/dd");
        String FormDate = Date.format(jtgl.getValue());
        String sql = "update transaksi set nik_pembeli=?, nik_penjual=?, noajb=?, luas_tanah=?, njop=?, tgltransaksi=?, harga_transaksi=?, harga_notaris=?, harga_total=? where idtransaksi='"+txtid.getText()+"'";
        try {
            PreparedStatement State = conn.prepareStatement(sql);
            State.setString(1, txtnikpem.getText());
            State.setString(2, txtnikpen.getText());
            State.setString(3, txtno.getText());
            State.setString(4, txtluas.getText());
            State.setString(5, txtnjop.getText());
            State.setString(6, FormDate);
            State.setString(7, txtht.getText());
            State.setString(8, txthn.getText());
            State.setString(9, txttotal.getText());
            State.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            datatable();
            kosong();
            txtno.requestFocus();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal Diubah " + e);
        }
    }//GEN-LAST:event_beditActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int bar = table.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        Date h = java.sql.Date.valueOf(tabmode.getValueAt(bar, 7).toString());
        String i = tabmode.getValueAt(bar, 8).toString();
        String j = tabmode.getValueAt(bar, 9).toString();
        String k = tabmode.getValueAt(bar, 10).toString();
        txtid.setText(a);
        lusername.setText(b);
        txtnikpem.setText(c);
        txtnikpen.setText(d);
        txtno.setText(e);
        txtluas.setText(f);
        txtnjop.setText(g);
        jtgl.setValue(h);
        txtht.setText(i);
        txthn.setText(j);
        txttotal.setText(k);
    }//GEN-LAST:event_tableMouseClicked

    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formtransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formtransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formtransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formtransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formtransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari;
    private javax.swing.JButton bcaripem;
    private javax.swing.JButton bcaripen;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jtgl;
    private javax.swing.JLabel lusername;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txthn;
    private javax.swing.JTextField txtht;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtluas;
    private javax.swing.JTextField txtnampem;
    private javax.swing.JTextField txtnampen;
    private javax.swing.JTextField txtnikpem;
    private javax.swing.JTextField txtnikpen;
    private javax.swing.JTextField txtnjop;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
