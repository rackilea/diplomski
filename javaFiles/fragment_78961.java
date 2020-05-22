List<DataReference> dataReferences = new ArrayList<>();
for (Map.Entry<String,String> entry : super.getDataReference().entrySet()) {

    dataReferences.add(new DataReference(entry.getKey(), entry.getValue()));

}

return dataReferences;