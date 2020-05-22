@Test
public void multiplePattern() throws FindFailed{

    ImagePath.setBundlePath("C:\\patterns\\");

    Screen s = new Screen();
    Iterator<Match> it = s.findAll("downloadArrow.png");

    while(it.hasNext()){

        it.next().highlight(1);
    }
}