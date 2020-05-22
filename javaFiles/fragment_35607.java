SELECT lvl.lowerLevel AS "from", lvl.upperLevel AS "to"
     , lvl.levelDesc AS "level", COUNT(*) AS "students"
  FROM StudentTable s
  JOIN LevelsTable lvl ON lvl.levelType = 'pushUps'
                      AND lvl.lowerLevel <= s.pushUps
                      AND (lvl.upperLevel > s.pushUps OR lvl.upperLevel
 GROUP BY lvl.lowerLevel, lvl.upperLevel, lvl.levelDesc
 ORDER BY lvl.lowerLevel;