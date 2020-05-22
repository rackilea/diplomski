public class RequestObj implements Serializable{

    private List<Long> ids;

    private UsuarioDTO user;

    /* getters and setters here */

}

public class UsuarioDTO implements Serializable{

    private String name;
    private String email;

    /* getters and setters here */

}