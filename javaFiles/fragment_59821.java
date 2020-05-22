Exception ex = null;
try {
    // do something that raises an exception
    ex = new Exception();
} catch (Exception ex)  {
    ex = ex;
}
// ex == null