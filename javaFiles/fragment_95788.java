class EnumUtil {

    public static <T extends Enum<T>> String getExportLib(T[] aValues){
        StringBuilder sb = new StringBuilder();
         for( T t : aValues){
            //todo 
         }
         return sb.toString();
    }
}