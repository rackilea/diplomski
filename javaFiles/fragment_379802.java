int flag = 0;
int first = scores[0];
for (int i = 0; i < scores.length; i++) {
    if(first != scores[i]) { //Encountering second number
        first = scores[i];
        flag++;
    }
    if(flag == 2) { //If already seen three numbers, break
        break;
    }
    System.out.println(scores[i]); //Good to print it
}