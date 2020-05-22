Phase: TagFinder
Input: Token
Options: control = first debug = true


// The following rule is able to find the tag "a" within the document.
Rule: RuleToFindTag_a
(
    (
        ({Token.string == "<"} {Token.string == "a"} {Token.string == ">"})
        ({Token})*
        ({Token.string == "<"} {Token.string == "/"} {Token.string == "a"} {Token.string == ">"})
    )
    |
    ({Token.string == "<"} {Token.string == "a"} {Token.string == "/"} {Token.string == ">"})
):match
-->
:match.a = { rule = "RuleToFindTag_a" }


// The following rule is able to find the tag "b" within the document.
Rule: RuleToFindTag_b
(
    (
        ({Token.string == "<"} {Token.string == "b"} {Token.string == ">"})
        ({Token})*
        ({Token.string == "<"} {Token.string == "/"} {Token.string == "b"} {Token.string == ">"})
    )
    |
    ({Token.string == "<"} {Token.string == "b"} {Token.string == "/"} {Token.string == ">"})
):match
-->
:match.b = { rule = "RuleToFindTag_b" }