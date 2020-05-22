class Element: pass

class ElementQuad2D(Element): pass

mapping = {'quad8': ElementQuad2D}
obj = mapping['quad8']()
print(obj)
#  <__main__.ElementQuad2D object at 0x01D70BD0>