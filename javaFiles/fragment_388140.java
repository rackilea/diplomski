public class MyIntro extends AppIntro {

Appintro1 appIntro1 = new Appintro1();
Appintro2 appIntro2 = new Appintro2();
ScreenSlidePageFragment appIntro3 = new ScreenSlidePageFragment();

@Override
public void init(Bundle savedInstanceState) {
addSlide(appIntro1);
addSlide(appIntro2)
addSlide(appIntro3);
}
....
}