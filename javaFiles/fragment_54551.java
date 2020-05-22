POST http://localhost:3000/api/session

{
    "environment": "prod",
    "sessionLabel": "Run smoke tests",
    "tests": [
        {
            "path": ".",
            "name": "Smoke test 1"
        },
        {
            "path": ".",
            "name": "Web test 2"
        }
    ]
}