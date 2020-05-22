for(int zmienna = 0 ; zmienna <= 100 ; zmienna++){
    if (zmienna % 5 == 0 && zmienna % 3 == 0)
        System.out.println("FizzBizz");
    else if (zmienna % 3 == 0)
        System.out.println("Fizz");
    else if (zmienna % 5 == 0)
        System.out.println("Bizz");
    else
        System.out.println("int");
}