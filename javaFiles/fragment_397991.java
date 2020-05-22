int per = 0;
String state = "beginning";
String currentText = "";
Delay delay;

String headband = "Clip band around your head to begin";
String access = "Welcome to Brain Frame -- an intersection between the mind and the virtual. Please press the blue button to proceed a neural link. Press the red button to exit.";
String Y ="Establishing pre-cursory neural link. Do not remove headband."; 
String N ="Shutting Down. Do not remove headband until prompted - may result in memory distortion otherwise.";

boolean yes = false;
boolean no = false;
boolean head = false;

class Delay {
  protected int limit;

  public Delay() {limit = millis();}
  public Delay (int l) {
    limit = millis() + l;
  }

  public boolean expired () {
    if (millis() > limit) { return true; }

    return false;
  }
}

void setup() {
  size(1080, 720); 
  delay = new Delay();
}

void draw () {
  SetText();


  background(0);

  fill(0,255,255);
  text (currentText, 540, 360);
  textSize(30);
  textAlign(CENTER);
}

void SetText() {
  // This method will check what text you should display and set it. The draw() method will... well, just "draw" everything.

  // The switch "choose" what to do by checking what you set the "state" variable to.
  switch(state) {
    case "beginning":
      currentText = headband;
      if (head) {
        state = "head";
      }
      break;
    case "head":
      currentText = access;
      if (yes) {
        state = "yes";
      } else if (no) {
        state = "no"; 
      }
      break;
    case "yes":
      currentText = Y + "\n" + per + "%";
      if (per < 100) {
        if (delay.expired()) {
          // the delay timer will expire every 100 milliseconds until the 'per' variable is 100, kinda like you did but with a timer
          per += 1;
          delay = new Delay(100);
        }
      } else {
        state = "childhood";
        delay = new Delay(3000);
      }
      break;
    case "no":
      currentText = N;
      break;
    case "childhood":
      currentText = "Think about your childhood";
      if (delay.expired()) {
        state = "link";
        delay = new Delay(3000);
      }
      break;
    case "link":
      currentText = "Link created";
      break;
  }
}

void keyPressed(){
   if (key == 'j' || key == 'J'){
       head = true;
   }

   if (key == 'y' || key == 'Y'){
       yes = true;
   }

   if (key == 'n' || key == 'N'){
       no = true;
   }
}