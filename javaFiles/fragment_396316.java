try {
        if (carrito == null) {
            InitialContext ic = new InitialContext();
            carrito = (CartLocal) ic.lookup("java:comp/env/CartLocal");

            request.getSession().setAttribute(CARRITO_SESSION_KEY, carrito);
        }
    } catch (NamingException ex) {
        Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
    }