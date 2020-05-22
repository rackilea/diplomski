Integer f1 = map.get(c1);
Integer f2 = map.get(c2);
int x = f1.compareTo(f2)
if(x == 0){
    return Character.compare(c1, c2);
}
return x;