while (result.next()) {

obj = new JSONObject();

        obj.put("id", result.getInt("idUser"));

        obj.put("email", result.getString("emailUser"));

        obj.put("password", result.getString("motPassUser"));

        array.add(obj);
    }