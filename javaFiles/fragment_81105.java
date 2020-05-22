class Argument {

    public final static int TOMAYTO = 0;
    public final static int TOMAHTO = 1;

    static void argue() {

        int say = TOMAYTO;

        while (true) {

            switch (say) {

            case TOMAYTO:

                say = TOMAHTO;
                break;

            case TOMAHTO:

                say = TOMAYTO;
                break;
            }
        }
    }
}