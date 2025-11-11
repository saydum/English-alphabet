package com.englishalphabet;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundPlayer {

    private MediaPlayer mediaPlayer;

    public void playSound(Context context, int soundResource) {
        stopSound();

        mediaPlayer = MediaPlayer.create(context, soundResource);
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopSound();
                }
            });
            mediaPlayer.start();
        }
    }

    public void stopSound() {
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
