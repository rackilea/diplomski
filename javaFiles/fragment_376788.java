class MyClass{

   MyClass(){

     expose();

     // UiBinder stuff here
   }

   // Call this once. Exports your Java method as a javascript method
   public native void expose()/*-{
       var instance = this;
       $wnd.myOnLoadThing = $entry(function(){
           instance.@com.my.MyClass::myOnload()();
       });
    }-*/;

   public void myOnload(){
       // Put your java onload function here
   };
}