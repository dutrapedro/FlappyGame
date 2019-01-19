package dutrapedro.com.br.flappybird;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

class GameThread extends Thread {

    boolean isRunning;
    SurfaceHolder surfaceHolder;
    long startTime, loopTime;
    long DELAY = 33;

    public GameThread(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        this.isRunning = true;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        while (this.isRunning) {
            this.startTime = SystemClock.uptimeMillis();
            Canvas canvas = surfaceHolder.lockCanvas(null);
            if (canvas != null) {
                synchronized (surfaceHolder) {
                    AppConstants.getGameEngine().updateAndDrawBackgroundImage(canvas);
                    AppConstants.getGameEngine().updateAndDrawBird(canvas);
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }

            this.loopTime = SystemClock.uptimeMillis() - startTime;

            if (this.loopTime < this.DELAY) {
                try {
                    Thread.sleep(this.DELAY - this.loopTime);
                } catch (InterruptedException e) {
                    Log.i("Interrupted", "Interrupted while sleeping");
                }
            }
        }
    }
}
