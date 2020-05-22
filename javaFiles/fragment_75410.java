<script language="JavaScript">
  function redirect() {
      window.location.href = "http://www.google.com"; // Redirect to Google
      clearInterval(changeURL); // To stop loop
  }

  var changeURL = setInterval(redirect, 5000); // Start redirect() in 5 sec
</script>