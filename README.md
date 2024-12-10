This project runs on Java Spring Boot.
The server can be started by running TbaApplication and runs on localhost:8080

The API takes requests with a JSON body such as
{
    "registration": "AB12 XYZ",
    "haulier": "Shipping Co.",
    "tare": 123,
    "gross": 456,
    "nett": 789
}
