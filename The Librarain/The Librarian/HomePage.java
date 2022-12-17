
import java.awt.*;
import java.sql.*;
import java.text.*;
import java.time.LocalDate;
import java.time.format.*;
import java.util.*;
import java.util.Date;
import javax.swing.table.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class HomePage extends javax.swing.JFrame implements Runnable {

    Statement st;
    ResultSet rs;
    PreparedStatement ps;

    Color mouseEnterColor = new Color(196, 92, 186, 80);
    Color mouseExitColor = new Color(22, 28, 49);

    public HomePage() {
        initComponents();
        setBackground(new Color(17, 21, 37, 1));
        setDataToCards();
        Fetch();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        Thread t = new Thread(this);
        t.start();
    }

    private void setDataToCards() {

        try {
            st = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("SELECT * FROM `books`");
            rs.last();
            NumBook.setText(Integer.toString(rs.getRow()));

            rs = st.executeQuery("SELECT * FROM `member`");
            rs.last();
            NumMem.setText(Integer.toString(rs.getRow()));

            rs = st.executeQuery("SELECT * FROM `issued_book` WHERE status='pending'");
            rs.last();
            NumIssBook.setText(Integer.toString(rs.getRow()));

            DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.now();
            lb_Date.setText(date.format(localDate));

            // Set Data in Bar Chart
//            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//            dataset.setValue(6, "Amount", "No. of Books");
//            dataset.setValue(4, "Amount", "Total no. of Books");
//            dataset.setValue(3, "Amount", "No. of Members");
//
//            JFreeChart chart = ChartFactory.createBarChart("contribution", "monthly", "amount", dataset, PlotOrientation.VERTICAL, false, true, false);
//            
//            CategoryPlot categoryPlot = chart.getCategoryPlot();
//            categoryPlot.setBackgroundPaint(Color.WHITE);
//            BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
//            Color c1 = new Color(204, 0, 51);
//            renderer.setSeriesPaint(0, c1);
//
//            ChartPanel chartPanel = new ChartPanel(chart);
//            panelGraph.removeAll();
//            panelGraph.add(chartPanel, BorderLayout.CENTER);
//            panelGraph.validate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void Fetch() {

        try {
            int q;
            ps = DBConnection.getConnection().prepareStatement("SELECT * FROM `issued_book`");
            rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            q = rsm.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) TableIssueBook.getModel();
            df.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= q; a++) {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("book_id"));
                    v2.add(rs.getString("mem_name"));
                    v2.add(rs.getString("issue_date"));
                    v2.add(rs.getString("return_date"));
                    v2.add(rs.getString("status"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder = new PanelBorder();
        panelMenu = new PanelMenu();
        panelMoving = new javax.swing.JPanel();
        Header = new javax.swing.JLabel();
        line1 = new javax.swing.JPanel();
        jP_HomePage = new javax.swing.JPanel();
        HomePage = new javax.swing.JLabel();
        line2 = new javax.swing.JPanel();
        jPH_Mem = new javax.swing.JPanel();
        hMember = new javax.swing.JLabel();
        jP_AddMem = new javax.swing.JPanel();
        AddMem = new javax.swing.JLabel();
        jP_DelMem = new javax.swing.JPanel();
        DelMem = new javax.swing.JLabel();
        jP_MemList = new javax.swing.JPanel();
        MemList = new javax.swing.JLabel();
        line3 = new javax.swing.JPanel();
        jPH_Book = new javax.swing.JPanel();
        hBook = new javax.swing.JLabel();
        jP_AddBook = new javax.swing.JPanel();
        AddBook = new javax.swing.JLabel();
        jP_DelBook = new javax.swing.JPanel();
        DelBook = new javax.swing.JLabel();
        jP_BookList = new javax.swing.JPanel();
        BookList = new javax.swing.JLabel();
        jP_IssueBook = new javax.swing.JPanel();
        IssueBook = new javax.swing.JLabel();
        jP_ReturnBook = new javax.swing.JPanel();
        ReturnBook = new javax.swing.JLabel();
        line4 = new javax.swing.JPanel();
        jP_Logout = new javax.swing.JPanel();
        Logout = new javax.swing.JLabel();
        line5 = new javax.swing.JPanel();
        MainPanel = new javax.swing.JPanel();
        PanelGrid1 = new javax.swing.JPanel();
        CardNumBook = new PanelCard();
        Label_NB = new javax.swing.JLabel();
        NumBook = new javax.swing.JLabel();
        CardIssuedBook = new PanelCard();
        Label_NB4 = new javax.swing.JLabel();
        NumIssBook = new javax.swing.JLabel();
        PanelGrid2 = new javax.swing.JPanel();
        CardNumMem = new PanelCard();
        Label_NB5 = new javax.swing.JLabel();
        NumMem = new javax.swing.JLabel();
        CardBookCategory = new PanelCard();
        lb_Date = new javax.swing.JLabel();
        lb_Time = new javax.swing.JLabel();
        panelGraph = new PanelBorder();
        panelTable = new PanelBorder();
        HIssueDetail = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableIssueBook = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder.setForeground(new java.awt.Color(17, 21, 37));

        panelMenu.setForeground(new java.awt.Color(22, 28, 49));

        panelMoving.setOpaque(false);
        panelMoving.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelMovingMouseDragged(evt);
            }
        });
        panelMoving.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelMovingMousePressed(evt);
            }
        });

        Header.setFont(new java.awt.Font("Prompt ExtraBold", 0, 20)); // NOI18N
        Header.setForeground(new java.awt.Color(255, 255, 255));
        Header.setText("The Librarian");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(Header)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(Header))
        );

        line1.setBackground(new java.awt.Color(36, 41, 61));
        line1.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout line1Layout = new javax.swing.GroupLayout(line1);
        line1.setLayout(line1Layout);
        line1Layout.setHorizontalGroup(
            line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line1Layout.setVerticalGroup(
            line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jP_HomePage.setBackground(new java.awt.Color(178, 81, 169));

        HomePage.setFont(new java.awt.Font("Prompt Semibold", 0, 14)); // NOI18N
        HomePage.setForeground(new java.awt.Color(255, 255, 255));
        HomePage.setText("Home Page");
        HomePage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jP_HomePageLayout = new javax.swing.GroupLayout(jP_HomePage);
        jP_HomePage.setLayout(jP_HomePageLayout);
        jP_HomePageLayout.setHorizontalGroup(
            jP_HomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_HomePageLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(HomePage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_HomePageLayout.setVerticalGroup(
            jP_HomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomePage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        line2.setBackground(new java.awt.Color(36, 41, 61));
        line2.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout line2Layout = new javax.swing.GroupLayout(line2);
        line2.setLayout(line2Layout);
        line2Layout.setHorizontalGroup(
            line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line2Layout.setVerticalGroup(
            line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPH_Mem.setBackground(new java.awt.Color(22, 28, 49));

        hMember.setFont(new java.awt.Font("Prompt Medium", 0, 16)); // NOI18N
        hMember.setForeground(new java.awt.Color(196, 92, 186));
        hMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user-20.png"))); // NOI18N
        hMember.setText("MEMBERS");
        hMember.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPH_MemLayout = new javax.swing.GroupLayout(jPH_Mem);
        jPH_Mem.setLayout(jPH_MemLayout);
        jPH_MemLayout.setHorizontalGroup(
            jPH_MemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPH_MemLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(hMember)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPH_MemLayout.setVerticalGroup(
            jPH_MemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hMember, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jP_AddMem.setBackground(new java.awt.Color(22, 28, 49));

        AddMem.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        AddMem.setForeground(new java.awt.Color(255, 255, 255));
        AddMem.setText("Add Member");
        AddMem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddMem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddMemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddMemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddMemMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jP_AddMemLayout = new javax.swing.GroupLayout(jP_AddMem);
        jP_AddMem.setLayout(jP_AddMemLayout);
        jP_AddMemLayout.setHorizontalGroup(
            jP_AddMemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_AddMemLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(AddMem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_AddMemLayout.setVerticalGroup(
            jP_AddMemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddMem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        jP_DelMem.setBackground(new java.awt.Color(22, 28, 49));
        jP_DelMem.setPreferredSize(new java.awt.Dimension(118, 25));

        DelMem.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        DelMem.setForeground(new java.awt.Color(255, 255, 255));
        DelMem.setText("Delete Member");
        DelMem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelMem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DelMemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DelMemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DelMemMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jP_DelMemLayout = new javax.swing.GroupLayout(jP_DelMem);
        jP_DelMem.setLayout(jP_DelMemLayout);
        jP_DelMemLayout.setHorizontalGroup(
            jP_DelMemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_DelMemLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(DelMem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_DelMemLayout.setVerticalGroup(
            jP_DelMemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DelMem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        jP_MemList.setBackground(new java.awt.Color(22, 28, 49));
        jP_MemList.setPreferredSize(new java.awt.Dimension(118, 25));

        MemList.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        MemList.setForeground(new java.awt.Color(255, 255, 255));
        MemList.setText("Members List");
        MemList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MemList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MemListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MemListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MemListMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jP_MemListLayout = new javax.swing.GroupLayout(jP_MemList);
        jP_MemList.setLayout(jP_MemListLayout);
        jP_MemListLayout.setHorizontalGroup(
            jP_MemListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_MemListLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(MemList)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_MemListLayout.setVerticalGroup(
            jP_MemListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MemList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        line3.setBackground(new java.awt.Color(36, 41, 61));
        line3.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout line3Layout = new javax.swing.GroupLayout(line3);
        line3.setLayout(line3Layout);
        line3Layout.setHorizontalGroup(
            line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line3Layout.setVerticalGroup(
            line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPH_Book.setBackground(new java.awt.Color(22, 28, 49));

        hBook.setFont(new java.awt.Font("Prompt Medium", 0, 16)); // NOI18N
        hBook.setForeground(new java.awt.Color(196, 92, 186));
        hBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/book-20.png"))); // NOI18N
        hBook.setText("BOOKS");
        hBook.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPH_BookLayout = new javax.swing.GroupLayout(jPH_Book);
        jPH_Book.setLayout(jPH_BookLayout);
        jPH_BookLayout.setHorizontalGroup(
            jPH_BookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPH_BookLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(hBook)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPH_BookLayout.setVerticalGroup(
            jPH_BookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hBook, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jP_AddBook.setBackground(new java.awt.Color(22, 28, 49));

        AddBook.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        AddBook.setForeground(new java.awt.Color(255, 255, 255));
        AddBook.setText("Add Book");
        AddBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddBookMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jP_AddBookLayout = new javax.swing.GroupLayout(jP_AddBook);
        jP_AddBook.setLayout(jP_AddBookLayout);
        jP_AddBookLayout.setHorizontalGroup(
            jP_AddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_AddBookLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(AddBook)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_AddBookLayout.setVerticalGroup(
            jP_AddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        jP_DelBook.setBackground(new java.awt.Color(22, 28, 49));
        jP_DelBook.setPreferredSize(new java.awt.Dimension(118, 25));

        DelBook.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        DelBook.setForeground(new java.awt.Color(255, 255, 255));
        DelBook.setText("Delete Book");
        DelBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DelBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DelBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DelBookMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jP_DelBookLayout = new javax.swing.GroupLayout(jP_DelBook);
        jP_DelBook.setLayout(jP_DelBookLayout);
        jP_DelBookLayout.setHorizontalGroup(
            jP_DelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_DelBookLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(DelBook)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_DelBookLayout.setVerticalGroup(
            jP_DelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DelBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        jP_BookList.setBackground(new java.awt.Color(22, 28, 49));
        jP_BookList.setPreferredSize(new java.awt.Dimension(118, 25));

        BookList.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        BookList.setForeground(new java.awt.Color(255, 255, 255));
        BookList.setText("Books List");
        BookList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BookList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BookListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BookListMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jP_BookListLayout = new javax.swing.GroupLayout(jP_BookList);
        jP_BookList.setLayout(jP_BookListLayout);
        jP_BookListLayout.setHorizontalGroup(
            jP_BookListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_BookListLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(BookList)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_BookListLayout.setVerticalGroup(
            jP_BookListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BookList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        jP_IssueBook.setBackground(new java.awt.Color(22, 28, 49));
        jP_IssueBook.setPreferredSize(new java.awt.Dimension(118, 25));

        IssueBook.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        IssueBook.setForeground(new java.awt.Color(255, 255, 255));
        IssueBook.setText("Issue Book");
        IssueBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IssueBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IssueBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                IssueBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                IssueBookMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jP_IssueBookLayout = new javax.swing.GroupLayout(jP_IssueBook);
        jP_IssueBook.setLayout(jP_IssueBookLayout);
        jP_IssueBookLayout.setHorizontalGroup(
            jP_IssueBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_IssueBookLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(IssueBook)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_IssueBookLayout.setVerticalGroup(
            jP_IssueBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IssueBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        jP_ReturnBook.setBackground(new java.awt.Color(22, 28, 49));
        jP_ReturnBook.setPreferredSize(new java.awt.Dimension(118, 25));

        ReturnBook.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        ReturnBook.setForeground(new java.awt.Color(255, 255, 255));
        ReturnBook.setText("Return Book");
        ReturnBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ReturnBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReturnBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ReturnBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ReturnBookMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jP_ReturnBookLayout = new javax.swing.GroupLayout(jP_ReturnBook);
        jP_ReturnBook.setLayout(jP_ReturnBookLayout);
        jP_ReturnBookLayout.setHorizontalGroup(
            jP_ReturnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_ReturnBookLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(ReturnBook)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_ReturnBookLayout.setVerticalGroup(
            jP_ReturnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ReturnBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        line4.setBackground(new java.awt.Color(36, 41, 61));
        line4.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout line4Layout = new javax.swing.GroupLayout(line4);
        line4.setLayout(line4Layout);
        line4Layout.setHorizontalGroup(
            line4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line4Layout.setVerticalGroup(
            line4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jP_Logout.setBackground(new java.awt.Color(22, 28, 49));
        jP_Logout.setPreferredSize(new java.awt.Dimension(118, 25));

        Logout.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setText("Logout");
        Logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogoutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jP_LogoutLayout = new javax.swing.GroupLayout(jP_Logout);
        jP_Logout.setLayout(jP_LogoutLayout);
        jP_LogoutLayout.setHorizontalGroup(
            jP_LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_LogoutLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(Logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_LogoutLayout.setVerticalGroup(
            jP_LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Logout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        line5.setBackground(new java.awt.Color(36, 41, 61));
        line5.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout line5Layout = new javax.swing.GroupLayout(line5);
        line5.setLayout(line5Layout);
        line5Layout.setHorizontalGroup(
            line5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line5Layout.setVerticalGroup(
            line5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(line1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(line2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(jP_AddMem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(line3, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(jPH_Book, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jP_AddBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jP_DelBook, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(jPH_Mem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jP_DelMem, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(jP_IssueBook, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(jP_ReturnBook, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(line4, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(jP_Logout, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(line5, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(jP_HomePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jP_MemList, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(jP_BookList, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jP_HomePage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(line2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPH_Mem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_AddMem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_DelMem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_MemList, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(line3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPH_Book, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_AddBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_DelBook, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_BookList, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_IssueBook, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_ReturnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(line4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jP_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(line5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        MainPanel.setOpaque(false);

        PanelGrid1.setOpaque(false);
        PanelGrid1.setLayout(new java.awt.GridLayout(2, 3, 10, 10));

        CardNumBook.setC1(new java.awt.Color(215, 111, 241));
        CardNumBook.setC2(new java.awt.Color(167, 124, 248));

        Label_NB.setFont(new java.awt.Font("Prompt Medium", 0, 18)); // NOI18N
        Label_NB.setForeground(new java.awt.Color(255, 255, 255));
        Label_NB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_NB.setText("No. of Books");

        NumBook.setFont(new java.awt.Font("Prompt ExtraBold", 0, 40)); // NOI18N
        NumBook.setForeground(new java.awt.Color(255, 255, 255));
        NumBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumBook.setText("0");

        javax.swing.GroupLayout CardNumBookLayout = new javax.swing.GroupLayout(CardNumBook);
        CardNumBook.setLayout(CardNumBookLayout);
        CardNumBookLayout.setHorizontalGroup(
            CardNumBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_NB, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
            .addComponent(NumBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        CardNumBookLayout.setVerticalGroup(
            CardNumBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CardNumBookLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(Label_NB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NumBook, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        PanelGrid1.add(CardNumBook);

        CardIssuedBook.setC1(new java.awt.Color(28, 236, 228));
        CardIssuedBook.setC2(new java.awt.Color(103, 101, 220));

        Label_NB4.setFont(new java.awt.Font("Prompt Medium", 0, 18)); // NOI18N
        Label_NB4.setForeground(new java.awt.Color(255, 255, 255));
        Label_NB4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_NB4.setText("Issued Books");

        NumIssBook.setFont(new java.awt.Font("Prompt ExtraBold", 0, 40)); // NOI18N
        NumIssBook.setForeground(new java.awt.Color(255, 255, 255));
        NumIssBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumIssBook.setText("0");

        javax.swing.GroupLayout CardIssuedBookLayout = new javax.swing.GroupLayout(CardIssuedBook);
        CardIssuedBook.setLayout(CardIssuedBookLayout);
        CardIssuedBookLayout.setHorizontalGroup(
            CardIssuedBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_NB4, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
            .addComponent(NumIssBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        CardIssuedBookLayout.setVerticalGroup(
            CardIssuedBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardIssuedBookLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Label_NB4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NumIssBook, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelGrid1.add(CardIssuedBook);

        PanelGrid2.setOpaque(false);
        PanelGrid2.setLayout(new java.awt.GridLayout(2, 3, 10, 10));

        CardNumMem.setC1(new java.awt.Color(215, 111, 241));
        CardNumMem.setC2(new java.awt.Color(167, 124, 248));

        Label_NB5.setFont(new java.awt.Font("Prompt Medium", 0, 18)); // NOI18N
        Label_NB5.setForeground(new java.awt.Color(255, 255, 255));
        Label_NB5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_NB5.setText("No. of Members");

        NumMem.setFont(new java.awt.Font("Prompt ExtraBold", 0, 40)); // NOI18N
        NumMem.setForeground(new java.awt.Color(255, 255, 255));
        NumMem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumMem.setText("0");

        javax.swing.GroupLayout CardNumMemLayout = new javax.swing.GroupLayout(CardNumMem);
        CardNumMem.setLayout(CardNumMemLayout);
        CardNumMemLayout.setHorizontalGroup(
            CardNumMemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_NB5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(NumMem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        CardNumMemLayout.setVerticalGroup(
            CardNumMemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardNumMemLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Label_NB5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NumMem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        PanelGrid2.add(CardNumMem);

        CardBookCategory.setC1(new java.awt.Color(28, 236, 228));
        CardBookCategory.setC2(new java.awt.Color(103, 101, 220));

        lb_Date.setFont(new java.awt.Font("Prompt ExtraBold", 0, 26)); // NOI18N
        lb_Date.setForeground(new java.awt.Color(255, 255, 255));
        lb_Date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Date.setText("dd-MM-yyyy");

        lb_Time.setFont(new java.awt.Font("Prompt ExtraBold", 0, 24)); // NOI18N
        lb_Time.setForeground(new java.awt.Color(255, 255, 255));
        lb_Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Time.setText("HH:MM:SS");

        javax.swing.GroupLayout CardBookCategoryLayout = new javax.swing.GroupLayout(CardBookCategory);
        CardBookCategory.setLayout(CardBookCategoryLayout);
        CardBookCategoryLayout.setHorizontalGroup(
            CardBookCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_Date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_Time, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        CardBookCategoryLayout.setVerticalGroup(
            CardBookCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CardBookCategoryLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(lb_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        PanelGrid2.add(CardBookCategory);

        panelGraph.setForeground(new java.awt.Color(22, 28, 49));

        javax.swing.GroupLayout panelGraphLayout = new javax.swing.GroupLayout(panelGraph);
        panelGraph.setLayout(panelGraphLayout);
        panelGraphLayout.setHorizontalGroup(
            panelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );
        panelGraphLayout.setVerticalGroup(
            panelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelTable.setForeground(new java.awt.Color(22, 28, 49));

        HIssueDetail.setFont(new java.awt.Font("Prompt Medium", 1, 18)); // NOI18N
        HIssueDetail.setForeground(new java.awt.Color(255, 255, 255));
        HIssueDetail.setText("Issue Books Detail");

        TableIssueBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null, null, null, null},
                {"2", null, null, null, null, null},
                {"3", null, null, null, null, null},
                {"4", null, null, null, null, null},
                {"5", null, null, null, null, null},
                {"6", null, null, null, null, null}
            },
            new String [] {
                "ID", "Book", "Member", "Issue Date", "Due Date", "Status"
            }
        ));
        TableIssueBook.setAltoHead(40);
        TableIssueBook.setColorBackgoundHead(new java.awt.Color(22, 28, 49));
        TableIssueBook.setColorBordeFilas(new java.awt.Color(22, 28, 49));
        TableIssueBook.setColorBordeHead(new java.awt.Color(17, 21, 37));
        TableIssueBook.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        TableIssueBook.setColorFilasForeground1(new java.awt.Color(17, 21, 37));
        TableIssueBook.setColorFilasForeground2(new java.awt.Color(17, 21, 37));
        TableIssueBook.setColorSelBackgound(new java.awt.Color(196, 123, 189));
        TableIssueBook.setFont(new java.awt.Font("Prompt Medium", 0, 12)); // NOI18N
        TableIssueBook.setFuenteFilas(new java.awt.Font("Prompt Medium", 1, 12)); // NOI18N
        TableIssueBook.setFuenteFilasSelect(new java.awt.Font("Prompt Medium", 1, 12)); // NOI18N
        TableIssueBook.setFuenteHead(new java.awt.Font("Prompt Medium", 1, 14)); // NOI18N
        TableIssueBook.setGridColor(new java.awt.Color(255, 255, 255));
        TableIssueBook.setOpaque(false);
        TableIssueBook.setRowHeight(30);
        TableIssueBook.setShowGrid(false);
        jScrollPane1.setViewportView(TableIssueBook);

        javax.swing.GroupLayout panelTableLayout = new javax.swing.GroupLayout(panelTable);
        panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HIssueDetail)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(HIssueDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(PanelGrid1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanelGrid2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelGrid1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelGrid2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorderLayout = new javax.swing.GroupLayout(panelBorder);
        panelBorder.setLayout(panelBorderLayout);
        panelBorderLayout.setHorizontalGroup(
            panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderLayout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorderLayout.setVerticalGroup(
            panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseExited
        jP_Logout.setBackground(mouseExitColor);
    }//GEN-LAST:event_LogoutMouseExited

    private void LogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseEntered
        jP_Logout.setBackground(mouseEnterColor);
    }//GEN-LAST:event_LogoutMouseEntered

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        new LoginPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutMouseClicked

    private void ReturnBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnBookMouseExited
        jP_ReturnBook.setBackground(mouseExitColor);
    }//GEN-LAST:event_ReturnBookMouseExited

    private void ReturnBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnBookMouseEntered
        jP_ReturnBook.setBackground(mouseEnterColor);
    }//GEN-LAST:event_ReturnBookMouseEntered

    private void ReturnBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnBookMouseClicked
        new ReturnBookPage().setVisible(true);
    }//GEN-LAST:event_ReturnBookMouseClicked

    private void IssueBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IssueBookMouseExited
        jP_IssueBook.setBackground(mouseExitColor);
    }//GEN-LAST:event_IssueBookMouseExited

    private void IssueBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IssueBookMouseEntered
        jP_IssueBook.setBackground(mouseEnterColor);
    }//GEN-LAST:event_IssueBookMouseEntered

    private void IssueBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IssueBookMouseClicked
        new IssueBookPage().setVisible(true);
    }//GEN-LAST:event_IssueBookMouseClicked

    private void BookListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookListMouseExited
        jP_BookList.setBackground(mouseExitColor);
    }//GEN-LAST:event_BookListMouseExited

    private void BookListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookListMouseEntered
        jP_BookList.setBackground(mouseEnterColor);
    }//GEN-LAST:event_BookListMouseEntered

    private void BookListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookListMouseClicked
        new TableBooks().setVisible(true);
    }//GEN-LAST:event_BookListMouseClicked

    private void DelBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelBookMouseExited
        jP_DelBook.setBackground(mouseExitColor);
    }//GEN-LAST:event_DelBookMouseExited

    private void DelBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelBookMouseEntered
        jP_DelBook.setBackground(mouseEnterColor);
    }//GEN-LAST:event_DelBookMouseEntered

    private void DelBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelBookMouseClicked
        new DeleteBook().setVisible(true);
    }//GEN-LAST:event_DelBookMouseClicked

    private void AddBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBookMouseExited
        jP_AddBook.setBackground(mouseExitColor);
    }//GEN-LAST:event_AddBookMouseExited

    private void AddBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBookMouseEntered
        jP_AddBook.setBackground(mouseEnterColor);
    }//GEN-LAST:event_AddBookMouseEntered

    private void AddBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBookMouseClicked
        new AddaNewBook().setVisible(true);
    }//GEN-LAST:event_AddBookMouseClicked

    private void MemListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemListMouseExited
        jP_MemList.setBackground(mouseExitColor);
    }//GEN-LAST:event_MemListMouseExited

    private void MemListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemListMouseEntered
        jP_MemList.setBackground(mouseEnterColor);
    }//GEN-LAST:event_MemListMouseEntered

    private void MemListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemListMouseClicked
        new TableMember().setVisible(true);
    }//GEN-LAST:event_MemListMouseClicked

    private void DelMemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelMemMouseExited
        jP_DelMem.setBackground(mouseExitColor);
    }//GEN-LAST:event_DelMemMouseExited

    private void DelMemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelMemMouseEntered
        jP_DelMem.setBackground(mouseEnterColor);
    }//GEN-LAST:event_DelMemMouseEntered

    private void DelMemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelMemMouseClicked
        new DeleteMember().setVisible(true);
    }//GEN-LAST:event_DelMemMouseClicked

    private void AddMemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMemMouseExited
        jP_AddMem.setBackground(mouseExitColor);
    }//GEN-LAST:event_AddMemMouseExited

    private void AddMemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMemMouseEntered
        jP_AddMem.setBackground(mouseEnterColor);
    }//GEN-LAST:event_AddMemMouseEntered

    private void AddMemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMemMouseClicked
        new AddMember().setVisible(true);
    }//GEN-LAST:event_AddMemMouseClicked

    private int xMouse, yMouse;

    private void panelMovingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMovingMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelMovingMousePressed

    private void panelMovingMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMovingMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_panelMovingMouseDragged

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddBook;
    private javax.swing.JLabel AddMem;
    private javax.swing.JLabel BookList;
    private PanelCard CardBookCategory;
    private PanelCard CardIssuedBook;
    private PanelCard CardNumBook;
    private PanelCard CardNumMem;
    private javax.swing.JLabel DelBook;
    private javax.swing.JLabel DelMem;
    private javax.swing.JLabel HIssueDetail;
    private javax.swing.JLabel Header;
    private javax.swing.JLabel HomePage;
    private javax.swing.JLabel IssueBook;
    private javax.swing.JLabel Label_NB;
    private javax.swing.JLabel Label_NB4;
    private javax.swing.JLabel Label_NB5;
    private javax.swing.JLabel Logout;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel MemList;
    private javax.swing.JLabel NumBook;
    private javax.swing.JLabel NumIssBook;
    private javax.swing.JLabel NumMem;
    private javax.swing.JPanel PanelGrid1;
    private javax.swing.JPanel PanelGrid2;
    private javax.swing.JLabel ReturnBook;
    private rojeru_san.complementos.RSTableMetro TableIssueBook;
    private javax.swing.JLabel hBook;
    private javax.swing.JLabel hMember;
    private javax.swing.JPanel jPH_Book;
    private javax.swing.JPanel jPH_Mem;
    private javax.swing.JPanel jP_AddBook;
    private javax.swing.JPanel jP_AddMem;
    private javax.swing.JPanel jP_BookList;
    private javax.swing.JPanel jP_DelBook;
    private javax.swing.JPanel jP_DelMem;
    private javax.swing.JPanel jP_HomePage;
    private javax.swing.JPanel jP_IssueBook;
    private javax.swing.JPanel jP_Logout;
    private javax.swing.JPanel jP_MemList;
    private javax.swing.JPanel jP_ReturnBook;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Date;
    private javax.swing.JLabel lb_Time;
    private javax.swing.JPanel line1;
    private javax.swing.JPanel line2;
    private javax.swing.JPanel line3;
    private javax.swing.JPanel line4;
    private javax.swing.JPanel line5;
    private PanelBorder panelBorder;
    private PanelBorder panelGraph;
    private PanelMenu panelMenu;
    private javax.swing.JPanel panelMoving;
    private PanelBorder panelTable;
    // End of variables declaration//GEN-END:variables

    int hour, second, minute;
    String times;

    @Override
    public void run() {

        while (true) {
            try {

                Calendar c = Calendar.getInstance();
                hour = c.get(Calendar.HOUR_OF_DAY);
                minute = c.get(Calendar.MINUTE);
                second = c.get(Calendar.SECOND);

                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                Date dat = c.getTime();
                times = sdf.format(dat);
                lb_Time.setText(times);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
