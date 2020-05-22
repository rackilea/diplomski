if( rs.next() )
{
  dispose();
  Main main = new Main();
  main.setSize(500,200);
  main.setVisible(true);
  conn.close();
}
else
{
  // show some error
}