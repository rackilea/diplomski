public static void main(String args[])
    {
       String s = "Abc\nDef";
       String t = "Abc"+System.lineSeparator()+"Def";
       System.out.println(s.equals(t));
       System.out.println(hexStr(s.getBytes()));
       System.out.println((hexStr(t.getBytes())));
    }
    static String hexStr(byte[] bytes) {
        try (Formatter formatter = new Formatter()) {
            for (byte b : bytes) formatter.format("%02x", b);
            return formatter.toString();
        }
    }