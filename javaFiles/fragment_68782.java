CREATE TABLE `a` ( 
   `id` int(11) primary key AUTO_INCREMENT, 
   `a_field` int(11) 
);
CREATE TABLE `b` ( 
   `id` int(11) primary key AUTO_INCREMENT, 
   `a_id` int(11), 
   `b_field` int(11),
   CONSTRAINT `b_fk_aid` FOREIGN KEY (`a_id`) REFERENCES `a` (`id`)
);
CREATE TABLE `c` ( 
   `id` int(11) primary key AUTO_INCREMENT, 
   `a_id` int(11), 
   `c_field` int(11),
   CONSTRAINT `c_fk_aid` FOREIGN KEY (`a_id`) REFERENCES `a` (`id`)
);

insert into a( a_field ) values ( 10 ), ( 20 );
insert into b( a_id, b_field ) values ( 1, 20 ), ( 2, 30 );

delimiter $$
create procedure test( p_a_id int, p_count int )
begin
   declare i int;
   set i = 0;
   REPEAT
      START TRANSACTION;
      INSERT INTO c( a_id, c_field ) values ( p_a_id, round(rand() * 100) );
      UPDATE a
         SET  a_field = (
                   SELECT sum(b_field) 
                   FROM b WHERE b.a_id = a.id 
                   FOR UPDATE)
         WHERE 
                id = p_a_id;
       commit; 
       set i = i + 1;
   until i > p_count 
   end repeat;
end $$
DELIMITER ;