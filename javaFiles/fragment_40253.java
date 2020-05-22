SELECT * 
FROM theTable
WHERE x BETWEEN [minX] AND [maxX] 
AND y BETWEEN [minY] AND [maxY]
HAVING POW(x-[originX], 2) + POW(y-[originY], 2) <= POW([distance], 2)
;