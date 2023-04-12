package jc.ac.it_college.std.s21016.weatherinforetrofit.service

import jc.ac.it_college.std.s21016.weatherinforetrofit.BuildConfig
import jc.ac.it_college.std.s21016.weatherinforetrofit.json.WeatherInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("data/2.5/weather/")
    fun fetchWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String = BuildConfig.OPENWEATHER_API_KEY,
        @Query("lang") lang: String = "ja",
    ): Call<WeatherInfo>
}