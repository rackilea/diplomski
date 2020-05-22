int tab_E_index = 0;
 for (int i = 0; i < tab2.length; i++){
    if (tab2[i] % 2 == 0){
         tab_E[tab_E_index] = tab2[i]; //i value gets incremented every loop iteration
         tab_E_index++;                //tab_E_index value get incremented only when even number is added to the tab_E array
    }
}