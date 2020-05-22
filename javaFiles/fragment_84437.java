@Override
public void requestInitialized(ServletRequestEvent event) {
    if (event.getServletContext().getAttribute("disableListener") == Boolean.TRUE) {
        return;
    }

    // Do the original job here.
}

@Override
public void requestDestroyed(ServletRequestEvent event) {
    if (event.getServletContext().getAttribute("disableListener") == Boolean.TRUE) {
        return;
    }

    // Do the original job here.
}