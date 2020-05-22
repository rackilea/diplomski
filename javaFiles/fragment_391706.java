CREATE TABLE stop_route 
( id       INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY
, stop_id  INT(11) NOT NULL COMMENT 'FK ref stop'
, route_id INT(11) NOT NULL COMMENT 'FK ref route'
, UNIQUE_KEY stop_route_UX1 (stop_id, route_id)
, CONSTRAINT FK_stop_route_stop (stop_id) REFERENCES stop(id)
, CONSTRAINT FK_stop_route_route (route_id) REFERENCES route(id)
}