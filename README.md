# ☀️ Weather Application (Spring Boot)

## 📌 Project Overview
This **Weather Application** is built using **Java Spring Boot** to fetch and display real-time weather data for any searched city. It integrates with the **OpenWeatherMap API** to retrieve weather details dynamically and displays them on the frontend using **Thymeleaf** and **Tailwind CSS**.

---

## 🎯 Features
- 🌍 Search weather details by city name
- 📡 Fetches **real-time** weather data from OpenWeatherMap API
- 🏰 Uses **RestTemplate** for API calls
- 🎨 Dynamic frontend with **Thymeleaf**
- ⚡ Fast and lightweight (No database used)
- 🔑 API key is securely stored in **System Environment Variables**

---

## 🛠️ Tech Stack
- **Backend:** Java, Spring Boot, RestTemplate
- **Frontend:** Thymeleaf, HTML, CSS, Tailwind CSS
- **API:** OpenWeatherMap API

---

## 📝 Installation & Setup

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/Niketan2004/weather-application.git
cd weather-application
```

### 2️⃣ Get OpenWeatherMap API Key
1. Sign up on [OpenWeatherMap](https://openweathermap.org/)
2. Generate an API key

### 3️⃣ Store API Key in System Environment Variables
#### 💻 Windows:
```sh
setx WEATHER_API_KEY "your_api_key_here"
```

#### 💻 macOS/Linux:
```sh
export WEATHER_API_KEY="your_api_key_here"
```

### 4️⃣ Run the Application
```sh
mvn spring-boot:run
```

---

## 🖼️ Screenshots

**Dashboard**  
![Dashboard image](https://github.com/user-attachments/assets/63dbb288-7bde-40ee-836b-c8a7ac39c0b8)

**Weather Page**  
![Weather page](https://github.com/user-attachments/assets/7d23387e-6395-4bc5-b3aa-cc49e5678ee9)

**About**  
![About page](https://github.com/user-attachments/assets/c47958f2-c411-4fb3-a1ea-f8637eaa72bd)

---

## 📚 How It Works
1. **User enters a city name**
2. **Spring Boot makes an API call** to OpenWeatherMap using `RestTemplate`
3. **API key is securely fetched from system environment variables**
4. **API returns JSON data**, which is parsed into a Java POJO
5. **Only necessary weather attributes** are extracted and displayed using Thymeleaf
6. **The UI updates dynamically** based on the search input

---

## 🚀 Lessons Learned
- **Storing and accessing API keys securely using System Environment Variables**
- **Integrating external APIs in Spring Boot**
- **Using RestTemplate for API requests**
- **Parsing JSON data into Java objects (POJO)**
- **Building a Spring Boot project without a database**

---

## 🌟 Future Enhancements
- 🌍 Support for multiple weather APIs
- 🌑 Implement dark mode UI
- 📍 Use Geolocation API for automatic city detection
- 📊 Show additional weather details (humidity, wind speed, etc.)

---

## 🤝 Contributions
Pull requests are welcome! Feel free to **fork** the repo and submit changes.

---



