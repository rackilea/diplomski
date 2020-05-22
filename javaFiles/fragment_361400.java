String s = "1,1n,1b\n2,2n,2b\n2,2n,2b\n";
    Scanner sc = new Scanner(s);
    StringBuilder sb = new StringBuilder();

    while (sc.hasNextLine()) {
        String[] sa = sc.nextLine().split(",");
        sb.append("nr:\t").append(sa[0]).append("\n");
        sb.append("\tbook name:\t").append(sa[1]).append("\n");
        sb.append("\tpublisher:\t").append(sa[2]).append("\n");
    }

    System.out.println(sb.toString());