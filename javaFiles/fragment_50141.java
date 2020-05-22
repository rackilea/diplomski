If either operand is NaN, the result is NaN.
If the result is not NaN, the sign of the result is positive if both operands have the same sign, negative if the operands have different signs.
Division of an infinity by an infinity results in NaN.
Division of an infinity by a finite value results in a signed infinity. The sign is determined by the rule stated above.
Division of a finite value by an infinity results in a signed zero. The sign is determined by the rule stated above.
Division of a zero by a zero results in NaN; division of zero by any other finite value results in a signed zero. The sign is determined by the rule stated above.
Division of a nonzero finite value by a zero results in a signed infinity. The sign is determined by the rule stated above.
In the remaining cases, where neither an infinity nor NaN is involved, the exact mathematical quotient is computed. A floating-point value set is then chosen:
    If the division expression is FP-strict (§15.4):
        If the type of the division expression is float, then the float value set must be chosen.
        If the type of the division expression is double, then the double value set must be chosen. 
    If the division expression is not FP-strict:
        If the type of the division expression is float, then either the float value set or the float-extended-exponent value set may be chosen, at the whim of the implementation.
        If the type of the division expression is double, then either the double value set or the double-extended-exponent value set may be chosen, at the whim of the implementation. 

Next, a value must be chosen from the chosen value set to represent the quotient. If the magnitude of the quotient is too large to represent, we say the operation overflows; the result is then an infinity of appropriate sign. Otherwise, the quotient is rounded to the nearest value in the chosen value set using IEEE 754 round-to-nearest mode. The Java programming language requires support of gradual underflow as defined by IEEE 754 (§4.2.4).