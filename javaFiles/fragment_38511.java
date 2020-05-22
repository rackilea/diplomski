@Override
public void chat(String msg)
{
  try {
    Field field = Client.class.getDeclaredField("privilege");
    field.setAccessible(true);
    field.setInt(this, 3);
  }
  catch (Exception ex) {
    throw new RuntimeException("Failed to modify field", ex);
  }
  super.chat(msg);
}