/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
import java.io.*;
import DrinkPackage.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
/**
 *Name: Stanley Tantysco
 * Binusian ID: 2201814670
 * Coffee/Tea Shop JFrame Application
 */
//Main Menu class
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    private Drink d;ColdDrink cd;HotDrink hd;//declare object ref variables
    private OrderList olist = new OrderList();//create new order list object
    private OrderQueue oq = new OrderQueue();//create new order queue object
    //Menu List (Start)
    //Cold Coffee
    private final ColdDrink coldcappu = new ColdDrink("Ice Cappuccino",40000);//ice cappucino object
    private final ColdDrink coldmoc = new ColdDrink("Ice Mocha",35000);//ice mocha object
    private final ColdDrink coldameri = new ColdDrink("Ice  Americano",45000);//ice americano object
    private final ColdDrink coldesp = new ColdDrink("Ice Espresso", 30000);//ice espresso object
    private final ColdDrink coldcaflat = new ColdDrink("Ice Caffe Latte",33000);//ice caffe latte object
    private final ColdDrink coldvanilla= new ColdDrink("Ice Vanilla Latte",36000);//ice  vanilla latte object
    private final ColdDrink coldfrap= new ColdDrink("Ice Frappuccino", 42000);//ice frappucino object
    //Hot Coffee
    private final HotDrink hotcappu = new HotDrink("Hot Cappuccino",30000);//hot cappucino object
    private final HotDrink hotmoc = new HotDrink("Hot Mocha",25000);//hot mocha object
    private final HotDrink hotameri = new HotDrink("Hot Americano",35000);//hot americano object
    private final HotDrink hotesp = new HotDrink("Hot Espresso",20000);//hot espresso object
    private final HotDrink hotcaflat = new HotDrink("Hot Caffe Latte",23000);//hot caffe latte object
    private final HotDrink hotvanilla = new HotDrink("Hot Vanilla Latte",26000);//hot vanilla latte object
    //Cold Tea
    private final ColdDrink coldmt = new ColdDrink("Ice Milk Tea",22000);//ice milk tea object
    private final ColdDrink coldmat = new ColdDrink("Ice Matcha Milk Tea",25000);//ice matcha milk tea object
    private final ColdDrink coldbtea = new ColdDrink("Ice Black Milk Tea", 28000);//ice black milk tea object
    private final ColdDrink coldmantea = new ColdDrink("Ice Mango Tea",30000);//ice mango tea object
    private final ColdDrink coldpeach = new ColdDrink("Ice Peach Tea",32000);//ice peach tea object
    private final ColdDrink coldtaro = new ColdDrink("Ice Taro Milk Tea", 34000);//ice taro milk tea object
    private final ColdDrink coldchoco = new ColdDrink("Ice Chocolate Milk Tea",36000);//ice chocolate milk tea object
    private final ColdDrink coldvantea = new ColdDrink("Ice Vanilla Milk Tea",35000);//ice vanilla milk tea object
    //Hot Tea
    private final HotDrink hotmt = new HotDrink("Hot Milk Tea",18000);//hot milk tea object
    private final HotDrink hotmat= new HotDrink("Hot Matcha Milk Tea",20000);//hot matcha milk tea object
    private final HotDrink hotbtea = new HotDrink("Hot Black Milk Tea",23000);//hot black milk tea object
    private final HotDrink hotmantea = new HotDrink("Hot Mango Tea",25000);//hot mango tea object
    private final HotDrink hotpeach = new HotDrink("Hot Peach Tea",27000);//hot peach tea object
    private final HotDrink hotmatlat = new HotDrink("Hot Matcha Tea Latte",30000);//hot matcha tea latte object
    private final HotDrink hotblat = new HotDrink("Hot Black Tea Latte",33000);//hot black tea latte object
    //Menu List (End)
    // add drink object into rows of table method
    public void addtoRowTable(Drink d){
        DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();//get model of Order Table
        Object rowdata[] = new Object[7];//create new object of 7 rows
        //to check whether drink object is Cold Drink or Hot Drink
        if(d instanceof ColdDrink){
            cd = (ColdDrink) d;//refer it to Cold Drink object
            rowdata[0]=cd.getName();//set into name row of object
            rowdata[1]=String.valueOf(cd.getquantity())+"X";//set into quantity row of object
            rowdata[2]=cd.getSize();//set into size row of object
            rowdata[3]=cd.getsugar();//set into sugar row of object
            rowdata[4]=cd.getice();//set into ice row of object
            rowdata[5]=cd.getTopping();//set into topping name row of object
            rowdata[6]=cd.getTotal();//add into total price row of object
            model.addRow(rowdata);//add row object into Order Table
        }
        else if(d instanceof HotDrink){
            hd = (HotDrink) d;//refer it to Hot Drink object
            rowdata[0]=hd.getName();//set into name row of object
            rowdata[1]=String.valueOf(hd.getquantity())+"X";//set into quantity row of object
            rowdata[2]=hd.getSize();//set into size row of object
            rowdata[3]=hd.getsugar();//set into sugar row of object
            rowdata[4]="-";//set into ice row of object
            rowdata[5]="-";//set into topping name row of object
            rowdata[6]=hd.getTotal();//add into total price row of object
            model.addRow(rowdata);//add row object into Order Table
        }
    }
    //clear table method
    public void clearTable(DefaultTableModel m){
        DefaultTableModel model =m;//get model of table
        model.setRowCount(0);//set row count of table into 0 to clear itself
    }
    //add all drink objects from order list into rows of table method
    public void AddAllRowTable(DefaultTableModel m){
        DefaultTableModel model = m;//get model of table
        Object rowdata[] = new Object[7];//create new object of 7 rows
        for(int i=0;i < olist.getlist().size();i++){
            //to check whether drink object is Cold Drink or Hot Drink
            if(olist.getlist().get(i) instanceof ColdDrink){
                  cd = (ColdDrink) olist.getlist().get(i);//refer it to Cold Drink object
                  rowdata[0]=cd.getName();//set into name row of object
                  rowdata[1]=String.valueOf(cd.getquantity())+"X";//set into quantity row of object
                  rowdata[2]=cd.getSize();//set into size row of object
                  rowdata[3]=cd.getsugar();//set into sugar row of object
                  rowdata[4]=cd.getice();//set into ice row of object
                  rowdata[5]=cd.getTopping();//set into topping name row of object
                  rowdata[6]=cd.getTotal();//add into total price row of object
                  model.addRow(rowdata);//add row object into Order Table
              }
              else if(olist.getlist().get(i) instanceof HotDrink){
                  hd = (HotDrink) olist.getlist().get(i);//refer it to Hot Drink object
                  rowdata[0]=hd.getName();//set into name row of object
                  rowdata[1]=String.valueOf(hd.getquantity())+"X";//set into quantity row of object
                  rowdata[2]=hd.getSize();//set into size row of object
                  rowdata[3]=hd.getsugar();//set into sugar row of object
                  rowdata[4]="-";//set into ice row of object
                  rowdata[5]="-";//set into topping name row of object
                  rowdata[6]=hd.getTotal();//add into total price row of object
                  model.addRow(rowdata);//add row object into Order Table
              }
        }  
    }
    //price from table getter method
    public double GetPriceFromTable(){
        double total = 0;//declare total price variable
        double rowprice=0;//declare price in row table variable
        for(int i =0;i<OrderTable.getRowCount();i++)
        {
            rowprice = (double) OrderTable.getValueAt(i,6);//get price value
            total = total + rowprice;//get total price
        }
        return total;
    }
    //reset cold coffee form method
    public void ResetColdCoffeeForm(){
        ColdCoffeeQuantityL.setText("1");//set quantity label text into "1"
        ColdCoffeeSizeBtnG.clearSelection();//clear selection of size radio button group
        ColdCoffeeIceBtnG.clearSelection();//clear selection of ice radio button group
        ColdCoffeeTopBtnG.clearSelection();//clear selection of top radio button group
       ColdCoffeeSugarCombo.setSelectedIndex(0);//set index of sugar combo box into 0
    }
    //reset hot drink form method
    public void ResetHotDrinkForm(){
        HotDrinkQuantityL.setText("1");//set quantity label text into "1"
        HotDrinkSizeBtnG.clearSelection(); //clear selection of size radio button group
        HotDrinkSugarCombo.setSelectedIndex(0);//set index of sugar combo box into 0
    }
    //reset cold tea form method
    public void ResetColdTeaForm(){
        ColdTeaQuantityL.setText("1");//set quantity label text into "1" 
        ColdTeaSizeBtnG.clearSelection();//clear selection of size radio button group
        ColdTeaIceBtnG.clearSelection();//clear selection of ice radio button group
        ColdTeaCombo.setSelectedIndex(0);//set index of topping combo box into 0
        ColdTeaSugarCombo.setSelectedIndex(0);//set index of sugar combo box into 0
    }
    public MainMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ColdCoffeeSizeBtnG = new javax.swing.ButtonGroup();
        ColdCoffeeTopBtnG = new javax.swing.ButtonGroup();
        ColdTeaSizeBtnG = new javax.swing.ButtonGroup();
        HotDrinkSizeBtnG = new javax.swing.ButtonGroup();
        ColdCoffeeIceBtnG = new javax.swing.ButtonGroup();
        ColdTeaIceBtnG = new javax.swing.ButtonGroup();
        TabPane1 = new javax.swing.JTabbedPane();
        MenuP = new javax.swing.JPanel();
        TabPane2 = new javax.swing.JTabbedPane();
        CoffeeP = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        ColdCappucinoBtn = new javax.swing.JButton();
        ColdMochaBtn = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        HotCappucinoBtn = new javax.swing.JButton();
        HotMocha = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        CoffeeMenuNameL = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        CoffeeMenuPriceL = new javax.swing.JLabel();
        CoffeeNextBtn = new javax.swing.JButton();
        ColdAmeriBtn = new javax.swing.JButton();
        HotAmeriBtn = new javax.swing.JButton();
        ColdFrapBtn = new javax.swing.JButton();
        HotEspBtn = new javax.swing.JButton();
        ColdEspBtn = new javax.swing.JButton();
        ColdCafLatBtn = new javax.swing.JButton();
        HotCafLatBtn = new javax.swing.JButton();
        HotVanillaBtn = new javax.swing.JButton();
        ColdVanillaBtn = new javax.swing.JButton();
        TeaP = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        ColdMilkTeaBtn = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        ColdMatchaBtn = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        HotMilkTeaBtn = new javax.swing.JButton();
        HotMatchaBtn = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        TeaMenuNameL = new javax.swing.JLabel();
        TeaMenuPriceL = new javax.swing.JLabel();
        TeaNextBtn = new javax.swing.JButton();
        ColdBTeaBtn = new javax.swing.JButton();
        HotBTeaBtn = new javax.swing.JButton();
        ColdChocoBtn = new javax.swing.JButton();
        HotManTeaBtn = new javax.swing.JButton();
        ColdTaroBtn = new javax.swing.JButton();
        HotPeachBtn = new javax.swing.JButton();
        ColdManTeaBtn = new javax.swing.JButton();
        ColdPeachBtn = new javax.swing.JButton();
        HotMatLatBtn = new javax.swing.JButton();
        HotBLatBtn = new javax.swing.JButton();
        ColdVanTeaBtn = new javax.swing.JButton();
        PrefP = new javax.swing.JPanel();
        TabPane3 = new javax.swing.JTabbedPane();
        ColdCoffeeP = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ColdCoffeeRegRB = new javax.swing.JRadioButton();
        ColdCoffeeLarRB = new javax.swing.JRadioButton();
        YesRB = new javax.swing.JRadioButton();
        NoRB = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        ColdCoffeePriceL = new javax.swing.JLabel();
        ColdCoffeeNameL = new javax.swing.JLabel();
        ColdCoffeeTypeL = new javax.swing.JLabel();
        ColdCoffeeAddBtn = new javax.swing.JButton();
        ColdCoffeeCheckBtn = new javax.swing.JButton();
        ColdCoffeeNormalRB = new javax.swing.JRadioButton();
        ColdCoffeeLessRB = new javax.swing.JRadioButton();
        ColdCoffeeSugarCombo = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        ColdCoffeeDecrementBtn = new javax.swing.JButton();
        ColdCoffeeQuantityL = new javax.swing.JLabel();
        ColdCoffeeIncrementBtn = new javax.swing.JButton();
        ColdTeaP = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ColdTeaNameL = new javax.swing.JLabel();
        ColdTeaTypeL = new javax.swing.JLabel();
        ColdTeaRegRB = new javax.swing.JRadioButton();
        ColdTeaLarRB = new javax.swing.JRadioButton();
        ColdTeaCombo = new javax.swing.JComboBox<>();
        ColdTeaPriceL = new javax.swing.JLabel();
        ColdTeaAddBtn = new javax.swing.JButton();
        ColdTeaCheckBtn = new javax.swing.JButton();
        ColdTeaLessRB = new javax.swing.JRadioButton();
        ColdTeaNormalRB = new javax.swing.JRadioButton();
        ColdTeaSugarCombo = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        ColdTeaDecrementBtn = new javax.swing.JButton();
        ColdTeaQuantityL = new javax.swing.JLabel();
        ColdTeaIncrementBtn = new javax.swing.JButton();
        HotDrinkP = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        HotDrinkNameL = new javax.swing.JLabel();
        HotDrinkTypeL = new javax.swing.JLabel();
        HotDrinkRegRB = new javax.swing.JRadioButton();
        HotDrinkLarRB = new javax.swing.JRadioButton();
        HotDrinkAddBtn = new javax.swing.JButton();
        HotDrinkCheckBtn = new javax.swing.JButton();
        HotDrinkPriceL = new javax.swing.JLabel();
        HotDrinkSugarCombo = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        HotDrinkDecrementBtn = new javax.swing.JButton();
        HotDrinkQuantityL = new javax.swing.JLabel();
        HotDrinkIncrementBtn = new javax.swing.JButton();
        OrderListP = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();
        BackBtn = new javax.swing.JButton();
        ConfirmBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        OrderNametf = new javax.swing.JTextField();
        DeleteOrderBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        OrderTotalPriceL = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        OrderPaytf = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        OrderChangePriceL = new javax.swing.JLabel();
        OrderGetTotalBtn = new javax.swing.JButton();
        OrderNumberL = new javax.swing.JLabel();
        OrderResetBtn = new javax.swing.JButton();
        CheckOrderP = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CheckTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        CheckNumberL = new javax.swing.JLabel();
        ShowBtn = new javax.swing.JButton();
        FinishBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel30.setText("Cold");

        ColdCappucinoBtn.setText("Cappuccino");
        ColdCappucinoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdCappucinoBtnActionPerformed(evt);
            }
        });

        ColdMochaBtn.setText("Mocha");
        ColdMochaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdMochaBtnActionPerformed(evt);
            }
        });

        jLabel31.setText("Hot");

        HotCappucinoBtn.setText("Cappuccino");
        HotCappucinoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotCappucinoBtnActionPerformed(evt);
            }
        });

        HotMocha.setText("Mocha");
        HotMocha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotMochaActionPerformed(evt);
            }
        });

        jLabel32.setText("Name:");

        CoffeeMenuNameL.setText("None");

        jLabel34.setText("Price:");

        CoffeeMenuPriceL.setText("0.0");

        CoffeeNextBtn.setText("Next");
        CoffeeNextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoffeeNextBtnActionPerformed(evt);
            }
        });

        ColdAmeriBtn.setText("Americano");
        ColdAmeriBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdAmeriBtnActionPerformed(evt);
            }
        });

        HotAmeriBtn.setText("Americano");
        HotAmeriBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotAmeriBtnActionPerformed(evt);
            }
        });

        ColdFrapBtn.setText("Frappuccino");
        ColdFrapBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdFrapBtnActionPerformed(evt);
            }
        });

        HotEspBtn.setText("Espresso");
        HotEspBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotEspBtnActionPerformed(evt);
            }
        });

        ColdEspBtn.setText("Espresso");
        ColdEspBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdEspBtnActionPerformed(evt);
            }
        });

        ColdCafLatBtn.setText("Caffe Latte");
        ColdCafLatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdCafLatBtnActionPerformed(evt);
            }
        });

        HotCafLatBtn.setText("Caffe Latte");
        HotCafLatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotCafLatBtnActionPerformed(evt);
            }
        });

        HotVanillaBtn.setText("Vanilla Latte");
        HotVanillaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotVanillaBtnActionPerformed(evt);
            }
        });

        ColdVanillaBtn.setText("Vanilla Latte");
        ColdVanillaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdVanillaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CoffeePLayout = new javax.swing.GroupLayout(CoffeeP);
        CoffeeP.setLayout(CoffeePLayout);
        CoffeePLayout.setHorizontalGroup(
            CoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoffeePLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CoffeePLayout.createSequentialGroup()
                        .addGroup(CoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CoffeePLayout.createSequentialGroup()
                                .addGroup(CoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel34))
                                .addGap(77, 77, 77)
                                .addGroup(CoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(CoffeePLayout.createSequentialGroup()
                                        .addComponent(CoffeeMenuPriceL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 418, Short.MAX_VALUE)
                                        .addComponent(CoffeeNextBtn))
                                    .addGroup(CoffeePLayout.createSequentialGroup()
                                        .addComponent(CoffeeMenuNameL)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(CoffeePLayout.createSequentialGroup()
                                .addGroup(CoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel31)
                                    .addGroup(CoffeePLayout.createSequentialGroup()
                                        .addComponent(ColdCappucinoBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(ColdMochaBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(ColdAmeriBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(ColdEspBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ColdCafLatBtn))
                                    .addGroup(CoffeePLayout.createSequentialGroup()
                                        .addComponent(ColdVanillaBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ColdFrapBtn)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(26, 26, 26))
                    .addGroup(CoffeePLayout.createSequentialGroup()
                        .addComponent(HotVanillaBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CoffeePLayout.createSequentialGroup()
                        .addComponent(HotCappucinoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(HotMocha)
                        .addGap(18, 18, 18)
                        .addComponent(HotAmeriBtn)
                        .addGap(18, 18, 18)
                        .addComponent(HotEspBtn)
                        .addGap(18, 18, 18)
                        .addComponent(HotCafLatBtn)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        CoffeePLayout.setVerticalGroup(
            CoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoffeePLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ColdCappucinoBtn)
                    .addComponent(ColdMochaBtn)
                    .addComponent(ColdAmeriBtn)
                    .addComponent(ColdEspBtn)
                    .addComponent(ColdCafLatBtn))
                .addGap(18, 18, 18)
                .addGroup(CoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ColdFrapBtn)
                    .addComponent(ColdVanillaBtn))
                .addGap(142, 142, 142)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HotCappucinoBtn)
                    .addComponent(HotMocha)
                    .addComponent(HotAmeriBtn)
                    .addComponent(HotEspBtn)
                    .addComponent(HotCafLatBtn))
                .addGap(18, 18, 18)
                .addComponent(HotVanillaBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addGroup(CoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(CoffeeMenuNameL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(CoffeeMenuPriceL)
                    .addComponent(CoffeeNextBtn))
                .addGap(7, 7, 7))
        );

        TabPane2.addTab("Coffee", CoffeeP);

        jLabel36.setText("Cold");

        ColdMilkTeaBtn.setText("Milk Tea");
        ColdMilkTeaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdMilkTeaBtnActionPerformed(evt);
            }
        });

        jLabel37.setText("Hot");

        ColdMatchaBtn.setText("Matcha Milk Tea");
        ColdMatchaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdMatchaBtnActionPerformed(evt);
            }
        });

        jLabel38.setText("Name:");

        HotMilkTeaBtn.setText("Milk Tea");
        HotMilkTeaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotMilkTeaBtnActionPerformed(evt);
            }
        });

        HotMatchaBtn.setText("Matcha Milk Tea");
        HotMatchaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotMatchaBtnActionPerformed(evt);
            }
        });

        jLabel39.setText("Price:");

        TeaMenuNameL.setText("None");

        TeaMenuPriceL.setText("0.0");

        TeaNextBtn.setText("Next");
        TeaNextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeaNextBtnActionPerformed(evt);
            }
        });

        ColdBTeaBtn.setText("Black Milk Tea");
        ColdBTeaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdBTeaBtnActionPerformed(evt);
            }
        });

        HotBTeaBtn.setText("Black Milk Tea");
        HotBTeaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotBTeaBtnActionPerformed(evt);
            }
        });

        ColdChocoBtn.setText("Chocolate Milk Tea");
        ColdChocoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdChocoBtnActionPerformed(evt);
            }
        });

        HotManTeaBtn.setText("Mango Tea");
        HotManTeaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotManTeaBtnActionPerformed(evt);
            }
        });

        ColdTaroBtn.setText("Taro Milk Tea");
        ColdTaroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdTaroBtnActionPerformed(evt);
            }
        });

        HotPeachBtn.setText("Peach Tea");
        HotPeachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotPeachBtnActionPerformed(evt);
            }
        });

        ColdManTeaBtn.setText("Mango Tea");
        ColdManTeaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdManTeaBtnActionPerformed(evt);
            }
        });

        ColdPeachBtn.setText("Peach Tea");
        ColdPeachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdPeachBtnActionPerformed(evt);
            }
        });

        HotMatLatBtn.setText("Matcha Tea Latte");
        HotMatLatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotMatLatBtnActionPerformed(evt);
            }
        });

        HotBLatBtn.setText("Black Tea Latte");
        HotBLatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotBLatBtnActionPerformed(evt);
            }
        });

        ColdVanTeaBtn.setText("Vanilla Milk Tea");
        ColdVanTeaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdVanTeaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TeaPLayout = new javax.swing.GroupLayout(TeaP);
        TeaP.setLayout(TeaPLayout);
        TeaPLayout.setHorizontalGroup(
            TeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeaPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TeaPLayout.createSequentialGroup()
                        .addGroup(TeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addGroup(TeaPLayout.createSequentialGroup()
                                .addComponent(ColdMilkTeaBtn)
                                .addGap(31, 31, 31)
                                .addComponent(ColdMatchaBtn)
                                .addGap(18, 18, 18)
                                .addComponent(ColdBTeaBtn)
                                .addGap(18, 18, 18)
                                .addComponent(ColdManTeaBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ColdPeachBtn)))
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(TeaPLayout.createSequentialGroup()
                        .addGroup(TeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39))
                        .addGap(49, 49, 49)
                        .addGroup(TeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TeaMenuPriceL)
                            .addComponent(TeaMenuNameL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TeaNextBtn)
                        .addGap(24, 24, 24))
                    .addGroup(TeaPLayout.createSequentialGroup()
                        .addGroup(TeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TeaPLayout.createSequentialGroup()
                                .addComponent(HotMatLatBtn)
                                .addGap(18, 18, 18)
                                .addComponent(HotBLatBtn))
                            .addGroup(TeaPLayout.createSequentialGroup()
                                .addGroup(TeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ColdTaroBtn)
                                    .addComponent(HotMilkTeaBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(TeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(TeaPLayout.createSequentialGroup()
                                        .addComponent(HotMatchaBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(HotBTeaBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(HotManTeaBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(HotPeachBtn))
                                    .addGroup(TeaPLayout.createSequentialGroup()
                                        .addComponent(ColdChocoBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ColdVanTeaBtn)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        TeaPLayout.setVerticalGroup(
            TeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeaPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ColdMilkTeaBtn)
                    .addComponent(ColdMatchaBtn)
                    .addComponent(ColdBTeaBtn)
                    .addComponent(ColdManTeaBtn)
                    .addComponent(ColdPeachBtn))
                .addGap(18, 18, 18)
                .addGroup(TeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ColdTaroBtn)
                    .addComponent(ColdChocoBtn)
                    .addComponent(ColdVanTeaBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HotMilkTeaBtn)
                    .addComponent(HotMatchaBtn)
                    .addComponent(HotBTeaBtn)
                    .addComponent(HotManTeaBtn)
                    .addComponent(HotPeachBtn))
                .addGap(18, 18, 18)
                .addGroup(TeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HotMatLatBtn)
                    .addComponent(HotBLatBtn))
                .addGap(116, 116, 116)
                .addGroup(TeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(TeaMenuNameL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(TeaMenuPriceL))
                .addGap(7, 7, 7))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TeaPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TeaNextBtn)
                .addContainerGap())
        );

        TabPane2.addTab("Tea", TeaP);

        javax.swing.GroupLayout MenuPLayout = new javax.swing.GroupLayout(MenuP);
        MenuP.setLayout(MenuPLayout);
        MenuPLayout.setHorizontalGroup(
            MenuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPane2)
        );
        MenuPLayout.setVerticalGroup(
            MenuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPane2)
        );

        TabPane1.addTab("Menu", MenuP);

        jLabel2.setText("Name:");

        jLabel3.setText("Type:");

        jLabel4.setText("Size:");

        jLabel5.setText("Sugar:");

        jLabel6.setText("Ice:");

        jLabel7.setText("Do you want to add Whipped Cream?");

        ColdCoffeeSizeBtnG.add(ColdCoffeeRegRB);
        ColdCoffeeRegRB.setText("Regular");
        ColdCoffeeRegRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdCoffeeRegRBActionPerformed(evt);
            }
        });

        ColdCoffeeSizeBtnG.add(ColdCoffeeLarRB);
        ColdCoffeeLarRB.setText("Large");
        ColdCoffeeLarRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdCoffeeLarRBActionPerformed(evt);
            }
        });

        ColdCoffeeTopBtnG.add(YesRB);
        YesRB.setText("Yes");
        YesRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YesRBActionPerformed(evt);
            }
        });

        ColdCoffeeTopBtnG.add(NoRB);
        NoRB.setText("No");
        NoRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoRBActionPerformed(evt);
            }
        });

        jLabel8.setText("Price:");

        ColdCoffeePriceL.setText("0.0");

        ColdCoffeeNameL.setText("None");

        ColdCoffeeTypeL.setText("None");

        ColdCoffeeAddBtn.setText("Add");
        ColdCoffeeAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdCoffeeAddBtnActionPerformed(evt);
            }
        });

        ColdCoffeeCheckBtn.setText("Check");
        ColdCoffeeCheckBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdCoffeeCheckBtnActionPerformed(evt);
            }
        });

        ColdCoffeeIceBtnG.add(ColdCoffeeNormalRB);
        ColdCoffeeNormalRB.setText("Normal");
        ColdCoffeeNormalRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdCoffeeNormalRBActionPerformed(evt);
            }
        });

        ColdCoffeeIceBtnG.add(ColdCoffeeLessRB);
        ColdCoffeeLessRB.setText("Less");
        ColdCoffeeLessRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdCoffeeLessRBActionPerformed(evt);
            }
        });

        ColdCoffeeSugarCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Select an Item----", "No Sugar (0%)", "Quarter Sugar (25%)", "Half Sugar (50%)", "Less Sugar (75%)", "Normal Sugar (100%)", "More Sugar (125%)" }));
        ColdCoffeeSugarCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdCoffeeSugarComboActionPerformed(evt);
            }
        });

        jLabel21.setText("Quantity:");

        ColdCoffeeDecrementBtn.setText("-");
        ColdCoffeeDecrementBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdCoffeeDecrementBtnActionPerformed(evt);
            }
        });

        ColdCoffeeQuantityL.setText("001");

        ColdCoffeeIncrementBtn.setText("+");
        ColdCoffeeIncrementBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdCoffeeIncrementBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ColdCoffeePLayout = new javax.swing.GroupLayout(ColdCoffeeP);
        ColdCoffeeP.setLayout(ColdCoffeePLayout);
        ColdCoffeePLayout.setHorizontalGroup(
            ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ColdCoffeePLayout.createSequentialGroup()
                .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ColdCoffeePLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ColdCoffeePLayout.createSequentialGroup()
                                .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(33, 33, 33)
                                .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ColdCoffeeAddBtn)
                                    .addGroup(ColdCoffeePLayout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ColdCoffeeNameL)
                                            .addComponent(ColdCoffeeTypeL))
                                        .addGap(22, 22, 22)
                                        .addComponent(ColdCoffeeCheckBtn))))
                            .addGroup(ColdCoffeePLayout.createSequentialGroup()
                                .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(54, 54, 54)
                                .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ColdCoffeeSugarCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ColdCoffeePLayout.createSequentialGroup()
                                        .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ColdCoffeeRegRB)
                                            .addComponent(ColdCoffeeNormalRB))
                                        .addGap(18, 18, 18)
                                        .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ColdCoffeeLarRB)
                                            .addComponent(ColdCoffeeLessRB)))))))
                    .addGroup(ColdCoffeePLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ColdCoffeePLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(103, 103, 103)
                                .addComponent(ColdCoffeePriceL))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ColdCoffeePLayout.createSequentialGroup()
                                .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21)
                                    .addComponent(YesRB))
                                .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ColdCoffeePLayout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(NoRB))
                                    .addGroup(ColdCoffeePLayout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(ColdCoffeeDecrementBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ColdCoffeeQuantityL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ColdCoffeeIncrementBtn)))))))
                .addContainerGap(330, Short.MAX_VALUE))
        );
        ColdCoffeePLayout.setVerticalGroup(
            ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ColdCoffeePLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ColdCoffeeNameL))
                .addGap(37, 37, 37)
                .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ColdCoffeeTypeL))
                .addGap(44, 44, 44)
                .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ColdCoffeePLayout.createSequentialGroup()
                        .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ColdCoffeeRegRB)
                            .addComponent(ColdCoffeeLarRB))
                        .addGap(49, 49, 49)
                        .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ColdCoffeeSugarCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68))
                    .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(ColdCoffeeNormalRB)
                        .addComponent(ColdCoffeeLessRB)))
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoRB)
                    .addComponent(YesRB))
                .addGap(18, 18, 18)
                .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(ColdCoffeeDecrementBtn)
                    .addComponent(ColdCoffeeQuantityL)
                    .addComponent(ColdCoffeeIncrementBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ColdCoffeePriceL))
                .addGap(81, 81, 81)
                .addGroup(ColdCoffeePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ColdCoffeeAddBtn)
                    .addComponent(ColdCoffeeCheckBtn))
                .addContainerGap())
        );

        TabPane3.addTab("Cold Coffee", ColdCoffeeP);

        jLabel12.setText("Name:");

        jLabel13.setText("Type:");

        jLabel14.setText("Size:");

        jLabel15.setText("Sugar:");

        jLabel16.setText("Ice:");

        jLabel17.setText("Topping:");

        jLabel18.setText("Price:");

        ColdTeaNameL.setText("None");

        ColdTeaTypeL.setText("None");

        ColdTeaSizeBtnG.add(ColdTeaRegRB);
        ColdTeaRegRB.setText("Regular");
        ColdTeaRegRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdTeaRegRBActionPerformed(evt);
            }
        });

        ColdTeaSizeBtnG.add(ColdTeaLarRB);
        ColdTeaLarRB.setText("Large");
        ColdTeaLarRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdTeaLarRBActionPerformed(evt);
            }
        });

        ColdTeaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select an Item---", "None (+0)", "Bubble Gum (+3000)", "Konjac Jelly (+5000)", "Aloe Vera (+6000)" }));
        ColdTeaCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdTeaComboActionPerformed(evt);
            }
        });

        ColdTeaPriceL.setText("0.0");

        ColdTeaAddBtn.setText("Add");
        ColdTeaAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdTeaAddBtnActionPerformed(evt);
            }
        });

        ColdTeaCheckBtn.setText("Check");
        ColdTeaCheckBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdTeaCheckBtnActionPerformed(evt);
            }
        });

        ColdTeaIceBtnG.add(ColdTeaLessRB);
        ColdTeaLessRB.setText("Less");
        ColdTeaLessRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdTeaLessRBActionPerformed(evt);
            }
        });

        ColdTeaIceBtnG.add(ColdTeaNormalRB);
        ColdTeaNormalRB.setText("Normal");
        ColdTeaNormalRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdTeaNormalRBActionPerformed(evt);
            }
        });

        ColdTeaSugarCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Select an Item----", "No Sugar (0%)", "Quarter Sugar (25%)", "Half Sugar (50%)", "Less Sugar (75%)", "Normal Sugar (100%)", "More Sugar (125%)" }));
        ColdTeaSugarCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdTeaSugarComboActionPerformed(evt);
            }
        });

        jLabel27.setText("Quantity:");

        ColdTeaDecrementBtn.setText("-");
        ColdTeaDecrementBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdTeaDecrementBtnActionPerformed(evt);
            }
        });

        ColdTeaQuantityL.setText("001");

        ColdTeaIncrementBtn.setText("+");
        ColdTeaIncrementBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdTeaIncrementBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ColdTeaPLayout = new javax.swing.GroupLayout(ColdTeaP);
        ColdTeaP.setLayout(ColdTeaPLayout);
        ColdTeaPLayout.setHorizontalGroup(
            ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ColdTeaPLayout.createSequentialGroup()
                .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ColdTeaPLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(ColdTeaAddBtn)
                        .addGap(71, 71, 71)
                        .addComponent(ColdTeaCheckBtn))
                    .addGroup(ColdTeaPLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ColdTeaPLayout.createSequentialGroup()
                                .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addGap(122, 122, 122)
                                .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ColdTeaPLayout.createSequentialGroup()
                                        .addComponent(ColdTeaNormalRB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ColdTeaLessRB))
                                    .addGroup(ColdTeaPLayout.createSequentialGroup()
                                        .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ColdTeaSugarCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ColdTeaRegRB))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(ColdTeaPLayout.createSequentialGroup()
                                .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(123, 123, 123)
                                .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ColdTeaTypeL)
                                    .addComponent(ColdTeaNameL))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                .addComponent(ColdTeaLarRB))
                            .addGroup(ColdTeaPLayout.createSequentialGroup()
                                .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addGroup(ColdTeaPLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(109, 109, 109)
                                        .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ColdTeaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ColdTeaPriceL)))
                                    .addGroup(ColdTeaPLayout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addGap(77, 77, 77)
                                        .addComponent(ColdTeaDecrementBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(ColdTeaQuantityL)
                                        .addGap(18, 18, 18)
                                        .addComponent(ColdTeaIncrementBtn)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(195, 195, 195))
        );
        ColdTeaPLayout.setVerticalGroup(
            ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ColdTeaPLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(ColdTeaNameL))
                .addGap(48, 48, 48)
                .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(ColdTeaTypeL))
                .addGap(38, 38, 38)
                .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(ColdTeaRegRB)
                    .addComponent(ColdTeaLarRB))
                .addGap(30, 30, 30)
                .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(ColdTeaSugarCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(ColdTeaLessRB)
                    .addComponent(ColdTeaNormalRB))
                .addGap(34, 34, 34)
                .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(ColdTeaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(ColdTeaDecrementBtn)
                    .addComponent(ColdTeaQuantityL)
                    .addComponent(ColdTeaIncrementBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(ColdTeaPriceL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(ColdTeaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ColdTeaAddBtn)
                    .addComponent(ColdTeaCheckBtn))
                .addGap(21, 21, 21))
        );

        TabPane3.addTab("Cold Tea", ColdTeaP);

        jLabel22.setText("Name:");

        jLabel23.setText("Type:");

        jLabel24.setText("Size:");

        jLabel25.setText("Sugar:");

        jLabel26.setText("Price:");

        HotDrinkNameL.setText("None");

        HotDrinkTypeL.setText("None");

        HotDrinkSizeBtnG.add(HotDrinkRegRB);
        HotDrinkRegRB.setText("Regular");
        HotDrinkRegRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotDrinkRegRBActionPerformed(evt);
            }
        });

        HotDrinkSizeBtnG.add(HotDrinkLarRB);
        HotDrinkLarRB.setText("Large");
        HotDrinkLarRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotDrinkLarRBActionPerformed(evt);
            }
        });

        HotDrinkAddBtn.setText("Add");
        HotDrinkAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotDrinkAddBtnActionPerformed(evt);
            }
        });

        HotDrinkCheckBtn.setText("Check");
        HotDrinkCheckBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotDrinkCheckBtnActionPerformed(evt);
            }
        });

        HotDrinkPriceL.setText("0.0");

        HotDrinkSugarCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Select an Item----", "No Sugar (0%)", "Quarter Sugar (25%)", "Half Sugar (50%)", "Less Sugar (75%)", "Normal Sugar (100%)", "More Sugar (125%)" }));
        HotDrinkSugarCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotDrinkSugarComboActionPerformed(evt);
            }
        });

        jLabel28.setText("Quantity:");

        HotDrinkDecrementBtn.setText("-");
        HotDrinkDecrementBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotDrinkDecrementBtnActionPerformed(evt);
            }
        });

        HotDrinkQuantityL.setText("001");

        HotDrinkIncrementBtn.setText("+");
        HotDrinkIncrementBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotDrinkIncrementBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HotDrinkPLayout = new javax.swing.GroupLayout(HotDrinkP);
        HotDrinkP.setLayout(HotDrinkPLayout);
        HotDrinkPLayout.setHorizontalGroup(
            HotDrinkPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HotDrinkPLayout.createSequentialGroup()
                .addGroup(HotDrinkPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HotDrinkPLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(HotDrinkPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22)
                            .addComponent(jLabel28))
                        .addGroup(HotDrinkPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HotDrinkPLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(HotDrinkPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(HotDrinkPriceL)
                                    .addGroup(HotDrinkPLayout.createSequentialGroup()
                                        .addComponent(HotDrinkRegRB)
                                        .addGap(29, 29, 29)
                                        .addComponent(HotDrinkLarRB))
                                    .addComponent(HotDrinkSugarCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(HotDrinkPLayout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(HotDrinkPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(HotDrinkTypeL)
                                    .addComponent(HotDrinkNameL)))
                            .addGroup(HotDrinkPLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(HotDrinkDecrementBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HotDrinkQuantityL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HotDrinkIncrementBtn))))
                    .addGroup(HotDrinkPLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(HotDrinkAddBtn)
                        .addGap(37, 37, 37)
                        .addComponent(HotDrinkCheckBtn)))
                .addContainerGap(242, Short.MAX_VALUE))
        );
        HotDrinkPLayout.setVerticalGroup(
            HotDrinkPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HotDrinkPLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(HotDrinkPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(HotDrinkNameL))
                .addGap(52, 52, 52)
                .addGroup(HotDrinkPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(HotDrinkTypeL))
                .addGap(56, 56, 56)
                .addGroup(HotDrinkPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(HotDrinkRegRB)
                    .addComponent(HotDrinkLarRB))
                .addGap(52, 52, 52)
                .addGroup(HotDrinkPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(HotDrinkSugarCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(HotDrinkPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(HotDrinkDecrementBtn)
                    .addComponent(HotDrinkQuantityL)
                    .addComponent(HotDrinkIncrementBtn))
                .addGap(18, 18, 18)
                .addGroup(HotDrinkPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(HotDrinkPriceL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addGroup(HotDrinkPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HotDrinkAddBtn)
                    .addComponent(HotDrinkCheckBtn))
                .addGap(24, 24, 24))
        );

        TabPane3.addTab("Hot Drink", HotDrinkP);

        javax.swing.GroupLayout PrefPLayout = new javax.swing.GroupLayout(PrefP);
        PrefP.setLayout(PrefPLayout);
        PrefPLayout.setHorizontalGroup(
            PrefPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPane3)
        );
        PrefPLayout.setVerticalGroup(
            PrefPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPane3)
        );

        TabPane1.addTab("Preferences", PrefP);

        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Quantity", "Size", "Sugar", "Ice", "Topping", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(OrderTable);

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        ConfirmBtn.setText("Confirm");
        ConfirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Name:");

        DeleteOrderBtn.setText("Delete");
        DeleteOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteOrderBtnActionPerformed(evt);
            }
        });

        jLabel9.setText("Total:");

        OrderTotalPriceL.setText("0.0");

        jLabel11.setText("Order No:");

        jLabel19.setText("Pay:");

        jLabel20.setText("Change:");

        OrderChangePriceL.setText("0.0");

        OrderGetTotalBtn.setText("Get Total");
        OrderGetTotalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderGetTotalBtnActionPerformed(evt);
            }
        });

        OrderNumberL.setText("000");

        OrderResetBtn.setText("Reset");
        OrderResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderResetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OrderListPLayout = new javax.swing.GroupLayout(OrderListP);
        OrderListP.setLayout(OrderListPLayout);
        OrderListPLayout.setHorizontalGroup(
            OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(OrderListPLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(OrderListPLayout.createSequentialGroup()
                        .addComponent(OrderNametf, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteOrderBtn))
                    .addGroup(OrderListPLayout.createSequentialGroup()
                        .addComponent(OrderNumberL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(OrderResetBtn)
                        .addGap(18, 18, 18)
                        .addComponent(BackBtn)))
                .addGroup(OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OrderListPLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addGroup(OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(OrderListPLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel19))
                                .addComponent(jLabel9)))
                        .addGap(36, 36, 36)
                        .addGroup(OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(OrderListPLayout.createSequentialGroup()
                                .addGroup(OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(OrderListPLayout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(OrderChangePriceL))
                                    .addGroup(OrderListPLayout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(OrderTotalPriceL)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderListPLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(OrderPaytf, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))))
                    .addGroup(OrderListPLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(OrderGetTotalBtn)
                        .addGap(27, 27, 27)
                        .addComponent(ConfirmBtn)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        OrderListPLayout.setVerticalGroup(
            OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderListPLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(OrderNametf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DeleteOrderBtn))
                    .addGroup(OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(OrderTotalPriceL)))
                .addGroup(OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OrderListPLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(OrderNumberL)
                            .addComponent(BackBtn)
                            .addComponent(OrderResetBtn)))
                    .addGroup(OrderListPLayout.createSequentialGroup()
                        .addGroup(OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(OrderListPLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(OrderPaytf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(OrderListPLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel19)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(OrderChangePriceL))))
                .addGap(20, 20, 20)
                .addGroup(OrderListPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OrderGetTotalBtn)
                    .addComponent(ConfirmBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabPane1.addTab("Order", OrderListP);

        CheckTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Quantity", "Size", "Sugar", "Ice", "Topping", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(CheckTable);

        jLabel10.setText("Order Number:");

        CheckNumberL.setText("000");

        ShowBtn.setText("Show");
        ShowBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowBtnActionPerformed(evt);
            }
        });

        FinishBtn.setText("Finish");
        FinishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CheckOrderPLayout = new javax.swing.GroupLayout(CheckOrderP);
        CheckOrderP.setLayout(CheckOrderPLayout);
        CheckOrderPLayout.setHorizontalGroup(
            CheckOrderPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
            .addGroup(CheckOrderPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(37, 37, 37)
                .addComponent(CheckNumberL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ShowBtn)
                .addGap(18, 18, 18)
                .addComponent(FinishBtn)
                .addGap(70, 70, 70))
        );
        CheckOrderPLayout.setVerticalGroup(
            CheckOrderPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CheckOrderPLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(CheckOrderPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CheckOrderPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(CheckNumberL))
                    .addGroup(CheckOrderPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ShowBtn)
                        .addComponent(FinishBtn)))
                .addGap(0, 152, Short.MAX_VALUE))
        );

        TabPane1.addTab("Check Order", CheckOrderP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//confirm button action performed method
    private void ConfirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmBtnActionPerformed
        // TODO add your handling code here:
        //check whether text of pay text field is empty or not
        if(OrderPaytf.getText().equalsIgnoreCase("")){
             JOptionPane.showMessageDialog(this,"Please fill the payment first","Error",JOptionPane.ERROR_MESSAGE);//show error message dialogue
        }
        else{
            //check whether text of total price label is "0.0" or not
            if(OrderTotalPriceL.getText().equalsIgnoreCase("0.0")){
                 JOptionPane.showMessageDialog(this,"Please check total price first","Error",JOptionPane.ERROR_MESSAGE);//show error message dialogue
            }
            else{
                double payprice=Double.valueOf(OrderPaytf.getText());//get pay price value
                double change = payprice - Double.valueOf(OrderTotalPriceL.getText());//get change price value
                JOptionPane.showMessageDialog(this,"Payment is complete!");//show 'payment is complete' notification
                OrderChangePriceL.setText(Double.toString(change));//set text of change price label into change price value
                olist.setPaid(true);//set statement of isPaid into true
            }
        }
    }//GEN-LAST:event_ConfirmBtnActionPerformed
