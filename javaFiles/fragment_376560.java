public class MyTemplate
{
  private MyTemplate[] childTemplates;

  void iterate()
  {
    // do something with this
    for (MyTemplate template: childTemplates)
      template.iterate();
  }
}