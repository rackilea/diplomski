for (int i = 0; i < settlement.length; i++) {

            if (settlement[i] == 0) {
                if (i != settlement.length - 1) {
                    settlement[i + 1] = settlement[i + 1] / 2;
                }
                if (i != 0) {
                    settlement[i - 1] = settlement[i - 1] / 2;

                }
            }
        }