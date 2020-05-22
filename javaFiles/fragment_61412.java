public class VerificarCorreoDAO extends InputVerifier {

    Pattern formato = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,3})$ ");
    JLabel lblMensaje;

    @Override
    public boolean verify(JComponent input) {
        Matcher mat;
        String texto;
        if (input instanceof JTextField) {
            texto = ((JTextField) input).getText().trim();
            if (texto.length() == 0) {                
                return false;
            } else if (texto.length() > 0 && texto.length() < 16 || texto.length() > 50) {                
                return false;
            }
        }
        mat = formato.matcher(texto);
        return mat.matches();
    }
}