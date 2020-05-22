String json = "{\"fkcl\":\"5\",\"fkdiv\":[\"1\",\"2\",\"3\",\"4\",\"5\"],\"fkcl1\":\"3\",\"fkdiv1\":[\"1\",\"2\",\"3\",\"4\",\"5\"]}";

String output = json
    .replaceAll("\\{?(\"fkcl)", "\n[{$1")
    .replaceAll(",\n", "}]\n") + "]";

System.out.println(output);