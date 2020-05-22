xi_i = xi.get(i).intValue(); // X index without round
    yi_i = yi.get(i).intValue(); // Y index without round
    if (xi_i < z.rows() - 1 && yi_i < z.cols() - 1 && xi_i >= 0 && yi_i >= 0) {
        // Four neighbors of sample pixel
        s00 = z.get(xi_i,yi_i)[0]; s01 = z.get(xi_i,yi_i + 1)[0];
        s10 = z.get(xi_i + 1,yi_i)[0];s11 = z.get(xi_i + 1,yi_i + 1)[0];

        // find fractional part of yi:
        double yi_frac = yi.get(i) - (double)yi_i;

        // interpolate between s00 and s01 to find s0:
        double s0 = s00 + ((s01 - s00) * yi_frac);
        // interpolate between s10 and s11 to find s1:
        double s1 = s10 + ((s11 - s10) * yi_frac);

        // find fractional part of xi:
        double xi_frac = xi.get(i) - (double)xi_i;

        // interpolate between s0 and s1 to find zi:
        zi[i] =  s0 + ((s1 - s0) * xi_frac);
    }