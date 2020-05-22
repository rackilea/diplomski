String initial = "123-45-6789 is a SSN that starts at the beginning of the string,
    and still matches. This is an SSN, 123-31-4321, and here is another 987658765. These
    have 10+ digits, so they don't match: 123-31-43214, and 98765876545.
    This (123-31-4321-blah) has 9 digits, but is followed by a dash, so it doesn't match.
    -123-31-4321 is preceded by a dash, so it doesn't match as well. :123-31-4321 is 
    preceded by a non-colon/digit, so it does match. Here's a 4-2-4 non-SSN that would've
    tricked the initial regex: 1234-56-7890. Here's two SSNs in parentheses: (777777777) 
    (777-77-7777), and here's four invalid SSNs in parentheses: (7777777778) (777-77-77778)
    (777-778-7777) (7778-77-7777). At the end of the string is a matching SSN:
    998-76-4321";
String processed = initial.replaceAll("(?<=^|[^-\\d])\\d{3}\\-\\d{2}(?=\\-\\d{4}([^-\\d]|$))","XXX-XX")
                       .replaceAll("(?<=^|[^-\\d])\\d{5}(?=\\d{4}($|\\D))","XXXXX");
System.out.println(initial);
System.out.println(processed);