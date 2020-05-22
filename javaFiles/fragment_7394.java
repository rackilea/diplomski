SELECT {c.pk}
FROM { CustomerReview c LEFT JOIN
     LikeReview l
     ON {c.pk} = {l.customerReview} }
WHERE {c.product} = ?product AND
      {c.LANGUAGE} = ?language
GROUP BY {c.pk}
ORDER BY SUM(CASE WHEN {l.ISLIKE} = "true" THEN 1 ELSE 0 END) DESC