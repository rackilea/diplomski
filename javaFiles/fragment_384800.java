/* this is static member of class */
static boolean map[] = new boolean[256];
static {
    for(int j = 0; j < map.length; j++)
        map[j] = false;
    /* map your required values true here */ 
    map['A'] = true;
    map['T'] = true;
    map['C'] = true;
    map['G'] = true;
    /* make small letter here too */
    map['a'] = true;
    map['t'] = true;
    map['c'] = true;
    map['g'] = true;
}