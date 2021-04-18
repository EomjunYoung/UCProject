package com.example.ucproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ucproject.CommuniAdapter
import com.example.ucproject.ListAdapter
import com.example.ucproject.R
import com.example.ucproject.model.Coworker
import com.example.ucproject.model.User
import kotlinx.android.synthetic.main.fragment_one.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class FragmentTwo : Fragment(){

    //RecyclerView를 적용할 fragment마다 어댑터를 둬야함
    private lateinit var communiAdapter: CommuniAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ):
            View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //현재시간 구해서 넘기기

        var date = Date()

        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA)
        var time = System.currentTimeMillis()
        var curTime = dateFormat.format(Date(time))


        var list: ArrayList<Coworker> = arrayListOf(
            Coworker("init1","eom1","블라블라~~"),
            Coworker("init2","eom2","블라블라~~~~~"),
            Coworker("init3","eom3","블라블라~~~~~~~~~")
        )

        //RecyclerView 어댑터에 데이터를 넘겨서 셋팅 후 현재의 fragment상에 만든 어댑터변수에 저장
        communiAdapter = CommuniAdapter(list)
        //
        listView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        //현재의 fragment에 만든 RecyclerView 어댑터를 실제 layout의 어댑터에 지정
        listView.adapter = communiAdapter
    }


}