@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void sdcardTest(){

        //check sdcard availability 
        Assert.assertEquals("Media is not mounted!", Environment.getExternalStorageState(), Environment.MEDIA_MOUNTED);
       //get and check Permissions
MyPermissionRequester.request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE);
        int grantResult = ActivityCompat.checkSelfPermission(InstrumentationRegistry.getTargetContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        Assert.assertEquals(PackageManager.PERMISSION_GRANTED, grantResult);
        grantResult = ActivityCompat.checkSelfPermission(InstrumentationRegistry.getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        Assert.assertEquals(PackageManager.PERMISSION_GRANTED, grantResult);

        //finally try to create folder
        File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "CompanyTest");
        if (!f.exists()){
            boolean mkdir = f.mkdirs();
            Assert.assertTrue("Folder '"+f.getAbsolutePath() + "' not Present!", mkdir);
        }
        boolean delete = f.delete();
        Assert.assertTrue("Folder '"+f.getAbsolutePath() + "' is Present!", delete);
    }
}