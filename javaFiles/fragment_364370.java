int[][] mdArray = new int[5][5];
int i = 0;
int j = 0;
int min = 100;

for(i = 0; i < mdArray.length; i++){
    for(j = 0; j < mdArray[i].length; j++) {
        mdArray[i][j] = (int)(Math.random()*100);
        System.out.print(mdArray[i][j] + " ");

        if(min>mdArray[i][j])
        {
            min= mdArray[i][j];
        }
    }
    System.out.println("");
}

System.out.println("");
for(i = 0; i < mdArray.length; i++){
    for(j = 0; j < mdArray[i].length; j++){
        if(mdArray[i][j] == min) {
            System.out.println("["+i+"]"+"["+j+"]");
        }
    }
}