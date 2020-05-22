public static void start(RootDoc root) {
       ClassDoc[] classes = root.classes();
        for (ClassDoc cd : classes) {
            System.out.println("Class [" + cd + "] has the following methods");
            for(MemberDoc md : cd.methods()) {
               System.out.println("  " + md);
            }
        }
    }