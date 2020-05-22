while(rs.next() && i<25){                    
        DTO aux=new DTO();// create aux object here

        aux.setIdVinilo(rs.getInt("id_vinilo"));
        aux.setTitulo(rs.getString("titulo"));
        aux.setAutor(rs.getString("autor"));
        aux.setGenero(rs.getString("genero"));
        aux.setFecha(rs.getInt("fecha"));
        aux.setDiscografica(rs.getString("discografica"));
        aux.setImagen(rs.getString("imagen"));

        historial.add(aux);
        i++;
}