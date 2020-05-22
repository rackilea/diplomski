for (int i = 0; i < 6; i++){
    if (i<3){
        City V = new City (arr[i], "EU", tab2[i]);
        array[i] = V;
    }
    else {
        Capitale C = new Capitale (arr[i], "USA", arr2[i], arr3[j - 3]);
        array[i] = C;
    }
}