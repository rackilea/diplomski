<?php
$to = "me@example.com"
$from = "From: form-results@example.com";
$subject = "Got a result from the form!";
// Get the e-mail from the form
$email = $_POST['email'];
$body = "The persons e-mail is" . $email;

// Send an e-mail to me@example.com 
mail($to, $subject, $body, $from);

?>
<html>
<head>
<title>Thank you :)</title>
</head>
<body>
Thanks for your submition. We have added 
<?php 
      echo $email;
?>
to our mailing list!.
</body></html>