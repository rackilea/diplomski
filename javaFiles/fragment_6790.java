@AfterMethod
public void after2(){
    System.out.println("after2");
}
@AfterMethod(dependsOnMethods = "after2")
public void after1(){
    System.out.println("after1");
}