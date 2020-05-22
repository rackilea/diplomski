LogPeriodic lppl = new LogPeriodic(1,tc);

    int j=0;
    double[] curve = new double[N-start];
    double[] weight = new double[N-start];
    for (int i=start;i<N;i++) {
        curve[j] = p[i];
        weight[j++] = 1;
    }

    double[] initialguess = new double[]{
        0.5,                  // m
        9d                    // w
    };

    lppl.setInitialParameters(initialguess);
    lppl.setWeights(weight);
    lppl.setMaxIteration(100);
    lppl.setTargetValues(curve);
    lppl.setErrorTolerance(1d);
    lppl.run();

    double[] fitted = lppl.getBestFitParameters();
    System.out.println("fitted m,w: " + Arrays.toString(fitted) + " in iterations " + lppl.getIterations());