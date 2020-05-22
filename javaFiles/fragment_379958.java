float wheelCount = 0;

void setup() {
  size(100, 100);
}

void draw() {
   if(wheelCount > 0){
      //do something with the variable

      wheelCount = 0; //reset it so we don't keep getting events
   }

} 

void mouseWheel(MouseEvent event) {
  wheelCount = event.getCount();
}