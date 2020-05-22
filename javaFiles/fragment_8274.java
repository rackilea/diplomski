String s = "1,2,3,4,5,6,7,8,9,10";

int even[] = new int[10];
int odd[] = new int[10];
String ar[] = s.split(",");
int j=0,k=0,oddChecker=0,evenChecker=0;
for(int i=0;i<ar.length;i++){
    if(Integer.parseInt(ar[i])%2 == 0){
        even[j] = Integer.parseInt(ar[i]);
                ++j;
        evenChecker = 1;

    }   
    else{
        odd[k] = Integer.parseInt(ar[i]);
        ++k;
    oddChecker = 1;
    }

}


if(oddChecker == 0){
    System.out.println("even");
    System.exit(0);
}

if(evenChecker == 0){
    System.out.println("odd");
    System.exit(0);
}



System.out.println("Even numbers:");

for(int i=0;i<j;i++){
if(i!=j-1){
        System.out.print(even[i]+",");
}
else{
    System.out.print(even[i]);
}
}
System.out.println();
System.out.println("Odd numbers:");

for(int i=0;i<k;i++){
if(i!=k-1){
        System.out.print(odd[i]+",");
}
else{
    System.out.print(odd[i]);
}
}