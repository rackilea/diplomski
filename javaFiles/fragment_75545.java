<?php
// Has the form been submitted?
if(isset($_POST['body']))
{
  // This should load the file into $lines, as an array of, well, lines.
  $lines = file('list.txt');

  // For each line, send a message. $line should contain an e-mail address.
  foreach($lines as $line)
    mail($line, $_POST['subject'], $_POST['body']);

  // Send a message to the browser.
  die("Message delivered.");
}
?>
<html>
 <head>
  <title>Post to Mailing List</title>
 </head>
 <body>
  <h1>Post</h1>
  <form action="#" method="post">
   <input type="text" name="subject" /><br/>
   <textarea name="body"></textarea><br/>
   <input type="submit" value="Submit" />
  </form>
 </body>
</html>