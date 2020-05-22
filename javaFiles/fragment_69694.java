>>> context_re = re.compile(r'''([\S]+)(XXX|AAA)(.*?)(YYY|BBB)''', re.M|re.S)
>>> matches = context_re.findall(line)
>>> for match in matches:
...     print('found {}'.format(match))
... 
found ('Value1', 'XXX', 'Value2', 'BBB')
found ('Value3', 'XXX', 'Value4', 'YYY')
found ('Value5', 'XXX', 'Value6', 'BBB')
found ('Value7', 'AAA', 'Value8', 'YYY')
>>>