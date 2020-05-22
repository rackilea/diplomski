import java.util.*;
class a_class{
    private int i;
    public a_class(int k){
        i=k;
    }
    public void print(){
        System.out.print(i+"\t");
    }
}
class Stack_help{
    public static void main(String []args){
        a_class [][]a=new a_class[4][4];//creating a new array of 2d objects
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                a[i][j] = new a_class(i);
                a[i][j].print();
            }
            System.out.println("\n");
        }
    }
}