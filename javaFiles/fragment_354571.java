bash-3.2$ ssh robot@gerrit.foo.int gerrit review --label Verified=-1 \
    --message '"Verified .. -1."' 2463,9 & \
    ssh robot@gerrit.foo.int gerrit review --label Tested=+1 \
    --message '"Tested .. +1."' 2463,9 &
[3] 29329
[4] 29330
bash-3.2$
bash-3.2$ error: Cannot post review
one or more reviews failed; review output above

[3]   Done                    ssh robot@gerrit.foo.int gerrit review --label Verified=-1 --message '"Verified .. -1."' 2463,9
[4]   Exit 1                  ssh robot@gerrit.foo.int gerrit review --label Tested=+1 --message '"Tested .. +1."' 2463,9