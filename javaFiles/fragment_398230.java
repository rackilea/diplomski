boolean flag = false;

void consume() {
    while (true) {
       if (flag) {
          //we received flag, hooray
       }
    }
}

void produce() {
    flag = true;
}