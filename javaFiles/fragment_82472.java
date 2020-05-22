<script>
 //get The current URL
 var currURL = ${requestScope['javax.servlet.forward.request_uri']}
 //Push the current URL to window history
 window.history.pushState("object or string", "mapviewer", currURL );
</script>