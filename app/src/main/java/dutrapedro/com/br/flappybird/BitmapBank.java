package dutrapedro.com.br.flappybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    Bitmap[] bird;

    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background);
        background = scaleImage(background);
        bird = getBird(res);

    }

    public Bitmap getBird(int frame) {
        return this.bird[frame];
    }

    public int getBirdWidth() {
        return bird[0].getWidth();
    }

    public int getBirdHeight() {
        return bird[0].getHeight();
    }

    public Bitmap getBackground() {
        return this.background;
    }

    public int getBackgroundWidth() {
        return this.background.getWidth();
    }

    public int getBackgroundHeight() {
        return this.background.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap) {
        float widthHeigthRatio = getBackgroundWidth() / getBackgroundHeight();

        int backgroundScaleWidth = (int) widthHeigthRatio * AppConstants.SCREEN_HEIGHT;

        return bitmap.createScaledBitmap(bitmap, backgroundScaleWidth, AppConstants.SCREEN_HEIGHT, false);
    }

    private Bitmap[] getBird(Resources res) {
        Bitmap[] bird = new Bitmap[8];
        int width = 220;
        int height = 220;
        bird[0] = getBirdBitmap(width, height,BitmapFactory.decodeResource(res, R.drawable.frame_1));
        bird[1] = getBirdBitmap(width, height,BitmapFactory.decodeResource(res, R.drawable.frame_2));
        bird[2] = getBirdBitmap(width, height,BitmapFactory.decodeResource(res, R.drawable.frame_3));
        bird[3] = getBirdBitmap(width, height,BitmapFactory.decodeResource(res, R.drawable.frame_4));
        bird[4] = getBirdBitmap(width, height,BitmapFactory.decodeResource(res, R.drawable.frame_5));
        bird[5] = getBirdBitmap(width, height,BitmapFactory.decodeResource(res, R.drawable.frame_6));
        bird[6] = getBirdBitmap(width, height,BitmapFactory.decodeResource(res, R.drawable.frame_7));
        bird[7] = getBirdBitmap(width, height,BitmapFactory.decodeResource(res, R.drawable.frame_8));

        return bird;
    }

    private Bitmap getBirdBitmap(int width, int height, Bitmap originalBitmap) {
        return Bitmap.createScaledBitmap(
                originalBitmap, width, height, false);
    }
}
