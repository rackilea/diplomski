public static void delete(int index,int[] array){
        if(index < 0 || index > array.length){
            return; // or throw error
        }

        for(int cpt = index; cpt < array.length - 1 ; cpt++){
            array[cpt] = array[cpt+1];
        }

        array[array.length - 1] = 0;
    }