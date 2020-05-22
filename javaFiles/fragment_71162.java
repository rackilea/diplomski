int size = 0;
for (int i = 0; i < arg.size(); size += arg.get(i++).size());

String[] headers =new String[size];
for(int count = 0, i=0;i<arg.size();i++) {
    for (int j=0; j< arg.get(i).size(); j++) {
        headers[count++]= arg.get(i).get(j).toString();
    }
}