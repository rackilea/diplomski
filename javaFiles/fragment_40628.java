import com.google.cloud.bigquery.JobStatistics.QueryStatistics;

...

QueryStatistics js = queryJob.getStatistics();

System.out.println(js.getCacheHit());