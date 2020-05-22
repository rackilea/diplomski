try{
        int[] lotteryNumbers = new int[5];
        int[] playersNumbers = new int[5];
        int[] winningNum = new int[]{0, 0, 0, 0, 0, 0};
        int winNum = 0;
        Random r = new Random();
        for (int i = 0; i < lotteryNumbers.length; i++){
                lotteryNumbers[i] = 0 + r.nextInt(9);
        }
        do{
            winNum = 0;

            for (int i = 0; i < playersNumbers.length; i++){
                playersNumbers[i] = 0 + r.nextInt(9);

            }

            for (int i = 0; i < lotteryNumbers.length; i++){
                if (lotteryNumbers[i] == playersNumbers[i]){
                    winNum++;
                }
            }
            winningNum[winNum]++;
        }while(winNum != 5);
        System.out.println(Arrays.toString(winningNum));
    }catch(Exception e){
        e.printStackTrace();
    }