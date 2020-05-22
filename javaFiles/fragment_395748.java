public static void main(String[] args) {
        int r = 9; 


        for (int g = 9; g >=0; g--) {


            for (int j = g; j >= 5; j--) {
                if(g==9) {
                    if(j>6) {
                        System.out.print(r+1-j);
                    }
                }else {
                    if(j>5) {
                        System.out.print(r+1-j);
                    }
                }
                System.out.print(j);

            }

            System.out.println();
        }

    }