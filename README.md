# Room API

This API is used for managing and booking various rooms within a facility.

## Endpoints

| Method | Path              | Status Code(s) | Description                                 |
|--------|-------------------|----------------|---------------------------------------------|
| GET    | `/api/rooms`      | 200            | Retrieves a list of all rooms.              |
| GET    | `/api/rooms/{id}` | 200 / 404      | Retrieves a specific room by its ID.        |
| POST   | `/api/rooms`      | 201            | Creates a new room.                         |
| PUT    | `/api/rooms/{id}` | 200 / 404      | Updates an existing room by its ID.         |
| DELETE | `/api/rooms/{id}` | 204 / 404      | Deletes an existing room by its ID.         |

## How to Run

1. Open a terminal in the project directory.
2. Run `./gradlew bootRun` (or `gradlew.bat bootRun` on Windows).
