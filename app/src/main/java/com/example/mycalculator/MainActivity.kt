package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.example.mycalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        /*numbers*/

        binding.One.setOnClickListener {
            evaluateExpression("1", true)
        }

        binding.Two.setOnClickListener {
            evaluateExpression("2", true)
        }

        binding.Three.setOnClickListener {
            evaluateExpression("3", true)
        }

        binding.Four.setOnClickListener {
            evaluateExpression("4", true)
        }

        binding.Five.setOnClickListener {
            evaluateExpression("5", true)
        }

        binding.Six.setOnClickListener {
            evaluateExpression("6", true)
        }

        binding.Seven.setOnClickListener {
            evaluateExpression("7", true)
        }

        binding.Eight.setOnClickListener {
            evaluateExpression("8", true)
        }

        binding.Nine.setOnClickListener {
            evaluateExpression("9", true)
        }

        binding.Zero.setOnClickListener {
            evaluateExpression("0", true)
        }


        /*Operators*/

        binding.Dot.setOnClickListener {
            evaluateExpression(".", true)
        }

        binding.Plus.setOnClickListener {
            evaluateExpression("+", true)
        }

        binding.Minus.setOnClickListener {
            evaluateExpression("-", true)
        }

        binding.Mul.setOnClickListener {
            evaluateExpression("*", true)
        }

        binding.Divide.setOnClickListener {
            evaluateExpression("/", true)
        }

        /*clear operator*/
        binding.Clear.setOnClickListener {
            binding.Expression.text = ""
            binding.Result.text = ""
        }

        /*scroll id*/


        /*equal operator*/

        binding.Equal.setOnClickListener {
            val text = binding.Expression.text.toString()
            val expression = ExpressionBuilder(text).build()
            val result  = expression.evaluate()
            val longResult = result.toLong()

            if (result == longResult.toDouble()) {
                binding.Result.text = longResult.toString()
            } else {
                binding.Result.text = result.toString()
            }
        }

        /*back*/
        binding.Back.setOnClickListener {
            val text = binding.Expression.text.toString()
            if (text.isNotEmpty()){
                binding.Expression.text = text.dropLast(1)
            }
            binding.Result.text = ""
        }
    }

    /*Function to calculate the expressions using expression builder library*/
    private fun evaluateExpression(string: String, clear: Boolean) {


        if(clear) {
            binding.Result.text = ""
            binding.Expression.append(string)
        } else {
            binding.Expression.append(binding.Result.text)
            binding.Expression.append(string)
            binding.Result.text = ""
        }
        binding.Expression.movementMethod = ScrollingMovementMethod()
    }
}