//this delegates what happens to 'a' to the lower link, passing the responsibility to it along the 'chain'
void action(String a,String b){
    action(a);
    functionB();
}
//this delegates what happens to 'a' to the lower link, passing the responsibility to it along the 'chain'
void action(String a,String B,String C){
    action(a);
    functionD();
}
//this is the lowest link in your chain of responsibility, it handles the one parameter case
void action(String a){
    functionA();
    functionC();
}