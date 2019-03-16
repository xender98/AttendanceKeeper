/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject.Details;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import miniproject.Utils.pieChart;
import miniproject.gui.CSFrame;
import miniproject.gui.MainPage;
import student_database.Student_database;

/**
 *
 * @author jaydutt
 */
public class AccountDetails extends javax.swing.JFrame {

    /**
     * Creates new form AccountDetails
     */
    public static boolean csFrame=false;
    
    String name;
    String email;
    int roll;
    
    ArrayList<String> data=null;
    
    public AccountDetails(int Roll_no){
        initComponents();
        roll=Roll_no;
        
        Student_database db=new Student_database();
        try {
            String []user=db.get_user(roll);
            name=user[0];
            email=user[1];
        } catch (Exception ex) {
            Logger.getLogger(AccountDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            data=db.cnt_present(roll);
        } catch (Exception ex) {
            Logger.getLogger(AccountDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultTableModel model=(DefaultTableModel) attandanceTable.getModel();

        int present=data.size(),absent=0;
        ArrayList<String> temp=null;
        for(int i=0;i<data.size()-1;i++)
        {
            
            try {
                temp=db.get_date(data.get(i),data.get(i+1));
            } catch (Exception ex) {
                Logger.getLogger(AccountDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            model.addRow(new Object[]{data.get(i),"present"}); ///need to handle absent as well
            
            absent+=temp.size();
            
            for(int j=0;j<temp.size();j++)
                model.addRow(new Object[]{temp.get(j),"absent"});
            
        }
        if(data.size()>0)
            model.addRow(new Object[]{data.get(data.size()-1),"present"});
        
        new pieChart(chart,present,absent);///show pie chart
        
        namelabel.setText(name);
        nametext.setText(name);
        rollnolabel.setText(String.valueOf(roll));
        emaillabel.setText(email);
        emailtext.setText(email);
        
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
        MenuPanel = new javax.swing.JPanel();
        MenuRootLabel = new javax.swing.JLabel();
        AttandancePanelButton = new javax.swing.JButton();
        AccountPanelButton = new javax.swing.JButton();
        LogOutButton = new javax.swing.JButton();
        PasswordPanelButton = new javax.swing.JButton();
        DetailsPanel = new javax.swing.JPanel();
        AttandancePanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        namelabel = new javax.swing.JLabel();
        rollnolabel = new javax.swing.JLabel();
        emaillabel = new javax.swing.JLabel();
        chart = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attandanceTable = new javax.swing.JTable();
        ChangePassword = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        oldpass = new javax.swing.JPasswordField();
        newpass1 = new javax.swing.JPasswordField();
        newpass2 = new javax.swing.JPasswordField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jButton8 = new javax.swing.JButton();
        AccountPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nametext = new javax.swing.JTextField();
        emailtext = new javax.swing.JTextField();
        faceidDisp = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        changedetails = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        MenuPanel.setBackground(new java.awt.Color(36, 47, 65));
        MenuPanel.setPreferredSize(new java.awt.Dimension(250, 783));

        MenuRootLabel.setFont(new java.awt.Font("Kristen ITC", 1, 36)); // NOI18N
        MenuRootLabel.setForeground(new java.awt.Color(255, 255, 255));
        MenuRootLabel.setText("MENU");

        AttandancePanelButton.setBackground(new java.awt.Color(36, 47, 65));
        AttandancePanelButton.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        AttandancePanelButton.setForeground(new java.awt.Color(255, 255, 255));
        AttandancePanelButton.setText("Attandance");
        AttandancePanelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AttandancePanelButtonMouseClicked(evt);
            }
        });
        AttandancePanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttandancePanelButtonActionPerformed(evt);
            }
        });

