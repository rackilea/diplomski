List<String> idsList = new ArrayList<>();
String[] ids = model.getId().split(",");
for(String id : ids) {
    idsList.add(id);
}

query.setParameterList("id", idsList);