#!/usr/bin/env python3

import re

xx_re = re.compile(r'''(.*?)?(XXX|AAA)(.*?)(YYY|BBB)''', re.M|re.S)

matches = context_re.findall(line)

for match in matches:
    print('found {}'.format(match))