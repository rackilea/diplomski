#{ifErrors}
   <h1>Oops...</h1>
#{/ifErrors}

#{form @Application.hello()}
   <div>
      Name: <input type="text" name="name" value="${flash.name}" />
      <span class="error">#{error 'name' /}</span>
   </div>
   <div>
      Age: <input type="text" name="age" value="${flash.age}" /> 
      <span class="error">#{error 'age' /}</span>
   </div>
   <div>
      <input type="submit" value="Say hello" /> 
   </div>
#{/form}