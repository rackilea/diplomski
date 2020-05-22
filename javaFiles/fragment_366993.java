sock = httplib.HTTPConnection('server.com', 80)
data = "op=a_login_attempt"
headers = { "Host":"server.com",
            "Content-Type":"application/x-www-form-urlencoded; charset=UTF=8",
            "Referer":"server2.com",
            "Cookie":"session=12345678",}
sock.request("POST", '/login.php', data, headers)