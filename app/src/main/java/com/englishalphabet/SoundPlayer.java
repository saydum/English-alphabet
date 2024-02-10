package com.englishalphabet;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundPlayer {

    private MediaPlayer mediaPlayer;

    public void playSound(Context context, int soundResource) {
        stopSound();

        mediaPlayer = MediaPlayer.create(context, soundResource);
        mediaPlayer.start();
    }

    public void stopSound() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
