void makeSteps(List<Integer> prevSteps, int s, int maxStep) {
    if (s == 0) {                        // no more stairs left
        System.out.println(prevSteps);
    } else {                             // 1 or more stairs left
        for (int step = 1; step <= Math.min(maxStep, s); step++) {
            List<Integer> newSteps = new ArrayList<>(prevSteps);
            newSteps.add(step);
            makeSteps(newSteps, s - step, maxStep);
        }           
    }
}