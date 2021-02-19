package com.example.osrsherbrunprofitcalculator
//this activity allows us to enter the data for a new herb run
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/*Still not done, but getting there.
* I need to add an entry for the herb price. Then store it properly.
* After that, I need to test that the data is actually saving. Not
* positive how best to do that.*/
class AddNewRunActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var saveHerbRunButton : Button
    lateinit var herbTypeSpinner : Spinner
    lateinit var attasSeedCheckBox : CheckBox
    lateinit var bottomlessCompostBucketCheckBox : CheckBox
    lateinit var magicSecateursCheckBox : CheckBox
    lateinit var farmingCapeCheckBox : CheckBox
    lateinit var totalHerbsEditTextNumber : EditText
    lateinit var herbDao : HerbRunDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_new_run)

        saveHerbRunButton = findViewById(R.id.saveHerbRunButton);
        saveHerbRunButton.setOnClickListener(this)

        herbTypeSpinner = findViewById(R.id.herbTypeSpinner);

        var herbTypesArray = arrayOf("Guam","Marrentil");

        var herbTypesArrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,herbTypesArray);
        herbTypeSpinner.adapter = herbTypesArrayAdapter

        attasSeedCheckBox = findViewById(R.id.attasSeedCheckBox);
        bottomlessCompostBucketCheckBox = findViewById(R.id.bottomlessCompostBucketCheckBox);
        magicSecateursCheckBox = findViewById(R.id.magicSecateursCheckBox);
        farmingCapeCheckBox = findViewById(R.id.farmingCapeCheckBox);

        totalHerbsEditTextNumber = findViewById(R.id.totalHerbsEditTextNumber);
    }

    override fun onClick(v: View?) {

        when(v?.id){

            R.id.saveHerbRunButton->{
                handleSaveHerbRunButtonClick()
            }

        }
    }

    private fun handleSaveHerbRunButtonClick(){

        Log.i("addnewrunactivity","inside saveHerbRunButtonClick")

        val db = Room.databaseBuilder(
            applicationContext,
            HerbRunDatabase::class.java, "herb_runs"
        ).build()

        this.herbDao = db.herbDao();

        GlobalScope.launch{

            createHerbRun()
        }
    }

    private fun createHerbRunTags() : String {

        var herbRunTags = ""

        if( attasSeedCheckBox.isChecked){

            herbRunTags += "Attas,"

        }

        if(bottomlessCompostBucketCheckBox.isChecked){

            herbRunTags += "Bottomless Compost Bucket,"
        }

        if(magicSecateursCheckBox.isChecked){

            herbRunTags += "Magic Secateurs,"

        }

        if(farmingCapeCheckBox.isChecked){

            herbRunTags += "Farming Cape"
        }

        return herbRunTags
    }

    private fun createHerbRun( ) {
        var herbRun = HerbRun(0, herbTypeSpinner.selectedItem as String,herb_price = 100, createHerbRunTags(), totalHerbsEditTextNumber.text.toString().toInt());

        var id = this.herbDao.insert(herbRun);
        Log.i("new insert id = ", id.toString());
    }



}