//yes radio button action performed method
    private void YesRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YesRBActionPerformed
        // TODO add your handling code here:
        //check whether drink object is cold drink object or not
        if(d instanceof ColdDrink){
            cd = (ColdDrink)d;//refer it to cold drink object
            cd.addTopping("Whipped Cream");//set value of topping name into "Whipped Cream"
            d= (Drink)cd;//refer it back to drink object
        }
    }//GEN-LAST:event_YesRBActionPerformed
//Ice Cappucino button action performed method 
    private void ColdCappucinoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdCappucinoBtnActionPerformed
        // TODO add your handling code here:
        d = coldcappu;//get values of coldcappu object
        CoffeeMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        CoffeeMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_ColdCappucinoBtnActionPerformed
//Ice Mocha button action performed method 
    private void ColdMochaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdMochaBtnActionPerformed
        // TODO add your handling code here:
         d = coldmoc;//get values of coldmoc object
        CoffeeMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        CoffeeMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_ColdMochaBtnActionPerformed
//Hot Cappucino button action performed method
    private void HotCappucinoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotCappucinoBtnActionPerformed
        // TODO add your handling code here:
         d = hotcappu;//get values of hotcappu object
        CoffeeMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        CoffeeMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_HotCappucinoBtnActionPerformed
//Hot Cappucino button action performed method
    private void HotMochaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotMochaActionPerformed
        // TODO add your handling code here:
         d = hotmoc;//get values of hotmoc object
        CoffeeMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        CoffeeMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_HotMochaActionPerformed
