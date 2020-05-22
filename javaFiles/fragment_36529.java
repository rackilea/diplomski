class Quest {

    Quest(int y) {

        System.out.print("A:"+y);
    }
}

class Quest1 extends Quest {

    Quest1(int x) {

        //super(x+1); 
        System.out.print("B:"+x);
    }
}