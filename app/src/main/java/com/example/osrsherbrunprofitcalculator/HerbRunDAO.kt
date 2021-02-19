package com.example.osrsherbrunprofitcalculator

import androidx.room.*

//this helps us access the SQLite database,
//which contains herb run data.
//It can then be used to return all herb runs, given a set of search terms.
@Dao
interface HerbRunDAO {

    @Query("SELECT * FROM HerbRun")
    fun getHerbRuns(): List<HerbRun>

    @Insert()
    fun insert(herbRun: HerbRun)

    @Insert()
    fun insert(vararg herbRun: HerbRun)

    @Delete
    fun delete(herbRun: HerbRun)

    @Update
    fun update(herbRun: HerbRun)




}