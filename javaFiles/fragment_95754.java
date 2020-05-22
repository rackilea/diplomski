static String separador(String nome){
name = nome;
char[] letras;
Map tempMap = new HashMap();
Map m = new HashMap();
m.put('A', 0);
m.put('B', 1); 
letras = name.toCharArray();
int qtd = letras.length;
String fullName = "";

 for(int i=0; i<qtd; i++)
{
  if(m.containsKey(letras[i])
    tempMap.put(letras[i], m.get(letras[i]))
}

 return tempMap;