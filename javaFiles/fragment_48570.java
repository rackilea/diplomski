Phase: secondpass 
Input: Lookup Sentence 
Options: control = brill

Rule: A3b 
(
    {Lookup.majorType == "trouble"}
    {Lookup.majorType == "alteration", !Sentence}
):label 
--> :label.A3b = {rule= "A3b"}