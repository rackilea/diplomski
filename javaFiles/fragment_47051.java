#!/usr/bin/env bash
sqlplus -s /nolog <<EOF
connect username/password
select username from dba_users where username = 'XYZ';
quit
EOF