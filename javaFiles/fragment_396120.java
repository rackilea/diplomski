$ cat tst.awk
BEGIN {
    FS="[<>]+"
    OFS="="
}
{
    for (i=2;i<NF;i+=3) {
        print $i, $(i+1)
    }
    print ""
}
$ awk -f tst.awk file
251=id1
223=author1
215=title1
230=year1
232=location1

251=id2
223=author2
230=year2
232=location2
215=title2

251=id3
230=year2
232=location2
215=title2