CREATE TEMPORARY TABLE bo_attribute_description_group_temp (SELECT id
                                                        FROM bo_attribute_description_group
                                                        WHERE display_name IN ('backoffice.attr.group.services', 'backoffice.attr.group.eyecatchergroup'));

select * from bo_attribute_description_group_temp;

CREATE TEMPORARY TABLE bo_attribute_description_temp (SELECT id
                                                  FROM bo_attribute_description
                                                  WHERE group_id IN (select id from bo_attribute_description_group_temp));