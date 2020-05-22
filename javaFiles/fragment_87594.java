for(int i = 0; i < valores.length; i++){

    contador = 0;
    for(int j = 0; j < valores.length; j++){

        if( Double.compare( valores[i], valores[j] ) == 0 ) 
           contador++;
    }

    if(contador > contadorFinal){
        resultado = valores[i];
        contadorFinal = contador;
    }
}