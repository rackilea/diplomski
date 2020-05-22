int i= -1;
int prev= -1;
boolean cond = true;
public void mousePressed() {  
    while(cond){
        i=myPositiveRNG.nextInt();//assuming positive numbers, 'cause it's an array index.
        if(prev>-1){
            System.out.println(prev);
        }
        if (mouseX > boxes[i].x){
            boxes.[i].openIt();
        }
        prev = i;
        cond=isItTimeToGo();
}