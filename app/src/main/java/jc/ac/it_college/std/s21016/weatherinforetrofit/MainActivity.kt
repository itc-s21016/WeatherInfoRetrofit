package jc.ac.it_college.std.s21016.weatherinforetrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import androidx.annotation.UiThread
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import jc.ac.it_college.std.s21016.weatherinforetrofit.databinding.ActivityMainBinding
import jc.ac.it_college.std.s21016.weatherinforetrofit.json.City

private const val BASE_URL = "https://api.openweathermap.org/"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private var cityList: List<City>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCityList()

        initListViewEvent()
    }

    private fun initCityList() {
        val jsonStr = resources.assets.open("cities_list.json").reader().readText()

        val type = Types.newParameterizedType(List::class.java, City::class.java)
        val adapter: JsonAdapter<List<City>> = moshi.adapter(type)
        cityList = adapter.fromJson(jsonStr)

        val nameList = cityList?.map { mapOf("name" to it.name) }

        binding.cityListView.adapter = SimpleAdapter(
            this@MainActivity, nameList,
            android.R.layout.simple_list_item_1,
            arrayOf("name"), intArrayOf(android.R.id.text1)
        )
    }

    private fun initListViewEvent() {
        binding.cityListView.setOnItemClickListener{ _, _, position, _ ->
            cityList?.let { list ->
                getWeatherInfo(list[position].q)
            }
        }
    }

    @UiThread
    private fun getWeatherInfo(city: String) {

    }
}