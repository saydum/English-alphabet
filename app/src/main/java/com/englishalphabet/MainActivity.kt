package com.englishalphabet

import android.os.Bundle
import android.widget.ImageView
import android.widget.GridLayout
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val letters = arrayListOf<Letter>()
    private lateinit var soundPlayer: SoundPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridLetters: GridLayout = findViewById(R.id.gridLetters)
        soundPlayer = SoundPlayer()

        letters.addAll(
                listOf(
                        Letter(R.drawable.a, R.raw.a),
                        Letter(R.drawable.b, R.raw.b),
                        Letter(R.drawable.c, R.raw.c),
                        Letter(R.drawable.d, R.raw.d),
                        Letter(R.drawable.e, R.raw.e),
                        Letter(R.drawable.f, R.raw.f),
                        Letter(R.drawable.g, R.raw.g),
                        Letter(R.drawable.h, R.raw.h),
                        Letter(R.drawable.i, R.raw.i),
                        Letter(R.drawable.j, R.raw.j),
                        Letter(R.drawable.k, R.raw.k),
                        Letter(R.drawable.l, R.raw.l),
                        Letter(R.drawable.m, R.raw.m),
                        Letter(R.drawable.n, R.raw.n),
                        Letter(R.drawable.o, R.raw.o),
                        Letter(R.drawable.p, R.raw.p),
                        Letter(R.drawable.q, R.raw.q),
                        Letter(R.drawable.r, R.raw.r),
                        Letter(R.drawable.s, R.raw.s),
                        Letter(R.drawable.t, R.raw.t),
                        Letter(R.drawable.u, R.raw.u),
                        Letter(R.drawable.v, R.raw.v),
                        Letter(R.drawable.w, R.raw.w),
                        Letter(R.drawable.x, R.raw.x),
                        Letter(R.drawable.y, R.raw.y),
                        Letter(R.drawable.z, R.raw.z)
                )
        )

        letters.forEachIndexed { index, letter ->
            val button = ImageButton(this).apply {
                setImageResource(letter.imageResource)
                setBackgroundColor(getColor(android.R.color.transparent))
                scaleType = ImageView.ScaleType.CENTER_INSIDE
                adjustViewBounds = true
                setPadding(6, 6, 6, 6)

                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    height = 0
                    columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                    rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                }

                setOnClickListener { view ->
                    soundPlayer.playSound(this@MainActivity, letter.soundResource)
                    view.animate()
                        .scaleX(1.2f)
                        .scaleY(1.2f)
                        .setDuration(150)
                        .withEndAction {
                            view.animate()
                                .scaleX(1f)
                                .scaleY(1f)
                                .setDuration(150)
                                .start()
                        }
                        .start()
                }
            }

            gridLetters.addView(button)
        }
    }

    override fun onStop() {
        super.onStop()
        soundPlayer.stopSound()
    }
}
