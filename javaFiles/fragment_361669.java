CREATE TABLE time_slot(
  id int primary key, 
  num_reservations int
);

CREATE TABLE reservation(
  time_slot_id int, 
  created_timestamp timestamp,
  CONSTRAINT time_slot_fk FOREIGN KEY (time_slot_id)
     REFERENCES time_slot( id )
);

INSERT INTO time_slot values( 1, 0 );
INSERT INTO time_slot values( 2, 0 );