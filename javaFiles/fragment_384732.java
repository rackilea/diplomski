class My {
    public static void main(String[] args) {
        try {
            base b = new derived();
            b.show();
        }
        /* NOTE: CHANGED FROM IOException TO Exception */
        catch (Exception e) {
            System.out.println("exception occurred at :" + e);
        }   
    }
}