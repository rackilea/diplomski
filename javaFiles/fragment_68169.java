package assingment;

public class frequencyCount {

    static void count(int x[]){
        System.out.println("ENTERED ARRAY IS ");
        // NEW - To store maximum
        int maxi = -1;
        for( int i=0; i < x.length; i++)
        {
            System.out.println(x[i]);
            // Keep checking for the maximum
            if (x[i] > maxi)
                maxi = x[i];
        }        

        // NEW - modify length to account for maximum
        int c[] = new int [maxi+1];
        for(int i=0; i<c.length ;i++)
        { 
            c[i] = 0;
        }
        for(int i=0; i< x.length ;i++){
            int m= x[i];
            c[m]++;
        }
        System.out.println("frequency table");
        for(int i=0; i< c.length ;i++){         
            System.out.println(i + " "+ c[i]);          
        }        
    }

    public static void main(String[] args) {
        count(new int []{1,1,5,2,10});     
    }    
}