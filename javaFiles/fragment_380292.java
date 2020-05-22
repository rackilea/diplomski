UPDATE SearchedWords 
    SET NrOfSearches = NrOfSearches + 1 
    WHERE EXISTS (SELECT 1
                  FROM Dictionary d
                  WHERE d.ID = SearchedWords.WordID AND
                        d.Word = ?
                 ) AND
          UserID = ?;