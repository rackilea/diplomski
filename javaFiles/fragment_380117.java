public class ExceptionOriginTracing {

    public static void main(String[] args){
        try {
            originOne();
            originTwo();
        } catch (Exception e){
            // Now for the magic:
            for (StackTraceElement element : e.getStackTrace()){
                if (element.getMethodName().equals("originOne")){
                    System.out.println("It's a read error!");
                    break;
                } else if (element.getMethodName().equals("originTwo")){
                    System.out.println("It's a write error!");
                    break;
                }
            }
        }
    }

    public static void originOne() throws Exception{
        throw new Exception("Read Failed...", null);
    }

    public static void originTwo() throws Exception{
        throw new Exception("Connect failed...", null);
    }
}