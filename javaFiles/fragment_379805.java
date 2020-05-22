#!/usr/bin/python

print "Content-type: text/html\n\n"

import json
from collections import defaultdict

mystuff = list()
mystuff.append( ('1', 'b', 'c', 'd') )
mystuff.append( ('2', 'f', 'g', 'h') )

stufflist = list()

for s in stufflist:
    d = {}
    d['a'] = s[0]
    d['b'] = s[1]
    d['c'] = s[2]
    d['d'] = s[3]
    stufflist.append(d)

print json.write(stufflist)