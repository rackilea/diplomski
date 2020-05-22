class A {
   public void foo() throws IOException {..}
}

class B extends A {
   @Override
   public void foo() throws SocketException {..} // allowed

   @Override
   public void foo() throws SQLException {..} // NOT allowed
}