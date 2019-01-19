package dutrapedro.com.br.flappybird;

public class BackgroundImage {

    private int backgroundImageX, backgroundImageY, backgroundImageVelocity;

    public BackgroundImage() {
        this.backgroundImageX = 0;
        this.backgroundImageY = 0;
        this.backgroundImageVelocity = 3;
    }

    public int getX() {
        return backgroundImageX;
    }

    public void setX(int backgroundImageX) {
        this.backgroundImageX = backgroundImageX;
    }

    public int getY() {
        return backgroundImageY;
    }

    public void setY(int backgroundImageY) {
        this.backgroundImageY = backgroundImageY;
    }

    public int getVelocity() {
        return backgroundImageVelocity;
    }
}
