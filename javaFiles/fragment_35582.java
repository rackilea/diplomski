Query query = em.createNativeQuery("FROM TipoUsuario WHERE NAME = :name;", TipoUsuario.class)
        .setParameter("name", name);

TipoUsuario tipoUsuario = null;

try
{
    tipoUsuario = (TipoUsuario) query.getSingleResult();
}
catch ( Exception e )
{
    return null;
}