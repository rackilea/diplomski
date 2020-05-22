<form id="login-form" action="j_security_check" method="post">
    <table>
        <tbody>
            <tr>
                <td><label for="username">User name:&nbsp;</label></td>
                <td><input type="text" name="j_username" id="username" /></td>
            </tr>
            <tr>
                <td><label for="password">Password:&nbsp;</label></td>
                <td><input type="password" name="j_password" id="password" /></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" id="submit" name="submit" value="Login"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><a href="../reg/create">I'm a new user</a></td>
            </tr>
        </tbody>
    </table>
</form>