>>> from itertools import product
>>> for a, b in product([False, True], repeat=2):
...     print('{a!r:5} and {b!r:5}: {o1!r:5}    {a!r:5} & {b!r:5}: {o2!r:5}'.format(a=a, b=b, o1=a and b, o2=a & b))
... 
False and False: False    False & False: False
False and True : False    False & True : False
True  and False: False    True  & False: False
True  and True : True     True  & True : True