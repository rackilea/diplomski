fetch('/logIn', {
  method: 'POST',
  body: JSON.stringify({
    username: txtUsername.value,
    password: txtPassword.value
  }),
  credentials: 'include', // <<< FIX
  headers : {
    'Content-Type' : 'application/json'
  }
})
.then(result => {
  result.text().then(function(text) {
    if(result.status == 200) {
        location.reload();
    } else {
        alert("Error:\n" + text);
    }
  });
})
.catch(e => {
  console.log(e);
  alert("Error:\n" + e);
});