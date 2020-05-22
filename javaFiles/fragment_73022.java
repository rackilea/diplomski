public String getData(){
        String c ;
        c = null;
        int a = cb1.getSelectedIndex();
        int b = cb2.getSelectedIndex();
        System.out.println("C: "+c+" A: "+a+" B: "+b);
        if (a == 1 && b == 1) {
            c=""+a;
        } else if (a == 1 && b == 2) {
            c=""+a;
        } else if (a == 2 && b == 1) {
            c=""+a;
        } else if (a == 2 && b == 2) {
            c=""+a;
        } else if (a == 3 && b == 1) {
            c=""+a;
        } else if (a == 4 && b == 1) {
            c=""+a;
        } else if (a == 4 && b == 2) {
            c="";
        } else if (a == 5 && b == 1) {
            c=""+a+""+b; 
        } else if (a == 5 && b == 2) {
            c=""+a+""+b;
        } else if (a == 6 && b == 1) {
            c=""+a+""+b;
        } else if (a == 7 && b == 1) {
            c=""+a+""+b;
        } else if (a == 8 && b == 1) {
            c=""+a+""+b;
        } else if (a == 8 && b == 2) {
            c=""+a+""+b;
        } else if (a == 8 && b == 3) {
            c=""+a+""+b;
        }

    }