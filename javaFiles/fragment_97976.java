import java.util.Scanner;

public class WomenDep{
int a,c,d,NoOfSizes=3,Counter;
double b,Total;
Prices P1 = new Prices();
double []arr = new double[NoOfSizes];
private int Pieces;
double Price;
double TPrice;
Scanner input = new Scanner(System.in);
private String ProductName;

public void GetDet(){
    System.out.println("Pls Select Product No., \n(1)--> Tshirt\n(2)--> Short\n(3)--> Jeans\n"
            + "(4)--> Dress\n(5)--> Skirts");
    a = input.nextInt();
    System.out.println("Pls Select required Size No., \n(1)-->S\n(2)-->M\n(3)-->L");
    b = input.nextDouble();
    System.out.println("Enter Number of Pieces");
    c = input.nextInt();
    this.Pieces=c;
    System.out.println("Do you want to add another product to your cart?\n(1)-->Yes\n(2)-->No");
    d = input.nextInt();
}


public double [] SearchArr(){
    if(this.a==1){
        this.ProductName = "Tshirt";
        for (int i = 0; i<NoOfSizes; ++i)
            arr[i]=P1.WTshirt[i];
    }
    if(this.a==2){
        this.ProductName = "Short";
        for (int i = 0; i<NoOfSizes; ++i)
            arr[i]=P1.WShort[i];
    }
    if(this.a==3){
        this.ProductName = "Jeans";
        for (int i = 0; i<NoOfSizes; ++i)
            arr[i]=P1.WJeans[i];
    }
    if(this.a==4){
        this.ProductName = "Dress";
        for (int i = 0; i<NoOfSizes; ++i)
            arr[i]=P1.WDress[i];
    }
    if(this.a==5){
        this.ProductName = "Skirts";
        for (int i = 0; i<NoOfSizes; ++i)
            arr[i]=P1.WSkirts[i];
    }
    return arr;
}


public double CalPrice(){

    if(b==1){
        Price = arr [0];}
    if(b==2){
        Price = arr [1];}
    else if(b==3){
        Price = arr [2];}
    return Price;
}


public void TotalPrice(){
     TPrice = TPrice + this.Price * Pieces;
    System.out.println("this is total Price "+TPrice);
}


public void Recal(){ 
    do{
        this.GetDet();
        this.SearchArr();
        double Price = this.CalPrice();
        this.TotalPrice();
    }while(d==1);
}
 class Prices{
    public double [] WTshirt = {60.00,100.5,120};//S,M,L
    public double [] WShort = {50,110,130.5};//S,M,L
    public double [] WJeans = {150.99,180,200};//S,M,L
    public double [] WDress = {350,400,450.99};//S,M,L
    public double [] WSkirts = {350.5,499.99,450.5};//S,M,L
}


public static void main(String[] args) {
WomenDep a = new WomenDep();
a.Recal();

}
}