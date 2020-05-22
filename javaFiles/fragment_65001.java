while (cursor.hasNext()) {
   Document element = cursor.next();
   b.setDepartament(element.getString("departament"));
   b.setText(element.getString("text"));
   b.setTitle(element.getString("title"));
   lista.add(b);
}