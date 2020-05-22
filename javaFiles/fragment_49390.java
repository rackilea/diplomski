if (v == accesodata) {
    Class c = null;
    if (someCondition) { // TODO: figure out what you should check 
        c = Barometro.class;
    } else {
        c = TemperaturaHuemdadDht22.class;
    } 
    Intent i = new Intent(ActividadInsercionObjeto.this, c);
    i.putExtra("IdentidadEnviada", (Serializable) campoIdObjeto.getText().toString());
    startActivity(i);