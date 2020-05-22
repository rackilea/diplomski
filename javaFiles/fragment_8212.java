for(double t = 0; t <= 25; t+=0.1) {
        double N =  220 / (1 +10 * (Math.pow(.83, t)));
        if (N >= 80) {
            System.out.println(N + " sheep after " + t + " years");
            break;
        }

    }