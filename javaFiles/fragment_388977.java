public class ClassC {

    static Solo solo;
    public ClassC(Solo _solo){
        solo = _solo
    }
    ClassA aa = new ClassA(solo);
    @Test
    public void test001(){
    Log.v("Test" , "Test Start ");
    aa.click_on_save();
    }
}