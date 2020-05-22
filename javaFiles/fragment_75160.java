if (context.getCrossContext()) {
        // If crossContext is enabled, can always return the context
        return child.getServletContext();
    } else if (child == context) {
        // Can still return the current context
        return context.getServletContext();
    } else {
        // Nothing to return
        return (null);
    }