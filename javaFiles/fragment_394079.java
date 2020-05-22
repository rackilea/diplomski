for (double x = 0; x <= Math.PI; x += 0.15) {
            int sinValue = (int) Math.round(Math.sin(x) * 30);
            for (int j = 0; j < sinValue; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}