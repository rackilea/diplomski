static private void foo() throws FileNotFoundException  {
    try {
        throw new FileNotFoundException();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        throw e;
    }
}