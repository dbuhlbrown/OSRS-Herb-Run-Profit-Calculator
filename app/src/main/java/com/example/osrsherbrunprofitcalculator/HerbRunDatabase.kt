package com.example.osrsherbrunprofitcalculator

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(HerbRun::class), version=1)
abstract class HerbRunDatabase : RoomDatabase(){
    abstract fun herbDao() : HerbRunDAO

}