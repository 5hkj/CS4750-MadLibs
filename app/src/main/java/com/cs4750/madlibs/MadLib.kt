package com.cs4750.madlibs

/**
 * MadLib Class:
 *  Represents a mad lib unfilled out.
 */
class MadLib constructor(
    val title: String, // Name of mad lib
    val inputs: List<String>, // The needed input fields to complete mad lib
    val lib: String){ // The unformated mad lib

    fun getInputSize():Int{
        return inputs.size
    }

    fun getInputAt(index:Int) : String{
        return inputs.get(index)
    }

    // Will format the mad lib to have the user's inputted values
    fun formatString(inputStrings : List<String>) : String{
        var newLib : String = lib
        for(x in 0..(inputStrings.size-1)){
            var oldValue : String = "{".plus(x).plus("}")
            newLib = newLib.replace(
                oldValue,
                inputStrings[x],
                ignoreCase = false
            )
        }

        // ** DEBUG **
        println(newLib)
        return newLib
    }


}