SQL> SELECT Name
  2    FROM CollationTestTable
  3   WHERE upper(convert(NAME, 'US7ASCII'))
  4         LIKE upper(convert('%pe%', 'US7ASCII'));

NAME
--------------------------------------------------------------------------------
pepe
pépé
PEPE

SQL> SELECT Name
  2    FROM CollationTestTable
  3   WHERE upper(translate(NAME, 'àâéèêìîòôùûÿ', 'aaeeeiioouuy'))
  4         LIKE upper(translate('%pe%', 'àâéèêìîòôùûÿ', 'aaeeeiioouuy'));

NAME
-----------------------------------
pepe
pépé
PEPE