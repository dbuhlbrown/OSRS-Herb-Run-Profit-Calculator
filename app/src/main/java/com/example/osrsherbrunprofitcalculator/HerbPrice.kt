package com.example.osrsherbrunprofitcalculator
//Note: GE data will not be available during the first launch
class HerbPrice {

    var herb_name : String = "Ranaar"
    var herb_price : Int = 6500
    var herb_seed_price : Int = 32000

    //until the GE code is done, we will simply add the herb price and seed price data to the
    //new herb run form.
    fun HerbPrice(herb_name: String, herb_price: Int, herb_seed_price: Int){

        this.herb_name = herb_name
        this.herb_price = herb_price
        this.herb_seed_price = herb_seed_price
    }
}

