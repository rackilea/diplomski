public class Contact {
    private String surname, lastname, address;
    private int age, floor;
    private Image contactPhoto, companyPhoto;
    private boolean isEmployed;

    public static String[] getFieldsOfType(Class<?> target, Class<?> searchType) {

        Field[] fields  = target.getDeclaredFields();

        List<String> results = new LinkedList<String>();
        for(Field f:fields){
            if(f.getType().equals(searchType)){
                results.add(f.getName());
            }
        }
        return results.toArray(new String[results.size()]);
    }

    public static String[] getAllImages(){
        return getFieldsOfType(Contact.class, Image.class); 
    }

    public static void main(String[] args) {
        String[] fieldNames = getAllImages();

        for(String name:fieldNames){
            System.out.println(name);
        }
    }
}