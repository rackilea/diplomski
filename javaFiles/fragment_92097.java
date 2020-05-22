select u.userid as User, 'Rugby' as TeamType, t.team_name as Team
from Users u
inner join RugbyTeam t on u.userid = t.userid

union all

select u.userid as User, 'Football' as TeamType, t.team_name as Team
from Users u
inner join FootballTeam t on u.userid = t.userid

union all

select u.userid as User, 'Rugby' as TeamType, t.team_name as Team
from Users u
inner join CricketTeam t on u.userid = t.userid

order by User;