//Coffee Panel Next Button Action Performed method
    private void CoffeeNextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoffeeNextBtnActionPerformed
        // TODO add your handling code here:
        //check whether text of name label is "none" or not and text of price label is "0.0" or not
        if(CoffeeMenuNameL.getText().equalsIgnoreCase("none") && CoffeeMenuPriceL.getText().equalsIgnoreCase("0.0")){
            JOptionPane.showMessageDialog(this,"Please select a drink first","Error",JOptionPane.ERROR_MESSAGE);//show error message
        }
        else{
            TabPane1.setSelectedComponent(PrefP);//go to Preference Panel
            //check whether drink object is Cold Drink or Hot Drink
            if(d.getDrinktype().equalsIgnoreCase("hot")){
                TabPane3.setSelectedComponent(HotDrinkP);//go to hot drink form panel
                HotDrinkNameL.setText(d.getName());//set text of name label into name value of drink object
                HotDrinkTypeL.setText(d.getDrinktype());//set text of drink type label into drink type value of drink object 
                HotDrinkPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
                ResetHotDrinkForm();//call ResetHotDrinkForm function
            }
            else if(d.getDrinktype().equalsIgnoreCase("cold")){
                TabPane3.setSelectedComponent(ColdCoffeeP);//go to cold coffee form panel
                ColdCoffeeNameL.setText(d.getName());//set text of name label into name value of drink object
                ColdCoffeeTypeL.setText(d.getDrinktype());//set text of drink type label into drink type value of drink object
                ColdCoffeePriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
                ResetColdCoffeeForm();//call ResetColdCoffeeForm function
            }
        }  
    }//GEN-LAST:event_CoffeeNextBtnActionPerformed
