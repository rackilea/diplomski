public class MyTest {

private SoundManager sfm;

@Before
public void setup() {
      sfm = new SoundFileManager();
}

@Test
public void getByIdAndName() {
  // Test adding a sound file and then getting it by id and name.
      SoundFile addedFile =              
      sfm.addSoundfile("E:\\Eclipse_Prj\\pSound\\data\\Adrenaline01.wav");
      SoundFile sf = sfm.getSoundfile(addedFile.getID());
      assertTrue(sf!=null);
      System.out.println(sf.toString());

      sf = sfm.getSoundfileByName("E:\\Eclipse_Prj\\pSound\\data\\Adrenaline01.wav");
      assertTrue(sf!=null);
      System.out.println(sf.toString());
}

@Test(expected=RapsManagerException.class)
public void getByInvalidId() {
      // Test get with invalid id. 
      sfm.getSoundfile(-100);
}

@Test(expected=RapsManagerException.class)
public void getByInvalidName() {
      // Test get with invalid id. 
      sfm.getSoundfileByName(new String());
}
}