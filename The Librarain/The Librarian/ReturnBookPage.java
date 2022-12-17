
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ReturnBookPage extends javax.swing.JFrame {

    public ReturnBookPage() {
        initComponents();
        FillComboBox();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }

    private void FillComboBox() {

        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM `issued_book` WHERE status='pending'";

        try {
            st = DBConnection.getConnection().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                jCB_BookID.addItem(rs.getString("book_id"));
                jCB_MemID.addItem(rs.getString("mem_id"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public boolean checkReturnBook() {

        PreparedStatement ps;
        boolean checkReturnBook = false;
        String query = "UPDATE `issued_book` SET status=? WHERE `book_id`=? AND `mem_id`=? AND status=?";

        String Bookid = jCB_BookID.getSelectedItem().toString();
        String Memid = jCB_MemID.getSelectedItem().toString();

        try {
            ps = DBConnection.getConnection().prepareStatement(query);

            ps.setString(1, "returned");
            ps.setString(2, Bookid);
            ps.setString(3, Memid);
            ps.setString(4, "pending");

            checkReturnBook = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return checkReturnBook;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        panelContant = new javax.swing.JPanel();
        BookID = new javax.swing.JLabel();
        jCB_BookID = new javax.swing.JComboBox<>();
        MemID = new javax.swing.JLabel();
        jCB_MemID = new javax.swing.JComboBox<>();
        IssDate = new javax.swing.JLabel();
        jDC_IssDate = new com.toedter.calendar.JDateChooser();
        ReDate = new javax.swing.JLabel();
        jDC_ReDate = new com.toedter.calendar.JDateChooser();
        btn_IssBook = new javax.swing.JButton();
        panelHeader = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        H_IssueBook = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(420, 450));

        panelContant.setBackground(new java.awt.Color(22, 28, 49));
        panelContant.setPreferredSize(new java.awt.Dimension(414, 600));

        BookID.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        BookID.setForeground(new java.awt.Color(255, 255, 255));
        BookID.setText("Enter Book ID");

        jCB_BookID.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        jCB_BookID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose a Book ID" }));
        jCB_BookID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        MemID.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        MemID.setForeground(new java.awt.Color(255, 255, 255));
        MemID.setText("Enter Member ID");

        jCB_MemID.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        jCB_MemID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select members" }));
        jCB_MemID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        IssDate.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        IssDate.setForeground(new java.awt.Color(255, 255, 255));
        IssDate.setText("Issue Date");

        jDC_IssDate.setDateFormatString("yyyy-MM-dd");
        jDC_IssDate.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        jDC_IssDate.setMaxSelectableDate(null);
        jDC_IssDate.setMinSelectableDate(null);

        ReDate.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        ReDate.setForeground(new java.awt.Color(255, 255, 255));
        ReDate.setText("Return Date");

        jDC_ReDate.setDateFormatString("yyyy-MM-dd");
        jDC_ReDate.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        jDC_ReDate.setMaxSelectableDate(null);
        jDC_ReDate.setMinSelectableDate(null);

        btn_IssBook.setBackground(new java.awt.Color(0, 153, 255));
        btn_IssBook.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        btn_IssBook.setForeground(new java.awt.Color(255, 255, 255));
        btn_IssBook.setText("RETURN");
        btn_IssBook.setBorderPainted(false);
        btn_IssBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_IssBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_IssBookMouseClicked(evt);
            }
        });
        btn_IssBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IssBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContantLayout = new javax.swing.GroupLayout(panelContant);
        panelContant.setLayout(panelContantLayout);
        panelContantLayout.setHorizontalGroup(
            panelContantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContantLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelContantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ReDate, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BookID, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MemID, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IssDate, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDC_ReDate, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jDC_IssDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_IssBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCB_BookID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCB_MemID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelContantLayout.setVerticalGroup(
            panelContantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContantLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(BookID)
                .addGap(4, 4, 4)
                .addComponent(jCB_BookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MemID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCB_MemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IssDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDC_IssDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(ReDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDC_ReDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btn_IssBook, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        panelHeader.setBackground(new java.awt.Color(17, 21, 38));
        panelHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelHeaderMouseDragged(evt);
            }
        });
        panelHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelHeaderMousePressed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(15, 19, 35));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close-30.png"))); // NOI18N
        btnExit.setBorder(null);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        H_IssueBook.setFont(new java.awt.Font("Prompt Semibold", 0, 24)); // NOI18N
        H_IssueBook.setForeground(new java.awt.Color(255, 255, 255));
        H_IssueBook.setText("Return Book");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(H_IssueBook)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(23, 23, 23))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(H_IssueBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelContant, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContant, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_IssBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IssBookActionPerformed

        if (checkReturnBook() == true) {
            System.out.println("Successfully");
            JOptionPane.showMessageDialog(null, "Return Book Successfully");
            jCB_BookID.setSelectedIndex(0);
            jCB_MemID.setSelectedIndex(0);
            jDC_IssDate.setDate(null);
            jDC_ReDate.setDate(null);
        } else {
            System.out.println("Failed");
            JOptionPane.showMessageDialog(null, "Return Book Failed!!!");
        }

//        if (isAlreadyIssued() == false) {
//            if (checkReturnBook() == true) {
//                System.out.println("Successfully");
//                JOptionPane.showMessageDialog(null, "Issue Book Successfully");
//                jCB_BookID.setSelectedIndex(0);
//                jCB_MemID.setSelectedIndex(0);
//                jDC_IssDate.setDate(null);
//                jDC_ReDate.setDate(null);
//            } else {
//                System.out.println("failed");
//                JOptionPane.showMessageDialog(null, "Issue Book Failed!!!");
//            }
//        } else {
//            System.out.println("The book has been issued.");
//            JOptionPane.showMessageDialog(null, "The book has been issued.");
//            jCB_BookID.setSelectedIndex(0);
//        }

    }//GEN-LAST:event_btn_IssBookActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.out.println("Closed!");
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private int xMouse, yMouse;

    private void panelHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelHeaderMousePressed

    private void panelHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_panelHeaderMouseDragged

    private void btn_IssBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_IssBookMouseClicked
        checkReturnBook();
    }//GEN-LAST:event_btn_IssBookMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBookPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookID;
    private javax.swing.JLabel H_IssueBook;
    private javax.swing.JLabel IssDate;
    private javax.swing.JLabel MemID;
    private javax.swing.JLabel ReDate;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btn_IssBook;
    private javax.swing.JComboBox<String> jCB_BookID;
    private javax.swing.JComboBox<String> jCB_MemID;
    private com.toedter.calendar.JDateChooser jDC_IssDate;
    private com.toedter.calendar.JDateChooser jDC_ReDate;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelContant;
    private javax.swing.JPanel panelHeader;
    // End of variables declaration//GEN-END:variables
}
