POST /api/foo HTTP/1.1
Host: example.org
Content-Type: application/json

{
  "name": "AZ",
  "adress": "US",
  "content": {
    "clients": [
      {
        "client_ref": "213",
        "commands": {
          "subCommands": [...]
        }
      },
      {
        "client_ref": "213",
        "commands": {
          "subCommands": [...]
        }
      }
    ]
  }
}