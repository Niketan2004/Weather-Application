# 🌦️ Weather Application (Spring Boot)

## 📌 Project Overview
This is a **Weather Application** built using **Java Spring Boot** that fetches real-time weather data for any searched city. The application integrates with the **OpenWeatherMap API** to retrieve weather information and displays it dynamically on the frontend using **Thymeleaf**.

---

## 🎯 Features
- 🌍 Search weather details by city name
- 📡 Fetches **real-time** weather data from OpenWeatherMap API
- 🏗️ Uses **RestTemplate** for API calls
- 🎨 Dynamic frontend using **Thymeleaf**
- ⚡ Fast and lightweight (No database used)

---

## 🛠️ Tech Stack
- **Backend:** Java, Spring Boot, RestTemplate
- **Frontend:** Thymeleaf, HTML, CSS
- **API:** OpenWeatherMap API

---

## 📥 Installation & Setup
### 1️⃣ Clone the Repository
```sh
git clone https://github.com/Niketan2004/weather-application.git
cd weather-application
```

### 2️⃣ Get OpenWeatherMap API Key
1. Sign up on [OpenWeatherMap](https://openweathermap.org/)
2. Generate an API key

### 3️⃣ Configure API Key
- Open `application.properties` file and add your API key:
```properties
weather.api.key=your_api_key_here

```

### 4️⃣ Run the Application
```sh
mvn spring-boot:run
```

---

## 📸 Screenshots
**Dashboard**
![Dashboard image](https://github.com/user-attachments/assets/34a5b81b-429d-4244-bad9-02ba33c33c72)

**Weather Page**
![Weather page](https://github.com/user-attachments/assets/6b6155d9-90ed-4978-a565-6cb5def124fb)

**About**
![About page](https://github.com/user-attachments/assets/9457ee18-4112-4a9c-b998-d4e573210cde)

---

## 📚 How It Works
1. **User enters a city name**
2. **Spring Boot makes an API call** to OpenWeatherMap using `RestTemplate`
3. **API returns JSON data**, which is parsed into a Java POJO
4. **Only necessary weather attributes** are extracted and displayed using Thymeleaf
5. **The UI updates dynamically** based on the search input

---

## 🚀 Lessons Learned
- **Integrating external APIs in Spring Boot**
- **Using RestTemplate for API requests**
- **Parsing JSON data into Java objects (POJO)**
- **Handling dynamic data with Thymeleaf**
- **Building a Spring Boot project without a database**

---

## 📌 Future Improvements
- 🌍 Add support for multiple weather APIs
- 🕶️ Implement dark mode UI
- 📍 Use Geolocation API for automatic city detection
- 📊 Show more weather details (humidity, wind speed, etc.)

---

## 🤝 Contributing
Pull requests are welcome! Feel free to **fork** the repo and submit changes.

---


