package com.example.ucproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.ucproject.fragment.FragmentOne
import com.example.ucproject.fragment.FragmentThree
import com.example.ucproject.fragment.FragmentTwo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val fragmentOne by lazy { FragmentOne() }
    private val fragmentTwo by lazy { FragmentTwo() }
    private val fragmentThree by lazy { FragmentThree() }

    private val fragments : List<Fragment> = listOf(fragmentOne, fragmentTwo, fragmentThree)

    private val pagerAdapter : MainViewPagerAdapter by lazy {
        MainViewPagerAdapter(this, fragments)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);//뒤로가기 버튼추가
//        supportActionBar?.title = "아이템 추가하기" //툴바 타이틀 설정

        initViewPager()
        initNavigationBar2()
    }

    //Bottom NavigationView의 아이콘 클릭시 Fragment 변화함수
    private fun initNavigationBar() {
        bnv_main.run {
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.first -> {
                        changeFragment(fragmentOne)
                    }
                    R.id.second -> {
                        changeFragment(fragmentTwo)
                    }
                    R.id.third -> {
                        changeFragment(fragmentThree)
                    }
                }
                true
            }
            selectedItemId = R.id.first
        }
    }

    //ViewPager2가 적용된 Bottom NavigationView (좌우 스와이핑시 Fragment 변화함수)
    private fun initNavigationBar2() {

        bnv_main.run {
            setOnNavigationItemSelectedListener {
                val page = when(it.itemId){
                    R.id.first -> 0
                    R.id.second -> 1
                    R.id.third -> 2
                    else -> 0
                }

                //viewpager의 현재화면은 currentItem(Int형)으로 받고
                //BottomNavigationView의 현재아이콘은 currentItemId(리소스id(int))형으로 받음
                if(page!= vp_main.currentItem){
                    vp_main.currentItem = page
                }

                true
            }
            selectedItemId = R.id.first
        }

    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_container, fragment)
            .commit()
    }

    private fun initViewPager(){
        vp_main.run{
            adapter = pagerAdapter
            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    val navigation = when(position){
                        0 -> {
                            supportActionBar?.title = "대화"
                            R.id.first
                        }
                        1 -> {
                            supportActionBar?.title = "동료"
                            R.id.second
                        }
                        2 -> {
                            supportActionBar?.title = "알림"
                            R.id.third
                        }
                        else -> R.id.first
                    }

                    //viewpager의 현재화면은 currentItem(Int형)으로 받고
                    //BottomNavigationView의 현재아이콘은 currentItemId(리소스id(int))형으로 받음
                    if(bnv_main.selectedItemId != navigation){
                        bnv_main.selectedItemId = navigation
                    }
                }
            })
        }
    }



}