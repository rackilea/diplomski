package AsciiToDIVs;

import java.util.ArrayList;

public class FoundBoxObject extends FoundObject {
    public ArrayList<FoundObject> containedObjects = new ArrayList<FoundObject>();
    public static int boxCounter = 0;

    public final int ID = boxCounter++;

    public FoundBoxObject(int rowIndex, int colIndex, int width, int height, FoundBoxObject parent) {
        super(rowIndex, colIndex, width, height);

        if(parent!=null)
        System.out.println("Created a box(" +
                "ID="+ID+
                ",X="+rowIndex+
                ",Y="+colIndex+
                ",width="+width+
                ",height="+height+
                ",parent="+parent.ID+")");
        else
            System.out.println("Created a box(" +
                    "ID="+ID+
                    ",X="+rowIndex+
                    ",Y="+colIndex+
                    ",width="+width+
                    ",height="+height+
                    ")");   
    }

}