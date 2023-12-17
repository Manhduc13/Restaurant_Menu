package View;

import Model.Dish;
import Model.Origin;
import Service.Dish_Service;
import Service.Origin_Service;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {
    Dish_Service dishService = new Dish_Service();
    Origin_Service originService = new Origin_Service();
    DefaultTableModel AppetizerTableModel;
    DefaultTableModel MainCourseTableModel;
    DefaultTableModel DessertTableModel;
    DefaultTableModel DrinkTableModel;
    DefaultTableModel AllDishTableModel;
    DefaultComboBoxModel AppetizerComboBoxModel;
    DefaultComboBoxModel MainCourseComboBoxModel;
    DefaultComboBoxModel DessertComboBoxModel;
    DefaultComboBoxModel DrinkComboBoxModel;
    DefaultComboBoxModel AllComboBoxModel;
    
    public MainFrame() throws SQLException {
        initComponents();
        this.AppetizerComboBoxModel = new DefaultComboBoxModel();
        this.MainCourseComboBoxModel = new DefaultComboBoxModel();
        this.DessertComboBoxModel = new DefaultComboBoxModel();
        this.DrinkComboBoxModel = new DefaultComboBoxModel();
        this.AllComboBoxModel = new DefaultComboBoxModel();
//================= SET UP DATA FOR APPETIZER TABLE ================================
        this.AppetizerTableModel  = new DefaultTableModel(){
             @Override
             public boolean isCellEditable(int row, int column) {
                return false;
             }
        };
        AppetizerTable.setModel(AppetizerTableModel);
        AppetizerTableModel.addColumn("ID");
        AppetizerTableModel.addColumn("Name");
        AppetizerTableModel.addColumn("Price");
        
        
        List<Dish> appetizerDishes  = dishService.getDishesByCategory(1);
        
        for(Dish dish :  appetizerDishes){
            AppetizerTableModel.addRow(new Object[] {dish.getId(), dish.getName(), dish.getPrice()});
        }
        
        AppetizerOrigin.setModel(AppetizerComboBoxModel);
        List<Origin> appetizerOrigin = originService.getOriginOfCategory(1);
        for(Origin origin : appetizerOrigin){
            AppetizerOrigin.addItem(origin);
        }
        
        AppetizerTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 2 ) {
                   int selectedRow = AppetizerTable.getSelectedRow();
                   int dishID = (int) AppetizerTable.getValueAt(selectedRow, 0);
                   try {
                       new DishDetailFrame(dishID).setVisible(true);
                   } catch (SQLException ex) {
                       Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           }
        });
//================= SET UP DATA FOR MAIN COURSE TABLE =============================  
        this.MainCourseTableModel  = new DefaultTableModel(){
             @Override
             public boolean isCellEditable(int row, int column) {
                return false;
             }
        };
        MainCourseTable.setModel(MainCourseTableModel);
        MainCourseTableModel.addColumn("ID");
        MainCourseTableModel.addColumn("Name");
        MainCourseTableModel.addColumn("Price");
        
        
        List<Dish> mainCourseDishes  = dishService.getDishesByCategory(2);
        
        for(Dish dish :  mainCourseDishes){
            MainCourseTableModel.addRow(new Object[] {dish.getId(), dish.getName(), dish.getPrice()});
        }
        
        MainCourseOrigin.setModel(MainCourseComboBoxModel);
        List<Origin> mainCourseOrigin = originService.getOriginOfCategory(2);
        for(Origin origin : mainCourseOrigin){
            MainCourseOrigin.addItem(origin);
        }
        
        MainCourseTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 2 ) {
                   int selectedRow = MainCourseTable.getSelectedRow();
                   int dishID = (int) MainCourseTable.getValueAt(selectedRow, 0);
                   try {
                       new DishDetailFrame(dishID).setVisible(true);
                   } catch (SQLException ex) {
                       Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           }
        });
//================= SET UP DATA FOR DESSERT TABLE =================================        
        this.DessertTableModel  = new DefaultTableModel(){
             @Override
             public boolean isCellEditable(int row, int column) {
                return false;
             }
        };
        DessertTable.setModel(DessertTableModel);
        DessertTableModel.addColumn("ID");
        DessertTableModel.addColumn("Name");
        DessertTableModel.addColumn("Price");
        
        List<Dish> dessertDishes  = dishService.getDishesByCategory(3);
        
        for(Dish dish :  dessertDishes){
            DessertTableModel.addRow(new Object[] {dish.getId(), dish.getName(), dish.getPrice()});
        }
        
        DessertOrigin.setModel(DessertComboBoxModel);
        List<Origin> dessertOrigin = originService.getOriginOfCategory(3);
        for(Origin origin : dessertOrigin){
            DessertOrigin.addItem(origin);
        }
        
        DessertTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 2 ) {
                   int selectedRow = DessertTable.getSelectedRow();
                   int dishID = (int) DessertTable.getValueAt(selectedRow, 0);
                   try {
                       new DishDetailFrame(dishID).setVisible(true);
                   } catch (SQLException ex) {
                       Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           }
        });
