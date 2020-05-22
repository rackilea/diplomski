see "p" in your code,
1.first 'p' not contains , so call charMap.put(ch, 1); now in map 'p'->1 ,right?
2.second 'p' contains map , so call  charMap.put(ch,  charMap.get(ch) + 30); now in map 
'p'-> 31 , right?
3.third 'p' in map 'p'->61 , right?
4.fourth 'p' in map 'p'->91 , right?