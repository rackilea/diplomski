import java.io.IOException;
import java.util.Arrays;

import com.aspose.cells.MsoLineDashStyle;
import com.aspose.cells.PlacementType;
import com.aspose.cells.ShapeLine;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;


public class Main {
public static void main(String[] args) throws IOException{
    Workbook oWorkbook = new Workbook();

    Worksheet oWorksheet = oWorkbook.getWorksheets().addSheet("Sparklines");
    oWorksheet.getCells().getCell("A1").setValue(10);
    oWorksheet.getCells().getCell("B1").setValue(10);
    oWorksheet.getCells().getCell("C1").setValue(10);
    oWorksheet.getCells().getCell("D1").setValue(10);

    //We get the values from Excel worksheet
    int val1 =  Integer.parseInt(oWorksheet.getCells().getCell("A1").getValue().toString());
    int val2 =  Integer.parseInt(oWorksheet.getCells().getCell("B1").getValue().toString());
    int val3 =  Integer.parseInt(oWorksheet.getCells().getCell("C1").getValue().toString());
    int val4 =  Integer.parseInt(oWorksheet.getCells().getCell("D1").getValue().toString());

    //We set ascending sort
    int[] nums={val1,val2,val3,val4};  
    Arrays.sort(nums);  
    System.out.println("Minimum = " + nums[0]);  
    System.out.println("Maximum = " + nums[nums.length-1]);

    //constant values
    float height = 17;
    float width = 64;
    float dist = 20; //horizontal offset for each point

    //we find a constant to set the proportion between the point values and the cell height
    float con = height/nums[nums.length-1];
    System.out.println("Con = " + con);

    //we find the offset values ??relative to the upper edge of the cell
    float point1 = height - val1*con;
    float point2 = height - val2*con;
    float point3 = height - val3*con;
    float point4 = height - val4*con;

    //we'll have to round those values up
    int point1_int = Math.round(point1);
    int point2_int = Math.round(point2);
    int point3_int = Math.round(point3);
    int point4_int = Math.round(point4);

    System.out.println(point1);
    System.out.println(point2);
    System.out.println(point3);
    System.out.println(point4);
    /**********************************START OF LINE1*********************************************************/

    double  oposed_line = point1_int-point2_int;
    System.out.println("oposed_line:"+oposed_line);



    double hipotenusa = Math.sqrt(Math.pow(oposed_line, 2)+Math.pow(dist, 2));
    Math.round(hipotenusa);
    System.out.println("Hipotenusa: "+hipotenusa);

    //printing the line
    com.aspose.cells.LineShape line1  = oWorksheet.getShapes().addLine(0,4,2,point1_int, (int)hipotenusa, 0);

    //finding rotation_angle
    double rotation_angle =  Math.atan((oposed_line)/dist);
    rotation_angle = Math.toDegrees(rotation_angle);
    System.out.println("Angle 1: "+rotation_angle);

    line1.setRotation((float)-rotation_angle);

    /**********************************END OF LINE1*********************************************************/


    /********************************** LINE2*********************************************************/

    oposed_line = point2_int-point3_int;
    System.out.println("oposed_line:"+oposed_line);

    hipotenusa = Math.sqrt(Math.pow(oposed_line, 2)+Math.pow(dist, 2));
    Math.round(hipotenusa);
    System.out.println("Hipotenusa: "+hipotenusa);


    com.aspose.cells.LineShape line2  = oWorksheet.getShapes().addLine(0,4,(int)dist,point2_int, (int)hipotenusa, 0);

    rotation_angle =  Math.atan((oposed_line)/dist);
    rotation_angle = Math.toDegrees(rotation_angle);
    System.out.println("Angle 2: "+rotation_angle);

    line2.setRotation((float)-rotation_angle);

    /********************************** LINE2*********************************************************/     


    /**********************************LINE3*********************************************************/

    oposed_line = point3_int-point4_int;
    System.out.println("oposed_line:"+oposed_line);

    hipotenusa = Math.sqrt(Math.pow(oposed_line, 2)+Math.pow(dist, 2));
    Math.round(hipotenusa);
    System.out.println("Hipotenusa: "+hipotenusa);


    int offset = (int) (dist*2);
    com.aspose.cells.LineShape line3  = oWorksheet.getShapes().addLine(0,4,offset,point3_int,(int)hipotenusa, 0);


    rotation_angle =  Math.atan(oposed_line/dist);
    rotation_angle = Math.toDegrees(rotation_angle);
    System.out.println("Angle 3: "+rotation_angle);

    line3.setRotation((float)-rotation_angle);

    /**********************************LINE3*********************************************************/

    //Set the line dash style

    ShapeLine shapeline = line1.getLine();
    ShapeLine shapeline2 = line2.getLine();
    ShapeLine shapeline3 = line3.getLine();


    shapeline.setDashStyle(MsoLineDashStyle.SOLID);
    shapeline2.setDashStyle(MsoLineDashStyle.SOLID);
    shapeline3.setDashStyle(MsoLineDashStyle.SOLID);

    short smallNumber = 3;
    System.out.println(smallNumber);

    line1.setLineEndArrowHead(smallNumber);
    line2.setLineEndArrowHead(smallNumber);
    line3.setLineEndArrowHead(smallNumber);


    //Set the placement.

    line1.setPlacement(PlacementType.FREE_FLOATING);
    line2.setPlacement(PlacementType.FREE_FLOATING);
    line3.setPlacement(PlacementType.FREE_FLOATING);

    oWorkbook.save("C:\\test3.xlsx");

}