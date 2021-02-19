package com.example.osrsherbrunprofitcalculator

import org.json.JSONObject

//this class must access a GE API, to retrieve the herb prices.
//When the user selects an herb on the addnewrun page, we will autopopulate two
//fields using the data from here.

//This class contains a static list of IDs per herb / herb seed.
//Note: We are using the prices for grimy herbs, so as to make each herb run's
//profit more accurate

//List of herbs, for reference:
/*
Guam        Marrentill Tarromin
Harralandar Ranarr     Toadflax
Irit        Avantoe    Kwuarm
Snapdragon  Cadantine  Lantadyme
Dwarf weed  Torstol
 */

class HerbPricingDataHelper(herb_type : String) {

    private lateinit var herbPriceJsonObject : JSONObject
    private lateinit var herbSeedPriceJsonObject : JSONObject
    lateinit var herbPrice : HerbPrice

    val herb_ids = mapOf(
        "Guam" to "199",
        "Marrentill" to "201",
        "Tarromin" to "203",
        "Harralander" to "205",
        "Ranarr" to "207",
        "Toadflax" to "3049",
        "Irit" to "209",
        "Avantoe" to "211",
        "Kwuarm" to "213",
        "Snapdragon" to "3051",
        "Cadantine" to "215",
        "Lantadyme" to "2485",
        "Dwarf weed" to "217",
        "Torstol" to "219");

    val herb_seed_ids = mapOf(
        "Guam" to "5291",
        "Marrentill" to "5292",
        "Tarromin" to "5293",
        "Harralander" to "5294",
        "Ranarr" to "5295",
        "Toadflax" to "5296",
        "Irit" to "5297",
        "Avantoe" to "5298",
        "Kwuarm" to "5299",
        "Snapdragon" to "5300",
        "Cadantine" to "5301",
        "Lantadyme" to "5302",
        "Dwarf weed" to "5303",
        "Torstol" to "5304");

    val API_URL = "https://secure.runescape.com/m=itemdb_oldschool/api/catalogue/detail.json?item=";

    init{

        pullData();
    }

    //this creates an herb price object.
    fun createHerbPriceObject( ){


    }

    //when the data is returned, we will trigger this function.
    fun data_returned(){


    }

    //this initializes our API call in a background thread. We do this
    //so that the user can enter herb run values while the data is downloading.
    fun pullData( ){


    }
    //the GE api returns price with a K, or M, etc. We need to parse this out.
    //While it is very unlikely we will ever need to parse a price of Xm, I will still include it.
    fun returnPriceAsInt( ): Int{

        var price = 0;

        return price;
    }
}