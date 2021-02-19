package com.example.osrsherbrunprofitcalculator

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.properties.Delegates

//simply contains an herb run's appropriate data
@Entity (tableName = "HerbRun")
data class HerbRun (

    @PrimaryKey(autoGenerate = true) val iD : Long,
    @ColumnInfo(name="herb_type") val herb_type : String,
    @ColumnInfo(name="herb_price") val herb_price : Int,
    @ColumnInfo(name="herb_run_tags") val herb_run_tags : String,
    @ColumnInfo(name="total_herbs") val total_profit : Int

)
    /*var herb_type : String = "Ranaar"
    var herb_price : HerbPrice = HerbPrice()
    var total_herbs_received : Int = 6
    var herb_run_tags : String = ""

    var total_profit : Int = 20000*/
