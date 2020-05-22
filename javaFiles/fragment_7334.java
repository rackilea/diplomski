@Override
public void onLoopjTaskCompletedBarometro(ArrayList<JSONObject> arrayJSONObjects) {

    String temperatura = null;
    String presion = null;
    String fecha = null;
    String Id = null;
    String altitud = null;
    JSONObject date = null;

    int index = 0;

    for (JSONObject jsonObject : arrayJSONObjects) {

        try {
            Id = jsonObject.getString("Id_temp");
            temperatura = jsonObject.getString("temperatura");
            fecha = jsonObject.getString("Insertado_temp");
            presion = jsonObject.getString("presion");
            altitud = jsonObject.getString("altitud");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Medicion medicion =  new Medicion(temperatura, presion, fecha, Id);

        if (!mediciones.contains(medicion)) {
            mediciones.add(medicion);


        temperaturas.add(new Entry(Float.valueOf(index), Float.valueOf(medicion.getTemperatura())));
        presiones.add(new Entry(Float.valueOf(index), Float.valueOf(medicion.getPresion())));
        dates.add(fecha); // reduce the string to just 12:13 etc
        index++;
    }
    }

    for (Medicion temporaryMed : mediciones) {
        Log.i(UtilitiesGlobal.TAG, "onLoopjTaskCompletedBarometro: listado sin dobles "
                + temporaryMed.getId());
        Log.i(UtilitiesGlobal.TAG, "onSuccess: loopj "
                + "temperatura: " + temporaryMed.getTemperatura()
                + " presion: " + temporaryMed.getPresion()
                + " Fecha Inserción: " + temporaryMed.getFecha());
    }