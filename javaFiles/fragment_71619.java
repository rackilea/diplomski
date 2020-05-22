ArrayList<String> s = new ArrayList<String>();

String line;
int n = 0;
while ((line = r.readLine()) != null) {
    if(n % 2 == 0){
        s.add(line);
    }
    else{
        w.println(line);
    }
    n++;
}
Iterator<String> i = s.iterator();
while (i.hasNext()) {
    w.println(i.next());
}