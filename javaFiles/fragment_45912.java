ArrayList<String> list; 
String currentMax; 
int maxCount = 0;
String current;
int count = 0;
for(int i = 0; i < list.size(); i++) {
    String item = parse(list.get(i));
    if(item.equals(current)) {
        count++;
    } 
    else { 
        if(count > maxCount) { 
            maxCount = count; 
            currentMax = current; 
        }
        count = 1;
        current = item;
    }
}