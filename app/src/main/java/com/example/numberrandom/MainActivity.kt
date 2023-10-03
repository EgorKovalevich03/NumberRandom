package com.example.numberrandom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.numberrandom.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var spisok:MutableList<Int> = mutableListOf()

    var ee = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener{
            spisok.add(0)

        }
        binding.button1.setOnClickListener{spisok.add(1)}
        binding.button2.setOnClickListener{spisok.add(2)}
        binding.button3.setOnClickListener{spisok.add(3)}
        binding.button4.setOnClickListener{spisok.add(4)}
        binding.button5.setOnClickListener{spisok.add(5)}
        binding.button6.setOnClickListener{spisok.add(6)}
        binding.button7.setOnClickListener{spisok.add(7)}
        binding.button8.setOnClickListener{spisok.add(8)}
        binding.button9.setOnClickListener{spisok.add(9)}
        binding.button10.setOnClickListener{spisok.add(10)}
        binding.button11.setOnClickListener{spisok.add(11)}
        binding.button12.setOnClickListener{spisok.add(12) }
        binding.button13.setOnClickListener{spisok.add(13) }
        binding.button14.setOnClickListener{spisok.add(14) }


        binding.btnLoadNumber.setOnClickListener{
            val a = howLongDidNumNotAppear(spisok.reversed())
            binding.textAboutLastNumber.text = a.toString()
        }

        binding.btnDelete.setOnClickListener{
            val e = spisok.size -1
            spisok.removeAt(e)
        }

    }

    fun howLongDidNumNotAppear(spisok:List<Int>):Map<String,Int>{
        var howLongHasNum = mutableMapOf("0" to 0,"1" to 0,"2" to 0,"3" to 0,"4" to 0,"5" to 0,"6" to 0,"7" to 0,"8" to 0,"9" to 0,"10" to 0,"11" to 0
            ,"12" to 0,"13" to 0,"14" to 0)

        for(i in 0..14){
            var v =0
            for(j in spisok){
                if(i != j){
                    v++
                } else {
                    howLongHasNum[i.toString()] = v
                    break
                }
            }
        }
        return howLongHasNum.entries.sortedByDescending { it.value }.associate { it.toPair() }
    }

}