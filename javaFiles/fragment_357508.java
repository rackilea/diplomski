1. Open config.inc.php file in the phpmyadmin directory

2. Find line 21: $cfg['Servers'][$i]['password'] = ''

3. Change it to: $cfg['Servers'][$i]['password'] = 'your_password';

4. Restart XAMPP 


The setting you are looking for is "$cfg['Servers'][$i]['auth_type']" - set this to 'HTTP', and you will be able to input a username and password.