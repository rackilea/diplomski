CREATE KEYSPACE test with replication = {
    'class' : 'SimpleStrategy', 'replication_factor' : '1' 
}; 

CREATE TABLE test.users (
    id bigint PRIMARY KEY,
    name text,
    surname text
);

CREATE CUSTOM INDEX test_users_idx ON test.users() 
USING 'com.stratio.cassandra.lucene.Index'
WITH OPTIONS = {
    'refresh_seconds': '1',
    'schema': '{
        fields: {
            name: {type: "string"},
            surname:{type:"string"}
        }
    }'
};

INSERT INTO test.users(id, name, surname) VALUES (1, 'Hans', 'Albers');
INSERT INTO test.users(id, name, surname) VALUES (2, 'Quintina', 'Koch');
INSERT INTO test.users(id, name, surname) VALUES (3, 'Orlando', 'Schwarz');
INSERT INTO test.users(id, name, surname) VALUES (4, 'Federico', 'Hans');
INSERT INTO test.users(id, name, surname) VALUES (5, 'Berenice', 'Schwarz');
INSERT INTO test.users(id, name, surname) VALUES (6, 'Zaida', 'Koch');

SELECT * FROM test.users WHERE expr(test_users_idx,'{
    query: {
        type : "boolean", 
        should : [
            {type: "match", field: "name", value: "Hans", boost: 1.5},
            {type: "match", field: "surname", value: "Hans", boost: 1.0}
        ]
    }
}');