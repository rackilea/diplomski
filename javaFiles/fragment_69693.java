bjb@blueeyes:~/$ python3
Python 3.5.3 (default, Sep 27 2018, 17:25:39) 
[GCC 6.3.0 20170516] on linux
Type "help", "copyright", "credits" or "license" for more information.
>>> import re
>>> line = '''Value1XXXValue2BBB
... Value3XXXValue4YYY any words in there Value5XXXValue6BBB
... a line there. and pattern here: Value7AAAValue8YYY'''
>>> context_re = re.compile(r'''(.*?)?(XXX|AAA)(.*?)(YYY|BBB)''', re.M|re.S)
>>> matches = context_re.findall(line)
>>> for match in matches:
...     print('found {}'.format(match))
... 
found ('Value1', 'XXX', 'Value2', 'BBB')
found ('\nValue3', 'XXX', 'Value4', 'YYY')
found (' any words in there Value5', 'XXX', 'Value6', 'BBB')
found ('\na line there. and pattern here: Value7', 'AAA', 'Value8', 'YYY')
>>> 
>>>