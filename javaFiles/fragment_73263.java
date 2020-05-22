CREATE OR REPLACE VIEW manager_location_all AS
 WITH RECURSIVE ancestor_descendant(ancestor_id, descendant_id) AS (
         SELECT root.upper_location_id, root.location_id
           FROM location root
         UNION ALL
         SELECT l.upper_location_id, ad.descendant_id
           FROM location l
           JOIN ancestor_descendant ad ON l.location_id = ad.ancestor_id
        )
 SELECT manager_location.manager_id, ancestor_descendant.descendant_id AS location_id
   FROM ancestor_descendant
   JOIN manager_location ON ancestor_descendant.ancestor_id = manager_location.location_id
  UNION ALL
 SELECT manager_location.manager_id, manager_location.location_id
   FROM manager_location;