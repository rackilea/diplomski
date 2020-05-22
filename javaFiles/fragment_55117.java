public void setup() throws SQLException {
    sentencia = conexion.createStatement();
    MockitoAnnotations.initMocks(this);
    //Mockito.initMocks(this);
    Mockito.when(conexion.createStatement()).thenReturn(sentencia);
}