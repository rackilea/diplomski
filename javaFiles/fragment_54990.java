package haneef.code.check;

       import java.io.File;

       import java.util.ArrayList;

       import java.util.List;

       public class DirSpace

       {

            static Double val=1000000000.00;

            public static void main(String[] args) 

            {
                 File file=new File("\\");
                 List<Double> values=new ArrayList<Double>();
                 File[] list=file.listRoots();
                 for(File driver:list)
                 {
                      Double driveGB=driver.getTotalSpace()/val;
                      System.out.println("Driver "+driver+" Space - "+driveGB);
                      values.add(driveGB);
                      Double cDrive=values.get(0);
                      for(int i=1;i<values.size();i++)
                      {
                            Double totalSpace=cDrive+values.get(i);
                            System.out.println("Final --- Total space is "+totalSpace);
                      }
                 }

             }

        }