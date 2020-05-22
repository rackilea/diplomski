<% } else {%>
    <script>
        $.alert({
            title: 'Alert!',
            content: '<%= myText%>',
        });
    </script>
<% }%>