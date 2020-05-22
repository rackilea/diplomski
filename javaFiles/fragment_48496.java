@(questionForm: Form[Question])

@main("Welcome to Play") {
  @helper.form(action = routes.Application.post()) {
    <h2>Question:</h2>
    @helper.inputText(questionForm("text"))
    @helper.inputText(questionForm("sourceCode"))
    @helper.inputText(questionForm("complement"))
    <h3>Answers:</h3>
    @helper.repeat(questionForm("answer.alternatives"), min = 2) { alternative =>
      @helper.checkbox(alternative("correct"))
      @helper.inputText(alternative("statement"))
    }
    <button type="submit">Save</button>
  }
}