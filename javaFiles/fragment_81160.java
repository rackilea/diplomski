$container->when('UserModel')->needs('DAO')->give(function () {
    return new DAO('connectionA', 'usernameA', 'passwrodA');
});

$container->when('PostModel')->needs('DAO')->give(function () {
    return new DAO('connectionB', 'usernameB', 'passwrodB');
});