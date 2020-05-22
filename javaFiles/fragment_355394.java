public Tab abaUsuario( String nome )
{
    try
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation( Principal.class.getResource( "controls/novoUsuarioForm.fxml" ) );
        AnchorPane novoUsuario = ( AnchorPane ) loader.load();
        //UsuarioDAO usrDAO = new UsuarioDAO();
        //Usuario usr = new Usuario();

        // NovoUsuarioFormController nvu = new NovoUsuarioFormController();

        NovoUsuarioFormController nvu = (NovoUsuarioFormController) loader.getController();
        nvu.setMainApp( this );

        Tab t = new Tab( nome );
        t.setContent( novoUsuario );
        return t;
    }
    catch ( IOException ex )
    {
        Dialogs.showErrorDialog( primaryStage, ex.getMessage(), "Erro ao inserir Usuário", "JANELA DE ERRO" );
        //ex.getCause().printStackTrace();
    }
    return null;
}