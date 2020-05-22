for (int i = 0; i < sizeOfArray; i++) {
    boolean isNextTheSame = (i+1 < sizeOfArray) && randomNumList.get(i+1) == randomNumList.get(i);
    if (!inRun && isNextTheSame) {
        System.out.print("(");
        inRun = true;
    }
    System.out.print(randomNumList.get(i) + 1);
    if (inRun && !isNextTheSame) {
        System.out.print(")");
        inRun = false;
    }
}