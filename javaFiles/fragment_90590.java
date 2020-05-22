wv[axis][i] = wrr1[axis] - W * x[i] / L;
wm[axis][i] = (float) (wmm1[axis] + wrr1[axis] * x[i] - 
    0.5 * W * x[i] * x[i] / L);
wy[axis][i] = (float) (1. / (6. * E * I) * 
    (wrr1[axis]* Math.pow(x[i], 3.) - 3. * 
     -wmm1[axis] * x[i] * x[i] - W / 4. * 
     Math.pow(x[i], 4) / L));
wd[axis][i] = (float) (1. / (6. * E * I) * 
    (wrr1[axis] * 3 * Math.pow(x[i], 2.) - 6. * 
     -wmm1[axis] * x[i] - W / 4. * 4 * Math.pow(x[i], 3.) / L));