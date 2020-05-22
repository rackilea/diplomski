<form class="form-signin" th:action="@{/login}" method = "post">
    <h2 class="form-signin-heading">Please sign in</h2>
    <label for="inputEmail" class="sr-only">Username</label>
    <input type="text" id="username" name="username" class="form-control" placeholder="Username" required="required" autofocus="autofocus" />
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="password"  name="password" class="form-control" placeholder="Password" required ="required" />

    <button class="btn btn-lg btn-primary btn-block" type="submit" style="background-color:#F6358A;">Sign in</button>
  </form>