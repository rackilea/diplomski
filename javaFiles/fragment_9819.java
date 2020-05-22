public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        GetExcel res = new GetExcel();
        String maker = res.getExcel("IS Maker Username");
        System.out.println("User :" + maker);
        GetExcel res1 = new GetExcel();
        String passMaker = res1.getExcel("IS Maker Password");
        System.out.println("Password :" + passMaker);
    }