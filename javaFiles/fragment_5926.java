String res = "\r\nC:\\User\\aaa\\bbb\\ccc\\tdex_ecb.exe 000000 111111 33333 44444 \r\n INFO I WANT\r\n C:\\\\User\\\\aaa\\\\bbb\\\\ccc\\\\";

res = res.substring(2);
res = res.substring(res.indexOf("\r\n")+2);
res = res.substring(0, res.indexOf("\r\n"));

System.out.println(res);