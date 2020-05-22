CREATE TABLE Tree (
    id int NOT NULL,
    parent_id int NULL,
    name nvarchar(50) NOT NULL,
    start_date_time datetime NOT NULL,
    end_date_time datetime NULL
);

GO

CREATE UNIQUE NONCLUSTERED INDEX UN_Tree_id_end_date_time
ON Tree (id, end_date_time)
WHERE end_date_time IS NULL;

INSERT INTO Tree (
    id,
    parent_id,
    name,
    start_date_time,
    end_date_time
)
VALUES
    (1, NULL, 'A', GETDATE(), NULL), -- node A created
    (2, NULL, 'B', GETDATE(), NULL), -- node B created
    (3, 1, 'A.1', GETDATE(), NULL), -- node A.1 created
    (4, 2, 'A.1.1', GETDATE(), NULL); -- node A.1.1 added

-- Node A.1 renamed
UPDATE Tree
SET end_date_time = GETDATE()
WHERE id = 3 AND end_date_time IS NULL;

INSERT INTO Tree VALUES (3, 1, 'A.1_renamed', GETDATE(), NULL);

-- Node A.1.1 removed a day after
UPDATE Tree
SET end_date_time = DATEADD(d, 1, GETDATE())
WHERE id = 4 AND end_date_time IS NULL;


-- Query nodes from root A as of now using a recursive CTE
-- Note: Did not manage to declare a @asOf variable variable in SQL Fiddle
WITH data AS (
    SELECT id, parent_id, name
    FROM Tree
    WHERE 
        id = 1
        AND start_date_time <= GETDATE() 
        AND (end_date_time IS NULL OR end_date_time > GETDATE())

    UNION ALL

    SELECT child.id, child.parent_id, child.name
    FROM data d
    INNER JOIN Tree child
        ON 
            child.parent_id = d.id
            AND start_date_time <= GETDATE() 
            AND (end_date_time IS NULL OR end_date_time > GETDATE())
)   
SELECT *
FROM data;