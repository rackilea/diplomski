<?php
// Has the form been posted?
if(isset($_POST['email']))
{
  // Append the submitted e-mail to the list.
  $file = fopen('list.txt', 'a');
  fputs($file, $_POST['email'] . "\n");
  fclose($file);

  // Send a message to the browser.
  die('Added to mailing list.');
}
?>
<html>
 <head>
  <title>Subscribe to Mailing List</title>
 </head>
 <body>
  <form action="#" method="post">
   <input type="text" name="email" />
   <input type="submit" value="Submit" />
  </form>
 </body>
</html>