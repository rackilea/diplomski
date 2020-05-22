public class b {

public static void main(String[] args) {
    int a[][] = new int [5][5];
    int i,j;
    int s = 0;

    for(i= 0;i<a.length; i++)
        for(j = 0; j<a[i].length; j++){
            a[i][j] = (int)(Math.random()*10);
        }
    for(i=0;i<a.length;i++){
        for(j=0;j<a[i].length;j++)

        System.out.print(a[i][j] + "\t");
        System.out.println();   
    }

   for(j=0;j<a[0].length;j++){
    for(i=0;i<a.length;i++)
        if(a[i][j] >-1 && a[i][j]<1){
        s++;

       }
    System.out.println("Zero in column no. "+j+" is "+s +"\t");
    s=0;
    }

  }   
}