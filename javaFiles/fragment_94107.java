String temp = jsonObject.getJSONObject("data").toString();

Pattern p = Pattern.compile("\"(.*?)\":\\[");
Matcher m = p.matcher(temp);

m.find();

plans.add(m.group(1));

p = Pattern.compile("],\"(.*?)\":\\[");
m = p.matcher(temp);

while (m.find()){

    plans.add(m.group(1));

}

status = true;

return plans;