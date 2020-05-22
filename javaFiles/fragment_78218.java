if (token == null || !usuarioService.validarSesion(token)) {
            ((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", "*");
            ((HttpServletResponse) response).setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
            ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            return;
        }