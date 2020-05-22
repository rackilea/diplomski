@Logger private Log log;

@In(required = true)
private String username;

@In(required=false, scope=ScopeType.SESSION)
Usuario usuario;

@In @Out
Identity identity;

@In @Out
Credentials credentials;

public boolean authenticate(){

    log.info("authenticating {0}", username);

    try {

        UsuarioBean usuarioBean = (UsuarioBean) Component.getInstance(UsuarioBean.class, true);
        usuario = usuarioBean.validaUsuario(username);

        if (usuario == null){
            throw new AuthorizationException("login failed");
        }else{
            credentials.setUsername(usuario.getNome());
            return Boolean.TRUE;
        }

    }catch(Exception e){
        log.error("falha na autenticação do usuario {0} : {1}", username, e.getCause().toString());
        throw new AuthorizationException("login failed");
    }

}