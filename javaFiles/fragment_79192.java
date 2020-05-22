for (int i = arg[0].length - 1; i >= 0; i--) {
    for (int j = 0; j < arg.length; j++) {
        for (int k = 0; k < arg[j].length - 1; k++) {

            if (arg[j][k] > arg[j][k + 1]) {
                int temp = arg[j][k];
                arg[j][k] = arg[j][k + 1];
                arg[j][k + 1] = temp;

            }
        }

    }
}