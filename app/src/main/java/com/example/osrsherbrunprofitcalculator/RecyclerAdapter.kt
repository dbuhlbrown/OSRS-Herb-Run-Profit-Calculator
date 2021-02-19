package com.example.osrsherbrunprofitcalculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//not done super not done
class RecyclerAdapter(private var herbRuns: ArrayList<HerbRun>, val context: Context, private val listener: (Any) -> Unit) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>()  {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val textView : TextView

        init{

            textView = view.findViewById(R.id.herbCountTextView);
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textView.text = herbRuns[position].herb_type
        holder.itemView.setOnClickListener{listener(herbRuns[position])}

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.herb_run_row_item,viewGroup,false);

        return ViewHolder(view);

    }

    override fun getItemCount() = herbRuns.size

}