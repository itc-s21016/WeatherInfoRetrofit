package jc.ac.it_college.std.s21016.weatherinforetrofit.json

import com.squareup.moshi.JsonClass


@JsonClass( generateAdapter = true)
data class City(
    val name: String,
    val q: String,
)
