while (count1 < 10) {
    count1++;
    trinumber += count1;
    System.out.print("trinumber: " + trinumber + ", factors: ");
    for (int count2 = 1; count2 <= trinumber; count2++)
        if (trinumber % count2 == 0)
            System.out.print(count2 + ", ");
    System.out.println();
}