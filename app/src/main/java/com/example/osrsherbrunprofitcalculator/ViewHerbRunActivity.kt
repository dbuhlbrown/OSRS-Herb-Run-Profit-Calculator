package com.example.osrsherbrunprofitcalculator
//This allows us to view the herb run data, and if we choose to,
//edit all of this data.
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ViewHerbRunActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_herb_run)
    }
}