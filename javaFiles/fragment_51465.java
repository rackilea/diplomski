int lastEnd = -1;
while (mat1.find()) {

    // Was there any junk between last two matches?
    if (mat1.start() != lastEnd+1) {
        System.out.println("Fail.");
        break;
    }

    System.out.println(mat1.group());
    lastEnd = mat1.end();

}