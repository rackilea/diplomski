// Get a default NumberFormat instance.
    NumberFormat numForm = NumberFormat.getInstance();

    // Format some longs using the pattern supplied above.
    StringBuffer dest1 = new StringBuffer(24);
    StringBuffer dest2 = new StringBuffer(24);
    FieldPosition pos = new FieldPosition(NumberFormat.INTEGER_FIELD);

    dest1 = numForm.format(223423L, dest1, pos);
    System.out.println("dest1 = " + dest1);
    System.out.println("INTEGER portion is at: " + pos.getBeginIndex() +
        ", " + pos.getEndIndex());

    dest2 = numForm.format(64000L, dest2, pos);
    System.out.println("dest2 = " + dest2);
    System.out.println("INTEGER portion is at: " + pos.getBeginIndex() +
        ", " + pos.getEndIndex());