/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package teammanagementapp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import teammanagementapp.DbConfigurations.DatabaseConfig;


/**
 *
 * @author pinartalas
 */
public class Home extends javax.swing.JFrame {
       private int userId; // Kullanıcı ID'sini saklamak için bir değişken
    private int teamId = -1; // Kullanıcının takım ID'sini saklamak için bir değişken, başlangıçta -1 (takım yok anlamında)


    /**
     * Creates new form Home
     */
    public Home(int userId) {
                this.userId = userId; // Kullanıcı ID'sini constructor'dan al

        initComponents();
                checkUserTeam(); // Takım kontrolü yap

    }
    public Home(){
        initComponents();
    }
        private void checkUserTeam(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASS);
            Statement st = con.createStatement();
            
            // Kullanıcının takımını kontrol eden sorgu
            String query = "SELECT * FROM team WHERE user_id = " + userId;
            ResultSet rs = st.executeQuery(query);
            
             if (rs.next()) {
                // Eğer kullanıcıya ait takım varsa, takım bilgilerini göster
                //String teamName = rs.getString("team_name");
                //jLabel1.setText("Your Team: " + teamName); // Takım adı etiketine yazılır 
                  // Eğer kullanıcıya ait takım varsa, takım ID'sini sakla
                teamId = rs.getInt("id"); // Takım ID'sini al ve sakla
                addTeamPanel.setVisible(false)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ; // Takım ekleme formunu gizle

            } else {
                // Eğer takım yoksa, yeni takım ekleme formunu göster
                //jLabel1.setText("You don't have a team. Please create a team.");
                // Burada TextField ve butonları göstererek takım ekleme işlemi yapabilirsin
                addTeamPanel.setVisible(true); // Takım ekleme formunu göster
            }
             rs.close();
            st.close();
            con.close();


        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
     // Takım ID'sini başka yerlerde kullanmak için getter metodu
    public int getTeamId() {
        return teamId;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addTeamPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        addTeamBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        addNewPlayerPageBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Players = new javax.swing.JButton();
        Players1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 400));

        addTeamPanel.setBackground(new java.awt.Color(255, 255, 255));
        addTeamPanel.setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manage Team");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(302, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setText("Add New Team");

        jLabel4.setText(" Name");

        addTeamBtn.setBackground(new java.awt.Color(255, 255, 0));
        addTeamBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        addTeamBtn.setForeground(new java.awt.Color(102, 102, 102));
        addTeamBtn.setText("Add");
        addTeamBtn.setBorderPainted(false);
        addTeamBtn.setFocusPainted(false);
        addTeamBtn.setOpaque(true);
        addTeamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeamBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addTeamPanelLayout = new javax.swing.GroupLayout(addTeamPanel);
        addTeamPanel.setLayout(addTeamPanelLayout);
        addTeamPanelLayout.setHorizontalGroup(
            addTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
            .addGroup(addTeamPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(addTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(addTeamPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(addTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addTeamBtn)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addTeamPanelLayout.setVerticalGroup(
            addTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTeamPanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(addTeamBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 500));
        jPanel2.setLayout(null);

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Manage Team");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(38, 601, 116, 23);

        addNewPlayerPageBtn.setBackground(new java.awt.Color(0, 0, 0));
        addNewPlayerPageBtn.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        addNewPlayerPageBtn.setForeground(new java.awt.Color(51, 0, 51));
        addNewPlayerPageBtn.setText("Add New Player");
        addNewPlayerPageBtn.setBorder(null);
        addNewPlayerPageBtn.setContentAreaFilled(false);
        addNewPlayerPageBtn.setVerifyInputWhenFocusTarget(false);
        addNewPlayerPageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewPlayerPageBtnActionPerformed(evt);
            }
        });
        jPanel2.add(addNewPlayerPageBtn);
        addNewPlayerPageBtn.setBounds(38, 683, 132, 23);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/pinartalas/Downloads/orangeLogo.png")); // NOI18N
        jLabel2.setText(".");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(-90, 0, 470, 160);

        Players.setBackground(new java.awt.Color(255, 255, 0));
        Players.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        Players.setText("Add New Player");
        Players.setBorder(null);
        Players.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayersActionPerformed(evt);
            }
        });
        jPanel2.add(Players);
        Players.setBounds(20, 240, 190, 23);

        Players1.setBackground(new java.awt.Color(255, 255, 0));
        Players1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        Players1.setText("Players");
        Players1.setBorder(null);
        Players1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Players1ActionPerformed(evt);
            }
        });
        jPanel2.add(Players1);
        Players1.setBounds(-20, 200, 200, 23);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(addTeamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(addTeamPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNewPlayerPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewPlayerPageBtnActionPerformed
        // TODO add your handling code here:
        System.out.println("Add New Player Button clicked!!!");
        if(teamId != -1){
           
            NewPlayer newPlayerPage = new NewPlayer(teamId);
             newPlayerPage.setVisible(true);
        newPlayerPage.pack();
        newPlayerPage.setLocationRelativeTo(null);
        this.dispose();
        }else{
                   JOptionPane.showMessageDialog(this, "Lütfen takım oluşturun!", "Takım Yok", JOptionPane.WARNING_MESSAGE);
 
        }
    }//GEN-LAST:event_addNewPlayerPageBtnActionPerformed

    private void addTeamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeamBtnActionPerformed
        // TODO add your handling code here:
           System.out.println("Add Team Button Clicked!!");
         String teamName, query;
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASS);
             Statement st = con.createStatement();
             if("".equals(name.getText())){
                 JOptionPane.showMessageDialog(new JFrame(), "Name is required", "Error", JOptionPane.ERROR_MESSAGE);

             }else{
                 teamName = name.getText();
                 query = "INSERT INTO team(user_id, team_name)" + 
                        "VALUES('"+userId+"', '" +teamName+"' )";
                 st.execute(query);
                 String teamIdQuery =  "SELECT id FROM team WHERE team_name= '"+teamName+"'";
                 ResultSet rs = st.executeQuery(teamIdQuery);
                 
                          if (rs.next()) {
                 teamId = rs.getInt("id");
                System.out.println("Inserted team ID: " + teamId);
            } else {
                System.out.println("No team found with the given name.");
            }

            name.setText("");
            JOptionPane.showMessageDialog(null, "Team has been created successfully!");
     

             }
         }catch(Exception e){
            System.out.println("Error!" + e.getMessage());
         }
    }//GEN-LAST:event_addTeamBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Players1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Players1ActionPerformed
        // TODO add your handling code here:
             System.out.println("Players Button clicked!!!");
                if(teamId != -1){
           
            Player PlayerPage = new Player(teamId);
             PlayerPage.setVisible(true);
        PlayerPage.pack();
        PlayerPage.setLocationRelativeTo(null);
        this.dispose();
        }else{
                   JOptionPane.showMessageDialog(this, "Lütfen takım oluşturun!", "Takım Yok", JOptionPane.WARNING_MESSAGE);
 
        }
    }//GEN-LAST:event_Players1ActionPerformed

    private void PlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayersActionPerformed
        // TODO add your handling code here:
         System.out.println("Add New Player Button clicked!!!");
        if(teamId != -1){
           
            NewPlayer newPlayerPage = new NewPlayer(teamId);
             newPlayerPage.setVisible(true);
        newPlayerPage.pack();
        newPlayerPage.setLocationRelativeTo(null);
        this.dispose();
        }else{
                   JOptionPane.showMessageDialog(this, "Lütfen takım oluşturun!", "Takım Yok", JOptionPane.WARNING_MESSAGE);
 
        }
    }//GEN-LAST:event_PlayersActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Players;
    private javax.swing.JButton Players1;
    private javax.swing.JButton addNewPlayerPageBtn;
    private javax.swing.JButton addTeamBtn;
    private javax.swing.JPanel addTeamPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
}
