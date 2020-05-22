UPDATE A
SET    GuestCode = 'gc',
       FirstName = B.FirstName,
       LastName = B.LastName,
       Country = Country,
       State = B.State,
       City = B.City,
       ContactNo = B.contactNO
FROM   ROOM A
       JOIN GuestDetails B
         ON b.GuestCode = 'gc'
WHERE  RoomNo = 'rn';