;WITH cte AS 
(
    SELECT *
    FROM dbo.docStatus
    WHERE docId = N'abc'
)
MERGE cte t
USING (
    SELECT docId = N'abc'
) s ON s.docId = t.docId
WHEN MATCHED
    THEN
        UPDATE SET t.[count] += 1
WHEN NOT MATCHED BY TARGET
    THEN
        INSERT (docId, [count])
        VALUES (s.docId, 1);