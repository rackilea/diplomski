router.get('/redirect', function(req, res) {
    var token = 'jsdh98yuhes87e6ywqy2'; // Something Your server have generated

    res.header('Authorization', token);

    res.redirect(301,'http://www.SiteB.com/autologin/');
});