        AccountPanelButton.setBackground(new java.awt.Color(36, 47, 65));
        AccountPanelButton.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        AccountPanelButton.setForeground(new java.awt.Color(255, 255, 255));
        AccountPanelButton.setText("Account");
        AccountPanelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AccountPanelButtonMouseClicked(evt);
            }
        });

        LogOutButton.setBackground(new java.awt.Color(36, 47, 65));
        LogOutButton.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        LogOutButton.setForeground(new java.awt.Color(255, 255, 255));
        LogOutButton.setText("Log Out");
        LogOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutButtonMouseClicked(evt);
            }
        });

        PasswordPanelButton.setBackground(new java.awt.Color(36, 47, 65));
        PasswordPanelButton.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        PasswordPanelButton.setForeground(new java.awt.Color(255, 255, 255));
        PasswordPanelButton.setText("Change Pass.");
        PasswordPanelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PasswordPanelButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PasswordPanelButton)
                    .addComponent(LogOutButton)
                    .addComponent(AccountPanelButton)
                    .addComponent(AttandancePanelButton)
                    .addComponent(MenuRootLabel))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(MenuRootLabel)
                .addGap(102, 102, 102)
                .addComponent(AttandancePanelButton)
                .addGap(89, 89, 89)
                .addComponent(AccountPanelButton)
                .addGap(105, 105, 105)
                .addComponent(PasswordPanelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(LogOutButton)
                .addGap(127, 127, 127))
        );

        jPanel1.add(MenuPanel, java.awt.BorderLayout.LINE_START);

        DetailsPanel.setBackground(new java.awt.Color(97, 212, 195));
        DetailsPanel.setLayout(new java.awt.CardLayout());

        AttandancePanel.setBackground(new java.awt.Color(97, 212, 195));

        jLabel10.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        jLabel10.setText("Name :");

        jLabel11.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        jLabel11.setText("Rollno :");

        jLabel12.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        jLabel12.setText("Email Id :");

        namelabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        namelabel.setText("place holder");

        rollnolabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rollnolabel.setText("place holder");

        emaillabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        emaillabel.setText("place holder");

        chart.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout chartLayout = new javax.swing.GroupLayout(chart);
        chart.setLayout(chartLayout);
        chartLayout.setHorizontalGroup(
            chartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        chartLayout.setVerticalGroup(
            chartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );

        attandanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "P/A"
            }
        ));
        attandanceTable.setEnabled(false);
        jScrollPane1.setViewportView(attandanceTable);

        javax.swing.GroupLayout AttandancePanelLayout = new javax.swing.GroupLayout(AttandancePanel);
        AttandancePanel.setLayout(AttandancePanelLayout);
        AttandancePanelLayout.setHorizontalGroup(
            AttandancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttandancePanelLayout.createSequentialGroup()
                .addGroup(AttandancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AttandancePanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(AttandancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AttandancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AttandancePanelLayout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(73, 73, 73))
                                .addGroup(AttandancePanelLayout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(64, 64, 64)))
                            .addGroup(AttandancePanelLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(41, 41, 41)))
                        .addGroup(AttandancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rollnolabel)
                            .addComponent(namelabel)
                            .addComponent(emaillabel)))
                    .addGroup(AttandancePanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        AttandancePanelLayout.setVerticalGroup(
            AttandancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttandancePanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(AttandancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AttandancePanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(AttandancePanelLayout.createSequentialGroup()
                        .addGroup(AttandancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(namelabel))
                        .addGap(18, 18, 18)
                        .addGroup(AttandancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(rollnolabel))
                        .addGap(25, 25, 25)
                        .addGroup(AttandancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(emaillabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );

        DetailsPanel.add(AttandancePanel, "card3");

        ChangePassword.setBackground(new java.awt.Color(97, 212, 195));

        jLabel7.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        jLabel7.setText("Old Password:");

        jLabel8.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        jLabel8.setText("New Password:");

        jLabel9.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        jLabel9.setText("Confirm Password:");

        oldpass.setBackground(new java.awt.Color(97, 212, 195));
        oldpass.setText("jPasswordField1");
        oldpass.setBorder(null);

        newpass1.setBackground(new java.awt.Color(97, 212, 195));
        newpass1.setText("jPasswordField1");
        newpass1.setBorder(null);

        newpass2.setBackground(new java.awt.Color(97, 212, 195));
        newpass2.setText("jPasswordField1");
        newpass2.setBorder(null);

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));

        jButton8.setBackground(new java.awt.Color(36, 47, 65));
        jButton8.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Change");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ChangePasswordLayout = new javax.swing.GroupLayout(ChangePassword);
        ChangePassword.setLayout(ChangePasswordLayout);
        ChangePasswordLayout.setHorizontalGroup(
            ChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChangePasswordLayout.createSequentialGroup()
                .addGroup(ChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(ChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ChangePasswordLayout.createSequentialGroup()
                                .addGap(546, 546, 546)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ChangePasswordLayout.createSequentialGroup()
                                .addGap(252, 252, 252)
                                .addGroup(ChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(52, 52, 52)
                                .addGroup(ChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(oldpass, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newpass1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newpass2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(ChangePasswordLayout.createSequentialGroup()
                        .addGap(443, 443, 443)
                        .addComponent(jButton8)))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        ChangePasswordLayout.setVerticalGroup(
            ChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChangePasswordLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(ChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(oldpass, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(ChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(newpass1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(ChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(newpass2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jButton8)
                .addContainerGap(289, Short.MAX_VALUE))
        );

        DetailsPanel.add(ChangePassword, "card4");

        AccountPanel.setBackground(new java.awt.Color(97, 212, 195));
        AccountPanel.setPreferredSize(new java.awt.Dimension(1087, 792));

        jLabel2.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        jLabel2.setText("Name :");

        jLabel4.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        jLabel4.setText("EmailId:");

        nametext.setBackground(new java.awt.Color(97, 212, 195));
        nametext.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nametext.setText("jTextField1");
        nametext.setBorder(null);

        emailtext.setBackground(new java.awt.Color(97, 212, 195));
        emailtext.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        emailtext.setText("jTextField3");
        emailtext.setBorder(null);
        emailtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtextActionPerformed(evt);
            }
        });

        faceidDisp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        faceidDisp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miniproject/Details/ic_person_outline_white_48dp.png"))); // NOI18N
        faceidDisp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton4.setBackground(new java.awt.Color(36, 47, 65));
        jButton4.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Change");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        changedetails.setBackground(new java.awt.Color(36, 47, 65));
        changedetails.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        changedetails.setForeground(new java.awt.Color(255, 255, 255));
        changedetails.setText("Submit");
        changedetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changedetailsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout AccountPanelLayout = new javax.swing.GroupLayout(AccountPanel);
        AccountPanel.setLayout(AccountPanelLayout);
        AccountPanelLayout.setHorizontalGroup(
            AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccountPanelLayout.createSequentialGroup()
                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AccountPanelLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(faceidDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AccountPanelLayout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jButton4)))
                .addGap(0, 670, Short.MAX_VALUE))
            .addGroup(AccountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AccountPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(emailtext, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AccountPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(113, 113, 113)
                        .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changedetails, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nametext, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                                .addComponent(jSeparator1)
                                .addComponent(jSeparator3)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AccountPanelLayout.setVerticalGroup(
            AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccountPanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nametext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emailtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(changedetails, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146)
                .addComponent(faceidDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        DetailsPanel.add(AccountPanel, "card4");

        jPanel1.add(DetailsPanel, java.awt.BorderLayout.CENTER);

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

    private void AttandancePanelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AttandancePanelButtonMouseClicked
        DetailsPanel.removeAll();
        DetailsPanel.add(AttandancePanel);
        DetailsPanel.repaint();
        DetailsPanel.revalidate();
    }//GEN-LAST:event_AttandancePanelButtonMouseClicked

    private void AccountPanelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountPanelButtonMouseClicked
        DetailsPanel.removeAll();
        DetailsPanel.add(AccountPanel);
        DetailsPanel.repaint();
        DetailsPanel.revalidate();
    }//GEN-LAST:event_AccountPanelButtonMouseClicked

    private void PasswordPanelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordPanelButtonMouseClicked
        DetailsPanel.removeAll();
        DetailsPanel.add(ChangePassword);
        DetailsPanel.repaint();
        DetailsPanel.revalidate();
    }//GEN-LAST:event_PasswordPanelButtonMouseClicked

    private void LogOutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseClicked
        MainPage page=new MainPage();
        page.setVisible(true);
        this.dispose(); ///stop this frame and open previous main menu frame
    }//GEN-LAST:event_LogOutButtonMouseClicked

    private void AttandancePanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttandancePanelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AttandancePanelButtonActionPerformed

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        String old=oldpass.getText();
        String new1=newpass1.getText();
        String new2=newpass2.getText();
        if(new1.equals(new2))
        {
            try {
                Student_database db=new Student_database();
                db.update_password(roll,name,old,new1);
                db.stmt.close();
                db.c.commit();
                db.c.close();
            } catch (Exception ex) {
                Logger.getLogger(AccountDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            ///print in note not possible
        }
    }//GEN-LAST:event_jButton8MouseClicked

    private void changedetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changedetailsMouseClicked
        name=nametext.getText();
        email=emailtext.getText();

        namelabel.setText(name);
        emaillabel.setText(email);
        rollnolabel.setText(String.valueOf(roll));
        
        try {
                Student_database db=new Student_database();
                db.update_profile(roll, name, email);
                db.stmt.close();
                db.c.commit();
                db.c.close();
            } catch (Exception ex) {
                Logger.getLogger(AccountDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_changedetailsMouseClicked

    private void emailtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtextActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // change image of the user
        if(csFrame==false)
        { 
            CSFrame.start(roll+"",faceidDisp,2);
            csFrame=true;
        }
        
    }//GEN-LAST:event_jButton4MouseClicked

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
            java.util.logging.Logger.getLogger(AccountDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountDetails(8).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AccountPanel;
    private javax.swing.JButton AccountPanelButton;
    private javax.swing.JPanel AttandancePanel;
    private javax.swing.JButton AttandancePanelButton;
    private javax.swing.JPanel ChangePassword;
    private javax.swing.JPanel DetailsPanel;
    private javax.swing.JButton LogOutButton;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JLabel MenuRootLabel;
    private javax.swing.JButton PasswordPanelButton;
    private javax.swing.JTable attandanceTable;
    private javax.swing.JButton changedetails;
    private javax.swing.JPanel chart;
    private javax.swing.JLabel emaillabel;
    private javax.swing.JTextField emailtext;
    private javax.swing.JLabel faceidDisp;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel namelabel;
    private javax.swing.JTextField nametext;
    private javax.swing.JPasswordField newpass1;
    private javax.swing.JPasswordField newpass2;
    private javax.swing.JPasswordField oldpass;
    private javax.swing.JLabel rollnolabel;
    // End of variables declaration//GEN-END:variables
}