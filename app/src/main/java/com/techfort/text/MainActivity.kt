package com.techfort.text

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import cn.iwgang.simplifyspan.SimplifySpanBuild
import cn.iwgang.simplifyspan.customspan.CustomClickableSpan
import cn.iwgang.simplifyspan.other.OnClickableSpanListener
import cn.iwgang.simplifyspan.unit.SpecialClickableUnit
import cn.iwgang.simplifyspan.unit.SpecialTextUnit

class MainActivity : AppCompatActivity(), OnClickableSpanListener {


    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text)

        val stringArray = arrayListOf<String>("There ", "are ", "many ", "people ", "in ", "our ", "country ", "are ", "unemployed ")

        val simplifySpanBuild41 = SimplifySpanBuild()
        var isEven = false;
        for (i in stringArray.indices){
            if(isEven){
                simplifySpanBuild41.append(SpecialTextUnit(stringArray.get(i)).setClickableUnit(SpecialClickableUnit(textView, this).setTag(i)).setTextColor(Color.BLUE))
                isEven = false
            }else{
                simplifySpanBuild41.append(SpecialTextUnit(stringArray.get(i)).setClickableUnit(SpecialClickableUnit(textView, this).setTag(i)).setTextColor(Color.CYAN))
                isEven = true
            }
        }
        textView.text = simplifySpanBuild41.build()

       /* simplifySpanBuild41.append("Hello ")
            .append(
                SpecialTextUnit("are ").setClickableUnit(
                    SpecialClickableUnit(
                        textView,
                        this
                    ).setTag("1").setPressBgColor(-0xb000)
                ).setTextColor(
                    Color.BLUE
                )
            )
            .append("you ")
            .append(
                SpecialTextUnit("do ").setClickableUnit(
                    SpecialClickableUnit(
                        textView,
                        this
                    ).setTag("2").showUnderline().setPressBgColor(-0xb000).setPressTextColor(
                        Color.WHITE
                    )
                ).setTextColor(-0xb000)
            )
            .append("you ")
            .append(
                SpecialTextUnit("have ").setClickableUnit(
                    SpecialClickableUnit(textView, this).setTag("3").setPressBgColor(Color.BLUE).setPressTextColor(
                        Color.WHITE
                    )
                ).setTextColor(-0xb000).setTextBackgroundColor(795548)
            )
            .append("any ")
        textView.text = simplifySpanBuild41.build()*/
    }

    override fun onClick(tv: TextView?, clickableSpan: CustomClickableSpan?) {
        Toast.makeText(
            this, "Click Text: " + clickableSpan!!.getClickText()
                    + "  tag: " + clickableSpan!!.getTag()
                    + "  StartSpanIndex: " + clickableSpan.getStartSpanIndex()
                    + "  EndSpanIndex: " + clickableSpan.getEndSpanIndex(), Toast.LENGTH_SHORT
        ).show()
    }
    
    /*
    azizul [1:58 PM]
mithu@w3engineers.com

hr@w3engineers.com
rakib@w3engineers.com
ayesha@w3engineers.com
    */

}
