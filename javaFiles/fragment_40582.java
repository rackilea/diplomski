public static void main(String[] args) {


    int age = 20;

    if (age<18){
        System.out.println("You cannot enter");
    }
    else if(age>=18 && age<=21){ //checks if his/her age is between 18 and 21
        System.out.println("You may enter but you cannot drink");
    }
    else{
        System.out.println("You may enter and have a drink");
    }


}