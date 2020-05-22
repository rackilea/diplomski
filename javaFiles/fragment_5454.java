public void printField(){
    for(int i = 0;i < 20;i++){
        for(int j = 0;j < 20;j++){
            if(objectIsOnField(j, i)) //j is for x because j iterate through line
                System.out.print("[*]");
            else
                System.out.print("[_]");
        }
        System.out.println();
    }
}