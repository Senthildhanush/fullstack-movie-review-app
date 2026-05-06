# 🎬 MovieVerse — Full Stack Movie Review App

A full-stack movie review application built with **React** on the frontend and **Spring Boot + MongoDB** on the backend. Users can browse movies, write reviews, manage a personal watchlist, and search for films — all secured with JWT-based authentication.

---

## 🚀 Features

- **User Registration & Login** — Secure sign-up and authentication with JWT token generation
- **JWT Authentication** — Tokens stored in the frontend and sent with every protected request
- **Browse Movies** — Public endpoint displays movies to all visitors without login
- **Write & Read Reviews** — Authenticated users can post reviews and read others' on any movie
- **Personal Watchlist** — Add movies to your watchlist; only your watchlist is visible to you (protected endpoint)
- **Search** — Search across the movie catalog by title or other attributes

---

## 🛠️ Tech Stack

### Backend
| Technology | Purpose |
|---|---|
| Java Spring Boot | Core backend framework |
| Spring MVC | REST API layer |
| Spring Security + JWT | Authentication & authorization |
| MongoDB | NoSQL database |
| Postman | API testing |

### Frontend
| Technology | Purpose |
|---|---|
| React | UI framework |
| Axios / Fetch API | HTTP requests to backend |
| React Router | Client-side routing |
| Local Storage / State | JWT token management |

---

## 🔐 Authentication Flow

```
User registers → credentials stored in MongoDB
User logs in   → JWT token generated & returned
Frontend stores token → attached to every protected API call
Backend validates token → grants or denies access
```

---

## 📡 API Endpoints Overview

### Public Endpoints (No Auth Required)
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/v1/auth/register` | Register a new user |
| `POST` | `/api/v1/auth/login` | Login and receive JWT token |
| `GET` | `/api/v1/movies` | Get all movies |
| `GET` | `/api/v1/movies/{id}` | Get a single movie |
| `GET` | `/api/v1/movies/search?query=` | Search movies |
| `GET` | `/api/v1/reviews/{movieId}` | Read reviews for a movie |

### Protected Endpoints (JWT Required)
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/v1/reviews` | Write a review |
| `GET` | `/api/v1/watchlist` | Get user's watchlist |
| `POST` | `/api/v1/watchlist/{movieId}` | Add movie to watchlist |
| `DELETE` | `/api/v1/watchlist/{movieId}` | Remove from watchlist |

---

## 📁 Project Structure

```
movie-review-app/
├── backend/
│   ├── src/main/java/com/movieverse/
│   │   ├── controller/        # Spring MVC REST controllers
│   │   ├── service/           # Business logic
│   │   ├── repository/        # MongoDB repositories
│   │   ├── model/             # Entity classes (Movie, Review, User)
│   │   ├── security/          # JWT filter, config, utils
│   │   └── MovieVerseApplication.java
│   ├── src/main/resources/
│   │   └── application.properties
│   └── pom.xml
│
└── frontend/
    ├── public/
    └── src/
        ├── components/        # Reusable UI components
        ├── pages/             # Home, Login, Register, Watchlist
        ├── api/               # Axios instance with JWT interceptor
        ├── context/           # Auth context / state
        └── App.jsx
```

---

## ⚙️ Getting Started

### Prerequisites
- Java 17+
- Node.js 18+
- MongoDB (local or Atlas)
- Maven

### Backend Setup

```bash
# Clone the repo
git clone https://github.com/your-username/movie-review-app.git
cd movie-review-app/backend

# Configure MongoDB URI and JWT secret in application.properties
# spring.data.mongodb.uri=mongodb://localhost:27017/movieverse
# jwt.secret=your_secret_key

# Run the application
mvn spring-boot:run
```

### Frontend Setup

```bash
cd ../frontend

# Install dependencies
npm install

# Start the development server
npm start
```

The app will be available at `http://localhost:3000` with the backend running at `http://localhost:8080`.

---

## 🧪 API Testing

All endpoints were tested using **Postman**. To test protected endpoints:

1. Register or login via `/api/v1/auth/login`
2. Copy the JWT token from the response
3. Add it to the request header: `Authorization: Bearer <token>`

---

## 📸 Pages Overview

| Page | Access | Description |
|------|--------|-------------|
| Home | Public | Displays all movies fetched from the public API |
| Movie Detail | Public | Shows movie info and user reviews |
| Login / Register | Public | Auth forms |
| Watchlist | Protected | Displays movies added by the logged-in user |
| Search Results | Public | Filtered movie results |

---

## 🔮 Future Improvements

- [ ] Movie ratings (1–5 stars)
- [ ] Admin panel to add/edit movies
- [ ] Email verification on registration
- [ ] Pagination for movie listings
- [ ] Deployment (AWS / Railway / Vercel)

---

## 👨‍💻 Author
VALARMATHI S
- LinkedIn: https://www.linkedin.com/in/valarmathi-s-574484245
---

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
