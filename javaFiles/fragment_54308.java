import  java.util.regex.Matcher;
import  java.util.regex.Pattern;

/**
   <P>{@code java RegexTest}</P>
 **/
public class RegexTest  {
   public static final void main(String[] igno_red)  {
        String itemJson = "{\"data\":{{ \"id\":1001,\"name\":\"Boots of Speed\",\"plaintext\":\"Slightly increases Movement Speed\",\"group\":\"BootsNormal\",\"description\":\"<groupLimit>Limited to 1.</groupLimit><br><br><unique>UNIQUE Passive - Enhanced Movement:</unique> +25 Movement Speed<br><br><i>(Unique Passives with the same name don't stack.)</i>\",\"colloq\":\";\",\"into\":[\"3006\",\"3047\",\"3020\",\"3158\",\"3111\",\"3117\",\"3009\"],\"image\":{\"full\":\"1001.png\",\"sprite\":\"item0.png\",\"group\":\"item\",\"x\":0,\"y\":0,\"w\":48,\"h\":48},\"gold\":{\"base\":325,\"total\":325,\"sell\":227,\"purchasable\":true},\"tags\":[\"Movement\",\"Boots\"],\"stats\":{\"FlatMovementSpeedMod\":25.{ \"id\":}},\",4\":{\"name\":\"Faerie Charm\",\"plaintext\":\"Slightly increases Mana Regen\",\"description\":\"<stats>+3 Mana Regen per 5 seconds</stats>\",\"colloq\":\";\",\"into\":[\"3152\",\"3028\",\"3070\",\"3073\",\"1080\",\"3069\",\"3165\"],\"image\":{\"full\":\"1004.png\",\"sprite\":\"item0.png\",\"group\":\"item\",\"x\":48,\"y\":0,\"w\":48,\"h\":48},\"gold\":{\"base\":180,\"total\":180,\"sell\":126,\"purchasable\":true},\"tags\":[\"ManaRegen\"],\"stats\":{\"FlatMPRegenMod{ \"id\"::0.6,\"1006\":{\"name\":\"Rejuvenation Bead\",\"plaintext\":\"Slightly increases Health Regen\",\"description\":\"<stats>+5 Health Regen per 5 seconds</stats>\",\"colloq\":\";\",\"into\":[\"3077\",\"3097\",\"3112\",\"3083\",\"1080\",\"2051\",\"3105\"],\"image\":{\"full\":\"1006.png\",\"sprite\":\"item0.png\",\"group\":\"item\",\"x\":96,\"y\":0,\"w\":48,\"h\":48},\"gold\":{\"base\":180,\"total\":180,\"sell\":126,\"purchasable\":true},\"tags\":[\"HealthRegen\"],\"stats\":{\"FlatHPRege{ \"id\":Mod\",0}},\"1011\":{\"name\":\"Giant's Belt\",\"plaintext\":\"Greatly increases Health\",\"description\":\"<stats>+380 Health</stats>\",\"colloq\":\";\",\"into\":[\"3083\",\"3022\",\"3068\",\"3116\",\"3084\",\"3143\"],\"image\":{\"full\":\"1011.png\",\"sprite\":\"item0.png\",\"group\":\"item\",\"x\":144,\"y\":0,\"w\":48,\"h\":48},\"gold\":{\"base\":1000,\"total\":1000,\"sell\":700,\"purchasable\":true},\"tags\":[\"Health\"],\"stats\":{\"FlatHPPoolMod\":380.0}}}";

      Pattern regex = Pattern.compile("(\"[0-9]{4}\":)");
      System.out.println("Regex: " + regex.pattern());
      Matcher matcher = regex.matcher(itemJson);
      String itemId;
      String toReplace;
      String replaceWith;
      int lastIndex;
      while(matcher.find()){
         lastIndex = matcher.start();
         itemId = itemJson.substring(lastIndex+1, lastIndex+5);
System.out.println("-itemId=\"" + itemId + "\"");
         toReplace = itemJson.substring(lastIndex, lastIndex+8);
System.out.println("-toReplace=\"" + toReplace + "\"");
         replaceWith = "{ \"id\":" + itemId + ",";
System.out.println("-replaceWith=\"" + replaceWith + "\"");
         System.out.println(itemJson.substring(matcher.start(), matcher.end()));
         itemJson = itemJson.replace(toReplace, replaceWith);

         //Must reset the matcher for the updated string!
         matcher.reset(itemJson);
      }
   }
}