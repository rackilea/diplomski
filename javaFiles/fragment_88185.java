public class PermissionResponse {

    private Long id;
    private String name;
    private Action action;
    private Resource resource;
    private Environment environment;
}

public class Action {

    private Long id;
    private String name;
}

public class Resource {

    private Long id;
    private String name;
}

public class Environment {

    private Long id;
    private String name;
}