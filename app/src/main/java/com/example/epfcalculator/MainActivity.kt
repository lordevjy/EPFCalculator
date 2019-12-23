package com.example.epfcalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtDOB.setOnClickListener() {
            val c: Calendar = Calendar.getInstance();
            val currentDay = c.get(Calendar.DAY_OF_MONTH);
            val currentMonth = c.get(Calendar.MONTH);
            val currentYear = c.get(Calendar.YEAR);

            var basic:Double = 0.00
            var allowable:Double = 0.00

            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, month, day ->
                    txtDOB.setText(day.toString() + "/" + (month + 1).toString() + "/" + year.toString())
                    //todo

                    val age = currentYear - year

                    if(age >= 16 && age <= 20){
                        basic = 5000.00
                        allowable = basic * 0.3
                    }else if(age >= 21 && age <= 25){
                        basic = 14000.00
                        allowable = basic * 0.3
                    }else if(age >= 26 && age <= 30){
                        basic = 29000.00
                        allowable = basic * 0.3
                    }else if(age >= 31 && age <= 35){
                        basic = 50000.00
                        allowable = basic * 0.3
                    }else if(age >= 36 && age <= 40){
                        basic = 78000.00
                        allowable = basic * 0.3
                    }else if(age >= 41 && age <= 45){
                        basic = 116000.00
                        allowable = basic * 0.3
                    }else if(age >= 46 && age <= 50){
                        basic = 165000.00
                        allowable = basic * 0.3
                    }else if(age >= 51 && age <= 55){
                        basic = 228000.00
                        allowable = basic * 0.3
                    }else{
                        basic = 0.00
                        allowable = basic * 0.3
                    }

                    txtAge.text = age.toString()
                    txtBasic.text = basic.toString()
                    txtAllowable.text = allowable.toString()

                }, currentYear, currentMonth, currentDay
            )

            dpd.show()
        }


    }
}