//Cold Coffee Panel Check Button Action Performed method
    private void ColdCoffeeCheckBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdCoffeeCheckBtnActionPerformed
        // TODO add your handling code here:
             //check whether text of name label is "none" or not and text of price label is "0.0" or not
            if(ColdCoffeeNameL.getText().equalsIgnoreCase("none")&&ColdCoffeePriceL.getText().equalsIgnoreCase("0.0")){
                 JOptionPane.showMessageDialog(this,"Please order a drink  first","Error",JOptionPane.ERROR_MESSAGE);//show error message
                 TabPane1.setSelectedComponent(MenuP);//go to Menu Panel
            }
            else{
                //check whether drink object is Cold Drink or not
                if(d instanceof ColdDrink){
                   cd = (ColdDrink)d;//refer it to cold drink object
                   //check whether size button group is null or not, ice button group is null or not, topping button group is null or not, and sugar combo box is in index 0 or not
                   if(ColdCoffeeSizeBtnG.getSelection()==null || ColdCoffeeIceBtnG.getSelection()==null || ColdCoffeeTopBtnG.getSelection()==null || ColdCoffeeSugarCombo.getSelectedIndex()==0){
                       JOptionPane.showMessageDialog(this,"Please complete this form","Error",JOptionPane.ERROR_MESSAGE);//show error message
                   }
                   else{
                       cd.setquantity(Integer.valueOf(ColdCoffeeQuantityL.getText()));//set quantity value of cold drink object into text of quantity label
                       ColdCoffeePriceL.setText(Double.toString(cd.getTotal()));//set text of price label into total price value of cold drink object
                       d = (Drink)cd;//refer it to drink object
                   }
                }
          }
    }//GEN-LAST:event_ColdCoffeeCheckBtnActionPerformed
