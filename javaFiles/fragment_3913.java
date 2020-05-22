{{#gender}}
            <input type="radio" name="gender" value="male" > Male<br>
            <input type="radio" name="gender" value="female" checked> Female
        {{/gender}}
        {{^gender}}
            <input type="radio" name="gender" value="male" checked> Male<br>
            <input type="radio" name="gender" value="female"> Female
        {{/gender}}