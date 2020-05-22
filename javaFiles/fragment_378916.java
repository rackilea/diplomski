import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JTable;


public class Hscore extends javax.swing.JFrame {

    public static String hname[]= new String[50];
    public static double hscore[]= new double[50];
    public static String hlevel[]= new String[50];
    public static String data[][]= new String[50][3];
    public Hscore() {
        initComponents();
        setHScore();
        String col[] = {"Name","Course","Grade"};
        JTable table = new JTable(data,col);
        table.setPreferredSize(new Dimension(200,200));
        jPanel1.add(table,BorderLayout.CENTER);
        getContentPane().add(jPanel1);
        setSize(300,200);
        setVisible(true);
    }
    public void op(){

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jButton1.setText("jButton1");

        /*javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                  .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                          .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 370, Short.MAX_VALUE)
                                          .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addContainerGap())
        );*/

        pack();
    }// </editor-fold>                        
    //=====Set HScore
    public void setHScore(){

        File oFile=new File("C:\\Users\\sony\\Documents\\NetBeansProjects\\SplashDemos\\HScore.txt");
        FileInputStream fis=null;
        BufferedInputStream bis=null;
        DataInputStream dis=null;
        int iIndex=0;
        String name;

        try{
            fis=new FileInputStream(oFile);
            bis=new BufferedInputStream(fis);
            dis=new DataInputStream(bis);

            while(dis.available()!=0){
                hname[iIndex]=dis.readLine();
                name=dis.readLine();
                hscore[iIndex]=(int) Double.parseDouble(name);
                hlevel[iIndex]=dis.readLine();
                data[iIndex]=new String[]{hname[iIndex], String.valueOf(hscore[iIndex]), hlevel[iIndex]};

                iIndex++;
            }
            fis.close();
            bis.close();
            dis.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //==============
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hscore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   

}