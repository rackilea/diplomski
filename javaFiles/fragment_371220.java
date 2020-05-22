String[] jStrings = {"one", "two", "three"};
JsArrayString jsStrings = (JsArrayString)JsArrayString.createArray();

for (String s : jStrings) {
  jsStrings.push(s);
}

test(jsStrings);