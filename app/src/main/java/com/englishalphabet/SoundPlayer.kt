package com.englishalphabet

import android.content.Context
import android.media.MediaPlayer

class SoundPlayer {

    private var mediaPlayer: MediaPlayer? = null

    fun playSound(context: Context, soundResource: Int) {
        stopSound()

        mediaPlayer = MediaPlayer.create(context, soundResource)?.apply {
            setOnCompletionListener {
                stopSound()
            }
            start()
        }
    }

    fun stopSound() {
        mediaPlayer?.let { player ->
            try {
                if (player.isPlaying) {
                    player.stop()
                }
            } catch (e: IllegalStateException) {
                e.printStackTrace()
            } finally {
                player.release()
                mediaPlayer = null
            }
        }
    }
}
