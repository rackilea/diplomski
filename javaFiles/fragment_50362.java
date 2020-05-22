public class CariNama {
public static void main(String[] args) {
    String[] nama = {"Leon", "Helena", "Chris", "Piers", "Jake", "Sherry", "Ada"};
    String temp;
    int proximator=0;
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Insert RE 6 Characters name : ");
    temp=keyboard.nextLine();
    for(int i=0;i<nama.length;i++){
        if (nama[i].equalsIgnoreCase(temp)){
        proximator = 1;
        break;
        }
    }
    if(proximator==1){
        System.out.println("Character "+temp+" Found!");
    }
    else{
        System.out.println("There is no "+temp);
    }
}
}