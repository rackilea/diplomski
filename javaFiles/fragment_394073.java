interface Mood{
   behave();
}

class GoodMood implements Mood{
   behave(){
       // behavior for good mood
   }
}


class AngryMood implements Mood{
   behave(){
       // behavior for angry mood
   }
}

class Troll{

    doSomething(Mood m){
         m.behave()
     }
}