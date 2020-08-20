/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import com.mysql.jdbc.Statement;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author JayJomJohn
 */
public class Main extends javax.swing.JFrame {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    DefaultTableModel model = new DefaultTableModel();
    
    public Main() {
        initComponents();
        conn=JavaConnector.ConnectDb();
        showDate();
        showTime();
        showTableHeader();
        showIcon();
        showBrand();
        showCategory();
        showProduct();
        brand();
        category();
        showBarcode();
        showSalesRecord();
        showSale();
        showdash();
    }

    //DISPLAY ICON
    private void showIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IconB/sale.png")));
    } 
    
    //COLUMN HEADER
    private void showTableHeader(){
        jTable_Brand.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable_Brand.getTableHeader().setBackground(new Color(0,153,153));
        jTable_Brand.getTableHeader().setOpaque(false);
        jTable_Brand.getTableHeader().setForeground(Color.WHITE);
        jTable_Brand.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 12));
        jTable_Brand.setRowHeight(18);
        
        jTable_Category.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable_Category.getTableHeader().setBackground(new Color(0,153,153));
        jTable_Category.getTableHeader().setOpaque(false);
        jTable_Category.getTableHeader().setForeground(Color.WHITE);
        jTable_Category.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 12));
        jTable_Category.setRowHeight(18);
        
        jTable_Product.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable_Product.getTableHeader().setBackground(new Color(0,153,153));
        jTable_Product.getTableHeader().setOpaque(false);
        jTable_Product.getTableHeader().setForeground(Color.WHITE);
        jTable_Product.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 12));
        jTable_Product.setRowHeight(18);
        
        jTable_Sales.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable_Sales.getTableHeader().setBackground(new Color(0,153,153));
        jTable_Sales.getTableHeader().setOpaque(false);
        jTable_Sales.getTableHeader().setForeground(Color.WHITE);
        jTable_Sales.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 12));
        jTable_Sales.setRowHeight(18);
        
        jTable_SalesRecord.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable_SalesRecord.getTableHeader().setBackground(new Color(0,153,153));
        jTable_SalesRecord.getTableHeader().setOpaque(false);
        jTable_SalesRecord.getTableHeader().setForeground(Color.WHITE);
        jTable_SalesRecord.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 12));
        jTable_SalesRecord.setRowHeight(18);
        
        jTable_Sale.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable_Sale.getTableHeader().setBackground(new Color(0,153,153));
        jTable_Sale.getTableHeader().setOpaque(false);
        jTable_Sale.getTableHeader().setForeground(Color.WHITE);
        jTable_Sale.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 12));
        jTable_Sale.setRowHeight(18);
        
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.getTableHeader().setBackground(new Color(0,153,153));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setForeground(Color.WHITE);
        jTable1.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 12));
        jTable1.setRowHeight(18);
    }
    
    //DATE & TIME
    public final void showDate() {
        java.util.Date d = new java.util.Date();
        SimpleDateFormat s = new SimpleDateFormat("MMMM dd, yyyy");
        SimpleDateFormat a = new SimpleDateFormat("EEEE");
        Date.setText("Date: "+s.format(d)+", it's "+a.format(d));
       
        }
   
    public final void showTime() {
        new Timer(0, new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
            java.util.Date d = new java.util.Date();
            SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
            Time.setText("Time: "+s.format(d));
            
            }
            }).start();
    } 
    
    //SETFONTS
    public void setFont(JLabel label) {    
        label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    }
    public void resetFont(JLabel label){
        label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    }       
  
    //SETHOVERBOARD   
    public void setColor (JPanel pane) {
        pane.setBackground(new Color(0,153,153));
    }
    public void resetColor(JPanel []pane, JPanel[] indicators)
    {
        for (int i=0; i<pane.length; i++) {
           pane[i].setBackground(new Color(46, 49, 49));
            
        }for (int i=0; i<indicators.length; i++) {
           indicators[i].setOpaque(false);          
        }
    } 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        sidebar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        BTN1 = new javax.swing.JPanel();
        PN1 = new javax.swing.JPanel();
        label11 = new javax.swing.JLabel();
        BTN2 = new javax.swing.JPanel();
        PN2 = new javax.swing.JPanel();
        label22 = new javax.swing.JLabel();
        BTN3 = new javax.swing.JPanel();
        PN3 = new javax.swing.JPanel();
        label33 = new javax.swing.JLabel();
        BTN4 = new javax.swing.JPanel();
        PN4 = new javax.swing.JPanel();
        label44 = new javax.swing.JLabel();
        BTN5 = new javax.swing.JPanel();
        PN5 = new javax.swing.JPanel();
        label55 = new javax.swing.JLabel();
        BTN6 = new javax.swing.JPanel();
        PN6 = new javax.swing.JPanel();
        label66 = new javax.swing.JLabel();
        panelhead = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        label_user = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cardpanel = new javax.swing.JPanel();
        dashboard = new javax.swing.JPanel();
        panelboard = new javax.swing.JPanel();
        Date = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        count3 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        count2 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        count1 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        count4 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        count5 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        brand = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Brand = new javax.swing.JTable();
        txt_brand = new LIB.FSTexFieldMD();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton_NotActive = new javax.swing.JRadioButton();
        jRadioButton_Active = new javax.swing.JRadioButton();
        btn_delete = new rojerusan.RSMaterialButtonRectangle();
        btn_add = new rojerusan.RSMaterialButtonRectangle();
        btn_edit = new rojerusan.RSMaterialButtonRectangle();
        category = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Category = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txt_category = new LIB.FSTexFieldMD();
        jLabel8 = new javax.swing.JLabel();
        jRadioButtonc_active = new javax.swing.JRadioButton();
        jRadioButtonc_notactive = new javax.swing.JRadioButton();
        btn_cadd = new rojerusan.RSMaterialButtonRectangle();
        btn_cedit = new rojerusan.RSMaterialButtonRectangle();
        btn_cdelete = new rojerusan.RSMaterialButtonRectangle();
        product = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_Product = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txt_product = new LIB.FSTexFieldMD();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_description = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmb_status = new javax.swing.JComboBox<>();
        cmb_brand = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        txt_costprice = new LIB.FSTexFieldMD();
        jLabel15 = new javax.swing.JLabel();
        txt_retailprice = new LIB.FSTexFieldMD();
        jLabel16 = new javax.swing.JLabel();
        txt_quantity = new LIB.FSTexFieldMD();
        jLabel17 = new javax.swing.JLabel();
        txt_barcode = new LIB.FSTexFieldMD();
        jLabel18 = new javax.swing.JLabel();
        cmb_category = new javax.swing.JComboBox();
        btnp_add = new rojerusan.RSMaterialButtonRectangle();
        btnp_edit = new rojerusan.RSMaterialButtonRectangle();
        btnp_delete = new rojerusan.RSMaterialButtonRectangle();
        btnp_clear = new rojerusan.RSMaterialButtonRectangle();
        sales = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txt_productcode = new LIB.FSTexFieldMD();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_SalesRecord = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        txt_productname = new LIB.FSTexFieldMD();
        jLabel21 = new javax.swing.JLabel();
        txt_price = new LIB.FSTexFieldMD();
        jLabel22 = new javax.swing.JLabel();
        txt_pay = new LIB.FSTexFieldMD();
        txt_qty = new LIB.FSTexFieldMD();
        jLabel23 = new javax.swing.JLabel();
        txt_subtotal = new LIB.FSTexFieldMD();
        jLabel24 = new javax.swing.JLabel();
        txt_balance = new LIB.FSTexFieldMD();
        btns_removetag = new rojerusan.RSMaterialButtonRectangle();
        btns_payinvoice = new rojerusan.RSMaterialButtonRectangle();
        btns_add = new rojerusan.RSMaterialButtonRectangle();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_Sales = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable_Sale = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidebar.setBackground(new java.awt.Color(46, 49, 49));
        sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_manager_127px_1.png"))); // NOI18N
        sidebar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 216, 140));

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Administrator");
        sidebar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 216, 24));

        BTN1.setBackground(new java.awt.Color(0, 153, 153));
        BTN1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTN1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout PN1Layout = new javax.swing.GroupLayout(PN1);
        PN1.setLayout(PN1Layout);
        PN1Layout.setHorizontalGroup(
            PN1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        PN1Layout.setVerticalGroup(
            PN1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        label11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label11.setForeground(new java.awt.Color(255, 255, 255));
        label11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconA/icons8_home_35px_1.png"))); // NOI18N
        label11.setText("Dashboard");
        label11.setIconTextGap(10);

        javax.swing.GroupLayout BTN1Layout = new javax.swing.GroupLayout(BTN1);
        BTN1.setLayout(BTN1Layout);
        BTN1Layout.setHorizontalGroup(
            BTN1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BTN1Layout.createSequentialGroup()
                .addComponent(PN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        BTN1Layout.setVerticalGroup(
            BTN1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PN1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BTN1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label11, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidebar.add(BTN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 280, 70));

        BTN2.setBackground(new java.awt.Color(46, 49, 49));
        BTN2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTN2MousePressed(evt);
            }
        });

        PN2.setOpaque(false);

        javax.swing.GroupLayout PN2Layout = new javax.swing.GroupLayout(PN2);
        PN2.setLayout(PN2Layout);
        PN2Layout.setHorizontalGroup(
            PN2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        PN2Layout.setVerticalGroup(
            PN2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        label22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label22.setForeground(new java.awt.Color(255, 255, 255));
        label22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconA/icons8_opened_folder_35px.png"))); // NOI18N
        label22.setText("Manage Brand");
        label22.setIconTextGap(10);

        javax.swing.GroupLayout BTN2Layout = new javax.swing.GroupLayout(BTN2);
        BTN2.setLayout(BTN2Layout);
        BTN2Layout.setHorizontalGroup(
            BTN2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BTN2Layout.createSequentialGroup()
                .addComponent(PN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label22, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        BTN2Layout.setVerticalGroup(
            BTN2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PN2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BTN2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label22, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidebar.add(BTN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 280, 70));

        BTN3.setBackground(new java.awt.Color(46, 49, 49));
        BTN3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTN3MousePressed(evt);
            }
        });

        PN3.setOpaque(false);

        javax.swing.GroupLayout PN3Layout = new javax.swing.GroupLayout(PN3);
        PN3.setLayout(PN3Layout);
        PN3Layout.setHorizontalGroup(
            PN3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        PN3Layout.setVerticalGroup(
            PN3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        label33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label33.setForeground(new java.awt.Color(255, 255, 255));
        label33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconA/icons8_magazine_35px.png"))); // NOI18N
        label33.setText("Manage Category");
        label33.setIconTextGap(10);

        javax.swing.GroupLayout BTN3Layout = new javax.swing.GroupLayout(BTN3);
        BTN3.setLayout(BTN3Layout);
        BTN3Layout.setHorizontalGroup(
            BTN3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BTN3Layout.createSequentialGroup()
                .addComponent(PN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label33, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        BTN3Layout.setVerticalGroup(
            BTN3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PN3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BTN3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label33, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidebar.add(BTN3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 280, 70));

        BTN4.setBackground(new java.awt.Color(46, 49, 49));
        BTN4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTN4MousePressed(evt);
            }
        });

        PN4.setOpaque(false);

        javax.swing.GroupLayout PN4Layout = new javax.swing.GroupLayout(PN4);
        PN4.setLayout(PN4Layout);
        PN4Layout.setHorizontalGroup(
            PN4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        PN4Layout.setVerticalGroup(
            PN4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        label44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label44.setForeground(new java.awt.Color(255, 255, 255));
        label44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconA/icons8_product_35px.png"))); // NOI18N
        label44.setText("Manage Product");
        label44.setIconTextGap(10);

        javax.swing.GroupLayout BTN4Layout = new javax.swing.GroupLayout(BTN4);
        BTN4.setLayout(BTN4Layout);
        BTN4Layout.setHorizontalGroup(
            BTN4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BTN4Layout.createSequentialGroup()
                .addComponent(PN4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label44, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        BTN4Layout.setVerticalGroup(
            BTN4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PN4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BTN4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label44, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidebar.add(BTN4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 280, 70));

        BTN5.setBackground(new java.awt.Color(46, 49, 49));
        BTN5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTN5MousePressed(evt);
            }
        });

        PN5.setOpaque(false);

        javax.swing.GroupLayout PN5Layout = new javax.swing.GroupLayout(PN5);
        PN5.setLayout(PN5Layout);
        PN5Layout.setHorizontalGroup(
            PN5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        PN5Layout.setVerticalGroup(
            PN5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        label55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label55.setForeground(new java.awt.Color(255, 255, 255));
        label55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconA/icons8_shopping_cart_35px.png"))); // NOI18N
        label55.setText("Manage Sales");
        label55.setIconTextGap(10);

        javax.swing.GroupLayout BTN5Layout = new javax.swing.GroupLayout(BTN5);
        BTN5.setLayout(BTN5Layout);
        BTN5Layout.setHorizontalGroup(
            BTN5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BTN5Layout.createSequentialGroup()
                .addComponent(PN5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label55, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        BTN5Layout.setVerticalGroup(
            BTN5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PN5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BTN5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label55, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidebar.add(BTN5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 280, 70));

        BTN6.setBackground(new java.awt.Color(46, 49, 49));
        BTN6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTN6MousePressed(evt);
            }
        });

        PN6.setOpaque(false);

        javax.swing.GroupLayout PN6Layout = new javax.swing.GroupLayout(PN6);
        PN6.setLayout(PN6Layout);
        PN6Layout.setHorizontalGroup(
            PN6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        PN6Layout.setVerticalGroup(
            PN6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        label66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label66.setForeground(new java.awt.Color(255, 255, 255));
        label66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconA/icons8_login_rounded_right_35px.png"))); // NOI18N
        label66.setText("Log-Out");
        label66.setIconTextGap(10);

        javax.swing.GroupLayout BTN6Layout = new javax.swing.GroupLayout(BTN6);
        BTN6.setLayout(BTN6Layout);
        BTN6Layout.setHorizontalGroup(
            BTN6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BTN6Layout.createSequentialGroup()
                .addComponent(PN6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label66, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        BTN6Layout.setVerticalGroup(
            BTN6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PN6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BTN6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label66, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidebar.add(BTN6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 280, 70));

        getContentPane().add(sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 650));

        panelhead.setBackground(new java.awt.Color(0, 153, 153));
        panelhead.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconA/icons8_user_male_circle_35px.png"))); // NOI18N
        panelhead.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 48, 36));

        label_user.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_user.setForeground(new java.awt.Color(255, 255, 255));
        label_user.setText("label User");
        panelhead.add(label_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 12, 180, 36));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconB/icons8_minimize_window_25px.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelhead.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 30, 38));

        Exit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Exit.setForeground(new java.awt.Color(255, 255, 255));
        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconB/icons8_close_window_25px_1.png"))); // NOI18N
        Exit.setBorderPainted(false);
        Exit.setContentAreaFilled(false);
        Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exit.setFocusPainted(false);
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        panelhead.add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 30, 38));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Inventory System");
        jLabel5.setIconTextGap(10);
        panelhead.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 12, 456, 36));

        getContentPane().add(panelhead, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 1020, 60));

        cardpanel.setLayout(new java.awt.CardLayout());

        dashboard.setBackground(new java.awt.Color(232, 232, 232));
        dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelboard.setBackground(new java.awt.Color(0, 153, 153));
        panelboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Date.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Date.setForeground(new java.awt.Color(255, 255, 255));
        Date.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconA/icons8_today_35px.png"))); // NOI18N
        Date.setText("DATE:");
        Date.setIconTextGap(10);
        panelboard.add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 390, 48));

        Time.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Time.setForeground(new java.awt.Color(255, 255, 255));
        Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Time.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconA/icons8_time_35px_1.png"))); // NOI18N
        Time.setText("TIME:");
        Time.setIconTextGap(10);
        panelboard.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(722, 12, 264, 48));

        dashboard.add(panelboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 70));

        jPanel22.setBackground(new java.awt.Color(0, 0, 0));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Cost");
        jPanel22.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 150, 30));

        jLabel41.setBackground(new java.awt.Color(153, 0, 0));
        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_coins_60px.png"))); // NOI18N
        jLabel41.setOpaque(true);
        jPanel22.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 110));

        count3.setBackground(new java.awt.Color(0, 51, 102));
        count3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        count3.setForeground(new java.awt.Color(255, 255, 255));
        count3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel22.add(count3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 150, 60));

        dashboard.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, 110));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setText("Dashboard");
        dashboard.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 260, 40));

        jPanel23.setBackground(new java.awt.Color(0, 0, 0));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setBackground(new java.awt.Color(255, 255, 255));
        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Stock");
        jPanel23.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 150, 30));

        jLabel43.setBackground(new java.awt.Color(0, 102, 153));
        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_warehouse_60px.png"))); // NOI18N
        jLabel43.setOpaque(true);
        jPanel23.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 110));

        count2.setBackground(new java.awt.Color(0, 51, 102));
        count2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        count2.setForeground(new java.awt.Color(255, 255, 255));
        count2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel23.add(count2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 150, 60));

        dashboard.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 110));

        jPanel24.setBackground(new java.awt.Color(0, 0, 0));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Product");
        jPanel24.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 150, 30));

        jLabel45.setBackground(new java.awt.Color(0, 153, 153));
        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_product_60px.png"))); // NOI18N
        jLabel45.setOpaque(true);
        jPanel24.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 110));

        count1.setBackground(new java.awt.Color(0, 51, 102));
        count1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        count1.setForeground(new java.awt.Color(255, 255, 255));
        count1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel24.add(count1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 150, 60));

        dashboard.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 110));

        jPanel25.setBackground(new java.awt.Color(0, 0, 0));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Sales");
        jPanel25.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 150, 30));

        jLabel47.setBackground(new java.awt.Color(102, 0, 102));
        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_sale_60px.png"))); // NOI18N
        jLabel47.setOpaque(true);
        jPanel25.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 110));

        count4.setBackground(new java.awt.Color(0, 51, 102));
        count4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        count4.setForeground(new java.awt.Color(255, 255, 255));
        count4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel25.add(count4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 150, 60));

        dashboard.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, -1, 110));

        jPanel26.setBackground(new java.awt.Color(0, 0, 0));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Sale Record");
        jPanel26.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 150, 30));

        jLabel49.setBackground(new java.awt.Color(153, 51, 0));
        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_receive_cash_60px.png"))); // NOI18N
        jLabel49.setOpaque(true);
        jPanel26.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 110));

        count5.setBackground(new java.awt.Color(0, 51, 102));
        count5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        count5.setForeground(new java.awt.Color(255, 255, 255));
        count5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel26.add(count5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 150, 60));

        dashboard.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, 110));

        jTable1.setBackground(new java.awt.Color(46, 49, 49));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFillsViewportHeight(true);
        jTable1.setGridColor(new java.awt.Color(46, 49, 49));
        jTable1.setSelectionBackground(new java.awt.Color(153, 51, 0));
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        dashboard.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 287, 620, 260));

        cardpanel.add(dashboard, "card2");

        brand.setBackground(new java.awt.Color(232, 232, 232));
        brand.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Brand.setBackground(new java.awt.Color(46, 49, 49));
        jTable_Brand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable_Brand.setForeground(new java.awt.Color(255, 255, 255));
        jTable_Brand.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "BRAND", "STATUS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Brand.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable_Brand.setFillsViewportHeight(true);
        jTable_Brand.setGridColor(new java.awt.Color(46, 49, 49));
        jTable_Brand.setRowHeight(18);
        jTable_Brand.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jTable_Brand.getTableHeader().setReorderingAllowed(false);
        jTable_Brand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_BrandMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Brand);
        if (jTable_Brand.getColumnModel().getColumnCount() > 0) {
            jTable_Brand.getColumnModel().getColumn(0).setResizable(false);
            jTable_Brand.getColumnModel().getColumn(1).setResizable(false);
            jTable_Brand.getColumnModel().getColumn(2).setResizable(false);
        }

        brand.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 950, 350));

        txt_brand.setBackground(new java.awt.Color(232, 232, 232));
        txt_brand.setForeground(new java.awt.Color(0, 0, 0));
        txt_brand.setBordeColorFocus(new java.awt.Color(0, 153, 153));
        txt_brand.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_brand.setPlaceholder("Brand");
        brand.add(txt_brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Status:");
        brand.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 130, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Brand:");
        brand.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 130, 40));

        jRadioButton_NotActive.setBackground(new java.awt.Color(232, 232, 232));
        buttonGroup1.add(jRadioButton_NotActive);
        jRadioButton_NotActive.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton_NotActive.setText("Not Active");
        jRadioButton_NotActive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton_NotActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_NotActiveActionPerformed(evt);
            }
        });
        brand.add(jRadioButton_NotActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 91, 140, 40));

        jRadioButton_Active.setBackground(new java.awt.Color(232, 232, 232));
        buttonGroup1.add(jRadioButton_Active);
        jRadioButton_Active.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton_Active.setText("Active");
        jRadioButton_Active.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton_Active.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_ActiveActionPerformed(evt);
            }
        });
        brand.add(jRadioButton_Active, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 91, 100, 40));

        btn_delete.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete.setText("delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        brand.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 180, 50));

        btn_add.setBackground(new java.awt.Color(0, 51, 102));
        btn_add.setText("ADD");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        brand.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 180, 50));

        btn_edit.setBackground(new java.awt.Color(0, 153, 153));
        btn_edit.setText("EDIT");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        brand.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 180, 50));

        cardpanel.add(brand, "card3");

        category.setBackground(new java.awt.Color(232, 232, 232));
        category.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Category.setBackground(new java.awt.Color(46, 49, 49));
        jTable_Category.setForeground(new java.awt.Color(255, 255, 255));
        jTable_Category.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Category", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Category.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable_Category.setFillsViewportHeight(true);
        jTable_Category.setGridColor(new java.awt.Color(46, 49, 49));
        jTable_Category.setRowHeight(18);
        jTable_Category.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jTable_Category.getTableHeader().setReorderingAllowed(false);
        jTable_Category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_CategoryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Category);
        if (jTable_Category.getColumnModel().getColumnCount() > 0) {
            jTable_Category.getColumnModel().getColumn(0).setResizable(false);
            jTable_Category.getColumnModel().getColumn(1).setResizable(false);
            jTable_Category.getColumnModel().getColumn(2).setResizable(false);
        }

        category.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 950, 350));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Category:");
        category.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 130, 40));

        txt_category.setBackground(new java.awt.Color(232, 232, 232));
        txt_category.setForeground(new java.awt.Color(0, 0, 0));
        txt_category.setBordeColorFocus(new java.awt.Color(0, 153, 153));
        txt_category.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_category.setPlaceholder("Category");
        category.add(txt_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Status:");
        category.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 130, 40));

        jRadioButtonc_active.setBackground(new java.awt.Color(232, 232, 232));
        buttonGroup2.add(jRadioButtonc_active);
        jRadioButtonc_active.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButtonc_active.setText("Active");
        jRadioButtonc_active.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButtonc_active.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonc_activeActionPerformed(evt);
            }
        });
        category.add(jRadioButtonc_active, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 91, 100, 40));

        jRadioButtonc_notactive.setBackground(new java.awt.Color(232, 232, 232));
        buttonGroup2.add(jRadioButtonc_notactive);
        jRadioButtonc_notactive.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButtonc_notactive.setText("Not Active");
        jRadioButtonc_notactive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButtonc_notactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonc_notactiveActionPerformed(evt);
            }
        });
        category.add(jRadioButtonc_notactive, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 91, 140, 40));

        btn_cadd.setBackground(new java.awt.Color(0, 51, 102));
        btn_cadd.setText("ADD");
        btn_cadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_caddActionPerformed(evt);
            }
        });
        category.add(btn_cadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 180, 50));

        btn_cedit.setBackground(new java.awt.Color(0, 153, 153));
        btn_cedit.setText("EDIT");
        btn_cedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ceditActionPerformed(evt);
            }
        });
        category.add(btn_cedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 180, 50));

        btn_cdelete.setBackground(new java.awt.Color(153, 0, 0));
        btn_cdelete.setText("DELETE");
        btn_cdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cdeleteActionPerformed(evt);
            }
        });
        category.add(btn_cdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 180, 50));

        cardpanel.add(category, "card4");

        product.setBackground(new java.awt.Color(232, 232, 232));
        product.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Product.setBackground(new java.awt.Color(46, 49, 49));
        jTable_Product.setForeground(new java.awt.Color(255, 255, 255));
        jTable_Product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Product", "Description", "Brand", "Category", "Costprice", "Retailprice", "Quantity", "Barcode", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Product.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable_Product.setFillsViewportHeight(true);
        jTable_Product.setGridColor(new java.awt.Color(46, 49, 49));
        jTable_Product.setRowHeight(18);
        jTable_Product.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jTable_Product.getTableHeader().setReorderingAllowed(false);
        jTable_Product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ProductMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_Product);
        if (jTable_Product.getColumnModel().getColumnCount() > 0) {
            jTable_Product.getColumnModel().getColumn(0).setResizable(false);
            jTable_Product.getColumnModel().getColumn(1).setResizable(false);
            jTable_Product.getColumnModel().getColumn(2).setResizable(false);
            jTable_Product.getColumnModel().getColumn(3).setResizable(false);
            jTable_Product.getColumnModel().getColumn(4).setResizable(false);
            jTable_Product.getColumnModel().getColumn(5).setResizable(false);
            jTable_Product.getColumnModel().getColumn(6).setResizable(false);
            jTable_Product.getColumnModel().getColumn(7).setResizable(false);
            jTable_Product.getColumnModel().getColumn(8).setResizable(false);
            jTable_Product.getColumnModel().getColumn(9).setResizable(false);
        }

        product.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 950, 200));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Category:");
        product.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 130, 40));

        txt_product.setBackground(new java.awt.Color(232, 232, 232));
        txt_product.setForeground(new java.awt.Color(0, 0, 0));
        txt_product.setBordeColorFocus(new java.awt.Color(0, 153, 153));
        txt_product.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_product.setPlaceholder("Product");
        product.add(txt_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Product:");
        product.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 130, 40));

        txt_description.setBackground(new java.awt.Color(232, 232, 232));
        txt_description.setColumns(20);
        txt_description.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_description.setRows(5);
        jScrollPane4.setViewportView(txt_description);

        product.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 250, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Description:");
        product.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 130, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Brand:");
        product.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 130, 40));

        cmb_status.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmb_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Available", "Not Available" }));
        product.add(cmb_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 250, 40));

        cmb_brand.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        product.add(cmb_brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 250, 40));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Cost Price:");
        product.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 130, 40));

        txt_costprice.setBackground(new java.awt.Color(232, 232, 232));
        txt_costprice.setForeground(new java.awt.Color(0, 0, 0));
        txt_costprice.setBordeColorFocus(new java.awt.Color(0, 153, 153));
        txt_costprice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_costprice.setPlaceholder("Price");
        txt_costprice.setSoloNumeros(true);
        product.add(txt_costprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Retail Price:");
        product.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 130, 40));

        txt_retailprice.setBackground(new java.awt.Color(232, 232, 232));
        txt_retailprice.setForeground(new java.awt.Color(0, 0, 0));
        txt_retailprice.setBordeColorFocus(new java.awt.Color(0, 153, 153));
        txt_retailprice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_retailprice.setPlaceholder("Retail Price");
        txt_retailprice.setSoloNumeros(true);
        product.add(txt_retailprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Quantity:");
        product.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 130, 40));

        txt_quantity.setBackground(new java.awt.Color(232, 232, 232));
        txt_quantity.setForeground(new java.awt.Color(0, 0, 0));
        txt_quantity.setBordeColorFocus(new java.awt.Color(0, 153, 153));
        txt_quantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_quantity.setPlaceholder("Quantity");
        txt_quantity.setSoloNumeros(true);
        product.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Status:");
        product.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 130, 40));

        txt_barcode.setEditable(false);
        txt_barcode.setBackground(new java.awt.Color(232, 232, 232));
        txt_barcode.setForeground(new java.awt.Color(0, 0, 0));
        txt_barcode.setBordeColorFocus(new java.awt.Color(0, 153, 153));
        txt_barcode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_barcode.setPlaceholder("Barcode");
        txt_barcode.setSoloNumeros(true);
        product.add(txt_barcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Barcode:");
        product.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 130, 40));

        cmb_category.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        product.add(cmb_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 250, 40));

        btnp_add.setBackground(new java.awt.Color(0, 51, 102));
        btnp_add.setText("ADD");
        btnp_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnp_addActionPerformed(evt);
            }
        });
        product.add(btnp_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 180, 50));

        btnp_edit.setBackground(new java.awt.Color(0, 153, 153));
        btnp_edit.setText("EDIT");
        btnp_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnp_editActionPerformed(evt);
            }
        });
        product.add(btnp_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 180, 50));

        btnp_delete.setBackground(new java.awt.Color(153, 0, 0));
        btnp_delete.setText("DELETE");
        btnp_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnp_deleteActionPerformed(evt);
            }
        });
        product.add(btnp_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 300, 180, 50));

        btnp_clear.setBackground(new java.awt.Color(51, 51, 51));
        btnp_clear.setText("Clear");
        btnp_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnp_clearActionPerformed(evt);
            }
        });
        product.add(btnp_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 180, 50));

        cardpanel.add(product, "card5");

        sales.setBackground(new java.awt.Color(232, 232, 232));
        sales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("|");
        sales.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 20, 40));

        txt_productcode.setBackground(new java.awt.Color(232, 232, 232));
        txt_productcode.setForeground(new java.awt.Color(0, 0, 0));
        txt_productcode.setToolTipText("Press Enter to Search Product Code");
        txt_productcode.setBordeColorFocus(new java.awt.Color(0, 153, 153));
        txt_productcode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_productcode.setPlaceholder("Product Code");
        txt_productcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_productcodeKeyPressed(evt);
            }
        });
        sales.add(txt_productcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 170, -1));

        jTable_SalesRecord.setBackground(new java.awt.Color(46, 49, 49));
        jTable_SalesRecord.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable_SalesRecord.setForeground(new java.awt.Color(255, 255, 255));
        jTable_SalesRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Date", "Subtotal", "Pay", "Balance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_SalesRecord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable_SalesRecord.setFillsViewportHeight(true);
        jTable_SalesRecord.setGridColor(new java.awt.Color(46, 49, 49));
        jTable_SalesRecord.setRowHeight(18);
        jTable_SalesRecord.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jTable_SalesRecord.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTable_SalesRecord);
        if (jTable_SalesRecord.getColumnModel().getColumnCount() > 0) {
            jTable_SalesRecord.getColumnModel().getColumn(0).setResizable(false);
            jTable_SalesRecord.getColumnModel().getColumn(1).setResizable(false);
            jTable_SalesRecord.getColumnModel().getColumn(2).setResizable(false);
            jTable_SalesRecord.getColumnModel().getColumn(3).setResizable(false);
            jTable_SalesRecord.getColumnModel().getColumn(4).setResizable(false);
        }

        sales.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 500, 150));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Sales");
        sales.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 220, 30));

        txt_productname.setEditable(false);
        txt_productname.setBackground(new java.awt.Color(232, 232, 232));
        txt_productname.setForeground(new java.awt.Color(0, 0, 0));
        txt_productname.setBordeColorFocus(new java.awt.Color(0, 153, 153));
        txt_productname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_productname.setPlaceholder("Product Name");
        sales.add(txt_productname, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 230, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("|");
        sales.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 20, 40));

        txt_price.setEditable(false);
        txt_price.setBackground(new java.awt.Color(232, 232, 232));
        txt_price.setForeground(new java.awt.Color(0, 0, 0));
        txt_price.setBordeColorFocus(new java.awt.Color(0, 153, 153));
        txt_price.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_price.setPlaceholder("Price");
        sales.add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 200, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("|");
        sales.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 20, 40));

        txt_pay.setBackground(new java.awt.Color(232, 232, 232));
        txt_pay.setForeground(new java.awt.Color(0, 0, 0));
        txt_pay.setBordeColorFocus(new java.awt.Color(0, 153, 153));
        txt_pay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_pay.setPlaceholder("Pay");
        txt_pay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_payKeyReleased(evt);
            }
        });
        sales.add(txt_pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 220, -1));

        txt_qty.setBackground(new java.awt.Color(232, 232, 232));
        txt_qty.setForeground(new java.awt.Color(0, 0, 0));
        txt_qty.setBordeColorFocus(new java.awt.Color(0, 153, 153));
        txt_qty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_qty.setPlaceholder("Quantity");
        sales.add(txt_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 220, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("|");
        sales.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 30, 40));

        txt_subtotal.setEditable(false);
        txt_subtotal.setBackground(new java.awt.Color(232, 232, 232));
        txt_subtotal.setForeground(new java.awt.Color(102, 0, 0));
        txt_subtotal.setBordeColorFocus(new java.awt.Color(0, 153, 153));
        txt_subtotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_subtotal.setPlaceholder("SubTotal");
        sales.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 220, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("|");
        sales.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 20, 40));

        txt_balance.setEditable(false);
        txt_balance.setBackground(new java.awt.Color(232, 232, 232));
        txt_balance.setForeground(new java.awt.Color(0, 0, 0));
        txt_balance.setBordeColorFocus(new java.awt.Color(0, 153, 153));
        txt_balance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_balance.setPlaceholder("Balance");
        sales.add(txt_balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 220, -1));

        btns_removetag.setBackground(new java.awt.Color(102, 0, 0));
        btns_removetag.setText("REMOVE TAG");
        btns_removetag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns_removetagActionPerformed(evt);
            }
        });
        sales.add(btns_removetag, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, 200, 50));

        btns_payinvoice.setBackground(new java.awt.Color(0, 102, 153));
        btns_payinvoice.setText("PAY");
        btns_payinvoice.setEnabled(false);
        btns_payinvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns_payinvoiceActionPerformed(evt);
            }
        });
        sales.add(btns_payinvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, 200, 50));

        btns_add.setBackground(new java.awt.Color(0, 51, 102));
        btns_add.setText("ADD");
        btns_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns_addActionPerformed(evt);
            }
        });
        sales.add(btns_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, 200, 50));

        jTable_Sales.setBackground(new java.awt.Color(46, 49, 49));
        jTable_Sales.setForeground(new java.awt.Color(255, 255, 255));
        jTable_Sales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Product", "Price", "Quantity", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Sales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable_Sales.setFillsViewportHeight(true);
        jTable_Sales.setGridColor(new java.awt.Color(46, 49, 49));
        jTable_Sales.setRowHeight(18);
        jTable_Sales.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jTable_Sales.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTable_Sales);
        if (jTable_Sales.getColumnModel().getColumnCount() > 0) {
            jTable_Sales.getColumnModel().getColumn(0).setResizable(false);
            jTable_Sales.getColumnModel().getColumn(1).setResizable(false);
            jTable_Sales.getColumnModel().getColumn(2).setResizable(false);
            jTable_Sales.getColumnModel().getColumn(3).setResizable(false);
            jTable_Sales.getColumnModel().getColumn(4).setResizable(false);
        }

        sales.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 730, 210));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("|");
        sales.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 20, 40));

        jTable_Sale.setBackground(new java.awt.Color(46, 49, 49));
        jTable_Sale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable_Sale.setForeground(new java.awt.Color(255, 255, 255));
        jTable_Sale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "SalesID", "ProductID", "Sellprice", "Quantity", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Sale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable_Sale.setFillsViewportHeight(true);
        jTable_Sale.setGridColor(new java.awt.Color(46, 49, 49));
        jTable_Sale.setRowHeight(18);
        jTable_Sale.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jTable_Sale.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(jTable_Sale);
        if (jTable_Sale.getColumnModel().getColumnCount() > 0) {
            jTable_Sale.getColumnModel().getColumn(0).setResizable(false);
            jTable_Sale.getColumnModel().getColumn(1).setResizable(false);
            jTable_Sale.getColumnModel().getColumn(2).setResizable(false);
            jTable_Sale.getColumnModel().getColumn(3).setResizable(false);
            jTable_Sale.getColumnModel().getColumn(4).setResizable(false);
            jTable_Sale.getColumnModel().getColumn(5).setResizable(false);
        }

        sales.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 460, 150));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Sales Record");
        sales.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 220, 30));

        cardpanel.add(sales, "card6");

        getContentPane().add(cardpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 1020, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?","System Logout", JOptionPane.YES_NO_OPTION);
        if(YesOrNo == 1)
        {
            // if click no
        }
        if(YesOrNo == 0)
        {
            // if click yes
            System.exit(0);
        }
    }//GEN-LAST:event_ExitActionPerformed

    private void BTN1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN1MouseEntered
        setFont(label11);
    }//GEN-LAST:event_BTN1MouseEntered

    private void BTN1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN1MouseExited
        resetFont(label11);
    }//GEN-LAST:event_BTN1MouseExited

    private void BTN2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN2MouseEntered
        setFont(label22);
    }//GEN-LAST:event_BTN2MouseEntered

    private void BTN2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN2MouseExited
        resetFont(label22);
    }//GEN-LAST:event_BTN2MouseExited

    private void BTN3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN3MouseEntered
        setFont(label33);
    }//GEN-LAST:event_BTN3MouseEntered

    private void BTN3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN3MouseExited
        resetFont(label33);
    }//GEN-LAST:event_BTN3MouseExited

    private void BTN4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN4MouseEntered
        setFont(label44);
    }//GEN-LAST:event_BTN4MouseEntered

    private void BTN4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN4MouseExited
        resetFont(label44);
    }//GEN-LAST:event_BTN4MouseExited

    private void BTN5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN5MouseEntered
        setFont(label55);
    }//GEN-LAST:event_BTN5MouseEntered

    private void BTN5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN5MouseExited
        resetFont(label55);
    }//GEN-LAST:event_BTN5MouseExited

    private void BTN6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN6MouseEntered
        setFont(label66);
    }//GEN-LAST:event_BTN6MouseEntered

    private void BTN6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN6MouseExited
        resetFont(label66);
    }//GEN-LAST:event_BTN6MouseExited

    private void BTN1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN1MousePressed
        setColor(BTN1);
        PN1.setOpaque(true);
        resetColor(new JPanel[]{BTN2,BTN3,BTN4,BTN5,BTN6},new JPanel[]{PN6,PN2,PN3,PN4,PN5});
    }//GEN-LAST:event_BTN1MousePressed

    private void BTN2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN2MousePressed
        setColor(BTN2);
        PN2.setOpaque(true);
        resetColor(new JPanel[]{BTN1,BTN3,BTN4,BTN5,BTN6},new JPanel[]{PN1,PN3,PN4,PN5,PN6});
    }//GEN-LAST:event_BTN2MousePressed

    private void BTN3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN3MousePressed
        setColor(BTN3);
        PN3.setOpaque(true);
        resetColor(new JPanel[]{BTN1,BTN2,BTN4,BTN5,BTN6},new JPanel[]{PN1,PN2,PN4,PN5,PN6});  
    }//GEN-LAST:event_BTN3MousePressed

    private void BTN4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN4MousePressed
        setColor(BTN4);
        PN4.setOpaque(true);
        resetColor(new JPanel[]{BTN1,BTN2,BTN3,BTN5,BTN6},new JPanel[]{PN1,PN2,PN3,PN5,PN6});
    }//GEN-LAST:event_BTN4MousePressed

    private void BTN5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN5MousePressed
        setColor(BTN5);
        PN5.setOpaque(true);
        resetColor(new JPanel[]{BTN1,BTN2,BTN3,BTN4,BTN6},new JPanel[]{PN1,PN2,PN3,PN4,PN6});
    }//GEN-LAST:event_BTN5MousePressed

    private void BTN6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN6MousePressed
        setColor(BTN6);
        PN6.setOpaque(true);
        resetColor(new JPanel[]{BTN1,BTN2,BTN3,BTN4,BTN5},new JPanel[]{PN1,PN2,PN3,PN4,PN5});  
    }//GEN-LAST:event_BTN6MousePressed

    private void BTN1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN1MouseClicked
        cardpanel.removeAll();
        cardpanel.repaint();
        cardpanel.revalidate();
        cardpanel.add(dashboard);
        cardpanel.repaint();
        cardpanel.revalidate();
    }//GEN-LAST:event_BTN1MouseClicked

    private void BTN2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN2MouseClicked
        cardpanel.removeAll();
        cardpanel.repaint();
        cardpanel.revalidate();
        cardpanel.add(brand);
        cardpanel.repaint();
        cardpanel.revalidate();
    }//GEN-LAST:event_BTN2MouseClicked

    private void BTN3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN3MouseClicked
        cardpanel.removeAll();
        cardpanel.repaint();
        cardpanel.revalidate();
        cardpanel.add(category);
        cardpanel.repaint();
        cardpanel.revalidate();
    }//GEN-LAST:event_BTN3MouseClicked

    private void BTN4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN4MouseClicked
        cardpanel.removeAll();
        cardpanel.repaint();
        cardpanel.revalidate();
        cardpanel.add(product);
        cardpanel.repaint();
        cardpanel.revalidate();
    }//GEN-LAST:event_BTN4MouseClicked

    private void BTN5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN5MouseClicked
        cardpanel.removeAll();
        cardpanel.repaint();
        cardpanel.revalidate();
        cardpanel.add(sales);
        cardpanel.repaint();
        cardpanel.revalidate();
    }//GEN-LAST:event_BTN5MouseClicked

    private void BTN6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN6MouseClicked
       int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "System Logout", JOptionPane.YES_NO_OPTION);
        if (YesOrNo == 1) {
            // if click no                        
        }
        if (YesOrNo == 0) {
            // if click yes
            
            this.setVisible(false);
            Login L = new Login();
            L.setVisible(true);
 
        }
    }//GEN-LAST:event_BTN6MouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        //CONFIRMATION
        int x = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Add Record?","AddRecord",JOptionPane.YES_NO_OPTION);
        if(x==0){
            
            if(txt_brand.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "No Brand Found!", "ATTENTION", JOptionPane.ERROR_MESSAGE);
                txt_brand.requestFocus();
                getToolkit().beep();
                
            }else{
            
            try {
                String sql = "INSERT INTO brand(brand,status)VALUES(?,?)";
                pst=conn.prepareStatement(sql);
                pst.setString(1, txt_brand.getText());
                pst.setString(2, status);
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "Successfully Add Brand");
                showBrand();
                brand();
                txt_brand.setText("");
                buttonGroup1.clearSelection();
                txt_brand.requestFocus();
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        }
            }
        }
    }//GEN-LAST:event_btn_addActionPerformed
