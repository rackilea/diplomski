<form action="subscribe.html" th:attr="action=@{/subscribe}">  
   <fieldset>
    <input type="text" name="email" />
    <input type="submit" value="Subscribe!" th:attr="value=#{subscribe.submit}"/>   
    </fieldset> 
</form>