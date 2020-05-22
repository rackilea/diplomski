Phase: RecordFinder
Input: Token
Options: control = first debug = true


// The following rule is able to find the sentence within a record
Rule: RuleToFindRecord
(
    ({Token.string == "<"} {Token.string == "record"} ({Token})* {Token.string == ">"})
    ({Token})*
    ({Token.string == "<"} {Token.string == "/"} {Token.string == "record"} {Token.string == ">"})
):match
-->
:match.Record = { rule = "RuleToFindRecord" }