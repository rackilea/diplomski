from nltk.parse.corenlp import CoreNLPParser
parser = CoreNLPParser(url='http://localhost:{somePort}'
next(
     parser.raw_parse('The quick brown fox sucks at jumping.')
     ).pretty_print()
                ROOT
                 |
                 S
       __________|__________________________
      |                     VP              |
      |                 ____|___            |
      |                |        PP          |
      |                |     ___|_____      |
      |                |    |         S     |
      |                |    |         |     |
      NP               |    |         VP    |
  ____|__________      |    |         |     |
 DT   JJ    JJ   NN   VBZ   IN       VBG    .
 |    |     |    |     |    |         |     |
The quick brown fox  sucks  at     jumping  .