
package employees;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ndekere254
 */
public class Employees extends JFrame {
    private JPanel pane;
    private JMenu files;
    private JLabel empno,name,dep,basic,hou;
    private JTextField emtx,natx,detx,batx,hotx;
    private  JButton submit,cancel;
    private JMenuItem add,view1;
public Employees (){
    pane=new JPanel();
   JMenuBar menubar =new JMenuBar();
        add=new JMenuItem("Add Employee");
        menubar.add(add);
        view1=new JMenuItem("View Employees");
        menubar.add(view1);
        
        view1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          setVisible(false);
          new view().setVisible(true);
        }
    });
       
        //decleare Labels
        pane.setLayout(null);
        empno=new JLabel("Emp No: ");
        name=new JLabel("Name :");
        dep=new JLabel("Department: ");
        basic=new JLabel("Basic Salary: ");
        hou=new JLabel("House Allowance: ");
        emtx=new JTextField();
        natx=new JTextField();
        detx=new JTextField();
        batx=new JTextField();
        hotx=new JTextField();
        save1 h=new save1();
        submit=new JButton("Submit");
        submit.addActionListener(h);
        refresh k=new refresh();
        cancel=new JButton("Cancel");
        cancel.addActionListener(k);
        //set in pane
        empno.setBounds(5, 0, 200, 30);
        name.setBounds(5, 50, 200, 30);
        dep.setBounds(5, 100, 200, 30);
        basic.setBounds(5, 150, 200, 30);
        hou.setBounds(5, 200, 200, 30);
        emtx.setBounds(110, 0, 200, 30);
        natx.setBounds(110, 50, 200, 30);
        detx.setBounds(110, 100, 200, 30);
        batx.setBounds(110, 150, 200, 30);
        hotx.setBounds(110, 200, 200, 30);
        submit.setBounds(5, 250, 100, 30);
        cancel.setBounds(200, 250, 100, 30);
       //add in pane 
            pane.add(empno);
            pane.add(name);
            pane.add(dep);
            pane.add(basic);
            pane.add(hou);
            pane.add(emtx);
            pane.add(natx);
            pane.add(detx);
            pane.add(batx);
            pane.add(hotx);
            pane.add(submit);
            pane.add(cancel);
    
   // pane.setBackground(Color.red);
    this.setJMenuBar(menubar);
    this.setTitle("Add Employee");
    this.add(pane);
    this.setVisible(true);
    this.setSize(350,400);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      center();
   
}

 public class save1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
         try {
   Salary s=new Salary();
   double basicsalary,houseallowance;
   basicsalary=Double.parseDouble(batx.getText());
   houseallowance=Double.parseDouble(hotx.getText());
   s.Nhif(basicsalary);
   s.Nssf();
   s.Payee(basicsalary);
   s.Gross(basicsalary, houseallowance);
   s.Gross(basicsalary, houseallowance);
   s.Netpay(basicsalary);
   
             String id,Name,dep1;
             double sal,hao;
             id=emtx.getText();
             Name=natx.getText();
             dep1=detx.getText();
             sal=Double.parseDouble(batx.getText());
             hao=Double.parseDouble(hotx.getText());
             double pension=0.5*sal;
             System.out.println(id+Name+dep1+sal+hao);
            Class.forName("com.mysql.jdbc.Driver");
             Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "");
             String query="insert into employee values ('"+id+"','"+Name+"','"+dep1+"','"+sal+"','"+hao+"','"+s.setNhif()+"','"+s.setNssf()+"','"+s.setPayee()+"','"+pension+"','"+s.setNetpay()+"')";
             PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
             st.executeUpdate(query);
            
        }   catch (ClassNotFoundException ex) {
               
                 JOptionPane.showMessageDialog(null, ex); 
            } catch (SQLException ex) {
         
         JOptionPane.showMessageDialog(null, ex);
     }
        }
    }
    public class refresh implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
         
       emtx.setText("");
       natx.setText("");
       detx.setText("");
       batx.setText("");
       hotx.setText("");
        }
    }
     public void center(){
    Toolkit tk=Toolkit.getDefaultToolkit();
    int sizex=(int) tk.getScreenSize().getWidth();
    int sizey=(int) tk.getScreenSize().getHeight();
    this.setLocation((sizex-350)/2, (sizey-450)/2);
    System.out.print(sizex+ "and"+sizey);
    }
    public static void main(String[] args) {
      new Employees().setVisible(true);
    
    }
    
}
