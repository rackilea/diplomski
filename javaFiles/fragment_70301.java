public void cantidadPositivos(){
    int i = 0;
    numerosPositivos = new int[pos];
    numerosNegativos = new int[neg];
    numerosNulos = new int[nulos];
    for(i = 0; i < cantidadElementos; i++)
    {
        if(numeros[i] >= 1)
        {
            numerosPositivos = ArrayUtils.add(numerosPositivos, numeros[i]);
            System.out.println(Arrays.toString(numerosPositivos));   
        }
        else if (numeros[i] <=-1)
        {
            numerosNegativos = ArrayUtils.add(numerosNegativos, numeros[i]);
        }
        else
        {
            numerosNulos = ArrayUtils.add(numerosNulos, numeros[i]);
        }

    }
    JOptionPane.showMessageDialog(null, "De los [ "+cantidadElementos +" ] elementos en el vector:\n\nPositivos: "+ pos +"\n\nNegativos: "+ neg +"\n\nNulos: " + nulos + "\n", "Información que cura", JOptionPane.INFORMATION_MESSAGE, null);
}