String status;
    private void jRadioButton_ActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_ActiveActionPerformed
        status = "Active";
        if (jRadioButton_Active.isSelected() == true) {
            jRadioButton_NotActive.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton_ActiveActionPerformed

    private void jRadioButton_NotActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_NotActiveActionPerformed
        status = "Not Active";
        if (jRadioButton_NotActive.isSelected() == true) {
            jRadioButton_Active.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton_NotActiveActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        DefaultTableModel d = (DefaultTableModel)jTable_Brand.getModel();
        int row = jTable_Brand.getSelectedRow();
        int id = Integer.parseInt(d.getValueAt(row, 0).toString());
        
        int dialogResult = JOptionPane.showConfirmDialog(null,"Do You Want to Update the Record","Warning!",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            
            try {
                String sql = "UPDATE `brand` SET `brand`=?,`status`=? WHERE id=?";
                pst=conn.prepareStatement(sql);
                pst.setString(1, txt_brand.getText());
                pst.setString(2, status);
                pst.setInt(3, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Successfully Updated Brand");
                showBrand();
                brand();
                txt_brand.setText("");
                buttonGroup1.clearSelection();
                txt_brand.requestFocus();
            
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
            
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void jTable_BrandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_BrandMouseClicked
        DefaultTableModel d = (DefaultTableModel)jTable_Brand.getModel();
        int row = jTable_Brand.getSelectedRow();
        txt_brand.setText(d.getValueAt(row, 1).toString());
        String a = d.getValueAt(row, 2).toString();
        if("Active".equals(a)){
            jRadioButton_Active.setSelected(true);
        }else if("Not Active".equals(a)){
            jRadioButton_NotActive.setSelected(true);
        }        
    }//GEN-LAST:event_jTable_BrandMouseClicked

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        DefaultTableModel d = (DefaultTableModel)jTable_Brand.getModel();
        int row = jTable_Brand.getSelectedRow();
        int id = Integer.parseInt(d.getValueAt(row, 0).toString());
        
        int dialogResult = JOptionPane.showConfirmDialog(null,"Do You Want to Delete the Record","Warning!",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            try {
                String sql = "DELETE FROM `brand` WHERE id=?";
                pst=conn.prepareStatement(sql);
                pst.setInt(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Successfully Deleted Brand");
                showBrand();
                brand();
                txt_brand.setText("");
                buttonGroup1.clearSelection();
                txt_brand.requestFocus();
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_caddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_caddActionPerformed
        //CONFIRMATION
        int x = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Add Record?","AddRecord",JOptionPane.YES_NO_OPTION);
        if(x==0){
            
            if(txt_category.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "No Category Found!", "ATTENTION", JOptionPane.ERROR_MESSAGE);
                txt_category.requestFocus();
                getToolkit().beep();
                
            }else{
            
            try {
                String sql = "INSERT INTO category(category,status)VALUES(?,?)";
                pst=conn.prepareStatement(sql);
                pst.setString(1, txt_category.getText());
                pst.setString(2, stat);
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "Successfully Add Category");
                showCategory();
                category();
                txt_category.setText("");
                buttonGroup2.clearSelection();
                txt_category.requestFocus();
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        }
            }
        }
    }//GEN-LAST:event_btn_caddActionPerformed
String stat;
    private void jRadioButtonc_activeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonc_activeActionPerformed
        stat = "Active";
        if (jRadioButtonc_active.isSelected() == true) {
            jRadioButtonc_notactive.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonc_activeActionPerformed

    private void jRadioButtonc_notactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonc_notactiveActionPerformed
        stat = "Not Active";
        if (jRadioButtonc_notactive.isSelected() == true) {
            jRadioButtonc_active.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonc_notactiveActionPerformed

    private void jTable_CategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CategoryMouseClicked
        DefaultTableModel d = (DefaultTableModel)jTable_Category.getModel();
        int row = jTable_Category.getSelectedRow();
        txt_category.setText(d.getValueAt(row, 1).toString());
        String a = d.getValueAt(row, 2).toString();
        if("Active".equals(a)){
            jRadioButtonc_active.setSelected(true);
        }else if("Not Active".equals(a)){
            jRadioButtonc_notactive.setSelected(true);
        }    
    }//GEN-LAST:event_jTable_CategoryMouseClicked

    private void btn_ceditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ceditActionPerformed
        DefaultTableModel d = (DefaultTableModel)jTable_Category.getModel();
        int row = jTable_Category.getSelectedRow();
        int id = Integer.parseInt(d.getValueAt(row, 0).toString());
        
        int dialogResult = JOptionPane.showConfirmDialog(null,"Do You Want to Update the Record","Warning!",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            
            try {
                String sql = "UPDATE `category` SET `category`=?,`status`=? WHERE id=?";
                pst=conn.prepareStatement(sql);
                pst.setString(1, txt_category.getText());
                pst.setString(2, stat);
                pst.setInt(3, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Successfully Updated Category");
                showCategory();
                category();
                txt_category.setText("");
                buttonGroup2.clearSelection();
                txt_category.requestFocus();
            
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
            
        }
    }//GEN-LAST:event_btn_ceditActionPerformed

    private void btn_cdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cdeleteActionPerformed
        DefaultTableModel d = (DefaultTableModel)jTable_Category.getModel();
        int row = jTable_Category.getSelectedRow();
        int id = Integer.parseInt(d.getValueAt(row, 0).toString());
        
        int dialogResult = JOptionPane.showConfirmDialog(null,"Do You Want to Delete the Record","Warning!",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            try {
                String sql = "DELETE FROM `category` WHERE id=?";
                pst=conn.prepareStatement(sql);
                pst.setInt(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Successfully Deleted Category");
                showCategory();
                category();
                txt_category.setText("");
                buttonGroup2.clearSelection();
                txt_category.requestFocus();
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
        }
    }//GEN-LAST:event_btn_cdeleteActionPerformed
    private void clear(){
        txt_product.setText("");
        txt_description.setText("");
        cmb_brand.setSelectedIndex(-1);
        cmb_category.setSelectedIndex(-1);
        txt_costprice.setText("");
        txt_retailprice.setText("");
        txt_quantity.setText("");
        showBarcode();
        cmb_status.setSelectedItem("Select");
    }
    private void btnp_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnp_addActionPerformed
        Branditem b_item = (Branditem)cmb_brand.getSelectedItem();
        Categoryitem c_item = (Categoryitem)cmb_category.getSelectedItem();
        
        //CONFIRMATION
        int x = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Add Record?","AddRecord",JOptionPane.YES_NO_OPTION);
        if(x==0){
        
            if(txt_product.getText().isEmpty()){
                getToolkit().beep();
                JOptionPane.showMessageDialog(this, "No Product Found!", "ATTENTION", JOptionPane.ERROR_MESSAGE);
                txt_product.requestFocus();
                
    
            }else if(txt_description.getText().isEmpty()){
                getToolkit().beep();
                JOptionPane.showMessageDialog(this, "No Description Found!", "ATTENTION", JOptionPane.ERROR_MESSAGE);
                txt_description.requestFocus();
                
            
            }else if(txt_costprice.getText().isEmpty()){
                getToolkit().beep();
                JOptionPane.showMessageDialog(this, "No Costprice Found!", "ATTENTION", JOptionPane.ERROR_MESSAGE);
                txt_costprice.requestFocus();
                
                
            }else if(txt_retailprice.getText().isEmpty()){
                getToolkit().beep();
                JOptionPane.showMessageDialog(this, "No Retailprice Found!", "ATTENTION", JOptionPane.ERROR_MESSAGE);
                txt_retailprice.requestFocus();
                
            
            }else if(txt_quantity.getText().isEmpty()){
                getToolkit().beep();
                JOptionPane.showMessageDialog(this, "No Quantity Found!", "ATTENTION", JOptionPane.ERROR_MESSAGE);
                txt_quantity.requestFocus();
                
            
            }else if(cmb_status.getSelectedIndex()==0){
                getToolkit().beep();
                JOptionPane.showMessageDialog(this, "No Status Found!", "ATTENTION", JOptionPane.ERROR_MESSAGE);
                cmb_status.requestFocus();
                
            
            }else{
                
                
        try {
            String sql = "INSERT INTO product(product,description,brandid,categoryid,costprice,retailprice,quantity,barcode,status)"
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_product.getText());
            pst.setString(2, txt_description.getText());
            pst.setInt(3, b_item.id);
            pst.setInt(4, c_item.id);
            pst.setString(5, txt_costprice.getText());
            pst.setString(6, txt_retailprice.getText());
            pst.setString(7, txt_quantity.getText());
            pst.setString(8, txt_barcode.getText());
            pst.setString(9, cmb_status.getSelectedItem().toString());
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Successfully Add Product");
            showProduct();
            clear();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        }
        }
    }//GEN-LAST:event_btnp_addActionPerformed

    private void btnp_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnp_clearActionPerformed
        clear();
        showBarcode();
    }//GEN-LAST:event_btnp_clearActionPerformed

    private void jTable_ProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ProductMouseClicked
        DefaultTableModel d = (DefaultTableModel)jTable_Product.getModel();
        int row = jTable_Product.getSelectedRow();
        
        txt_product.setText(d.getValueAt(row, 1).toString());
        txt_description.setText(d.getValueAt(row, 2).toString());
        cmb_brand.setSelectedItem(d.getValueAt(row, 3).toString());
        cmb_category.setSelectedItem(d.getValueAt(row, 4).toString());
        txt_costprice.setText(d.getValueAt(row, 5).toString());  
        txt_retailprice.setText(d.getValueAt(row, 6).toString());  
        txt_quantity.setText(d.getValueAt(row, 7).toString());  
        txt_barcode.setText(d.getValueAt(row, 8).toString());  
        cmb_status.setSelectedItem(d.getValueAt(row, 9).toString());
        
    }//GEN-LAST:event_jTable_ProductMouseClicked

    private void btnp_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnp_editActionPerformed
        DefaultTableModel d = (DefaultTableModel)jTable_Product.getModel();
        int row = jTable_Product.getSelectedRow();
        
        int id = Integer.parseInt(d.getValueAt(row, 0).toString());
    int dialogResult = JOptionPane.showConfirmDialog(null,"Do You Want to Update the Record","Warning!",JOptionPane.YES_NO_OPTION);
    if(dialogResult == JOptionPane.YES_OPTION){
      
            
            try {
        
        String a = txt_product.getText();
        String b = txt_description.getText();
        Branditem bitem = (Branditem)cmb_brand.getSelectedItem();
        Categoryitem citem = (Categoryitem)cmb_category.getSelectedItem();
        String e = txt_costprice.getText();
        String f = txt_retailprice.getText();
        String g = txt_quantity.getText();
        String h = txt_barcode.getText();
        String i = cmb_status.getSelectedItem().toString();
            String sql = "UPDATE `product` SET "
                    + "`Product`=?,"
                    + "`Description`=?,"
                    + "`Brandid`=?,"
                    + "`Categoryid`=?,"
                    + "`Costprice`=?,"
                    + "`Retailprice`=?,"
                    + "`Quantity`=?,"
                    + "`Barcode`=?,`Status`=? WHERE id=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, a);
            pst.setString(2, b);
            pst.setInt(3,bitem.id);
            pst.setInt(4,citem.id);
            pst.setString(5, e);
            pst.setString(6, f);
            pst.setString(7, g);
            pst.setString(8, h);
            pst.setString(9, i);
            pst.setInt(10, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Successfully Updated Product");
            showProduct();
            clear();
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
        }
    }//GEN-LAST:event_btnp_editActionPerformed

    private void btnp_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnp_deleteActionPerformed
        DefaultTableModel d = (DefaultTableModel)jTable_Product.getModel();
        int row = jTable_Product.getSelectedRow();
        
        int id = Integer.parseInt(d.getValueAt(row, 0).toString());
          
    int dialogResult = JOptionPane.showConfirmDialog(null,"Do You Want to Delete the Record","Warning!",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
        try {
            String sql = "DELETE FROM `product` WHERE id=?";
            pst=conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Delete Product Successfully");
            showProduct();
            clear();
       
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
        }
    }//GEN-LAST:event_btnp_deleteActionPerformed

    private void txt_productcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_productcodeKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
            try {
                String data = "SELECT * FROM product WHERE barcode='"+txt_productcode.getText()+"'";
                pst=conn.prepareStatement(data);                
                rs=pst.executeQuery();
                if(rs.next()==false)
                {
                    JOptionPane.showMessageDialog(rootPane, "Barcode Not Found!");
                }else{
                    String productname = rs.getString("product");
                    txt_productname.setText(productname.trim());
                    String price = rs.getString("retailprice");
                    txt_price.setText(price.trim());                  
                }                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_txt_productcodeKeyPressed
    private void pos(){
        
        if(txt_qty.getText().isEmpty()){
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "No Quantity Found!", "ATTENTION", JOptionPane.ERROR_MESSAGE);
            txt_qty.requestFocus();
        }else{
      
    try {
        String sql = "SELECT * FROM product WHERE barcode='"+txt_productcode.getText()+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        while(rs.next()){
            int currentqty;
            currentqty = rs.getInt("quantity");
            
            int price = Integer.parseInt(txt_price.getText());
            int qtynew = Integer.parseInt(txt_qty.getText());
            
            int tot = price * qtynew;
            if(qtynew >= currentqty)
            {
            JOptionPane.showMessageDialog(rootPane,"Available Product"+"="+currentqty);
            JOptionPane.showMessageDialog(rootPane, "Quantity is Not Enough");
            }else{
                model = (DefaultTableModel)jTable_Sales.getModel();
                model.addRow(new Object[]
                {
                 txt_productcode.getText(),
                 txt_productname.getText(),
                 txt_price.getText(),
                 txt_qty.getText(),
                 tot,
                }
                );
                
                int sum = 0;
                for (int i = 0; i < jTable_Sales.getRowCount(); i++) 
                {
                    sum = sum + Integer.parseInt(jTable_Sales.getValueAt(i, 4).toString());
                }
                txt_subtotal.setText(Integer.toString(sum));
                
                txt_productcode.setText("");
                txt_productname.setText("");
                txt_price.setText("");
                txt_qty.setText("");
                txt_productcode.requestFocus();
            }           
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane,e);
    }
        }
}
    private void btns_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns_addActionPerformed
       pos();
       
    }//GEN-LAST:event_btns_addActionPerformed

    private void btns_removetagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns_removetagActionPerformed
        model.removeRow(jTable_Sales.getSelectedRow());
        int sum = 0;
        for (int i = 0; i < jTable_Sales.getRowCount(); i++){
            sum = sum + Integer.parseInt(jTable_Sales.getValueAt(i, 4).toString());
            }
                txt_subtotal.setText(Integer.toString(sum));
    }//GEN-LAST:event_btns_removetagActionPerformed
    //SALES METHOD
    private void salesrecord(){
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-d");
    LocalDateTime now = LocalDateTime.now();
    String date = dtf.format(now);
    
    
    String subtot = txt_subtotal.getText();    
    String pay = txt_pay.getText();
    String bal = txt_balance.getText();
    int lastinsertid = 0;
    
    try {
        String sql1 = "INSERT INTO salerecord(date,subtotal,pay,balance)VALUES(?,?,?,?)";
        pst=conn.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, date);
        pst.setString(2, subtot);
        pst.setString(3, pay);
        pst.setString(4, bal);
        pst.executeUpdate();
        ResultSet generatedKeyResultSet = pst.getGeneratedKeys();
        
        if(generatedKeyResultSet.next()){
            lastinsertid = generatedKeyResultSet.getInt(1);
        }
       
        int rows = jTable_Sales.getRowCount();
        
        String sql2 = "INSERT INTO sales(saleid,productid,sellprice,quantity,total)"
                + "VALUES(?,?,?,?,?)";
        pst=conn.prepareStatement(sql2);
        
        String product_id ="";        
        String price ="";
        String qty = "";
        int total = 0;
        
        for (int i = 0; i < jTable_Sales.getRowCount(); i++) 
        {
            product_id = (String)jTable_Sales.getValueAt(i, 0);
            price = (String)jTable_Sales.getValueAt(i, 2);
            qty = (String)jTable_Sales.getValueAt(i, 3);
            total = (int)jTable_Sales.getValueAt(i, 4);
            
            pst.setInt(1,lastinsertid);
            pst.setString(2, product_id);
            pst.setString(3, price);
            pst.setString(4, qty);
            pst.setInt(5, total);
            pst.executeUpdate();
        }
        
        String sql3 ="UPDATE product SET quantity= quantity-? WHERE barcode=?";
        pst=conn.prepareStatement(sql3);
        
        for (int i = 0; i < jTable_Sales.getRowCount(); i++) 
        {
            product_id = (String)jTable_Sales.getValueAt(i, 0);
            qty = (String)jTable_Sales.getValueAt(i, 3);
            
            pst.setString(1, qty);
            pst.setString(2, product_id);          
            pst.execute();
        }
       
        pst.addBatch();
        JOptionPane.showMessageDialog(rootPane,"Record Saved Successfully!");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane,e);
    }
}
    private void btns_payinvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns_payinvoiceActionPerformed
        int pay = Integer.parseInt(txt_pay.getText());
        int subtotal = Integer.parseInt(txt_subtotal.getText());
        int bal = pay - subtotal;
        
        txt_balance.setText(String.valueOf(bal));
        salesrecord();
        showSalesRecord();
        showSale();
        showdash();
        showProduct();
        btns_payinvoice.setEnabled(false);
    }//GEN-LAST:event_btns_payinvoiceActionPerformed

    private void txt_payKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_payKeyReleased
       btns_payinvoice.setEnabled(true);
    }//GEN-LAST:event_txt_payKeyReleased
    //BARCODE ID
    private void showBarcode(){
    Random ra = new Random();
    txt_barcode.setText(""+ra.nextInt(10000+1));
    }
    
    //COMBOBRAND
    private void brand(){
        try {
            String sql = "SELECT * FROM brand";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            cmb_brand.removeAllItems();
            while(rs.next()){
                cmb_brand.addItem(new Branditem(rs.getInt(1),rs.getString(2)));
            }        
        } catch (Exception e) {
        }
    } 
    
    //COMBOCATEGORY
    private void category(){
        try {
            String sql = "SELECT * FROM category";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            cmb_category.removeAllItems();        
            while(rs.next()){
            cmb_category.addItem(new Categoryitem(rs.getInt(1),rs.getString(2)) );
            }        
        } catch (Exception e) {
        }  
    } 
    
    //BRAND METHOD
    public class Branditem{
        int id;
        String name;

        public Branditem(int id, String name) {
            this.id = id;
            this.name = name;
        }       
        public String toString(){
            return name;
        }        
    }
    
    //CATEGORY METHOD
    public class Categoryitem {
        int id;
        String name;
    
        public Categoryitem(int id, String name){
            this.id = id;
            this.name = name;
         }
        public String toString(){
            return name;
        }
    }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BTN1;
    private javax.swing.JPanel BTN2;
    private javax.swing.JPanel BTN3;
    private javax.swing.JPanel BTN4;
    private javax.swing.JPanel BTN5;
    private javax.swing.JPanel BTN6;
    private javax.swing.JLabel Date;
    private javax.swing.JButton Exit;
    private javax.swing.JPanel PN1;
    private javax.swing.JPanel PN2;
    private javax.swing.JPanel PN3;
    private javax.swing.JPanel PN4;
    private javax.swing.JPanel PN5;
    private javax.swing.JPanel PN6;
    private javax.swing.JLabel Time;
    private javax.swing.JPanel brand;
    private rojerusan.RSMaterialButtonRectangle btn_add;
    private rojerusan.RSMaterialButtonRectangle btn_cadd;
    private rojerusan.RSMaterialButtonRectangle btn_cdelete;
    private rojerusan.RSMaterialButtonRectangle btn_cedit;
    private rojerusan.RSMaterialButtonRectangle btn_delete;
    private rojerusan.RSMaterialButtonRectangle btn_edit;
    private rojerusan.RSMaterialButtonRectangle btnp_add;
    private rojerusan.RSMaterialButtonRectangle btnp_clear;
    private rojerusan.RSMaterialButtonRectangle btnp_delete;
    private rojerusan.RSMaterialButtonRectangle btnp_edit;
    private rojerusan.RSMaterialButtonRectangle btns_add;
    private rojerusan.RSMaterialButtonRectangle btns_payinvoice;
    private rojerusan.RSMaterialButtonRectangle btns_removetag;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel cardpanel;
    private javax.swing.JPanel category;
    private javax.swing.JComboBox cmb_brand;
    private javax.swing.JComboBox cmb_category;
    private javax.swing.JComboBox<String> cmb_status;
    public static javax.swing.JLabel count1;
    public static javax.swing.JLabel count2;
    public static javax.swing.JLabel count3;
    public static javax.swing.JLabel count4;
    public static javax.swing.JLabel count5;
    private javax.swing.JPanel dashboard;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JRadioButton jRadioButton_Active;
    private javax.swing.JRadioButton jRadioButton_NotActive;
    private javax.swing.JRadioButton jRadioButtonc_active;
    private javax.swing.JRadioButton jRadioButtonc_notactive;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable_Brand;
    private javax.swing.JTable jTable_Category;
    private javax.swing.JTable jTable_Product;
    private javax.swing.JTable jTable_Sale;
    private javax.swing.JTable jTable_Sales;
    private javax.swing.JTable jTable_SalesRecord;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label22;
    private javax.swing.JLabel label33;
    private javax.swing.JLabel label44;
    private javax.swing.JLabel label55;
    private javax.swing.JLabel label66;
    public javax.swing.JLabel label_user;
    private javax.swing.JPanel panelboard;
    private javax.swing.JPanel panelhead;
    private javax.swing.JPanel product;
    private javax.swing.JPanel sales;
    private javax.swing.JPanel sidebar;
    private LIB.FSTexFieldMD txt_balance;
    private LIB.FSTexFieldMD txt_barcode;
    private LIB.FSTexFieldMD txt_brand;
    private LIB.FSTexFieldMD txt_category;
    private LIB.FSTexFieldMD txt_costprice;
    private javax.swing.JTextArea txt_description;
    private LIB.FSTexFieldMD txt_pay;
    private LIB.FSTexFieldMD txt_price;
    private LIB.FSTexFieldMD txt_product;
    private LIB.FSTexFieldMD txt_productcode;
    private LIB.FSTexFieldMD txt_productname;
    private LIB.FSTexFieldMD txt_qty;
    private LIB.FSTexFieldMD txt_quantity;
    private LIB.FSTexFieldMD txt_retailprice;
    private LIB.FSTexFieldMD txt_subtotal;
    // End of variables declaration//GEN-END:variables

    
    //BRAND
    private void showBrand(){
        int c;
        try {
            String sql ="SELECT * FROM brand";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            c = rsmd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel)jTable_Brand.getModel();
            d.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for (int i = 0; i <=c; i++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("brand"));
                    v2.add(rs.getString("status"));
                }
                d.addRow(v2);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,e);
        }
    }

    //CATEGORY
    private void showCategory(){
        int c;
        try {
            String sql ="SELECT * FROM category";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            c = rsmd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel)jTable_Category.getModel();
            d.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for (int i = 0; i <=c; i++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("category"));
                    v2.add(rs.getString("status"));
                }
                d.addRow(v2);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,e);
        }
    }
    
    
    private void showProduct(){
        int c;
        try {
            String sql ="SELECT p.id, p.Product, p.Description, c.category, b.brand, p.Costprice, p.Retailprice, p.Quantity, p.Barcode, p.Status\n" +
            "FROM product p, brand b, category c "
                    + "WHERE p.categoryid = c.id AND p.brandid = b.id";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            c = rsmd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel)jTable_Product.getModel();
            d.setRowCount(0);
            while(rs.next())
            {
                Vector v2 = new Vector();
                for (int i = 0; i <=c; i++) 
                {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("product"));
                    v2.add(rs.getString("description"));                                     
                    v2.add(rs.getString("brand"));
                    v2.add(rs.getString("category"));
                    v2.add(rs.getString("costprice"));
                    v2.add(rs.getString("retailprice"));
                    v2.add(rs.getString("quantity"));
                    v2.add(rs.getString("barcode"));
                    v2.add(rs.getString("status"));                    
                }
                d.addRow(v2);
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,e);
        }
        
        //COUNT1
        try {
            String sql = "SELECT COUNT(*) FROM product";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            count1.setText(rs.getString(1));
        } catch (Exception e) {
        }
        
          //COUNT2
        try {
            String sql = "SELECT SUM(quantity) AS Quantity FROM product";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            count2.setText(rs.getString("quantity"));
        } catch (Exception e) {
        }
        
        //COUNT3
        try {
            String sql = "SELECT SUM(costprice) AS Costprice FROM product";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            count3.setText(rs.getString("Costprice"));
        } catch (Exception e) {
        }
        
    }
    
    //SALES RECORD
    private void showSalesRecord(){
        int c;
        try {
            String sql ="SELECT * FROM salerecord";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            c = rsmd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel)jTable_SalesRecord.getModel();
            d.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for (int i = 0; i <=c; i++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("date"));
                    v2.add(rs.getString("subtotal"));
                    v2.add(rs.getString("pay"));
                    v2.add(rs.getString("balance"));                    
                }
                d.addRow(v2);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,e);
        }
        
        //COUNT5
        try {
            String sql = "SELECT COUNT(*) FROM salerecord";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            count5.setText(rs.getString(1));
        } catch (Exception e) {
        }
    }
    
     //SALES RECORD
    private void showSale(){
        int c;
        try {
            String sql ="SELECT * FROM sales";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            c = rsmd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel)jTable_Sale.getModel();
            d.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for (int i = 0; i <=c; i++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("saleid"));
                    v2.add(rs.getString("productid"));
                    v2.add(rs.getString("sellprice"));
                    v2.add(rs.getString("quantity"));
                    v2.add(rs.getString("total"));                    
                }
                d.addRow(v2);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,e);
        }
        
        //COUNT4
        try {
            String sql = "SELECT COUNT(*) FROM sales";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            count4.setText(rs.getString(1));
        } catch (Exception e) {
        }
       
    }
    
    private void showdash(){
        try {
            String sql ="SELECT ID,Date,Subtotal,Pay,Balance FROM salerecord";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }
    }
      
}
