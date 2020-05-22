Map<String, Label> map = new HashMap<String, Label>();
//...

for ( String key : map.keySet() ) {
}

for ( Label value : map.values() ) {
}

for ( Map.Entry<String, Label> entry : map.entrySet() ) {
    String key = entry.getKey();
    Label value = entry.getValue();
}