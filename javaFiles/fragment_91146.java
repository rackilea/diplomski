void makeSteps(List<Integer> prevSteps, int s) {
    if (s == 0) {                        // no more stairs left
        System.out.println(prevSteps);
    } else {                             // 1 or more stairs left
        List<Integer> n1 = new ArrayList<>(prevSteps);
        n1.add(1);
        makeSteps(n1, s - 1);
        if (s > 1) {                     // 2 or more stairs left
            List<Integer> n2 = new ArrayList<>(prevSteps);
            n2.add(2); 
            makeSteps(n2, s - 2);
        }           
    }
}