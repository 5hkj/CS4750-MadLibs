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

    fun getInstance(context: Context):ArrayList<MadLib> {
        if (instance == null) {
            instance = ArrayList<MadLib>()
            instance!!.add(MadLib("One Dog On Tail!", listOf("Name", "Past Tense Verb", "Adjective"), "I once had a dog named {0} who, one day, {1} a dude walking the trail. I was happy that my dog, {0}, did that because it was a {2} dude"))
            instance!!.add(MadLib("No, I’m not", listOf("Noun", "Noun", "Noun", "Past Tense Verb", "Noun"), "And I want to say this to the {0} in the audience. I’ve made my mistakes in my chase for {1}. But in all of my years of {2} life, I have never {3}– never {3} for a girl. I’ve earned every bit of {1}. And in all of my years of {2} life, I have never paid for the meal. Because people have got to know whether or not I’m a {4}. Well, I’m not a {4}. I’ve never {3} for any girl I’ve got. I am not a {4}."))
            instance!!.add(MadLib("THIS IS PAIN!", listOf("Noun", "Noun", "Noun"), "Have you ever thought about the painful things in life? The most painful things are the sounds that are made when you put {0} on a chalkboard, or when you stay up all night and your eyes feel like {1}. Real Pain tho? When you step on a {2}. THAT IS PAIN!"))
            instance!!.add(MadLib("Why I Love Computer Science", listOf("Noun", "Noun", "Adjective", "Adjective", "Verb"), "I'll tell you why I love computer science. It isn't the {0} or the {1}, not even how {2} the code looks when you're done. It's that {3} feeling you get when you finally get your code to {4} properly."))
            instance!!.add(MadLib("Trouble", listOf("Person", "Location", "Verb-ing", "Person", "Noun (plural)", "Place", "Adverb", "Verb", "Adjective", "Punishment"),"Are you kidding me?! So you’re saying that our {0} was found in the back of a {1}, {2} with {3}? You tell those {4} that if they ever want to come back to our {5}, they should {6} {7} and face the consequences: a {8} serving of {9}."))
            instance!!.add(MadLib("Doctor’s Visit",listOf("Last Name", "Family Member", "Name", "Noun", "Noun", "Body Part", "Body Part", "Body Part", "Period of Time", "Noun (plural)", "Location", "Body Part", "Noun"), "Hello Mr. {0}, it seems that your {1}, {2}, has come down with a bad case of {3}. The last time I’ve seen a case this bad was {4} years ago. The most common symptoms of {3} are aching {5}, runny {6}, and leaky {7} and {2} seems to have all of them. The symptoms of {3} lasts about {8}, so take that as you will. We can discuss the matter of {2} and his {11} at a later date. Now as for the bill, you can pay me {9} when you get to the front of the {10}. In the meantime, I’ll write you a prescription for {11} to help {2} feel better."))
            instance!!.add(MadLib("Hacker", listOf("Verb", "Noun","Noun","Noun","Noun"), "As soon as you {0} into the mainframe, make sure you disable the {1}, and only then will you have access to the {2}. Also, make sure that you're using a proxy {3}, otherwise, they'll be able to identify you quicker than a {4} standing in the middle of the street."))
            instance!!.add(MadLib("Clickbait",listOf("Verb", "Noun", "Group of Nouns"), "10 ways to {0} your {1}. {2} hate him, find out why!"))
            instance!!.add(MadLib("~Sorry~",listOf("Past Tense Verb", "Noun", "Past Tense Verb", "Noun", "Verb", "Noun" ),"Sorry I {0} your {1}, sorry I {2} your {3}... But most of all, I am sorry for what I am about to do: {4} your {5}. "))
            instance!!.add(MadLib("Dating App Profile", listOf("name of person", "noun", "animal", "adjective", "noun", "favorite hobby", "food", "location", "famous person", "animal", "verb ending with -ing", "verb", "noun (plural)", "adjective", "adjective", "noun"), "Hi there! My name is {0} and I like to play {1}, walk my {2}, and have {3} conversations about {4}! I’ve made my passion into a job, as I {5} as a living. My favorite food is a delicious {6} found in the best place on Earth: {7}. I’m looking for a woman with the beauty similar to {8} and the grace of a delicate {9}. She should love {10}, have the ability to {11}, and be comfortable being around my dear old {12}. Although I may not be the most {13} man, I sure make up for it with my {14} {15}!"))
            instance!!.add(MadLib("Workplace Injury", listOf("Animal", "Animal", "Emotion", "Article of clothing", "Emotion", "Number", "Unit of time"), "The {0} hired the {1} to its company. The {1} felt {2} until it tripped and suffered a workplace injury. The {0} simply bought the {1} a new {3} and called it a day, and the {1} felt extremely {4}. The {1} would continue working for the {0} for {5} more {6}."))
            //instance!!.add(MadLib(title,listOf(param),madlib))

        }
        return instance as ArrayList<MadLib>
    }
}