//================= SET UP DATA FOR DRINK TABLE =================================== 
        this.DrinkTableModel  = new DefaultTableModel(){
             @Override
             public boolean isCellEditable(int row, int column) {
                return false;
             }
        };
        DrinkTable.setModel(DrinkTableModel);
        DrinkTableModel.addColumn("ID");
        DrinkTableModel.addColumn("Name");
        DrinkTableModel.addColumn("Price");
        
        List<Dish> drinks  = dishService.getDishesByCategory(4);
        
        for(Dish dish :  drinks){
            DrinkTableModel.addRow(new Object[] {dish.getId(), dish.getName(), dish.getPrice()});
        }
        
        DrinkOrigin.setModel(DrinkComboBoxModel);
        List<Origin> drinkOrigin = originService.getOriginOfCategory(4);
        for(Origin origin : drinkOrigin){
            DrinkOrigin.addItem(origin);
        }
        
        DrinkTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 2 ) {
                   int selectedRow = DrinkTable.getSelectedRow();
                   int dishID = (int) DrinkTable.getValueAt(selectedRow, 0);
                   try {
                       new DishDetailFrame(dishID).setVisible(true);
                   } catch (SQLException ex) {
                       Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           }
        });
//================= SET UP DATA FOR ALL DISHES TABLE ===============================
        this.AllDishTableModel  = new DefaultTableModel(){
             @Override
             public boolean isCellEditable(int row, int column) {
                return false;
             }
        };
        AllDishTable.setModel(AllDishTableModel);
        AllDishTableModel.addColumn("ID");
        AllDishTableModel.addColumn("Name");
        AllDishTableModel.addColumn("Price");
        
        List<Dish> allDishes = dishService.getAllDish();
        
        for(Dish dish :  allDishes){
            AllDishTableModel.addRow(new Object[] {dish.getId(), dish.getName(), dish.getPrice()});
        }
        
        AllOrigin.setModel(AllComboBoxModel);
        List<Origin> allOrigins = originService.getAllOrigin();
        for(Origin origin : allOrigins){
            AllOrigin.addItem(origin);
        }
        
        AllDishTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 2 ) {
                   int selectedRow = AllDishTable.getSelectedRow();
                   int dishID = (int) AllDishTable.getValueAt(selectedRow, 0);
                   try {
                       new DishDetailFrame(dishID).setVisible(true);
                   } catch (SQLException ex) {
                       Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           }
        });
        
