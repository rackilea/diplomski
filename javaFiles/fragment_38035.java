StringBuilder stringBuilder = new StringBuilder();

for(int i = 0; i < links.size(); i++) {
    stringBuilder.append(links.get(i).getText());
}

String totalResult = stringBuilder.toString();

System.out.println(totalResult.toLowerCase().split("cheese", -1).length-1);