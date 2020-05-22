$ openssl dgst -sha256 -sign private.pem < data.txt > sign2
$ hd sign2
00000000  15 c2 94 87 eb e6 cb 45  c8 63 0c 97 60 d3 07 f3  |.......E.c..`...|
00000010  dc 65 32 ad 44 1c c2 2a  7f a3 e1 fc dd 84 27 8c  |.e2.D..*......'.|
00000020  77 a6 97 2b 33 6b c6 d7  7d e1 1d 39 5c 48 b6 48  |w..+3k..}..9\H.H|
00000030  cb 18 be bf 6a 66 90 d3  88 89 52 6c dd d1 b9 99  |....jf....Rl....|