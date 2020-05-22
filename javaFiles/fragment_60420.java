PreparedStatement ps = conn.preparedStatement(
  "INSERT INTO Xbox_One (Juego, URL, Publicado, Lanzamiento, Descripcion, "
            ..... + ") VALUES (?,?,?,?,? .... )";
);

for(String[] array : listaEmpresaA){
    for(int i = 0; i < 95; ++i){ //Careful to an arrayoutofbounds exception, but every parameter MUST BE SET
        ps.setString(i+1, array[i]); //Can't be null, if so, must use setNull(i+1);
    }
    ps.execute();
}