curl -X POST -i -H "Content-type: application/json" -c cookies.txt -X POST http://hostname:8080/service -d '
    {
        "field":"value",
        "field2":"value2"
    }
    '