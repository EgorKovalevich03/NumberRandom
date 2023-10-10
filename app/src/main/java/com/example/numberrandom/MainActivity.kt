package com.example.numberrandom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.numberrandom.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //в этот список добавляется наша последовательность
    var spisok:MutableList<Int> = mutableListOf()

    //храним кол-во выпавших чисел
    var spisok2 = arrayListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)

    //список для трёх последних выпавших чисел
    var spisok3 = arrayListOf(0,0,0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

    }

    //инициализируем кнопки
    private fun initViews() {
        binding.apply {
            button0.setOnClickListener{inNumberInList(0)}
            button1.setOnClickListener{inNumberInList(1)}
            button2.setOnClickListener{inNumberInList(2)}
            button3.setOnClickListener{inNumberInList(3)}
            button4.setOnClickListener{inNumberInList(4)}
            button5.setOnClickListener{inNumberInList(5)}
            button6.setOnClickListener{inNumberInList(6)}
            button7.setOnClickListener{inNumberInList(7)}
            button8.setOnClickListener{inNumberInList(8)}
            button9.setOnClickListener{inNumberInList(9)}
            button10.setOnClickListener{inNumberInList(10)}
            button11.setOnClickListener{inNumberInList(11)}
            button12.setOnClickListener{inNumberInList(12)}
            button13.setOnClickListener{inNumberInList(13)}
            button14.setOnClickListener{inNumberInList(14)}
            btnDelete.setOnClickListener{ delNum() }
        }
    }

    // при нажатии кнопки R.id.btnDelete -> происходит удаление последнего доьбавлено числа с последовательность
    private fun delNum() {
        val e = spisok.size -1
        spisok.removeAt(e)
        val qqq = howLongDidNumNotAppear(spisok.reversed())
        binding.textAboutLastNumber.text = qqq.toString()
    }

    //указываем количество всего выпаденых чисел за всё время , а так же три последних числа
    private fun inNumberInList(a: Int){
        spisok.add(a)
        spisok2[a]++

        val qqq = howLongDidNumNotAppear(spisok.reversed())
        binding.textAboutLastNumber.text = qqq.toString()

        var temp = spisok3[0]
        var temp2 = spisok3[1]
        spisok3[0] = a
        spisok3[1] = temp
        spisok3[2] = temp2

        binding.lastNumberInput.text = spisok3.toString()

        binding.lastNumb.text = spisok2.toString()
    }

    //основной tv который показывает сколько не выпадало конкретное число
    private fun howLongDidNumNotAppear(spisok:List<Int>):Map<String,Int>{
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