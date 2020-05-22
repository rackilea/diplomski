import java.util.Scanner;
import java.lang.Integer;
public class points{
    private class Vertex{
        public int xcoord,ycoord;
        public Vertex right,left;
    }    
    public points(){
        Scanner input = new Scanner(System.in);
        int no_of_pts = Integer.parseInt(input.nextLine());
        Vertex[] polygon = new Vertex[no_of_pts];        
        for(int i=0;i<no_of_pts;i++){
            String line = input.nextLine();
            String[] check = line.split(" "); 
            polygon[i] = new Vertex(); // this is what you need.          
            polygon[i].xcoord = Integer.parseInt(check[0]);
            polygon[i].ycoord = Integer.parseInt(check[1]);
        }    
    }    
    public static void main(String[] args){
        new points();    
    }    
}