public class ClassA{

    static Solo solo;

    //contructor
    public ClassA(Solo _solo){
      solo = _solo
    }

    public void click_on_save(){
    Log.v("Test" , "Test in classA");
    solo.sleep(5000);
    solo.clickOnText("Saved");
    }
}