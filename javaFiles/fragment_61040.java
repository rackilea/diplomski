#! /bin/bash
clear
cd /Users/amar/Documents/ThesisCode/CEP_Architectures/databases/
#starting sqlite3
sqlite3 joined.db <<EOF

-- attaching other db's
ATTACH DATABASE "mobile_data.db" as mobile;
ATTACH DATABASE "server_data.db" as server;
ATTACH DATABASE "flink_data.db" as flink;

-- creating tables
CREATE TABLE mobile_events as select * from mobile.mobile_events;
CREATE TABLE server_events as select * from server.server_events;
CREATE TABLE flink_events as select * from flink.flink_events;

-- create a joined table
CREATE TABLE join1 as select M.patientid, M.sensorid , M.uid , M.egtl, M.egtg, S.eatg, M.valuez from mobile_events M inner join server_events S  on M.sensorid = S.sensorid and  M.uid = S.uid ;

EOF

echo "program is complete"