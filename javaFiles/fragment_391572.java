package AsciiToDIVs;

public class FoundCharObject extends FoundObject {
private Character Char;

public FoundCharObject(int rowIndex, int colIndex,FoundBoxObject parent, char Char) {
    super(rowIndex, colIndex, 1, 1);

    if(parent!=null)
    System.out.println("Created a char(" +
            "Char="+Char+
            ",X="+rowIndex+
            ",Y="+colIndex+
            ",parent="+parent.ID+")");
    else
        System.out.println("Created a char(" +
                ",X="+rowIndex+
                ",Y="+colIndex+")");

    this.Char = Char;
}

public Character getChar() {
    return Char;
}
}