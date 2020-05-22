import java.util.Arrays;
import java.util.Comparator;

public class StackOverflow {

    public static void main(String[] args) {
        mat=new Element[3][4];
        int[][] gMat={{3 ,5 ,1 ,4},
                      {4 ,3 ,7 ,2},
                      {1 ,0 ,9 ,7}};
        for (int i=0;i<gMat.length;i++){
            for (int j=0;j<gMat[0].length;j++){
                mat[i][j]=new Element(j,gMat[i][j]);
            }
        }

        sort();
        for (int i=0;i<gMat.length;i++){
            for (int j=0;j<gMat[0].length;j++){
                System.out.print(mat[i][j].idx+" ");
            }
            System.out.println();
        }
    }

    static class Element{
        int idx;
        int val;
        Element(int idx,int val){
            this.idx=idx;
            this.val=val;
        }
    }

    static Element[][] mat;
    static void sort(){
        for (int i=0;i<mat.length;i++){
            Arrays.sort(mat[i], Comparator.comparingInt(o -> o.val));
        }
    }
}