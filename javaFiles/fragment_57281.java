private static double topOfHeart(double x, double y, double temp, double temp1) {
    //complex arithmetic; each double[] is a single number
    double[] temp3 = cbrt_complex(temp, sqrt(-temp1));
    double[] part1 = polar_reciprocal(temp3);
    part1[0] *= 36 * cbrt(2) * pow(y, 3);
    double[] part2 = temp3;
    part2[0] /= (10935 * cbrt(2));
    toRect(part1, part2);
    double looseparts = 4.0 / 9 - 4.0 / 9 * pow(x, 2) - 4.0 / 9 * pow(y, 2);
    double real_part = looseparts + part1[0] + part2[0];
    double imag_part = part1[1] + part2[1];
    double[] result = sqrt_complex(real_part, imag_part);
    toRect(result);

    // theoretically, result[1] == 0 should work, but floating point says otherwise
    if (Math.abs(result[1]) < 1e-5) {
        return result[0];
    }
    return -1;
}

/**
 * returns a specific cuberoot of this complex number, in polar form
 */
public static double[] cbrt_complex(double a, double b) {
    double r = Math.hypot(a, b);
    double theta = Math.atan2(b, a);
    double cbrt_r = cbrt(r);
    double cbrt_theta = 1.0 / 3 * (2 * PI * Math.floor((PI - theta) / (2 * PI)) + theta);
    return new double[]{cbrt_r, cbrt_theta};
}

/**
 * returns a specific squareroot of this complex number, in polar form
 */
public static double[] sqrt_complex(double a, double b) {
    double r = Math.hypot(a, b);
    double theta = Math.atan2(b, a);
    double sqrt_r = Math.sqrt(r);
    double sqrt_theta = 1.0 / 2 * (2 * PI * Math.floor((PI - theta) / (2 * PI)) + theta);
    return new double[]{sqrt_r, sqrt_theta};
}

public static double[] polar_reciprocal(double[] polar) {
    return new double[]{1 / polar[0], -polar[1]};
}

public static void toRect(double[]... polars) {
    for (double[] polar: polars) {
        double a = Math.cos(polar[1]) * polar[0];
        double b = Math.sin(polar[1]) * polar[0];
        polar[0] = a;
        polar[1] = b;
    }
}