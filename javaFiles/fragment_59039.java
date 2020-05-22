{
    "subject": "Test event",
    "start": {
        "dateTime": "2017-12-01T09:00:00",
        "timeZone": "SA Western Standard Time"
    },
    "end": {
        "dateTime": "2017-12-01T10:00:00",
        "timeZone": "SA Western Standard Time"
    },
    "body": {
        "contentType": "TEXT",
        "content": "This is a test"
    },
    "attendees": [{
        "emailAddress": {
            "address": "someuser@somewhere.com",
            "name": "someuser"
        }
    }],
    "recurrence": {
        "pattern": {
            "type": "daily",
            "interval": 1
        },
        "range": {
            "type": "endDate",
            "startDate": "2017-12-01",
            "endDate": "2017-12-01"
        }
    }
}