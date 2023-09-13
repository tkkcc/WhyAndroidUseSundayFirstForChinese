package com.example.myapplication

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.time.temporal.WeekFields
import java.util.Calendar
import java.util.Date
import java.util.Locale


class WeekdayName(val locale: Locale) {

    fun dayInISO8601(day: Int): Int {
        val shiftedDay = (day + 6) % 7
        return if (shiftedDay == 0) return /* Sunday */ 7 else shiftedDay
    }

    val firstDayOfWeek: Int =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WeekFields.of(locale).firstDayOfWeek.value
        } else {
            dayInISO8601(Calendar.getInstance(locale).firstDayOfWeek)
        }
}

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Date()
        Log.d("", WeekdayName(Locale.CHINESE).firstDayOfWeek.toString())
        Log.d("", WeekdayName(Locale.CHINA).firstDayOfWeek.toString())
        Log.d("", WeekdayName(Locale.FRANCE).firstDayOfWeek.toString())
        Log.d("", WeekdayName(Locale.ENGLISH).firstDayOfWeek.toString())

        setContent {
            MyApplicationTheme {
                Surface {
                    DatePicker(state = rememberDatePickerState())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}