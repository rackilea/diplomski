public void dump() {                                                        
    for (int y = 0; y < n; y++) {                                           
        for (int x = 0; x < n; x++) {                                       
            System.out.print(state[y * n + x]);                             
        }                                                                   
        System.out.println();                                               
    }                                                                       
}