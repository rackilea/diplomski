do {
        computewallValueReplace(computewallInt, 4, 0, rnd.nextInt(16));
        computewallValueReplace(computewallInt, 4, 1, rnd.nextInt(16));
        computewallValueReplace(computewallInt, 4, 2, rnd.nextInt(16));
        computewallValueReplace(computewallInt, 4, 3, rnd.nextInt(16));
        computewallValueReplace(computewallInt, 4, 4, rnd.nextInt(16));
        ///*
        if (computewallInt[4][0] == computewallInt[4][1] | computewallInt[4][0] == computewallInt[4][2] | computewallInt[4][0] == computewallInt[4][3] | computewallInt[4][0] == computewallInt[4][4]
                | computewallInt[4][1] == computewallInt[4][2] | computewallInt[4][1] == computewallInt[4][3] | computewallInt[4][1] == computewallInt[4][4]
                | computewallInt[4][2] == computewallInt[4][3] | computewallInt[4][2] == computewallInt[4][4] | computewallInt[4][3] == computewallInt[4][4]) {
            duplicateCheck = true;
        }
        if (computewallInt[4][0] == 0 | (computewallInt[4][1] == 0) | (computewallInt[4][1] == 0) | (computewallInt[4][3] == 0) | computewallInt[4][4] == 0) {
            ohCheck = true;
        }
    } while (duplicateCheck | ohCheck);