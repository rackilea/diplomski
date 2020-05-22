public static void main(String[] args) {
        String line="1             Juan García12-11-2016                               Reparación caldera 110.50";

        String amount=line.substring(line.lastIndexOf(' '),line.length());
        String code=line.substring(0,line.indexOf(' '));
        String remaining=line.substring(code.length(),line.lastIndexOf(' '));
        //Juan García12-11-2016                               Reparación caldera
        remaining=remaining.trim();

        Matcher matcher = Pattern.compile("\\d").matcher(remaining);
        matcher.find();
        int i = Integer.valueOf(matcher.group());

        String name=remaining.substring(0,i);
        remaining=remaining.substring(name.length(),remaining.length());
        //12-11-2016                               Reparación caldera
        String date=remaining.split(" ")[0];
        String concept=remaining.substring(date.length(),remaining.length());
        concept=concept.trim();

        System.out.printf("code: "+code+" client:"+name+" Date:"+date+" Concept: "+concept+" Price:"+amount);

}