//Cold Coffee Panel Regular Radio Button Action Performed method
    private void ColdCoffeeRegRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdCoffeeRegRBActionPerformed
        // TODO add your handling code here:
         //check whether drink object is Cold Drink or not
      if(d instanceof ColdDrink){
            cd= (ColdDrink)d;//refer it to cold drink object
            cd.setSize("regular");//set size value of cold drink object into "regular"
            d=(Drink)cd;//refer it to drink object
        }
    }//GEN-LAST:event_ColdCoffeeRegRBActionPerformed
//Cold Coffee Panel Regular Radio Button Action Performed method
    private void ColdCoffeeLarRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdCoffeeLarRBActionPerformed
        // TODO add your handling code here:
        //check whether drink object is Cold Drink or not
        if(d instanceof ColdDrink){
            cd= (ColdDrink)d;//refer it to cold drink object
            cd.setSize("large");//set size value of cold drink object into "large"
            d=(Drink)cd;//refer it to drink object
        }
    }//GEN-LAST:event_ColdCoffeeLarRBActionPerformed
//no radio button action performed method
    private void NoRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoRBActionPerformed
        // TODO add your handling code here:
        //check whether drink object is Cold Drink or not
        if(d instanceof ColdDrink){
            cd = (ColdDrink) d;//refer it to cold drink object
            cd.addTopping("None");//set value of topping name into "None"
            d= (Drink)cd;//refer it to drink object
        }
    }//GEN-LAST:event_NoRBActionPerformed
//Cold Coffee Panel Add Button Action Performed method
    private void ColdCoffeeAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdCoffeeAddBtnActionPerformed
        // TODO add your handling code here:
        //check whether text of name label is "none" or not and text of price label is "0.0" or not
        if(ColdCoffeeNameL.getText().equalsIgnoreCase("none")&&ColdCoffeePriceL.getText().equalsIgnoreCase("0.0")){
            JOptionPane.showMessageDialog(this,"Please order a drink  first","Error",JOptionPane.ERROR_MESSAGE);//show error message
            TabPane1.setSelectedComponent(MenuP);//go to Menu Panel
        }
        else{
            //check whether drink object is Cold Drink or not
            if(d instanceof ColdDrink){
                cd = (ColdDrink) d;//refer it to cold drink object
                 //check whether size button group is null or not, ice button group is null or not, topping button group is null or not, and sugar combo box is in index 0 or not
                if(ColdCoffeeSizeBtnG.getSelection()==null || ColdCoffeeIceBtnG.getSelection()==null || ColdCoffeeTopBtnG.getSelection()==null ||ColdCoffeeSugarCombo.getSelectedIndex()==0) {
                    JOptionPane.showMessageDialog(this,"Please complete this form","Error",JOptionPane.ERROR_MESSAGE);//show error message
                }
                else{
                    cd.setquantity(Integer.valueOf(ColdCoffeeQuantityL.getText()));//set quantity value of cold drink object into text of quantity label
                    d = (Drink)cd;//refer it to drink object
                    olist.addOrder(d);//add drink object into order list
                    JOptionPane.showMessageDialog(this, "Added Succesfully!");//show 'Added Successfully' notification
                    TabPane1.setSelectedComponent(OrderListP);//go to Order List Panel
                    addtoRowTable(d);//call addtoRowTable function
                    ColdCoffeeNameL.setText("None");//set text of name label into 'None'
                    ColdCoffeeTypeL.setText("None");//set text of drink type label into 'None'
                    ColdCoffeePriceL.setText("0.0");//set text of price label into '0.0'
                    ResetColdCoffeeForm();//call ResetColdCoffeeForm function
                }
           }
       }
    }//GEN-LAST:event_ColdCoffeeAddBtnActionPerformed
//Hot Drink Panel Regular Radio Button Action Performed method
    private void HotDrinkRegRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotDrinkRegRBActionPerformed
        // TODO add your handling code here:
         //check whether drink object is Hot Drink or not
        if(d instanceof HotDrink){
            hd= (HotDrink)d;//refer it to hot drink object
            hd.setSize("regular");//set size value of hot drink object into 'regular'
            d=(Drink)hd;//refer it to drink object
        }
    }//GEN-LAST:event_HotDrinkRegRBActionPerformed
//Hot Drink Panel Large Radio Button Action Performed method
    private void HotDrinkLarRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotDrinkLarRBActionPerformed
        // TODO add your handling code here:
         //check whether drink object is Hot Drink or not
       if(d instanceof HotDrink){
            hd= (HotDrink)d;//refer it to hot drink object
            hd.setSize("large");//set size value of hot drink object into 'large'
            d=(Drink)hd;//refer it to drink object
        }
    }//GEN-LAST:event_HotDrinkLarRBActionPerformed
//Hot Drink Panel Check Button Action Performed method
    private void HotDrinkCheckBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotDrinkCheckBtnActionPerformed
        // TODO add your handling code here:
        //check whether text of name label is "none" or not and text of price label is "0.0" or not
        if(HotDrinkNameL.getText().equalsIgnoreCase("none")&&HotDrinkPriceL.getText().equalsIgnoreCase("0.0")){
              JOptionPane.showMessageDialog(this,"Please order a drink  first","Error",JOptionPane.ERROR_MESSAGE);//show error message
            TabPane1.setSelectedComponent(MenuP);//go to Menu Panel
        }
        else{
             //check whether drink object is Hot Drink or not
             if(d instanceof HotDrink){
                hd = (HotDrink) d;//refer it to hot drink object
                //check whether size button group is null or not and sugar combo box is in index 0 or not
                if(HotDrinkSizeBtnG.getSelection()==null || HotDrinkSugarCombo.getSelectedIndex()==0){
                    JOptionPane.showMessageDialog(this,"Please complete this form","Error",JOptionPane.ERROR_MESSAGE);//show error message
                }
                else{
                    hd.setquantity(Integer.valueOf(HotDrinkQuantityL.getText()));//set quantity value of hot drink object into text of quantity label
                    HotDrinkPriceL.setText(Double.toString(hd.getTotal()));//set text of price label into total price value of hot drink object
                    d = (Drink) hd;//refer it to drink object
                }
            }
        }
    }//GEN-LAST:event_HotDrinkCheckBtnActionPerformed
//Hot Drink Panel Add Button Action Performed method
    private void HotDrinkAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotDrinkAddBtnActionPerformed
        // TODO add your handling code here:
        //check whether text of name label is "none" or not and text of price label is "0.0" or not
        if(HotDrinkNameL.getText().equalsIgnoreCase("none")&&HotDrinkPriceL.getText().equalsIgnoreCase("0.0")){
            JOptionPane.showMessageDialog(this,"Please order a drink  first","Error",JOptionPane.ERROR_MESSAGE);//show error message
            TabPane1.setSelectedComponent(MenuP);//go to Menu Panel
        }
        else{
            //check whether drink object is Hot Drink or not
            if(d instanceof HotDrink){
                hd = (HotDrink) d;//refer it to hot drink object
                 //check whether size button group is null or not and sugar combo box is in index 0 or not
                if(HotDrinkSizeBtnG.getSelection()==null || HotDrinkSugarCombo.getSelectedIndex()==0){
                    JOptionPane.showMessageDialog(this,"Please complete this form","Error",JOptionPane.ERROR_MESSAGE);//show error message
                }
                else{
                    hd.setquantity(Integer.valueOf(HotDrinkQuantityL.getText()));//set quantity value of hot drink object into text of quantity label
                    d = (Drink) hd;//refer it to drink object
                    olist.addOrder(d);//add drink object into order list
                    JOptionPane.showMessageDialog(this, "Added Succesfully!");//show 'Added Successfully' notification
                    TabPane1.setSelectedComponent(OrderListP);//go to Order List Panel
                    addtoRowTable(d);//call addtoRowTable function
                    HotDrinkNameL.setText("None");//set text of name label into 'None'
                    HotDrinkTypeL.setText("None");//set text of drink type label into 'None'
                    HotDrinkPriceL.setText("0.0");//set text of price label into '0.0'
                    ResetHotDrinkForm();//call ResetHotDrinkForm function
                }
            }    
        }
    }//GEN-LAST:event_HotDrinkAddBtnActionPerformed
//Back Button Action Performed method
    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
        TabPane1.setSelectedComponent(MenuP);//go to Menu Panel
        CoffeeMenuNameL.setText("None");//set text of Coffee Panel name label into 'None'
        CoffeeMenuPriceL.setText("0.0");//set text of Coffee Panel price label into '0.0'
        TeaMenuNameL.setText("None");//set text of Tea Panel name label into 'None'
        TeaMenuPriceL.setText("0.0");//set text of Tea Panel price label into '0.0'
    }//GEN-LAST:event_BackBtnActionPerformed
//Delete Order Button Action Performed method
    private void DeleteOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteOrderBtnActionPerformed
        // TODO add your handling code here:
        //check whether text of name text field is empty string or not
        if(OrderNametf.getText().equalsIgnoreCase("")){
             JOptionPane.showMessageDialog(this,"Please input the drink name first","Error",JOptionPane.ERROR_MESSAGE);//show error message
        }
        else{
            //check whether text of name text field is in order list or not to be deleted
            if(olist.deleteOrder(OrderNametf.getText())){
                JOptionPane.showMessageDialog(this,"Deleted Successfully!");// show 'Deleted Successfully' notification
                clearTable((DefaultTableModel) OrderTable.getModel());//call clearTable function
                AddAllRowTable((DefaultTableModel) OrderTable.getModel());//call AddAllRowTable function
                OrderNametf.setText("");//set text of name text field into empty string
            }
            else{
                JOptionPane.showMessageDialog(this,"Nothing to be deleted","Error",JOptionPane.ERROR_MESSAGE);//show error message
                OrderNametf.setText("");//set text of name text field into empty string
            }
        }
    }//GEN-LAST:event_DeleteOrderBtnActionPerformed
