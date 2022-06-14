package viet.hoang.automationproject.models
import com.google.gson.annotations.SerializedName
import java.util.*

data class ResultHistory (
    var date : Date,
    @SerializedName("nsx") // Update to new value
    var nsx : String,
    @SerializedName("hsd")// Update to new value
    var hsd : String,
)
