In some environments, certain algorithms or key lengths may be undesirable
for certification path building and validation.  For example, "MD2" is
generally no longer considered to be a secure hash algorithm.  This section
describes the mechanism for disabling algorithms based on algorithm name
and/or key length.  This includes algorithms used in certificates, as well
as revocation information such as CRLs and signed OCSP Responses.

The syntax of the disabled algorithm string is described as this Java
BNF-style:
  DisabledAlgorithms:
      " DisabledAlgorithm { , DisabledAlgorithm } "

  DisabledAlgorithm:
      AlgorithmName [Constraint]

  AlgorithmName:
      (see below)

  Constraint:
      KeySizeConstraint

  KeySizeConstraint:
      keySize Operator DecimalInteger

  Operator:
      <= | < | == | != | >= | >

  DecimalInteger:
      DecimalDigits

  DecimalDigits:
      DecimalDigit {DecimalDigit}

  DecimalDigit: one of
      1 2 3 4 5 6 7 8 9 0

The "AlgorithmName" is the standard algorithm name of the disabled
algorithm. See "Java Cryptography Architecture Standard Algorithm Name
Documentation" for information about Standard Algorithm Names.  Matching
is performed using a case-insensitive sub-element matching rule.  (For
example, in "SHA1withECDSA" the sub-elements are "SHA1" for hashing and
"ECDSA" for signatures.)  If the assertion "AlgorithmName" is a
sub-element of the certificate algorithm name, the algorithm will be
rejected during certification path building and validation.  For example,
the assertion algorithm name "DSA" will disable all certificate algorithms
that rely on DSA, such as NONEwithDSA, SHA1withDSA.  However, the assertion
will not disable algorithms related to "ECDSA".

A "Constraint" provides further guidance for the algorithm being specified.
The "KeySizeConstraint" requires a key of a valid size range if the
"AlgorithmName" is of a key algorithm.  The "DecimalInteger" indicates the
key size specified in number of bits.  For example, "RSA keySize <= 1024"
indicates that any RSA key with key size less than or equal to 1024 bits
should be disabled, and "RSA keySize < 1024, RSA keySize > 2048" indicates
that any RSA key with key size less than 1024 or greater than 2048 should
be disabled. Note that the "KeySizeConstraint" only makes sense to key
algorithms.

Note: This property is currently used by Oracle's PKIX implementation. It
is not guaranteed to be examined and used by other implementations.

Example:
  jdk.certpath.disabledAlgorithms=MD2, DSA, RSA keySize < 2048