//Ice Milk Tea Button Action Performed method 
    private void ColdMilkTeaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdMilkTeaBtnActionPerformed
        // TODO add your handling code here:
        d = coldmt;//get values of coldmt object
        TeaMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        TeaMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_ColdMilkTeaBtnActionPerformed
//Ice Matcha Button Action Performed method
    private void ColdMatchaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdMatchaBtnActionPerformed
        // TODO add your handling code here:
        d = coldmat;//get values of coldmat object
        TeaMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        TeaMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_ColdMatchaBtnActionPerformed
//Hot Milk Tea Button Action Performed method
    private void HotMilkTeaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotMilkTeaBtnActionPerformed
        // TODO add your handling code here:
        d = hotmt;//get values of hotmt object
        TeaMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        TeaMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_HotMilkTeaBtnActionPerformed
//Hot Matcha Button Action Performed method
    private void HotMatchaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotMatchaBtnActionPerformed
        // TODO add your handling code here:
        d = hotmat;//get values of hotmt object
        TeaMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        TeaMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_HotMatchaBtnActionPerformed
//Tea Panel Next Button Action Performed method
    private void TeaNextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeaNextBtnActionPerformed
        // TODO add your handling code here:
       //check whether text of name label is "none" or not and text of price label is "0.0" or not
        if(TeaMenuNameL.getText().equalsIgnoreCase("none") && TeaMenuPriceL.getText().equalsIgnoreCase("0.0")){
            JOptionPane.showMessageDialog(this,"Please select a drink first","Error",JOptionPane.ERROR_MESSAGE);//show error message
        }
        else{
            TabPane1.setSelectedComponent(PrefP);//go to Preference Panel
            //check whether drink object is Cold Drink or Hot Drink
            if(d.getDrinktype().equalsIgnoreCase("hot")){
                TabPane3.setSelectedComponent(HotDrinkP);//go to Hot Drink Panel
                HotDrinkNameL.setText(d.getName());//set text of name label into name value of drink object
                HotDrinkTypeL.setText(d.getDrinktype());//set text of drink type label into drink type value of drink object
                HotDrinkPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
                ResetHotDrinkForm();//call ResetHotDrinkForm function
            }
            else if(d.getDrinktype().equalsIgnoreCase("cold")){
                TabPane3.setSelectedComponent(ColdTeaP);//go to Cold Tea Panel
                ColdTeaNameL.setText(d.getName());//set text of name label into name value of drink object
                ColdTeaTypeL.setText(d.getDrinktype());//set text of drink type label into drink type value of drink object
                ColdTeaPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
                ResetColdTeaForm();//call ResetColdTeaForm function
            }
        }  
    }//GEN-LAST:event_TeaNextBtnActionPerformed
//Cold Tea Panel Combo Box Action Performed method
    private void ColdTeaComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdTeaComboActionPerformed
        // TODO add your handling code here:
        //check whether drink object is Cold Drink or not
        if(d instanceof ColdDrink){
            cd = (ColdDrink) d;//refer it to cold drink object
            if(ColdTeaCombo.getSelectedIndex()==1){
                cd.addTopping("None");//set topping name value of cold drink object into "None"
            }
            else if(ColdTeaCombo.getSelectedIndex()==2){
                cd.addTopping("Bubble Gum",3000);//set topping name value of cold drink object into "Bubble Gum"
            }
             else if(ColdTeaCombo.getSelectedIndex()==3){
                cd.addTopping("Konjac Jelly",5000);//set topping name value of cold drink object into "Konjac Jelly"
            }
             else if(ColdTeaCombo.getSelectedIndex()==4){
                cd.addTopping("Aloe Vera",6000);//set topping name value of cold drink object into "Aloe Vera"
            }
            d = (Drink)cd;//refer it to drink object
        }
    }//GEN-LAST:event_ColdTeaComboActionPerformed
//Cold Tea Panel Check Button Action Performed method
    private void ColdTeaCheckBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdTeaCheckBtnActionPerformed
        // TODO add your handling code here:
        //check whether text of name label is "none" or not and text of price label is "0.0" or not
       if(ColdTeaNameL.getText().equalsIgnoreCase("none")&&ColdTeaPriceL.getText().equalsIgnoreCase("0.0")){
           JOptionPane.showMessageDialog(this,"Please order a drink  first","Error",JOptionPane.ERROR_MESSAGE);//show error message
           TabPane1.setSelectedComponent(MenuP); //go to Menu Panel
        }
        else{
           //check whether drink object is Cold Drink or not
             if( d instanceof ColdDrink){
               cd = (ColdDrink)d;//refer it to cold drink object
               //check whether size button group is null or not, ice button group is null or not, topping combo box is in index 0 or not, and sugar combo box is in index 0 or not
               if (ColdTeaSizeBtnG.getSelection()==null || ColdTeaIceBtnG.getSelection()==null || ColdTeaCombo.getSelectedIndex()==0 || ColdTeaSugarCombo.getSelectedIndex()==0){
                   JOptionPane.showMessageDialog(this,"Please complete this form","Error",JOptionPane.ERROR_MESSAGE);//show error message
               }
               else{
                    cd.setquantity(Integer.valueOf(ColdTeaQuantityL.getText()));//set quantity value of cold drink object into text of quantity label
                    ColdTeaPriceL.setText(Double.toString(cd.getTotal()));//set text of price label into total price value of cold drink object
                    d = (Drink)cd;//refer it to drink object
               }
           }
       }
    }//GEN-LAST:event_ColdTeaCheckBtnActionPerformed
//Cold Tea Panel Add Button Action Performed method
    private void ColdTeaAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdTeaAddBtnActionPerformed
        // TODO add your handling code here:
         //check whether text of name label is "none" or not and text of price label is "0.0" or not
         if(ColdTeaNameL.getText().equalsIgnoreCase("none")&&ColdTeaPriceL.getText().equalsIgnoreCase("0.0")){
            JOptionPane.showMessageDialog(this,"Please order a drink  first","Error",JOptionPane.ERROR_MESSAGE);//show error message
           TabPane1.setSelectedComponent(MenuP); //go to Menu Panel
        }
        else{
             //check whether drink object is Cold Drink or not
            if(d instanceof ColdDrink){
                cd = (ColdDrink) d;//refer it to cold drink object
                 //check whether size button group is null or not, ice button group is null or not, topping combo box is in index 0 or not, and sugar combo box is in index 0 or not
                if(ColdTeaSizeBtnG.getSelection()==null || ColdTeaIceBtnG.getSelection()==null || ColdTeaCombo.getSelectedIndex()==0 || ColdTeaSugarCombo.getSelectedIndex()==0){
                   JOptionPane.showMessageDialog(this,"Please complete this form","Error",JOptionPane.ERROR_MESSAGE);//show error message
                }
                else{
                    cd.setquantity(Integer.valueOf(ColdTeaQuantityL.getText()));//set quantity value of cold drink object into text of quantity label
                    d = (Drink)cd;//refer it to drink object
                    olist.addOrder(d);//add drink object into order list
                    JOptionPane.showMessageDialog(this, "Added Succesfully!");//show 'Added Successfully' notification
                    TabPane1.setSelectedComponent(OrderListP);//go to Order List Panel
                    addtoRowTable(d);//call addtoRowTable function
                    ColdTeaNameL.setText("None");//set text of name label into 'None'
                    ColdTeaTypeL.setText("None");//set text of drink type label into drink type value of drink object
                    ColdTeaPriceL.setText("0.0");//set text of price label into price value of drink object
                    ResetColdTeaForm();//call ResetColdTeaForm function
                }
                    
            }       
        }
    }//GEN-LAST:event_ColdTeaAddBtnActionPerformed
//Cold Tea Regular Radio Button Action Performed method
    private void ColdTeaRegRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdTeaRegRBActionPerformed
        // TODO add your handling code here:
         //check whether drink object is Cold Drink or not
        if(d instanceof ColdDrink){
            cd= (ColdDrink)d;//refer it to cold drink object
            cd.setSize("regular");//set size value of cold drink object into "regular"
            d=(Drink)cd;//refer it to drink object
        }
    }//GEN-LAST:event_ColdTeaRegRBActionPerformed
//Cold Tea Large Radio Button Action Performed method
    private void ColdTeaLarRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdTeaLarRBActionPerformed
        // TODO add your handling code here:
         //check whether drink object is Cold Drink or not
         if(d instanceof ColdDrink){
            cd= (ColdDrink)d;//refer it to cold drink object
            cd.setSize("large");//set size value of cold drink object into "large"
            d=(Drink)cd;//refer it to drink object
        }
    }//GEN-LAST:event_ColdTeaLarRBActionPerformed
//Order Grand Total Button Action Performed method
    private void OrderGetTotalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderGetTotalBtnActionPerformed
        // TODO add your handling code here:
        //check whether order list is empty or not
        if(!olist.isEmptyOrder()){
           OrderTotalPriceL.setText(Double.toString(GetPriceFromTable()));//set text of total price label into return value of GetPriceFromTable function
            OrderNumberL.setText(Integer.toString(oq.getNumber()));//set text of order queue number label into value of order queue number
        }
        else{
            JOptionPane.showMessageDialog(this,"Order List is still empty","Error",JOptionPane.ERROR_MESSAGE);//show error message
        }
    }//GEN-LAST:event_OrderGetTotalBtnActionPerformed
//Order Reset Button Action Performed method
    private void OrderResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderResetBtnActionPerformed
        // TODO add your handling code here:
        //check whether text of order queue number label is equal to order queue number or not
        if(Integer.valueOf(OrderNumberL.getText())!=oq.getNumber()){
            JOptionPane.showMessageDialog(this,"Please get queue number","Error",JOptionPane.ERROR_MESSAGE);//show error message
        }
        else{
            //check whether isPaid is true or not
            if(olist.isPaid()){
                //do I/O error handling
                try{
                    olist.write(OrderNumberL.getText());//write drink objects into file that is named after text of order queue number label
                    //write drink objects and order queue number into file that is named after "Customer"+ text of order queue number label
                    olist.write(OrderNumberL.getText(),oq.getNumber());
                    oq.push(oq.getNumber());//push back order queue number into order queue list
                    oq.numberincrement();//increase order queue number
                    JOptionPane.showMessageDialog(this,"Order Queue has been added");//show "Order Queue has been added" notification
                    olist.clearOrder();//clear all drink objects from order list
                    olist.setPaid(false);//set statement of isPaid into false
                    clearTable((DefaultTableModel) OrderTable.getModel());//clear order list table
                    OrderPaytf.setText("");//set text of pay text field into empty string
                    OrderChangePriceL.setText("0.0");//set text of change price label into 0.0
                    OrderTotalPriceL.setText("0.0");//set text of total price label into 0.0
                }
                catch(IOException e){
                    e.printStackTrace();//print error stack
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Please complete the payment first","Error",JOptionPane.ERROR_MESSAGE);//show error message
            }
        }
    }//GEN-LAST:event_OrderResetBtnActionPerformed
//Cold Coffee Panel Normal Radio Button Action Performed method
    private void ColdCoffeeNormalRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdCoffeeNormalRBActionPerformed
        // TODO add your handling code here:
        //check whether drink object is Cold Drink or not
        if(d instanceof ColdDrink){
            cd = (ColdDrink) d;//refer it to cold drink object
            cd.setice("normal");//set ice value of cold drink object into "normal"
            d = (Drink) cd;//refer it to drink object
        }
    }//GEN-LAST:event_ColdCoffeeNormalRBActionPerformed
