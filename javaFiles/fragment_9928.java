Phase: Intersection
Input: Record a b
Options: control = first debug = true


// A record matches with this rule if it contains both tag a and tag b.
Rule: Rule_1
(
    {Record contains a, Record contains b}
):match
-->
:match.Record_with_both_tags = { rule = "Rule_1" }


// A record matches with this rule if it contains tag a.
Rule: Rule_2
(
    {Record contains a}
):match
-->
:match.Record_with_tag_a = { rule = "Rule_2" }