package com.example.ucproject.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ucproject.MainActivity
import com.example.ucproject.R
import com.example.ucproject.databinding.FragmentHomeBinding
import com.example.ucproject.databinding.FragmentThreeBinding

/**
 *
 * FragmentThree를 FragmentOne과 fragmentThree와 다르게 구현한 이유는
 * one과 two는 RecyclerView를 이용하여 adapter를 강제로 상속받아야 하기때문에
 * adapter를 통해서 .xml의 id를 초기화시켜주었는데, FragmentThree는 RecyclerView를
 * 사용하지 않아 adpater가 없어서 .xml의 id를 초기화시켜줄수가 없었다.
 *
 * 그래서, fragment만을 이용할때 초기화방법을 사용하여 .xml의 id를 초기화시켜주는 것임
 *
 */
class HomeFragment : Fragment() {

    //databinding을 사용하여 객체의 binding클래스를 만들려면 해당 xml은 layout을 사용해야한다.
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    var mainActivity: MainActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        binding.btnMainLogin.setOnClickListener {

            val email: String = binding.etEmailArea.text.toString().trim()
            val password: String = binding.etPasswordArea.text.toString().trim()

            loginUser(email, password)

        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun loginUser(email: String, password: String) {

        if(email.isNullOrBlank() or password.isNullOrBlank()){
            Toast.makeText(mainActivity, "email 또는 password가 공백입니다.", Toast.LENGTH_SHORT).show()
        }else{


            mainActivity?.initViewPager(1)
            mainActivity?.initNavigationBar2(1)

//            mainActivity?.changeFragment(FragmentOne())



        }

    }


}