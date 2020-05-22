<form th:object="${lecture}" method="post">
   <div>
       <label for="subject">Subject: </label>
       <input type="text" name="subject" th:field="*{subject}">
       <input type="submit" value="Search">
   </div>
</form>