boolean hasObjects = true;

while (hasObjects) {
    String notificacion = null;
    if (ois != null) {
        try {
            notificacion = (Notificacion) ois.readObject();
            listaNotificaciones.add(notificacion);
        } catch (EOFException e) {
            hasObjects = false;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    } else {
        hasObjects = false;
    }
}