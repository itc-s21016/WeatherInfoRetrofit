package jc.ac.it_college.std.s21016.weatherinforetrofit.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherInfo(
    val coord: Coord,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: Int,
    val wind: Wind,
    val clouds: All,
    val dt: Int,
    val sys: Sys,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int,
)

@JsonClass(generateAdapter = true)
data class Coord(
    val lon: Double,
    val lat: Double,
)

@JsonClass(generateAdapter = true)
data class Weather(
    val id: Int,
    val main: String,
    val descripton: String,
    val icon: String,
)

@JsonClass(generateAdapter = true)
data class Main(
    val temp: Double,
    @Json(name = "feels_like") val feelsLike: Double,
    @Json(name = "temp_min") val tempMin: Double,
    @Json(name = "temp_max") val tempMax: Double,
    val pressure: Int,
    val humidity: Int,
)

@JsonClass(generateAdapter = true)
data class Wind(
    val speed: Double,
    val deg: Int,
)

@JsonClass(generateAdapter = true)
data class All(
    val all: Int,
)

@JsonClass(generateAdapter = true)
data class Sys(
    val type: Int,
    val id: Int,
    val sumrise: Int,
    val sumset: Int,
)