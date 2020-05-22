TOKEN : // Opcodes
{
    <I_CAL: "CAL"> 
|   <I_JPC: "JPC"> 
|   ... // other op codes
    <CMP_OP: "Z" | "B" | "BE" | "A" | "AE" | "NZ">
|   <T_REGISTER : "R0" | "R1" | "R2" | "R3" | "RP" | "RF" |"RS" | "RB">
}
... // Other lexical rules.

TOKEN : // Be sure this rule comes after all keywords.
{
    < IDENTIFIER: <LETTER> (<LETTER>|<DIGIT>)* >
}