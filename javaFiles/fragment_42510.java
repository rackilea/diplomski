@(editForm:Form[User]

@*** IMPORTS ****@
@import helper._

@form(routes.Tasks.save(), 'class -> "form-horizontal") {
     @inputText(editForm:Form("description()").....)
     @inputArea(editForm:Form("description()").....)
}