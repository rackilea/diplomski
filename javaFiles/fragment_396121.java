$ cat tst.awk
BEGIN { FS="[<>]+"; OFS="," }

{
    for (i=2;i<NF;i+=3) {
        if (!seenName[$i]++) {
            names[++numNames] = $i
        }
        n2v[NR,$i] = $(i+1)
    }
}

END {
    for (nameNr=1; nameNr<=numNames; nameNr++) {
        printf "%s%s", names[nameNr], (nameNr<numNames?OFS:ORS)
    }

    for (recNr=1; recNr<=NR; recNr++) {
        for (nameNr=1; nameNr<=numNames; nameNr++) {
            name = names[nameNr]
            printf "%s%s", n2v[recNr,name], (nameNr<numNames?OFS:ORS)
        }
    }
}
$
$ awk -f tst.awk file
251,223,215,230,232
id1,author1,title1,year1,location1
id2,author2,title2,year2,location2
id3,,title2,year2,location2