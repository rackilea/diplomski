public abstract class Permission {
    Map<String, Supplier<Boolean>> permissionGetterMap = new HashMap<>();
    Map<String, Consumer<Boolean>> permissionSetterMap = new HashMap<>();

    public void put(String permission, Supplier<Boolean> getter, Consumer<Boolean> setter) {
        permissionGetterMap.put(permission, getter);
        permissionSetterMap.put(permission, setter);
    }

    public boolean isGranted(String permission) {
        return permissionGetterMap.get(permission).get();
    }

    public void setPermission(String permission, boolean granted) {
        permissionSetterMap.get(permission).accept(granted);
    }
}



public class MyPermission extends Permission {
    public static final String READ = "read";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";

    public MyPermission() {
        put(READ, this::isRead, this::setRead);
        put(UPDATE, this::isUpdate, this::setUpdate);
        put(DELETE, this::isDelete, this::setDelete);
    }

    private boolean read;
    public boolean isRead() { return read; }
    public void setRead(boolean read) { this.read = read; }

    private boolean update;
    public boolean isUpdate() { return update; }
    public void setUpdate(boolean update) { this.update = update; }

    private boolean delete;
    public boolean isDelete() { return delete; }
    public void setDelete(boolean delete) { this.delete = delete; }
}