public void expand() {
    String[] newArray = new String[OrigArray.length + 1];
    System.arraycopy(OrigArray, 0, newArray, 0, OrigArray.length);

    //an alternative to using System.arraycopy would be a for-loop:
    // for(int i = 0; i < OrigArray.length; i++)
    //     newArray[i] = OrigArray[i];
    OrigArray = newArray;
}