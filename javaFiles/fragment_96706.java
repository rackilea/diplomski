for (/* a lot of iteration with counter */) {
  st = connection.createStatement(); //you create a statement each iteration!

  //...

  // This whole thing not right here
  if ( counter % 50 == 0) {
    st.close(); // not right here -- will have 49 open statements by now
    connection.commit(); //this too
  }

}