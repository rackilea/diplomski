*{ assuming parameter 'user' is passed in the render method that creates this view }*
#{form @controller.save()}
  #{field 'user.name'}
    <p>
      <label>&{field.name}</label>
      <input type="text" id="${field.id}" name="${field.name}" value="${field.value}"  class="${field.errorClass}">
      <span class="error">${field.error}</span>
    </p>
  #{/field}
  *{ add more field the same way }*
#{/form}