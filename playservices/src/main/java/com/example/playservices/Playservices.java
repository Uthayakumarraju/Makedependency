package com.example.playservices;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.MediaController;

import androidx.annotation.Nullable;

public class Playservices extends Service implements MediaPlayer.OnPreparedListener,MediaPlayer.OnErrorListener,MediaPlayer.OnCompletionListener, MediaController.MediaPlayerControl {
    MediaPlayer player;
    IBinder play_bind=new QoutesBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return play_bind;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        player.stop();
        player.reset();
        player.release();
        return false;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player=new MediaPlayer();
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public void start() {

    }

    @Override
    public void pause() {
        if (player.isPlaying()){
            player.pause();
        }
    }

    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public int getCurrentPosition() {
        return 0;
    }

    @Override
    public void seekTo(int pos) {

    }

    @Override
    public boolean isPlaying() {
        return player.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return false;
    }

    @Override
    public boolean canSeekBackward() {
        return false;
    }

    @Override
    public boolean canSeekForward() {
        return false;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }

    public class QoutesBinder extends Binder {
        Playservices getservices(){
            return Playservices.this;
        }
    }
}
