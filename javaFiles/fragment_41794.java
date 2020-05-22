public class Demo2{

    public static void main(String[] args) {
        String str = "1991-0101";
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //pulled birthdayDae out of the try/catch, so it is accesible to the println later
        Date birthdayDate;

        try {
            // tries to do the parse
            birthdayDate = sdf.parse(str);
        }catch(ParseException e){
            // if it fails this will be executed
        }

        System.out.println(birthdayDate);
    }
}