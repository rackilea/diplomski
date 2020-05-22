# HELP http_server_requests_seconds  
# TYPE http_server_requests_seconds summary
http_server_requests_seconds_count{exception="None",method="GET",status="200",uri="/prometheus",} 1.0
http_server_requests_seconds_sum{exception="None",method="GET",status="200",uri="/prometheus",} 0.062559545
http_server_requests_seconds_count{exception="None",method="GET",status="200",uri="/hello/{name}",} 1.0
http_server_requests_seconds_sum{exception="None",method="GET",status="200",uri="/hello/{name}",} 0.02323862
http_server_requests_seconds_count{exception="None",method="GET",status="200",uri="UNKNOWN",} 1.0
http_server_requests_seconds_sum{exception="None",method="GET",status="200",uri="UNKNOWN",} 0.050339909
# HELP http_server_requests_seconds_max  
# TYPE http_server_requests_seconds_max gauge
http_server_requests_seconds_max{exception="None",method="GET",status="200",uri="/prometheus",} 0.062559545
http_server_requests_seconds_max{exception="None",method="GET",status="200",uri="/hello/{name}",} 0.02323862
http_server_requests_seconds_max{exception="None",method="GET",status="200",uri="UNKNOWN",} 0.050339909