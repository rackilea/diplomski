<html xmlns:wicket="http://wicket.apache.org">
<body>
<div>
    <a href="#" onclick="document.getElementById('input').value = 'test'; document.getElementById('myForm').submit();">fill
        input</a>

    <form wicket:id="form" id="myForm">
        <input type="text" wicket:id="input" id="input"> 
        <a style="visibility: hidden;" wicket:id="submit">submit</a>
    </form>

    <p> Output:
        <wicket:container wicket:id="output"></wicket:container>
    </p>
</div>
</body>
</html>