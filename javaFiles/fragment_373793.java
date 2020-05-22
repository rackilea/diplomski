for(ParseObject parseObject : citasTaller){
    String hora = parseObject.getString("Hora");
    if(horasList.contains(hora)){
        horasList.remove(hora);
    }
}