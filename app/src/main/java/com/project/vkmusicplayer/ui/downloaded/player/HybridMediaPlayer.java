package com.project.vkmusicplayer.ui.downloaded.player;

import android.content.Context;

/**
 * Created by gleb on 23.02.17.
 */

public abstract class HybridMediaPlayer {
    OnPreparedListener onPreparedListener = null;
    OnCompletionListener onCompletionListener = null;
    OnErrorListener onErrorListener = null;

    public static HybridMediaPlayer getInstance(Context context) {
        HybridMediaPlayer res;
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            res = new ExoMediaPlayer(context);
        } else {
            res = new AndroidMediaPlayer(context);
        }
        return res;
    }

    public abstract void setDataSource(String path);

    public abstract void prepare();

    public abstract void play();

    public abstract void pause();

    public abstract void seekTo(int msec);

    public abstract int getDuration();

    public abstract int getCurrentPosition();

    public abstract boolean isPlaying();

    public abstract void release();

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.onPreparedListener = onPreparedListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.onCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public interface OnPreparedListener {
        void onPrepared(HybridMediaPlayer player);
    }

    public interface OnCompletionListener {
        void onCompletion(HybridMediaPlayer player);
    }

    public interface OnErrorListener {
        void onError(Exception error, HybridMediaPlayer player);
    }
}