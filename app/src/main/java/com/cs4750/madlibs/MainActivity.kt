package com.cs4750.madlibs

import android.content.Context
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var index : Int = 0 // Represents the current mad lib that is being displayed to User
        var inputFields : MutableList<EditText> // dynamically created input fields

        initTitle(RepositoryManager.getInstance().get(index))
        inputFields = initScrollView(RepositoryManager.getInstance().get(index))



        next_madlib.setOnClickListener{ // Sends to next mad lib from repository
            if(index < RepositoryManager.getInstance().size-1) { // loops entirely
                index++
            }else{
                index = 0
            }

            initTitle(RepositoryManager.getInstance().get(index))
            inputFields = initScrollView(RepositoryManager.getInstance().get(index))
        }


        show_madlib.setOnClickListener { // Demonstrates the filled out mad lib

            // TODO: Error Checking Toast Messages-When text fields are empty or invalid

            line_view.removeAllViews()

            var textView: TextView = TextView(this)

            textView.setTypeface(ResourcesCompat.getFont(this, R.font.bubblegum_sans))
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)

            // Set text:
            textView.text = RepositoryManager.getInstance().get(index).formatString(textEditListToStringList(inputFields))

            line_view.addView(textView)
        }

    }

    fun initTitle(currentMadLib: MadLib){
        title_text.text = currentMadLib.title
    }

    fun initScrollView(currentMadLib : MadLib) : MutableList<EditText>{

        line_view.removeAllViews()

        var textView: TextView
        var layout : LinearLayout
        var textEditList: MutableList<EditText> = List<EditText>(currentMadLib.getInputSize(), { i-> EditText(this) }).toMutableList()

        for(x in 0..(currentMadLib.getInputSize()-1)){ // Loops through all potential input cases
            textView = TextView(this)
            layout = LinearLayout(this)

            textView.setTypeface(ResourcesCompat.getFont(this, R.font.bubblegum_sans))
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22F)

            layout.layoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            layout.orientation = LinearLayout.HORIZONTAL

            // Set text:
            textView.text = currentMadLib.getInputAt(x)

            layout.addView(textView)
            layout.addView(textEditList[x])
            line_view.addView(layout)
        }

        return textEditList

    }

    // Converts a list of EditText variables' contents to a list of strings
    fun textEditListToStringList(textEditList : MutableList<EditText>) : List<String>{
        var stringList : ArrayList<String> = ArrayList<String>()

        for(x in 0..(textEditList.size-1)){
            stringList.add(textEditList[x].text.toString())
        }

        return stringList.toList()
    }
}