data = "name=" + $scope.reg_name +
    "&surname=" + $scope.reg_surname +
    "&email=" + $scope.reg_email +
    "&phone=" + $scope.reg_phone +
    "&skype=" + $scope.reg_skype +
    "&password=" + $scope.reg_password;
  }
$http.post(baseUrl+'user/',data,{
    headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
  })