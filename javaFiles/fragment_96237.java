# Database settings for PostgreSQL 7.4
#
# General information on database access can be found here:
# http://weka.wikispaces.com/Databases
#
# url:     http://www.postgresql.org/
# jdbc:    http://jdbc.postgresql.org/
# author:  Fracpete (fracpete at waikato dot ac dot nz)
# version: $Revision: 11885 $

# JDBC driver (comma-separated list)
jdbcDriver=org.postgresql.Driver

# database URL
jdbcURL=jdbc:postgresql://localhost:5432/datamining

# specific data types
# string, getString() = 0;    --> nominal
# boolean, getBoolean() = 1;  --> nominal
# double, getDouble() = 2;    --> numeric
# byte, getByte() = 3;        --> numeric
# short, getByte()= 4;        --> numeric
# int, getInteger() = 5;      --> numeric
# long, getLong() = 6;        --> numeric
# float, getFloat() = 7;      --> numeric
# date, getDate() = 8;        --> date
# text, getString() = 9;      --> string
# time, getTime() = 10;       --> date
# timestamp, getTime() = 11;  --> date

# PostgreSQL data types to Java classes information can be found at:
# http://www.postgresql.org/message-id/AANLkTinsk4rwT7v-751bwQkgTN1rkA=8uE-jk69nape-@mail.gmail.com
varchar=0
text=0
float4=7
float8=2
int4=5
oid=5
timestamp=8
date=8
bool=1
int2=5
int8=2
numeric=2
bpchar=9