String line = "";
while ((line = br.readLine()) != null) {
  output += line;
}

output = "{" + output + "}";