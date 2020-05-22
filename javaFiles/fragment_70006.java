create table treemodel (
 `node` int not null 
 , `parent` int not null 
 , `principal` int not null 
 , `state` smallint unsigned not null 
 , ...
 , `supersedes` int    /*version instead of lossy update or delete*/
 , `supersededby` int
) engine = innodb;
alter table treemodel add primary key (`principal`, `node`) using btree;