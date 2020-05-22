import org.apache.commons.lang3.EnumUtils;

import java.util.Optional;

public enum MyRole  {

    Admin(1),
    Manager(2);

    private int id;

    MyRole(int id) {
        this.id = id;
    }

    public int id() {
        return this.id;
    }

    public static int getId(String role){
        return Optional.ofNullable(EnumUtils.getEnum(MyRole.class, role)).map(MyRole::id).orElse(-1);
    }

    public static String getRole(int id){
        return EnumUtils.getEnumList(MyRole.class).stream().filter(r -> r.id == id).map(MyRole::name).findAny().orElse(null);
    }

    public static void main(String args[]){

        String result=MyRole.getRole(1);
        System.out.println("role name"+result);
        int roleId=MyRole.getId("Admin");
        System.out.println("role id "+roleId);
    }
}