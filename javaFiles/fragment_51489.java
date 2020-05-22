<script>
    setTimeout(function() {
        document.getElementById('message').innerHTML = 'Session has timed out!';
    }, ${pageContext.session.maxInactiveInterval} * 1000); // It returns seconds, but setTimeout expects milliseconds.
</script>
<div id="message"></div>