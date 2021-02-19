package com.example.osrsherbrunprofitcalculator
//This activity will display all valid herb runs that were returned by the search results
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ShowSearchResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_search_results)
    }
}