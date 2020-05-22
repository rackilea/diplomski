(?=.*[0-9])         must contain a number 
(?=.*[a-z])         must contain a lower case
(?=.*[A-Z])         must contain an upper case
(?=.*[!@#$%&*])     must contain a special character
(?!.*(.)\1\1\1)     must not repeat the character in group 1 more than 3 times
[0-9a-zA-Z!@#$%&*]  is composed of these characters
{0,100}             0 to 100 symbols allowed