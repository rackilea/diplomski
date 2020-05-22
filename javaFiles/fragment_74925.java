if (i<steps) {
        x = x + delta;
        double fr = 0.5*x*x + 3*x + 5;
        double area = f * delta + 0.5*(fr - f)*delta;
        sum += area;
        f = fr;
        i++;
        rintegrate(a, b, steps, i, sum);
    }
    return sum;