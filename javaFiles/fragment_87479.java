String data="{4,15,26,7}";
data=data.substring(1,data.length-1);
String[] digits=data.split(",");
his.points=new ArrayList<Integer>();
    for (int i = 0; i < digits.length; i++) {
            this.points.add(Integer.parseInt(digits[i]));
    }