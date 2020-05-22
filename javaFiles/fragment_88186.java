public class Permission {

    private Long id;
    private String name;
}

public class PermissionResponse extends Permission {

    private Action action;
    private Resource resource;
    private Environment environment;
}

public class Action extends Permission {

}

public class Resource extends Permission {

}

public class Environment extends Permission {

}