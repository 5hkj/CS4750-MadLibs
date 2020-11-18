package com.cs4750.madlibs

import android.content.Context

/**
 * (Singleton) Class Repository:
 *      Handles the access to the information from the database.
 *      Instance should be an instantiated ArrayList of Mad libs generated from the database.
 *
 *      USE: RepositoryManager.getInstance()  (returns an ArrayList<MadLibs>)
 */

class RepositoryManager private constructor(context: Context){
    init {} // Do nothing
    companion object : Repository<RepositoryManager, Context>(::RepositoryManager)
}

open class Repository <out T: Any, in A>(creator: (A) -> T){
    private var creator:((A) -> T)? = creator
    @Volatile private var instance: ArrayList<MadLib>? = null

    fun getInstance():ArrayList<MadLib> {
        if (instance != null) {
            return instance as ArrayList<MadLib> // does not create new instance upon method call
        } else {
            // TODO: read from database and initialize instance.

            // ** Temporary **
            instance = ArrayList<MadLib>()
            instance!!.add(MadLib("One Dog On Tail!", listOf("Name", "Past Tense Verb", "Adjective"), "I once had a dog named {0} who, one day, {1} a dude walking the trail. I was happy that my dog, {0}, did that because it was a {2} dude"))
            instance!!.add(MadLib("No, I’m not", listOf("Noun", "Noun", "Noun", "Past Tense Verb", "Noun"), "And I want to say this to the {0} in the audience. I’ve made my mistakes in my chase for {1}. But in all of my years of {2} life, I have never {3}– never {3} for a girl. I’ve earned every bit of {1}. And in all of my years of {2} life, I have never paid for the meal. Because people have got to know whether or not I’m a {4}. Well, I’m not a {4}. I’ve never {3} for any girl I’ve got. I am not a {4}."))

            return instance as ArrayList<MadLib>
        }
    }
}