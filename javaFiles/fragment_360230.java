for(int year = 11; year <= 13; year++){
        for(int i = 1; i <= 350; i++){
            //generating 1050 URLs at one shot
            StringBuffer regNo = new StringBuffer("1111").append(year).append("111").append(String.format("%03d", i));


            String url = "magicUrl" + regNo;
            System.out.println(url);
            worker = new MyRunnable(url, regNo.toString());

        }    
}