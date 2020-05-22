List forms = new ArrayList();
int count = <number of vehicles>

while count > 0 {
   if ( count >= 5 ) {
      forms.add( "5.pdf" );
      count = count - 5;
   } else {
      forms.add( "" + count + ".pdf" );
      count = 0;
   }
}

<forms now contains the list of all forms you need>