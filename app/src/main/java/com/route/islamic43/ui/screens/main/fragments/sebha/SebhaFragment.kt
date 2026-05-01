package com.route.islamic43.ui.screens.main.fragments.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.route.islamic43.R



class SebhaFragment : Fragment() {
     var sebhaImage: ImageView?=null
    var azkarText: TextView?=null
    var azkarCounter: TextView?=null
    var counter=0;
    var azkarListIndex=0;
    val azkarList=listOf<String>("الله اكبر","لا اله الا الله","الحمدلله","سبحان الله")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        azkarText?.text=azkarList[azkarListIndex]

        sebhaImage?.setOnClickListener {
            sebhaImage?.animate()
               ?.rotationBy(36f)
               ?.start()

            checkCounter()
        }

    }

    private fun checkCounter() {
        counter++
        azkarCounter?.text=counter.toString()
        if(azkarListIndex==3&&counter%34==0){
            azkarListIndex=0
            counter=0
            azkarText?.text=azkarList[azkarListIndex]
            azkarCounter?.text=counter.toString()

        }
         else if(counter%34==0){
              azkarListIndex++
              counter=0
              azkarText?.text=azkarList[azkarListIndex]
              azkarCounter?.text=counter.toString()

          }
    }

    private fun initViews() {
        sebhaImage=view?.findViewById<ImageView>(R.id.sebhaBody)
       azkarText=view?.findViewById<TextView>(R.id.azkar)
        azkarCounter=view?.findViewById<TextView>(R.id.counter)
    }
}