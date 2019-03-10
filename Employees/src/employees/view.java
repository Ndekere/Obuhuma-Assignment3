
package employees;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class view extends JFrame{
    private JPanel pane;
    private JMenuItem add,view;
    private JTable j; 
   private JScrollPane s;
    public view(){
    pane=new JPanel();
   // DefaultTableModel model = new DefaultTableModel(); 
    
    JMenuBar menubar =new JMenuBar();
   
        add=new JMenuItem("Add Employee");
        menubar.add(add);
        view=new JMenuItem("View Employees");
        add.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          setVisible(false);
          new Employees().setVisible(true);
        }
    });
        menubar.add(view);
         Connection conn;
          try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "");
             String query="select * from employee";
             Statement st =conn.createStatement();
             ResultSet sy=st.executeQuery(query);
            
             
              j=new JTable();
              j.setFillsViewportHeight(true);
              j.setPreferredScrollableViewportSize(new Dimension(700,400));
             // j.setGridColor(Color.white);
              j.setSelectionBackground(Color.GREEN);
              j.setAutoscrolls(true);
              j.setAutoResizeMode(5);
           j.setModel(DbUtils.resultSetToTableModel(sy));
        }   catch (ClassNotFoundException ex) {
              System.out.println(ex);
                
            } catch (SQLException ex) {
       System.out.println(ex);
        
     }
    
     s=new JScrollPane(j); 
     pane.add(s);
       
    this.setJMenuBar(menubar);
    this.setTitle("View Employee");
    this.add(pane);
    this.setVisible(true);
    this.setSize(750,500);
    this.setResizable(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocation(500, 0);
    center();
    }
     public void center(){
    Toolkit tk=Toolkit.getDefaultToolkit();
    int sizex=(int) tk.getScreenSize().getWidth();
    int sizey=(int) tk.getScreenSize().getHeight();
    this.setLocation((sizex-700)/2, (sizey-500)/2);
    System.out.print(sizex+ "and"+sizey);
    }
}
