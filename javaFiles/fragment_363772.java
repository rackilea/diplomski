public static double digamma(double x) {

    double value = 0;

    while (true){

        if (x >= 0 && x < GAMMA_MINX) {
            x = GAMMA_MINX;
        }
        if (x < DIGAMMA_MINNEGX) {
            x = DIGAMMA_MINNEGX + GAMMA_MINX;
            continue;
        }
        if (x > 0 && x <= S_LIMIT) {
            return value + -GAMMA - 1 / x;
        }

        if (x >= C_LIMIT) {
            double inv = 1 / (x * x);
            return value + Math.log(x) - 0.5 / x - inv
                    * ((1.0 / 12) + inv * (1.0 / 120 - inv / 252));
        }

        value -= 1 / x;
        x = x + 1;
    }

}