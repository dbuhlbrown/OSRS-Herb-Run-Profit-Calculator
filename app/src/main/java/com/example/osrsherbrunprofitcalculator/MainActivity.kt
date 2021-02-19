package com.example.osrsherbrunprofitcalculator
//shows all herb runs and allows us to handle the user interactions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.coroutines.launch
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class HerbRunViewModel: ViewModel(){

}
class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerAdapter
    private lateinit var herbDAO: HerbRunDAO
    private lateinit var herbRuns: List<HerbRun>
    private lateinit var herbRunViewModel: HerbRunViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);

        val db = Room.databaseBuilder(
            applicationContext,
            HerbRunDatabase::class.java, "herb_runs"
        ).build()


        this.herbDAO = db.herbDao()
        this.herbRuns = ArrayList<HerbRun>();

        var getHerbRunsJob = GlobalScope.launch {

            getHerbRuns();
            Log.i("done running","getHerbRuns");

        }

        getHerbRunsJob.invokeOnCompletion { setupRecyclerView() }

        Log.i("herbRuns Object = ",this.herbRuns.toString());


    }

    fun setupRecyclerView( ){

        Log.i("herbRuns Object inside setupRecyclerView = ",this.herbRuns.toString());
        linearLayoutManager = LinearLayoutManager(this);
        herbRunRecyclerView.layoutManager = linearLayoutManager;

        adapter = RecyclerAdapter(this.herbRuns as ArrayList<HerbRun>,this) {item->onHerbRunClicked(item as HerbRun)}

        herbRunRecyclerView.adapter = adapter;


    }

    fun onHerbRunClicked( item:HerbRun ){

        Log.i("herbRun",item.herb_type);
    }
    //this function will get all of our herb runs from the database
    fun getHerbRuns(): Boolean {
        Log.i("inside getHerbRuns", "Now");
        this.herbRuns = herbDAO.getHerbRuns()

        return true
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.top_bar_menu,menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.search){

            //add the search code here
            //this will be a second activity since our search is complicated.
            val searchIntent = Intent(this, SearchActivity::class.java)
            startActivity(searchIntent);

        }

        if(item.itemId == R.id.new_run){

            val newRunIntent = Intent(this, AddNewRunActivity::class.java)
            startActivity(newRunIntent);
        }



        return true;
    }
}