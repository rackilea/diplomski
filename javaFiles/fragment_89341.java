for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (user[i].balance < user[j].balance) {
                    Account temp = user[i];
                    user[i] = user[j];
                    user[j]= temp;
                }
            }
        }