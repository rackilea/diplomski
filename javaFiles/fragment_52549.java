while (tulosjoukko.next()) {
    System.out.println(tulosjoukko.getString("pvm"));

    jsonolio = new JSONObject();
    jsonolio.put("id", tulosjoukko.getInt("id"));
    jsonolio.put("pvm", tulosjoukko.getString("pvm"));
    jsonolio.put("kulutus", tulosjoukko.getInt("kulutus"));
    jsontaulu.put(jsonolio);

}