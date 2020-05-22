import java.util.*;
public class Next_Permutation{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        for(int h=0;h<t;h++){
            String s=sc.nextLine();
            char ch[]=s.toCharArray();    
            int i=ch.length-1;//LastIndex
            while(i>0 && (int)ch[i-1]>=(int)ch[i])//Find the longest non-increasing suffix(end appendage)
                i--;// Now, i is the start of the suffix
            if(i<=0||s.length()==1)
                System.out.println("no answer");//The given permutation is the last permutaion  
            else {
                //now,the leftmost element to i is the pivot, i.e i-1
                //Now, we find the rightmost element that exceeds the pivot
                int j=ch.length-1;
                while((int)ch[j]<=(int)ch[i-1])//exceed the pivot
                    j--;
                //Now, j is the new pivot which needs to be swapped with the old pivot
                char temp=' ';
                temp=ch[i-1];
                ch[i-1]=ch[j];
                ch[j]=temp;

                //Now, reverse the new/updated suffix
                j=ch.length-1;
                while(i<j){
                    temp=ch[i];
                    ch[i]=ch[j];
                    ch[j]=temp;
                    i++;
                    j--;
                }
                System.out.println(String.valueOf(ch));
          }
       }
    }
}