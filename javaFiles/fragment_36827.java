<form method="post" action="/some/action/url">
    <!-- My fields and buttons here -->

    <input type="hidden"
           name="{{ _csrf.parameterName }}" value="{{ _csrf.token }}" />
</form>