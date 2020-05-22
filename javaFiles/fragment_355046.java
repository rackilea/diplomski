class Test
{
        public static void main(String argv[])
        {
                String parameter="WORLD=111#222:MOON=333#444:JUPITER=555:SATURN=666";
                String[] elements=parameter.split(":");
                for (int i=0; i < elements.length; i++) {
                        String[] parts=elements[i].split("=", 2);
                        if ((parts.length == 2) && (parts[0].equals("MOON"))) {
                                System.out.println("MOON is "+parts[1]);
                        }
                }
        }
};