set d=new Dictionary
set c1=new Collection
set c2=c1
d(c1) = 42
fv d
<Dictionary: keys: #V(0..0){<Collection: 0 elems: >}, items: #V(0..0){42%}>
d(c2)=99
fv d
<Dictionary: keys: #V(0..0){<Collection: 0 elems: >}, items: #V(0..0){99%}>
set c3=new Collection
d(c3)=101
fv d
<Dictionary: keys: #V(0..1){<Collection: 0 elems: >,<Collection: 0 elems: >}, items: #V(0..1){99%,101%}>