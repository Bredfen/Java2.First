
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GameCanvas extends JPanel {

    MainCircles gameWindow;
    private long lastFrameTime;
    private Background current_background;

    GameCanvas(MainCircles gameWindow) {
        this.gameWindow = gameWindow;
        current_background = new Background();
        current_background.setCurrentColor(this);
        lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float delta = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        current_background.setCurrentColor(this);

        gameWindow.onDrawFrame(this, g, delta);
        repaint();
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }
}
