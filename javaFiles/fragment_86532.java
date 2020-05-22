public ShavedBrick(int[] x, int[] y, int numberOfPoints)
        {
            Random ranGen = new Random();
            for(int i = 0; i < 8; i ++) {
                 xArray[i] = x[i];
                 yArray[i] = y[i];
            }
            this.numberOfSides = numberOfPoints;
            this.color = new Color(0,(ranGen.nextInt(156)+100),0);

        }