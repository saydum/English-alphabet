package com.englishalphabet;

public class Letter {
    private int imageResource;
    private int soundResource;

    public Letter(int imageResource, int soundResource) {
        this.imageResource = imageResource;
        this.soundResource = soundResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getSoundResource() {
        return soundResource;
    }

    public void setSoundResource(int soundResource) {
        this.soundResource = soundResource;
    }
}
