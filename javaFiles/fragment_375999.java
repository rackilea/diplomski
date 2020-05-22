List<Answer> answerList = new ArrayList<Answer>();
Answer answer = new Answer();
answer.setAnswerId(3);
answer.setDescription(3rd choice);
ModelAndView modelAndView = new ModelAndView();     
modelAndView.addObject("answerList", answerList);   

<select id="dropdown" name="dropdown">
    <option value="">Select</option>
    <c:forEach items="${answerList}" var="answer" varStatus="answerStatus">
        <option value="${answer.description}" label="${answer.description}"/>
    </c:forEach>
</select>