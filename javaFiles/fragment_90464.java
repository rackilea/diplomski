int k = 0;
while (stdIn.hasNextLine()) {
    // for (int k = 0; k <= line.length - 1; k++) {
    line[k] = stdIn.nextLine();
    out.println(line[k]);
    k++;
    // }
}
out.close();