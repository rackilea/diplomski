public class CustomObject{
     int id;
     int num;


     public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getNum() {
        return num;
    }


    public void setNum(int num) {
        this.num = num;
    }


    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        List<CustomObject> list=new ArrayList<CustomObject>();
        CustomObject c=new CustomObject();
        c.id=1;
        c.num=1;
        list.add(c);
        System.out.println(new ObjectMapper().writeValueAsString(list)); 
    }
 }