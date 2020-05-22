public class SeasonChecker
{
    public enum Season {Summer, Autumn, Winter, Spring};
    private List<SeasonRange> _seasons = new List<SeasonRange>();

    public void DefineSeason(Season season, DateTime starting, DateTime ending)
    {
        starting = starting.Date;
        ending = ending.Date;

        if(ending.Month < starting.Month)
        {
            // split into 2
            DateTime tmp_ending = new DateTime(ending.Year, 12, 31);
            DateTime tmp_starting = new DateTime(starting.Year, 1, 1);

            SeasonRange r1 = new SeasonRange() { Season = season, Starting= tmp_starting, Ending = ending };
            SeasonRange r2 = new SeasonRange() { Season = season, Starting= starting, Ending = tmp_ending };

            this._seasons.Add(r1);
            this._seasons.Add(r2);
        }
        else
        {
            SeasonRange r1 = new SeasonRange() { Season = season, Starting= starting, Ending = ending };
            this._seasons.Add(r1);
        }
    }

    public Season GetSeason(DateTime check)
    {
        foreach(SeasonRange range in _seasons)
        {
            if(range.InRange(check))
                return range.Season;
        }

        throw new ArgumentOutOfRangeException("Does not fall into any season");
    }


    private class SeasonRange
    {
        public DateTime Starting;
        public DateTime Ending;
        public Season Season;

        public bool InRange(DateTime test)
        {
            if(test.Month == Starting.Month)
            {
                if(test.Day >= Starting.Day)
                {
                    return true;
                }
            }
            else if(test.Month == Ending.Month)
            {
                if(test.Day <= Ending.Day)
                {
                    return true;
                }
            }
            else if(test.Month > Starting.Month && test.Month < Ending.Month)
            {
                return true;
            }

            return false;
        }

    }
}