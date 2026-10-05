# Room API

This API is used for managing and booking various rooms within a facility.

## Endpoints

| Method | Path              | Status Code(s) | Description                                                                 |
|--------|-------------------|----------------|-----------------------------------------------------------------------------|
| GET    | `/api/rooms`      | 200            | Retrieves a list of all rooms. Accepts `minCapacity` and `keyword` filters. |
| GET    | `/api/rooms/{id}` | 200 / 404      | Retrieves a specific room by its ID.                                        |
| POST   | `/api/rooms`      | 201 / 400      | Creates a new room. 400 if capacity is not between 1 and 20.                |
| PUT    | `/api/rooms/{id}` | 200 / 400 / 404| Updates an existing room. 400 if capacity is not between 1 and 20.          |
| DELETE | `/api/rooms/{id}` | 204 / 404      | Deletes an existing room by its ID.                                         |

## Database

The application uses an in-memory H2 database. There are two tables: `room` and `reservation`. The `reservation` table has a many-to-one relationship with the `room` table, linked by the `room_id` foreign key.

**H2 Console**
- **URL:** http://localhost:8080/h2-console
- **JDBC URL:** jdbc:h2:mem:testdb
- **User Name:** sa
- **Password:** *(leave blank)*

## Environment and Execution

- **JDK Version:** Java 25
- **Run Command:** `./gradlew bootRun` (or `gradlew.bat bootRun` on Windows)

## AI Usage

Code refactored to three layers, validation rules implemented, and Swagger UI configured with assistance from Gemini. H2 configuration and queries written with assistance from Gemini.
