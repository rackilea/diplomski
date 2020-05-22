String[] names = { "s1", "s2", "s3", "s4" };
String[] vals  = { "a", "b", "c", "d" };

int len = names.length;

for(int i = 0; i < len; i++){
//name[i] already exists so you can remove String
   names[i] = vals[i];
}