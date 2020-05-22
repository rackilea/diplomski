public final native <T> T myNativeMethod() throws JavaScriptException /*-{

    //..some code


    //in javascript you can throw anything it not just only exception object:
    throw "something"; 

    //or in another place of code
    throw "something else";

    //or:
    throw new (function WTF() {})();

}-*/;

void test() throws SomethingHappenedException, SomethingElseHappenedException, UnknownError {
    try {
        myNativeMethod();
    }
    catch(JavaScriptException e) { // what to catch here???

        final String name = e.getName(), description = e.toString(); 

        if(name.equalsIgnoreCase("string")) {

            if(description.equals("something")) {
                throw new SomethingHappenedException(); 
            }
            else if(description.equals("something else")) {
                throw new SomethingElseHappenedException(); 
            }
        }
        else if(name.equals("WTF")) {
            throw new UnknownError();
        }
    }
}