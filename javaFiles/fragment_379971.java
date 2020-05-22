@Repository
public class UsuarioHome extends Dao<Usuario> {

    public UsuarioHome() { //<---
        super(null);
    } 

    public UsuarioHome(Usuario entity) {
        super(entity);
        // TODO Auto-generated constructor stub
    }
}