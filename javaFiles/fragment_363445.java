$.ajax({
  url: 'CreateUserServlet',
  method: 'POST',
  data: createForm.serialize(),
  success: function () {
    $('#successMsg').removeClass('hideMsg').addClass('showMsg');
  }
});