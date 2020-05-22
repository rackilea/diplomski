private void sendMessage(String message) {
     out.print(message + END_OF_MESSAGE);
     out.println();
     if ( pw.checkError() )
     {
       LOG.log( Level.SEVERE, "An error occured while writing.");
       shutdown(); // <-- method with the shutdown logic (e.g. closing the socket).
     }
}