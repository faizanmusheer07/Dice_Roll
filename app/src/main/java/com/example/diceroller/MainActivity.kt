package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var score1 = 0
    var score2 = 0
    var isFirstPlayer = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.player1Score.text=  "Player 1 Score : \n $score1"
        binding.player2Score.text=  "Player 2 Score : \n $score2"
        binding.rollDice.setOnClickListener {
        val number = Random.nextInt(1,7)
        val image= when (number){
            1->{ R.drawable.dice_1 }
            2-> {R.drawable.dice_2}
            3-> {R.drawable.dice_3}
            4-> {R.drawable.dice_4}
            5-> {R.drawable.dice_5}
            else -> {R.drawable.dice_6}
        }
            if (isFirstPlayer){
                score1+=number
                binding.player1Score.text=  "Player 1 Score : \n $score1"
            } else{
                score2+=number
                binding.player2Score.text=  "Player 2 Score : \n $score2"
            }

            if (score1>=20 || score2>=20){
                binding.resultView.visibility=View.VISIBLE
                binding.winner.setText("Winner is ${if (score1>score2) "Player 1" else "Player 2"} and score is ${if(score1>score2){score1} else{score2}}")
            }
            binding.diceImage.setImageResource(image)
             binding.rollDice.setText(if (isFirstPlayer){
                 "Player 2"
             } else{
                 "Player 1"
        })
            isFirstPlayer =! isFirstPlayer
        }

    }
}