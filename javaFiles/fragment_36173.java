p = re.compile(r'(?:(?<=^\d\/)|(?<=^\d\d\/))\d{1,2}')

print(p.findall("12/34/56"))   # "[34]"
print(p.findall("1/23/45"))    # "[23]"

p = re.compile(r'^\d{1,2}\/(\d{1,2})')

print(p.findall("12/34/56"))   # "[34]"
print(p.findall("1/23/45"))    # "[23]"

p = re.compile(r'(?<=^\d{1,2}\/)\d{1,2}')
# raise error("look-behind requires fixed-width pattern")