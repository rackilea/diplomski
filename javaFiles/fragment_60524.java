class JavaCallback extends Callback
{
  public void run(Child p)
  {
    out.p("JavaCallback.run("+p.getClass().getSimpleName()+")");
    out.p("p.getName() = "+p.getName());
    super.run(p);
  }
}