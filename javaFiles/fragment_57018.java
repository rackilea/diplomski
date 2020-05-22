try {

        System.out.println("Entered Dates::\n");
        Scanner in = new Scanner(System.in);

        String si = in.nextLine();

        if (Pattern.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d", si)) {
            int di = Integer.parseInt(si.substring(0, 2));
            int mi = Integer.parseInt(si.substring(3, 5));
            int ai = Integer.parseInt(si.substring(6, si.length()));
            System.out.println("1st Date Accepted : " + di + "-" + mi + "-" + ai);
        }else{
            System.out.println("Entered 1st Date incorrect");
        }

        String sf = in.nextLine();
        if (Pattern.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d", sf)) {
            int df = Integer.parseInt(sf.substring(0, 2));
            int mf = Integer.parseInt(sf.substring(3, 5));
            int af = Integer.parseInt(sf.substring(6, sf.length()));
            System.out.println("2nd Date Accepted : " + df + "-" + mf + "-" + af);
        }else{
            System.out.println("Entered 2nd Date incorrect");
        }


    } catch (Exception e) {
        System.out.println("Exception occurred: " + e);
    }