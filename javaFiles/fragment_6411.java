drop index my_regex_index;

alter table my_table add my_regexp_column generated always
  as (upper(regexp_replace(my_column, '[[:punct:]]')));

create index my_regex_index on my_table (my_regexp_column);