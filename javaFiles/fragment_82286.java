JsonParser jsonParser = new JsonParser();
JsonElement tree = jsonParser.parse(json_input);

// now you can walk it
JsonObject document = tree.getAsJsonObject();

//check if -- is set
document.has("var1");

// get the value
document.get("var1").getAsString()

// assuming your identifiers are are all consecutively numbered
for (int i = 1; document.has("var" + i); i++)
    document.get("var" + i).getAsString();
}

// or to mimic your example - at the expense of readability
int i = 0;
while (document.has("var" + ++i)) {
    document.get("var" + i).getAsString();
}