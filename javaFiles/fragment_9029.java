public void createOrSave(DatosUsuario datosUsuario) {
    if (datosUsuario.getId() == null){
        em.persist(datosUsuario);
    }
    else{
        em.merge(datosUsuario);
    }
}