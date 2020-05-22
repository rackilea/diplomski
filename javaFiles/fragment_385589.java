String query =   "SELECT overallRating, count(*) as Total, g.name "
                        +"FROM gameSurvey gs, game g "
                        +"WHERE g.id = gs.gameID AND "
                        +"date BETWEEN (NOW() - INTERVAL 7 DAY) AND NOW() "
                        +"GROUP by overallRating "
                        +"ORDER by Total desc";