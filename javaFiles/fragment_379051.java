if(cstmt.isWrapperFor(SQLServerCallableStatement.class)) {
    SQLServerCallableStatement raw = cstmt.unwrap(SQLServerCallableStatement.class);
    raw.setStructured("ListaPlantaIds", "dbo.ID_PLANTAS_ASIGNADAS", sourceDataTable);
} else {
    // Do whatever you need to ; maybe throw an exception?
}