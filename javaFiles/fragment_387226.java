SELECT * FROM (
            SELECT s.*, @rank
            := @rank + 1 rank
            FROM
            quiz.score s, (SELECT @rank := 0) init
            ORDER BY points DESC
            ) s
            WHERE rank BETWEEN '(select count(id) from score)-(10)' AND '(select count(id) from score)'
            ORDER BY rank;