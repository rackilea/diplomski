`Datos datosFinal = gson.fromJson(response_jSon, Datos.class);
 for (int i=0; i<datosFinal.items.size(); i++){
        Log.d("msg_2", datosFinal.items.get(i).item.images.transparent);
        Log.d("msg_2", datosFinal.items.get(i).item.images.transparent_blank);
        Log.d("msg_2", datosFinal.items.get(i).item.images.transparent_dark);
}`