//Cold Coffee Panel Less Radio Button Action Performed method
    private void ColdCoffeeLessRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdCoffeeLessRBActionPerformed
        // TODO add your handling code here:
          //check whether drink object is Cold Drink or not
        if(d instanceof ColdDrink){
            cd = (ColdDrink) d;//refer it to cold drink object
            cd.setice("less");//set ice value of cold drink object into "less"
            d = (Drink) cd;//refer it to drink object
        }
    }//GEN-LAST:event_ColdCoffeeLessRBActionPerformed
//Cold Tea Panel Normal Radio Button Action Performed method
    private void ColdTeaNormalRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdTeaNormalRBActionPerformed
        // TODO add your handling code here:
        //check whether drink object is Cold Drink or not
        if(d instanceof ColdDrink){
            cd = (ColdDrink) d;//refer it to cold drink object
            cd.setice("normal");//set ice value of cold drink object into "normal"
            d = (Drink) cd;//refer it to drink object
        }
    }//GEN-LAST:event_ColdTeaNormalRBActionPerformed
//Cold Tea Panel Less Radio Button Action Performed method
    private void ColdTeaLessRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdTeaLessRBActionPerformed
        // TODO add your handling code here:
        //check whether drink object is Cold Drink or not
        if(d instanceof ColdDrink){
            cd = (ColdDrink) d;//refer it to cold drink object
            cd.setice("less");//set ice value of cold drink object into "less"
            d = (Drink) cd;//refer it to drink object
        }
    }//GEN-LAST:event_ColdTeaLessRBActionPerformed
//Cold Coffee Sugar Combo Box Action Performed method
    private void ColdCoffeeSugarComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdCoffeeSugarComboActionPerformed
        // TODO add your handling code here:
        //check whether drink object is Cold Drink or not
        if (d instanceof ColdDrink){
            cd = (ColdDrink) d;//refer it to cold drink object
            if (ColdCoffeeSugarCombo.getSelectedIndex()==1){
                cd.setsugar(0.0);//set sugar value of cold drink object into 0.0
            }
            else if(ColdCoffeeSugarCombo.getSelectedIndex()==2){
                cd.setsugar(0.25);//set sugar value of cold drink object into 0.25
            }
            else if(ColdCoffeeSugarCombo.getSelectedIndex()==3){
                cd.setsugar(0.5);//set sugar value of cold drink object into 0.5
            }
           else if(ColdCoffeeSugarCombo.getSelectedIndex()==4){
                cd.setsugar(0.75);//set sugar value of cold drink object into 0.75
            }
            else if(ColdCoffeeSugarCombo.getSelectedIndex()==5){
                cd.setsugar(1.0);//set sugar value of cold drink object into 1.0
            }
            else if(ColdCoffeeSugarCombo.getSelectedIndex()==6){
                cd.setsugar(1.25);//set sugar value of cold drink object into 1.25
            }
            d = (Drink)cd;//refer it to drink object
        }
    }//GEN-LAST:event_ColdCoffeeSugarComboActionPerformed
//Cold Tea Sugar Combo Box Action Performed method
    private void ColdTeaSugarComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdTeaSugarComboActionPerformed
        // TODO add your handling code here:
        //check whether drink object is Cold Drink or not
        if (d instanceof ColdDrink){
            cd = (ColdDrink) d;//refer it to cold drink object
           if (ColdTeaSugarCombo.getSelectedIndex()==1){
                cd.setsugar(0.0);//set sugar value of cold drink object into 0.0
            }
           else if (ColdTeaSugarCombo.getSelectedIndex()==2){
                cd.setsugar(0.25);//set sugar value of cold drink object into 0.25
            }
            else if (ColdTeaSugarCombo.getSelectedIndex()==3){
                cd.setsugar(0.5);//set sugar value of cold drink object into 0.5
            }
            else if (ColdTeaSugarCombo.getSelectedIndex()==4){
                cd.setsugar(0.75);//set sugar value of cold drink object into 0.75
            }
            else if (ColdTeaSugarCombo.getSelectedIndex()==5){
                cd.setsugar(1.0);//set sugar value of cold drink object into 1.0
            }
            else if (ColdTeaSugarCombo.getSelectedIndex()==6){
                cd.setsugar(1.25);//set sugar value of cold drink object into 1.25
            }
            d = (Drink)cd;//refer it to drink object
        }
    }//GEN-LAST:event_ColdTeaSugarComboActionPerformed
//Hot Drink Sugar Combo Box Action Performed method
    private void HotDrinkSugarComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotDrinkSugarComboActionPerformed
        // TODO add your handling code here:
        //check whether drink object is Hot Drink or not
        if (d instanceof HotDrink){
            hd = (HotDrink) d;//refer it to hot drink object
            if (HotDrinkSugarCombo.getSelectedIndex()==1){
                hd.setsugar(0.0);//set sugar value of hot drink object into 0.0
            }
           else if (HotDrinkSugarCombo.getSelectedIndex()==2){
                hd.setsugar(0.25);//set sugar value of hot drink object into 0.25
            }
           else if (HotDrinkSugarCombo.getSelectedIndex()==3){
                hd.setsugar(0.5);//set sugar value of hot drink object into 0.5
            }
            else if (HotDrinkSugarCombo.getSelectedIndex()==4){
                hd.setsugar(0.75);//set sugar value of hot drink object into 0.75
            }
            else if (HotDrinkSugarCombo.getSelectedIndex()==5){
                hd.setsugar(1.0);//set sugar value of hot drink object into 1.0
            }
            else if (HotDrinkSugarCombo.getSelectedIndex()==6){
                hd.setsugar(1.25);//set sugar value of hot drink object into 1.25
            }
            d = (Drink)hd;//refer it to drink object
        }
    }//GEN-LAST:event_HotDrinkSugarComboActionPerformed
//Show Order List Button Action Performed method
    private void ShowBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowBtnActionPerformed
        // TODO add your handling code here:
        //check whether order queue list is empty or not
        if(!oq.isEmptyQueue()){
            //check whether order list is empty or not
            if(olist.isEmptyOrder()){
                //do I/O error handling
                try{
                    CheckNumberL.setText(String.valueOf(oq.top()));//set text of check number label into top value of order queue list
                    olist.read(CheckNumberL.getText());//read objects from file that is named after text of check number label into order list
                    AddAllRowTable((DefaultTableModel) CheckTable.getModel());//call AddAllRowTable function
                }
                catch(IOException e){
                    e.printStackTrace();//print error stack
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Please complete this order first","Error",JOptionPane.ERROR_MESSAGE);//show error message
            }    
        }
        else{
            JOptionPane.showMessageDialog(this,"Order Queue is still empty","Error",JOptionPane.ERROR_MESSAGE);//show error message
        }
    }//GEN-LAST:event_ShowBtnActionPerformed
//Finish Order List Button Action Performed method
    private void FinishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishBtnActionPerformed
        // TODO add your handling code here:
        //check whether order queue list is empty or not
        if(oq.isEmptyQueue()){
             JOptionPane.showMessageDialog(this,"Order Queue is still empty","Error",JOptionPane.ERROR_MESSAGE);//show error message
        }
        else{
            if(Integer.valueOf(CheckNumberL.getText())==oq.top()){
                JOptionPane.showMessageDialog(this, "This order is complete");//show "This order is complete" notification
                olist.clearOrder();//clear all drink objects from order list
                clearTable((DefaultTableModel) CheckTable.getModel());//clear check order table
                //do I/O error handling
                try{
                    olist.write(String.valueOf(CheckNumberL.getText()));//write drink objects into file that is named after text of order queue number label
                    //write drink objects and order queue number into file that is named after "Customer"+ text of order queue number label
                    olist.write(String.valueOf(CheckNumberL.getText()),0);
                    oq.pop();//pop front order queue list
                }
                catch(IOException e){
                    e.printStackTrace();//print error stack
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Please click \"Show\" button first","Error",JOptionPane.ERROR_MESSAGE);//show error message
            }
        }
    }//GEN-LAST:event_FinishBtnActionPerformed
//Cold Coffee Panel Decrement Button Action Performed method
    private void ColdCoffeeDecrementBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdCoffeeDecrementBtnActionPerformed
        // TODO add your handling code here:
        int quantity = Integer.valueOf(ColdCoffeeQuantityL.getText());//get quantity value from text of quantity label
        quantity --;//decrease quantity
        //check whether quantity is equal to or less than 0 or not
        if(quantity <= 0){
            quantity = 1;//set quantity value into 1
        }
        ColdCoffeeQuantityL.setText(String.valueOf(quantity));//set text of quantity label into quantity value
    }//GEN-LAST:event_ColdCoffeeDecrementBtnActionPerformed
//Cold Coffee Panel Increment Button Action Performed method
    private void ColdCoffeeIncrementBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdCoffeeIncrementBtnActionPerformed
        // TODO add your handling code here:
        int quantity = Integer.valueOf(ColdCoffeeQuantityL.getText());//get quantity value from text of quantity label
        quantity ++;//increase quantity
        ColdCoffeeQuantityL.setText(String.valueOf(quantity));//set text of quantity label into quantity value
    }//GEN-LAST:event_ColdCoffeeIncrementBtnActionPerformed
//Cold Tea Panel Decrement Button Action Performed method
    private void ColdTeaDecrementBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdTeaDecrementBtnActionPerformed
        // TODO add your handling code here:
        int quantity = Integer.valueOf(ColdTeaQuantityL.getText());//get quantity value from text of quantity label
        quantity --;//decrease quantity
        //check whether quantity is equal to or less than 0 or not
        if(quantity <= 0){
            quantity = 1;//set quantity value into 1
        }
        ColdTeaQuantityL.setText(String.valueOf(quantity));//set text of quantity label into quantity value
    }//GEN-LAST:event_ColdTeaDecrementBtnActionPerformed
//Cold Tea Panel Increment Button Action Performed method
    private void ColdTeaIncrementBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdTeaIncrementBtnActionPerformed
        // TODO add your handling code here:
        int quantity = Integer.valueOf(ColdTeaQuantityL.getText());//get quantity value from text of quantity label
        quantity ++;//increase quantity
        ColdTeaQuantityL.setText(String.valueOf(quantity));//set text of quantity label into quantity value
    }//GEN-LAST:event_ColdTeaIncrementBtnActionPerformed
//Hot Drink Panel Decrement Button Action Performed method
    private void HotDrinkDecrementBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotDrinkDecrementBtnActionPerformed
        // TODO add your handling code here:
        int quantity = Integer.valueOf(HotDrinkQuantityL.getText());//get quantity value from text of quantity label
        quantity --;//decrease quantity
        //check whether quantity is equal to or less than 0 or not
        if(quantity <= 0){
            quantity = 1;//set quantity value into 1
        }
        HotDrinkQuantityL.setText(String.valueOf(quantity));//set text of quantity label into quantity value
    }//GEN-LAST:event_HotDrinkDecrementBtnActionPerformed
//Hot Drink Panel Increment Button Action Performed method
    private void HotDrinkIncrementBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotDrinkIncrementBtnActionPerformed
        // TODO add your handling code here:
         int quantity = Integer.valueOf(HotDrinkQuantityL.getText());//get quantity value from text of quantity label
        quantity ++;//increase quantity
        HotDrinkQuantityL.setText(String.valueOf(quantity));//set text of quantity label into quantity value
    }//GEN-LAST:event_HotDrinkIncrementBtnActionPerformed
//Ice Americano button action performed method 
    private void ColdAmeriBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdAmeriBtnActionPerformed
        // TODO add your handling code here:
        d = coldameri;//get values of coldameri object
        CoffeeMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        CoffeeMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_ColdAmeriBtnActionPerformed
//Hot Vanilla Latte button action performed method
    private void HotVanillaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotVanillaBtnActionPerformed
        // TODO add your handling code here:
        d = hotvanilla;//get values of hotvanilla object
        CoffeeMenuNameL.setText(d.getName()); //set text of name label into name value of drink object
        CoffeeMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_HotVanillaBtnActionPerformed
