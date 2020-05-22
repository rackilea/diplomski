import javax.swing.JOptionPane;
public class Permutation {

public static void main(String[] args) throws Exception {
    String str = null;
    str = JOptionPane.showInputDialog("Enter a word");
    StringBuffer strBuf = new StringBuffer(str);
    doPerm(strBuf,str.length());
    JOptionPane.showMessageDialog(null,sbuf.toString());
}
static StringBuffer sbuf = new StringBuffer();
private static void doPerm(StringBuffer str, int index){
    String[] anArrayOfStrings;  
    if(index == 0){ 
        //System.out.println(str);
        sbuf.append(str+"\n");
        }      
    else { 
        doPerm(str, index-1);
        int currPos = str.length()-index;
        for (int i = currPos+1; i < str.length(); i++) {
            swap(str,currPos, i);

            doPerm(str, index-1);
            swap(str,i, currPos);
        } 
    }       

}


private  static void swap(StringBuffer str, int pos1, int pos2){
    char t1 = str.charAt(pos1);
    str.setCharAt(pos1, str.charAt(pos2));
    str.setCharAt(pos2, t1);
} 

}