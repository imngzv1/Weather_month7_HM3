package com.example.weather_month7.data.model

data class WeatherModel(
    val current: Current,
    val location: Location,
    val forecast: Forecast
) {
    data class Current(
        val cloud: Int,
        val condition: Condition,
        val feelslike_c: Double,
        val feelslike_f: Double,
        val gust_kph: Double,
        val gust_mph: Double,
        val humidity: Int,
        val is_day: Int,
        val last_updated: String,
        val last_updated_epoch: Int,
        val precip_in: Double,
        val precip_mm: Double,
        val pressure_in: Double,
        val pressure_mb: Double,
        val temp_c: Double,
        val temp_f: Double,
        val uv: Double,
        val vis_km: Double,
        val vis_miles: Double,
        val wind_degree: Int,
        val wind_dir: String,
        val wind_kph: Double,
        val wind_mph: Double
    ) {
        data class Condition(
            val code: Int,
            val icon: String,
            val text: String
        )
    }

    data class Location(
        val country: String,
        val lat: Double,
        val localtime: String,
        val localtime_epoch: Int,
        val lon: Double,
        val name: String,
        val region: String,
        val tz_id: String
    )
    data class Forecast(
        val forecastday: List<ForecastDay>
    ) {
        data class ForecastDay(
            val date: String,
            val date_epoch: Long,
            val day: Day,
            val astro: Astro,
            val hour: List<Hour>
        )

        data class Day(
            val maxtemp_c: Double,
            val maxtemp_f: Double,
            val mintemp_c: Double,
            val mintemp_f: Double,
            val avgtemp_c: Double,
            val avgtemp_f: Double,
            val maxwind_mph: Double,
            val maxwind_kph: Double,
            val totalprecip_mm: Double,
            val totalprecip_in: Double,
            val totalsnow_cm: Double,
            val avgvis_km: Double,
            val avgvis_miles: Double,
            val avghumidity: Int,
            val daily_will_it_rain: Int,
            val daily_chance_of_rain: Int,
            val daily_will_it_snow: Int,
            val daily_chance_of_snow: Int,
            val uv: Double
        )

        data class Astro(
            val sunrise: String,
            val sunset: String,
            val moonrise: String,
            val moonset: String,
            val moon_phase: String,
            val moon_illumination: Int,
            val is_moon_up: Int,
            val is_sun_up: Int
        )

        data class Hour(
            val time_epoch: Long,
            val time: String,
            val temp_c: Double,
            val temp_f: Double,
            val is_day: Int,
            val condition: Condition,
            val wind_mph: Double,
            val wind_kph: Double,
            val wind_degree: Int,
            val wind_dir: String,
            val pressure_mb: Double,
            val pressure_in: Double,
            val precip_mm: Double,
            val precip_in: Double,
            val snow_cm: Double,
            val humidity: Int,
            val cloud: Int,
            val feelslike_c: Double,
            val feelslike_f: Double,
            val windchill_c: Double,
            val windchill_f: Double,
            val heatindex_c: Double,
            val heatindex_f: Double,
            val dewpoint_c: Double,
            val dewpoint_f: Double,
            val will_it_rain: Int,
            val chance_of_rain: Int,
            val will_it_snow: Int,
            val chance_of_snow: Int,
            val vis_km: Double,
            val vis_miles: Double,
            val gust_mph: Double,
            val gust_kph: Double,
            val uv: Double
        ){
            data class Condition(
                val text: String,
            )
        }
    }
}


