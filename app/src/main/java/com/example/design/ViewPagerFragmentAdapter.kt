package com.example.design

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter



const val NUM_PAGES = 4
class ViewPagerFragmentAdapter(val context: Context) : PagerAdapter() {
    lateinit var layoutInflater: LayoutInflater

    val slideImages = arrayOf(
        R.drawable.wallet,
        R.drawable.animat_rocket_color,
        R.drawable.animat_lock_color,
        R.drawable.animat_heart_color
    )

    val slideHeadings = arrayOf(
        "Welcome",
        "Super Fast",
        "Safe & Secure",
        "Money, Made Social"
    )

    val slideDescriptions = arrayOf(
        "The money messenger app with all the power of a bank",
        "Sending money is fun, free and instant to groups and individuals.",
        "You control who sees your transactions and your data always remains anonymous. ",
        "Imagine if sending money was as fun as spending it, add emojis to your transfers."
    )

    override fun getCount() = slideHeadings.size


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.fragment_intro_first,container,false)

        val image = view.findViewById<ImageView>(R.id.wallet_image)
        val heading = view.findViewById<TextView>(R.id.heading_text)
        val description = view.findViewById<TextView>(R.id.description_text)
        val firstDot = view.findViewById<View>(R.id.dot_first)
        val secondDot = view.findViewById<View>(R.id.dot_second)
        val thirdDot = view.findViewById<View>(R.id.dot_third)
        val forthDot = view.findViewById<View>(R.id.dot_forth)

        when(position){
            0 -> firstDot.setBackgroundResource(R.drawable.selected_tab_dots)
            1 -> secondDot.setBackgroundResource(R.drawable.selected_tab_dots)
            2 -> thirdDot.setBackgroundResource(R.drawable.selected_tab_dots)
            3 -> forthDot.setBackgroundResource(R.drawable.selected_tab_dots)
        }

        image.setImageResource(slideImages[position])
        heading.text = slideHeadings[position]
        description.text = slideDescriptions[position]

        container.addView(view)

        return view

    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }

}