public class HelloWorld{

     public static void main(String []args){
        String text ="\"type\":\"image\",\"originX\":\"center\",\"originY\":\"center\",\"left\":135,\"top\":259,\"width\":270,\"height\":519,\"fill\":\"rgb(0,0,0)\",\"overlayFill\":null,\"stroke\":null,\"strokeWidth\":1,\"strokeDashArray\":null,\"strokeLineCap\":\"butt\",\"strokeLineJoin\":\"miter\",\"strokeMiterLimit\":10,\"scaleX\":1,\"scaleY\":1,\"angle\":0,\"flipX\":false,\"flipY\":false,\"opacity\":1,\"shadow\":null,\"visible\":true,\"clipTo\":null,\"src\":\"file:///C:/Users/Alvin%20Combrink/Dropbox/Entrepren%C3%B6rskap/Design/Hemsidan/Backgrunder/Labyrint.jpg\"";
            //Just left and scaleX for example
        String left = readValue(text, "left");
        String scaleX = readValue(text, "scaleX");

        System.out.println("left:" + left);
        System.out.println("scaleX:" + scaleX);
     }

    public static String readValue(String text, String key)
    {
        //search for the init of the value
        int start = text.indexOf("\"" + key + "\"");
        //search for the end of the value
        int end = text.indexOf(",", start + key.length() + 3);

        //return the value. these + 3 , is for quotes and ":"
        return text.substring(start + key.length() + 3,end);
    }
}