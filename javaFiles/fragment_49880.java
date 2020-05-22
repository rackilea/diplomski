String[] params = request.split("&");
List<String> values = new ArrayList<String>();
for (int i = 0; i < params.length; i++) {
    if (params[i].startsWith("fq")) {
        String[] fqsplit = params[i].split("=");
        if (fqsplit.length > 1) {
            values.add(fqsplit[1]);
        }
    }
 }