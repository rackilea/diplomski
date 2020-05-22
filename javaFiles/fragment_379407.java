Glob   | Matches
-------------------------------------------------------------------------------------------------------------------
*      | Matches zero or more characters
?      | Matches a single character
[ab]   | Matches a single character in the set {a, b}
[^ab]  | Matches a single character not in the set {a, b}
[a-b]  | Matches a single character in the range [a, b] where a is lexicographically less than or equal to b
[^a-b] | Matches a single character not in the range [a, b] where a is lexicographically less than or equal to b
{a,b}  | Matches either expression a or b
\c     | Matches character c when it is a metacharacter