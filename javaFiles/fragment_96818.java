for (int k = i - 1; k <= i + 1; k++) {
    for (int l = j - 1; l <= j + 1; l++) {
        if (l - j == k - i) continue;
        try {
            if("**".equals(state[k][l])){
                state[k][l] = String.valueOf(stopState);
                stopState++;
                willBeInitialized[k][l] = true;
            }
        } catch (Exception e) {
            //do nothing, loop to next try block
        }
    }
}