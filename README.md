
# 🌤 Weather API Service

This Spring Boot project exposes a RESTful API to retrieve weather information by city name. The application serves as a proxy layer to simulate access to weather data and applies custom logic before returning the results.

## 🚀 Features

- Fetch weather details by city name
- Input validation for city names
- Error handling for missing data and invalid input
- Swagger integration for API documentation
- H2 in-memory database for testing
- API key protection

## 📍 Endpoint

- **Base URL**: `http://localhost:8081/api/weather`
- **GET** `/api/weather/{city}`  
  Returns weather information for a given city.

### 🔍 Example Response
```json
{
  "city": "Bogotá",
  "condition": "Cloudy",
  "wind": {
    "speed": 12.5,
    "unit": "km/h"
  },
  "temperature": {
    "value": 19.3,
    "unit": "C"
  }
}
```

## ✅ HTTP Status Codes

| Status | Description                      |
|--------|----------------------------------|
| 200    | Information found                |
| 204    | No information found for the city |
| 400    | City name is not valid           |
| 500    | Internal server error            |

## 🧪 Swagger Documentation

- URL: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

## 🗃 Database Access

This project uses an H2 in-memory database. You can access the console here:

- **H2 Console**: [http://localhost:8081/h2-console](http://localhost:8081/h2-console)

**Credentials**:

- **User**: `admin`  
- **Password**: `123456`

## 📦 How to Run

Make sure you have Java 17+ and Maven installed.

```bash
mvn spring-boot:run
```

## 📁 Project Structure

```
├── controller
│   └── WeatherController.java
├── domain
│   └── WeatherDTO.java
├── service
│   └── WeatherService.java
├── persistence
│   └── WeatherEntity.java
├── util
│   ├── exceptions
│   │   └── NoDataFountException.java
│   └── security
│       └── ApiKeyFilter.java (optional)
```

## 🛡 API Key Protection

If `ApiKeyFilter` is active, include the following header in your requests:

```
X-API-KEY: your-api-key
```

## 📬 Contact

For questions or feedback, open an issue or contact the maintainer.

---

## 📂 Notes

You can find additional files in the resources/files directory:

✅ A PDF with the answers to the design and Java-related questions

✅ A Postman collection to test the service

---