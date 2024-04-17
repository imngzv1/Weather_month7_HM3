import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_month7.R
import com.example.weather_month7.data.model.WeatherModel
import com.example.weather_month7.databinding.ItemHourlyDataBinding

class AdapterHours(private var listOfHours: List<WeatherModel.Forecast.Hour>) :
    RecyclerView.Adapter<AdapterHours.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<WeatherModel.Forecast.Hour>) {
        listOfHours = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHourlyDataBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hour = listOfHours[position]
        holder.bind(hour)
    }

    override fun getItemCount(): Int {
        return listOfHours.size
    }

    inner class ViewHolder(private val binding: ItemHourlyDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hour: WeatherModel.Forecast.Hour) {
            val timeParts = hour.time.split(" ")
            binding.hourTime.text = timeParts[1]
            binding.hourTime2.text=hour.temp_c.toString()+"°C"
            val conditionText=hour.condition.text
            val isCloudy=conditionText.contains("Cloudy",ignoreCase = true)
            val image=if (isCloudy){
                R.drawable.cloudy
            }else{
                R.drawable.sunny
            }
            binding.hourImage.setImageResource(image)
        }
    }
}
