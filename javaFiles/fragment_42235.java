#################################################
# Stdin -> Logstash -> Elastic Search pipeline.
#################################################
input {
    stdin{}
    tcp{
        host => "localhost"
        port => 9600
        codec => json
    }
}

filter 
{
   mutate 
    {
        remove_field => ["host", "@version", "@timestamp", "port", "tags", "level", "logger_name", "themessage", "mensage", "spring.application.name", "level_value", "thread_name"]
    }
}

output {
    stdout{ codec => rubydebug }

     elasticsearch{
        hosts => ["localhost:9200"]
        index => ["my-index"]
     }
}