int k = 0;
for (int i = 0; i < duplicates.size() -1; i++){
    for (int j = i + 1; j < duplicates.size(); j++){
        if (duplicates.get(i).equalsIgnoreCase(duplicates.get(j))){
            mass[k] = duplicates.get(i);
            k++;
        }
    }
 }