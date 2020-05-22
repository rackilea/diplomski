SELECT s.idS, s.firstName, s.famillyName
     , s.age, a.levelDesc AS ageLevel
     , s.pushUps, p.levelDesc AS pushUpLevel
  FROM StudentTable s
  JOIN LevelsTable a ON a.levelType = 'age'
                    AND a.lowerLevel <= s.age
                    AND (a.upperLevel > s.age OR a.upperLevel IS NULL)
  JOIN LevelsTable p ON p.levelType = 'pushUps'
                    AND p.lowerLevel <= s.pushUps
                    AND (p.upperLevel > s.pushUps OR p.upperLevel IS NULL)
 ORDER BY s.idS;