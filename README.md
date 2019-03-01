# Oyster
This is a basic spring boot (https://spring.io/projects/spring-boot) rest api application.

Start the app with the `bootRun` command.
Test it at `http://localhost:8080/greeting`

## Task 1
Solve at home. Make a pull request against this repo.

The data sources are preloaded into the in memory database in [`src/main/resources/data.sql`](src/main/resources/data.sql)

The new feature is to implement `GET`business card information.
The requirements are to print business cards for `persons`
- That does **not** have the occupation of being a student
- That works in `Gothenburg`

A business card should contain their full name, occupation and name of company.

Add an API call to `/businesscards` that should return
```json
 [
  {
    "id": 2,
    "name": "Severus Snape",
    "occupation": "Teacher",
    "company": "Abilia"
  },
  {
    "id": 5,
    "name": "Albus Dumbledore",
    "occupation": "Principal",
    "company": "Abilia"
  }
]
```

## Task 2
We solve together.

There will be changed and/or added requirements.
