Random rand = new Random();
while (!arrays.isEmpty()) {
    int index = rand.nextInt(array.size());
    short[] s = arrays.get(index);

    for(int i = 0; i < s.length; i++)
    {
        datosdeNivel[aux]= s[i];
        aux++;
    }

    arrays.remove(index);
}