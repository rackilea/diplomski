String str = "[#FF0000]red[#0000FF]blue";
        String[] ss = str.split("\\[");
        String[] sRe = Arrays.copyOfRange(ss, 1, ss.length);

        for (String s : sRe) {
            System.out.println(s.split("\\]")[0]);
            System.out.println(s.split("\\]")[1]);
        }