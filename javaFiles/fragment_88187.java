public class Permission {

    private Long id;
    private String name;
}

public class PermissionResponse extends Permission {

    private Permission action;
    private Permission resource;
    private Permission environment;
}