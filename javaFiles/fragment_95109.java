onLogin(loginData: {username: string, password: string}) {
  let headers = new Headers();
  headers.append('Access-Control-Allow-Credentials', 'true');
  headers.append('Content-Type','application/x-www-form-urlencoded');

  let body = `username=${loginData.username}&password=${loginData.password}`;

  this.http.post('http://localhost:5000/login', body, {headers: headers})

    .map(res => res)
    .subscribe(data => {
      console.log(data.status);
      if (data.status == 200) {
        this.navCtrl.push(TabsPage);
      }
      else {
        this.showError("Invalid username or password");
      }

    });
}