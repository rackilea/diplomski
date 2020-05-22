public static void main(String[] args){
    Scanner s = new Scanner(System.in); 
    System.out.print("Enter a integer for number of streams: ");
    int n=s.nextInt();
    List<Integer> x = new ArrayList<>();
    for(int i=0;i<n;i++) {
        System.out.println("Enter a integer: ");
        x.add(s.nextInt());
        if(i==0) { //first input number
            System.out.println(x.get(i)+" goes to stream --> Median is: "+x[i]);
        }
        else if(i==1) {   //when i =1, it is technically second input 
            System.out.println(x.get(i)+" goes to stream --> Median is: "+(float)(x.get(i)+x.get(0))/2);
        }
        else if(i>=2 && i%2==0) {  //3rd input so # of inputs is odd        
            Collections.sort(x);
            System.out.println(x.get(i)+" goes to stream --> Median is: "+x.get(i/2));
        }
        else if(i>=3 && i%2!=0) {  //when # of input is more than 3 and even
            Collections.sort(x);
            int j=i/2;
            float med=(x.get(j)+x.get(j-1))/2;
            System.out.println(x.get(i)+" goes to stream --> Median is: "+med);
        }
 }
}