//Ice Espresso button action performed method 
    private void ColdEspBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdEspBtnActionPerformed
        // TODO add your handling code here:
        d = coldesp;//get values of coldesp object
        CoffeeMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        CoffeeMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_ColdEspBtnActionPerformed
//Ice Caffe Latte button action performed method
    private void ColdCafLatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdCafLatBtnActionPerformed
        // TODO add your handling code here:
        d = coldcaflat;//get values of coldcaflat object
        CoffeeMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        CoffeeMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_ColdCafLatBtnActionPerformed
//Ice Vanilla Latte button action performed method
    private void ColdVanillaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdVanillaBtnActionPerformed
        // TODO add your handling code here:
        d = coldvanilla;//get values of coldvanilla object
        CoffeeMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        CoffeeMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_ColdVanillaBtnActionPerformed
//Ice Frappuccino button action performed method
    private void ColdFrapBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdFrapBtnActionPerformed
        // TODO add your handling code here:
        d = coldfrap;//get values of coldfrap object
        CoffeeMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        CoffeeMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_ColdFrapBtnActionPerformed
//Hot Americano button action performed method
    private void HotAmeriBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotAmeriBtnActionPerformed
        // TODO add your handling code here:
        d = hotameri;//get values of hotameri object
        CoffeeMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        CoffeeMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_HotAmeriBtnActionPerformed
//Hot Espresso button action performed method
    private void HotEspBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotEspBtnActionPerformed
        // TODO add your handling code here:
        d = hotesp;//get values of hotesp object
        CoffeeMenuNameL.setText(d.getName()); //set text of name label into name value of drink object
        CoffeeMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_HotEspBtnActionPerformed
//Hot Caffe Latte button action performed method
    private void HotCafLatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotCafLatBtnActionPerformed
        // TODO add your handling code here:
        d = hotcaflat;//get values of hotcaflat object
        CoffeeMenuNameL.setText(d.getName()); //set text of name label into name value of drink object
        CoffeeMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_HotCafLatBtnActionPerformed
//Ice Black Milk Tea Button Action Performed method 
    private void ColdBTeaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdBTeaBtnActionPerformed
        // TODO add your handling code here:
        d = coldbtea;//get values of coldbtea object
        TeaMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        TeaMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_ColdBTeaBtnActionPerformed
//Ice Mango Tea Button Action Performed method
    private void ColdManTeaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdManTeaBtnActionPerformed
        // TODO add your handling code here:
        d = coldmantea;//get values of coldmantea object
        TeaMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        TeaMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_ColdManTeaBtnActionPerformed
//Ice Peach Tea Button Action Performed method
    private void ColdPeachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdPeachBtnActionPerformed
        // TODO add your handling code here:
        d = coldpeach;//get values of coldpeach object
        TeaMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        TeaMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_ColdPeachBtnActionPerformed
//Ice Taro Milk Tea Button Action Performed method
    private void ColdTaroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdTaroBtnActionPerformed
        // TODO add your handling code here:
        d = coldtaro;//get values of coldtaro object
        TeaMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        TeaMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_ColdTaroBtnActionPerformed
//Ice Chocolate Milk Tea Button Action Performed method
    private void ColdChocoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdChocoBtnActionPerformed
        // TODO add your handling code here:
        d = coldchoco;//get values of coldchoco object
        TeaMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        TeaMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_ColdChocoBtnActionPerformed
//Ice Vanilla Milk Tea Button Action Performed method
    private void ColdVanTeaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdVanTeaBtnActionPerformed
        // TODO add your handling code here:
        d = coldvantea;//get values of coldvantea object
        TeaMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        TeaMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_ColdVanTeaBtnActionPerformed
//Hot Black Milk Tea Button Action Performed method
    private void HotBTeaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotBTeaBtnActionPerformed
        // TODO add your handling code here:
        d = hotbtea;//get values of hotbtea object
        TeaMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        TeaMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_HotBTeaBtnActionPerformed
//Hot Mango Tea Button Action Performed method
    private void HotManTeaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotManTeaBtnActionPerformed
        // TODO add your handling code here:
        d = hotmantea;//get values of hotmantea object
        TeaMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        TeaMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_HotManTeaBtnActionPerformed
//Hot Peach Tea Button Action Performed method
    private void HotPeachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotPeachBtnActionPerformed
        // TODO add your handling code here:
        d = hotpeach;//get values of hotpeach object
        TeaMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        TeaMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_HotPeachBtnActionPerformed
//Hot Matcha Tea Latte Button Action Performed method
    private void HotMatLatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotMatLatBtnActionPerformed
        // TODO add your handling code here:
        d = hotmatlat;//get values of hotmatlat object
        TeaMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        TeaMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_HotMatLatBtnActionPerformed
//Hot Black Tea Latte Button Action Performed method
    private void HotBLatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotBLatBtnActionPerformed
        // TODO add your handling code here:
        d = hotblat;//get values of hotblat object
        TeaMenuNameL.setText(d.getName());//set text of name label into name value of drink object
        TeaMenuPriceL.setText(Double.toString(d.getPrice()));//set text of price label into price value of drink object
    }//GEN-LAST:event_HotBLatBtnActionPerformed
// Main program
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);//to make Main Menu jframe becomes visible
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JLabel CheckNumberL;
    private javax.swing.JPanel CheckOrderP;
    private javax.swing.JTable CheckTable;
    private javax.swing.JLabel CoffeeMenuNameL;
    private javax.swing.JLabel CoffeeMenuPriceL;
    private javax.swing.JButton CoffeeNextBtn;
    private javax.swing.JPanel CoffeeP;
    private javax.swing.JButton ColdAmeriBtn;
    private javax.swing.JButton ColdBTeaBtn;
    private javax.swing.JButton ColdCafLatBtn;
    private javax.swing.JButton ColdCappucinoBtn;
    private javax.swing.JButton ColdChocoBtn;
    private javax.swing.JButton ColdCoffeeAddBtn;
    private javax.swing.JButton ColdCoffeeCheckBtn;
    private javax.swing.JButton ColdCoffeeDecrementBtn;
    private javax.swing.ButtonGroup ColdCoffeeIceBtnG;
    private javax.swing.JButton ColdCoffeeIncrementBtn;
    private javax.swing.JRadioButton ColdCoffeeLarRB;
    private javax.swing.JRadioButton ColdCoffeeLessRB;
    private javax.swing.JLabel ColdCoffeeNameL;
    private javax.swing.JRadioButton ColdCoffeeNormalRB;
    private javax.swing.JPanel ColdCoffeeP;
    private javax.swing.JLabel ColdCoffeePriceL;
    private javax.swing.JLabel ColdCoffeeQuantityL;
    private javax.swing.JRadioButton ColdCoffeeRegRB;
    private javax.swing.ButtonGroup ColdCoffeeSizeBtnG;
    private javax.swing.JComboBox<String> ColdCoffeeSugarCombo;
    private javax.swing.ButtonGroup ColdCoffeeTopBtnG;
    private javax.swing.JLabel ColdCoffeeTypeL;
    private javax.swing.JButton ColdEspBtn;
    private javax.swing.JButton ColdFrapBtn;
    private javax.swing.JButton ColdManTeaBtn;
    private javax.swing.JButton ColdMatchaBtn;
    private javax.swing.JButton ColdMilkTeaBtn;
    private javax.swing.JButton ColdMochaBtn;
    private javax.swing.JButton ColdPeachBtn;
    private javax.swing.JButton ColdTaroBtn;
    private javax.swing.JButton ColdTeaAddBtn;
    private javax.swing.JButton ColdTeaCheckBtn;
    private javax.swing.JComboBox<String> ColdTeaCombo;
    private javax.swing.JButton ColdTeaDecrementBtn;
    private javax.swing.ButtonGroup ColdTeaIceBtnG;
    private javax.swing.JButton ColdTeaIncrementBtn;
    private javax.swing.JRadioButton ColdTeaLarRB;
    private javax.swing.JRadioButton ColdTeaLessRB;
    private javax.swing.JLabel ColdTeaNameL;
    private javax.swing.JRadioButton ColdTeaNormalRB;
    private javax.swing.JPanel ColdTeaP;
    private javax.swing.JLabel ColdTeaPriceL;
    private javax.swing.JLabel ColdTeaQuantityL;
    private javax.swing.JRadioButton ColdTeaRegRB;
    private javax.swing.ButtonGroup ColdTeaSizeBtnG;
    private javax.swing.JComboBox<String> ColdTeaSugarCombo;
    private javax.swing.JLabel ColdTeaTypeL;
    private javax.swing.JButton ColdVanTeaBtn;
    private javax.swing.JButton ColdVanillaBtn;
    private javax.swing.JButton ConfirmBtn;
    private javax.swing.JButton DeleteOrderBtn;
    private javax.swing.JButton FinishBtn;
    private javax.swing.JButton HotAmeriBtn;
    private javax.swing.JButton HotBLatBtn;
    private javax.swing.JButton HotBTeaBtn;
    private javax.swing.JButton HotCafLatBtn;
    private javax.swing.JButton HotCappucinoBtn;
    private javax.swing.JButton HotDrinkAddBtn;
    private javax.swing.JButton HotDrinkCheckBtn;
    private javax.swing.JButton HotDrinkDecrementBtn;
    private javax.swing.JButton HotDrinkIncrementBtn;
    private javax.swing.JRadioButton HotDrinkLarRB;
    private javax.swing.JLabel HotDrinkNameL;
    private javax.swing.JPanel HotDrinkP;
    private javax.swing.JLabel HotDrinkPriceL;
    private javax.swing.JLabel HotDrinkQuantityL;
    private javax.swing.JRadioButton HotDrinkRegRB;
    private javax.swing.ButtonGroup HotDrinkSizeBtnG;
    private javax.swing.JComboBox<String> HotDrinkSugarCombo;
    private javax.swing.JLabel HotDrinkTypeL;
    private javax.swing.JButton HotEspBtn;
    private javax.swing.JButton HotManTeaBtn;
    private javax.swing.JButton HotMatLatBtn;
    private javax.swing.JButton HotMatchaBtn;
    private javax.swing.JButton HotMilkTeaBtn;
    private javax.swing.JButton HotMocha;
    private javax.swing.JButton HotPeachBtn;
    private javax.swing.JButton HotVanillaBtn;
    private javax.swing.JPanel MenuP;
    private javax.swing.JRadioButton NoRB;
    private javax.swing.JLabel OrderChangePriceL;
    private javax.swing.JButton OrderGetTotalBtn;
    private javax.swing.JPanel OrderListP;
    private javax.swing.JTextField OrderNametf;
    private javax.swing.JLabel OrderNumberL;
    private javax.swing.JTextField OrderPaytf;
    private javax.swing.JButton OrderResetBtn;
    private javax.swing.JTable OrderTable;
    private javax.swing.JLabel OrderTotalPriceL;
    private javax.swing.JPanel PrefP;
    private javax.swing.JButton ShowBtn;
    private javax.swing.JTabbedPane TabPane1;
    private javax.swing.JTabbedPane TabPane2;
    private javax.swing.JTabbedPane TabPane3;
    private javax.swing.JLabel TeaMenuNameL;
    private javax.swing.JLabel TeaMenuPriceL;
    private javax.swing.JButton TeaNextBtn;
    private javax.swing.JPanel TeaP;
    private javax.swing.JRadioButton YesRB;
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
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
//end of Main Menu class
/*References:
Coffee Drink Names' sources: https://coffee.fandom.com/wiki/List_of_coffee_drinks, https://www.starbucks.com/menu/drinks/frappuccino-blended-beverages
Tea Drink Names' sources: https://tealovers.com/10-bubble-tea-types-must-taste/, https://www.starbucks.com/menu/catalog/product?drink=tea#view_control=product
*/
