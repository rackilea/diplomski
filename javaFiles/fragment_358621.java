if (usersNumbers.length == lotteryNumbers.length) {
        for (int i = 0; i < lotteryNumbers.length; i++) {
            //Here you have to set j++
            for(int j = 0; j < lotteryNumbers.length; j++) {
                if (usersNumbers[i] == lotteryNumbers[j]) {
                    //match++;
                    break;
                }
            }
        }
    }