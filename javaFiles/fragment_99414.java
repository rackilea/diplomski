boolean existsData = false;
for(int i=0; i<arr.length; i++)
    //arr[i] = 0 means assign 0 to arr[i]
    //note that I'm using different (!=)
    existsData = (arr[i] != 0);
    if (existsData) {
        break;
    }
}
return existData;