//================= SET UP DATA FOR TABLES ========================================
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonPanel = new javax.swing.JPanel();
        MainCoursesButton = new javax.swing.JButton();
        DessertsButton = new javax.swing.JButton();
        AppetizersButton = new javax.swing.JButton();
        DrinksButton = new javax.swing.JButton();
        LogoImage = new javax.swing.JLabel();
        AllDishButton = new javax.swing.JButton();
        MainPanel = new javax.swing.JPanel();
        AppetizerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AppetizerTable = new javax.swing.JTable();
        AllAppetizerButton = new javax.swing.JButton();
        AppetizerOrigin = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        MainCoursePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MainCourseTable = new javax.swing.JTable();
        AllMainCourseButotn = new javax.swing.JButton();
        MainCourseOrigin = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        DessertPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        DessertTable = new javax.swing.JTable();
        AllDessertButton = new javax.swing.JButton();
        DessertOrigin = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DrinkPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        DrinkTable = new javax.swing.JTable();
        AllDrinkButton = new javax.swing.JButton();
        DrinkOrigin = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        AllDishPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        AllDishTable = new javax.swing.JTable();
        AllOrigin = new javax.swing.JComboBox<>();
        AllButton = new javax.swing.JButton();
        HeaderPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("MainFrame"); // NOI18N

        ButtonPanel.setBackground(new java.awt.Color(255, 255, 255));

        MainCoursesButton.setText("Main Course");
        MainCoursesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainCoursesButtonActionPerformed(evt);
            }
        });

        DessertsButton.setText("Dessert");
        DessertsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DessertsButtonActionPerformed(evt);
            }
        });

        AppetizersButton.setText("Appetizer");
        AppetizersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppetizersButtonActionPerformed(evt);
            }
        });

        DrinksButton.setText("Drink");
        DrinksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrinksButtonActionPerformed(evt);
            }
        });

        LogoImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logo12.png"))); // NOI18N

        AllDishButton.setText("All Dishes");
        AllDishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllDishButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButtonPanelLayout = new javax.swing.GroupLayout(ButtonPanel);
        ButtonPanel.setLayout(ButtonPanelLayout);
        ButtonPanelLayout.setHorizontalGroup(
            ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPanelLayout.createSequentialGroup()
                .addComponent(LogoImage)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AllDishButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ButtonPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MainCoursesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AppetizersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DessertsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DrinksButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(16, 16, 16))
        );
        ButtonPanelLayout.setVerticalGroup(
            ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPanelLayout.createSequentialGroup()
                .addComponent(LogoImage)
                .addGap(44, 44, 44)
                .addComponent(AppetizersButton)
                .addGap(30, 30, 30)
                .addComponent(MainCoursesButton)
                .addGap(30, 30, 30)
                .addComponent(DessertsButton)
                .addGap(30, 30, 30)
                .addComponent(DrinksButton)
                .addGap(30, 30, 30)
                .addComponent(AllDishButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MainPanel.setLayout(new java.awt.CardLayout());

        AppetizerPanel.setBackground(new java.awt.Color(255, 255, 255));

        AppetizerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        AppetizerTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        AppetizerTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(AppetizerTable);

        AllAppetizerButton.setText("All Dish");
        AllAppetizerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllAppetizerButtonActionPerformed(evt);
            }
        });

        AppetizerOrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppetizerOriginActionPerformed(evt);
            }
        });

        jLabel2.setText("Search by origin");

        javax.swing.GroupLayout AppetizerPanelLayout = new javax.swing.GroupLayout(AppetizerPanel);
        AppetizerPanel.setLayout(AppetizerPanelLayout);
        AppetizerPanelLayout.setHorizontalGroup(
            AppetizerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AppetizerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(AppetizerOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AllAppetizerButton)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );
        AppetizerPanelLayout.setVerticalGroup(
            AppetizerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AppetizerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AppetizerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AllAppetizerButton)
                    .addComponent(AppetizerOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        );

        MainPanel.add(AppetizerPanel, "card2");

        MainCoursePanel.setBackground(new java.awt.Color(255, 255, 255));

        MainCourseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        MainCourseTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        MainCourseTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(MainCourseTable);

        AllMainCourseButotn.setText("All Dish");
        AllMainCourseButotn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllMainCourseButotnActionPerformed(evt);
            }
        });

        MainCourseOrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainCourseOriginActionPerformed(evt);
            }
        });

        jLabel3.setText("Search by origin");

        javax.swing.GroupLayout MainCoursePanelLayout = new javax.swing.GroupLayout(MainCoursePanel);
        MainCoursePanel.setLayout(MainCoursePanelLayout);
        MainCoursePanelLayout.setHorizontalGroup(
            MainCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainCoursePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(MainCourseOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AllMainCourseButotn)
                .addContainerGap())
        );
        MainCoursePanelLayout.setVerticalGroup(
            MainCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainCoursePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AllMainCourseButotn)
                    .addComponent(MainCourseOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        );

        MainPanel.add(MainCoursePanel, "card3");

        DessertPanel.setBackground(new java.awt.Color(255, 255, 255));

        DessertTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        DessertTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        DessertTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(DessertTable);

        AllDessertButton.setText("All Dish");
        AllDessertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllDessertButtonActionPerformed(evt);
            }
        });

        DessertOrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DessertOriginActionPerformed(evt);
            }
        });

        jLabel4.setText("Tìm kiếm theo nguồn gốc:");

        jLabel5.setText("Search by origin");

        javax.swing.GroupLayout DessertPanelLayout = new javax.swing.GroupLayout(DessertPanel);
        DessertPanel.setLayout(DessertPanelLayout);
        DessertPanelLayout.setHorizontalGroup(
            DessertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DessertPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(DessertOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AllDessertButton)
                .addContainerGap())
            .addGroup(DessertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DessertPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        DessertPanelLayout.setVerticalGroup(
            DessertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DessertPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DessertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AllDessertButton)
                    .addComponent(DessertOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
            .addGroup(DessertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DessertPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        MainPanel.add(DessertPanel, "card4");

        DrinkPanel.setBackground(new java.awt.Color(255, 255, 255));

        DrinkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        DrinkTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        DrinkTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(DrinkTable);

        AllDrinkButton.setText("All Dish");
        AllDrinkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllDrinkButtonActionPerformed(evt);
            }
        });

        DrinkOrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrinkOriginActionPerformed(evt);
            }
        });

        jLabel6.setText("Search by origin");

        javax.swing.GroupLayout DrinkPanelLayout = new javax.swing.GroupLayout(DrinkPanel);
        DrinkPanel.setLayout(DrinkPanelLayout);
        DrinkPanelLayout.setHorizontalGroup(
            DrinkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DrinkPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(DrinkOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AllDrinkButton)
                .addContainerGap())
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );
        DrinkPanelLayout.setVerticalGroup(
            DrinkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DrinkPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DrinkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AllDrinkButton)
                    .addComponent(DrinkOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        );

        MainPanel.add(DrinkPanel, "card5");

        AllDishPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Search by origin");

        AllDishTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(AllDishTable);

        AllOrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllOriginActionPerformed(evt);
            }
        });

        AllButton.setText("All Dish");
        AllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AllDishPanelLayout = new javax.swing.GroupLayout(AllDishPanel);
        AllDishPanel.setLayout(AllDishPanelLayout);
        AllDishPanelLayout.setHorizontalGroup(
            AllDishPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllDishPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(AllOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AllButton)
                .addContainerGap())
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );
        AllDishPanelLayout.setVerticalGroup(
            AllDishPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllDishPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AllDishPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(AllOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AllButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        );

        MainPanel.add(AllDishPanel, "card6");

        HeaderPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("MENU");

        javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderPanelLayout.setVerticalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(HeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AppetizersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppetizersButtonActionPerformed
        CardLayout cardLayout = (CardLayout) MainPanel.getLayout();
        cardLayout.show(MainPanel, "card2");
    }//GEN-LAST:event_AppetizersButtonActionPerformed

    private void MainCoursesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainCoursesButtonActionPerformed
        CardLayout cardLayout = (CardLayout) MainPanel.getLayout();
        cardLayout.show(MainPanel, "card3");
    }//GEN-LAST:event_MainCoursesButtonActionPerformed

    private void DessertsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DessertsButtonActionPerformed
        CardLayout cardLayout = (CardLayout) MainPanel.getLayout();
        cardLayout.show(MainPanel, "card4");  
    }//GEN-LAST:event_DessertsButtonActionPerformed

    private void DrinksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DrinksButtonActionPerformed
        CardLayout cardLayout = (CardLayout) MainPanel.getLayout();
        cardLayout.show(MainPanel, "card5");   
    }//GEN-LAST:event_DrinksButtonActionPerformed

    private void AllAppetizerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllAppetizerButtonActionPerformed
        try {
            AppetizerTableModel.setRowCount(0);
            List<Dish> appetizerDishes  = dishService.getDishesByCategory(1);
            
            for(Dish dish :  appetizerDishes){
                AppetizerTableModel.addRow(new Object[] {dish.getId(), dish.getName(), dish.getPrice()});
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AllAppetizerButtonActionPerformed

    private void AllMainCourseButotnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllMainCourseButotnActionPerformed
        try {
            MainCourseTableModel.setRowCount(0);
            List<Dish> appetizerDishes  = dishService.getDishesByCategory(2);
            
            for(Dish dish :  appetizerDishes){
                MainCourseTableModel.addRow(new Object[] {dish.getId(), dish.getName(), dish.getPrice()});
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AllMainCourseButotnActionPerformed

    private void AllDessertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllDessertButtonActionPerformed
        try {
            DessertTableModel.setRowCount(0);
            List<Dish> appetizerDishes  = dishService.getDishesByCategory(3);
            
            for(Dish dish :  appetizerDishes){
                DessertTableModel.addRow(new Object[] {dish.getId(), dish.getName(), dish.getPrice()});
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AllDessertButtonActionPerformed

    private void AllDrinkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllDrinkButtonActionPerformed
        try {
            DrinkTableModel.setRowCount(0);
            List<Dish> appetizerDishes  = dishService.getDishesByCategory(4);
            
            for(Dish dish :  appetizerDishes){
                DrinkTableModel.addRow(new Object[] {dish.getId(), dish.getName(), dish.getPrice()});
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AllDrinkButtonActionPerformed

    private void AppetizerOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppetizerOriginActionPerformed
        Origin origin = (Origin) AppetizerOrigin.getSelectedItem();
        int originID = origin.getId();
        try {
            AppetizerTableModel.setRowCount(0);
            List<Dish> appetizerDishes  = dishService.getDishByOriginOfCategory(originID, 1);
            
            for(Dish dish :  appetizerDishes){
                AppetizerTableModel.addRow(new Object[] {dish.getId(), dish.getName(), dish.getPrice()});
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AppetizerOriginActionPerformed

    private void MainCourseOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainCourseOriginActionPerformed
        Origin origin = (Origin) MainCourseOrigin.getSelectedItem();
        int originID = origin.getId();
        try {
            MainCourseTableModel.setRowCount(0);
            List<Dish> mainCourses  = dishService.getDishByOriginOfCategory(originID, 2);
            
            for(Dish dish :  mainCourses){
                MainCourseTableModel.addRow(new Object[] {dish.getId(), dish.getName(), dish.getPrice()});
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MainCourseOriginActionPerformed

    private void DessertOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DessertOriginActionPerformed
        Origin origin = (Origin) DessertOrigin.getSelectedItem();
        int originID = origin.getId();
        try {
            DessertTableModel.setRowCount(0);
            List<Dish> desserts  = dishService.getDishByOriginOfCategory(originID, 3);
            
            for(Dish dish :  desserts){
                DessertTableModel.addRow(new Object[] {dish.getId(), dish.getName(), dish.getPrice()});
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DessertOriginActionPerformed

    private void DrinkOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DrinkOriginActionPerformed
        Origin origin = (Origin) DrinkOrigin.getSelectedItem();
        int originID = origin.getId();
        try {
            DrinkTableModel.setRowCount(0);
            List<Dish> drinks  = dishService.getDishByOriginOfCategory(originID, 4);
            
            for(Dish dish :  drinks){
                DrinkTableModel.addRow(new Object[] {dish.getId(), dish.getName(), dish.getPrice()});
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DrinkOriginActionPerformed

    private void AllDishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllDishButtonActionPerformed
        CardLayout cardLayout = (CardLayout) MainPanel.getLayout();
        cardLayout.show(MainPanel, "card6");
    }//GEN-LAST:event_AllDishButtonActionPerformed

    private void AllOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllOriginActionPerformed
        Origin origin = (Origin) AllOrigin.getSelectedItem();
        int originID = origin.getId();
        try {
            AllDishTableModel.setRowCount(0);
            List<Dish> allDishes  = dishService.getDishByOrigin(originID);
            
            for(Dish dish :  allDishes){
                AllDishTableModel.addRow(new Object[] {dish.getId(), dish.getName(), dish.getPrice()});
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AllOriginActionPerformed

    private void AllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllButtonActionPerformed
        try {
            AllDishTableModel.setRowCount(0);
            List<Dish> allDishes  = dishService.getAllDish();
            
            for(Dish dish :  allDishes){
                AllDishTableModel.addRow(new Object[] {dish.getId(), dish.getName(), dish.getPrice()});
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AllButtonActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AllAppetizerButton;
    private javax.swing.JButton AllButton;
    private javax.swing.JButton AllDessertButton;
    private javax.swing.JButton AllDishButton;
    private javax.swing.JPanel AllDishPanel;
    private javax.swing.JTable AllDishTable;
    private javax.swing.JButton AllDrinkButton;
    private javax.swing.JButton AllMainCourseButotn;
    private javax.swing.JComboBox<Origin> AllOrigin;
    private javax.swing.JComboBox<Origin> AppetizerOrigin;
    private javax.swing.JPanel AppetizerPanel;
    private javax.swing.JTable AppetizerTable;
    private javax.swing.JButton AppetizersButton;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JComboBox<Origin> DessertOrigin;
    private javax.swing.JPanel DessertPanel;
    private javax.swing.JTable DessertTable;
    private javax.swing.JButton DessertsButton;
    private javax.swing.JComboBox<Origin> DrinkOrigin;
    private javax.swing.JPanel DrinkPanel;
    private javax.swing.JTable DrinkTable;
    private javax.swing.JButton DrinksButton;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JLabel LogoImage;
    private javax.swing.JComboBox<Origin> MainCourseOrigin;
    private javax.swing.JPanel MainCoursePanel;
    private javax.swing.JTable MainCourseTable;
    private javax.swing.JButton MainCoursesButton;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
