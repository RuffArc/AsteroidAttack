
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.util.Vector;
import javax.swing.JFrame;

/**
 * 
 * Program Name: AsteroidAttack.java
 * @author Daniel Krauskopf
 * Purpose:
 * Date 13-Aug-2016
 */
public class AsteroidAttack extends JFrame {

public class AsteroidAttack extends JFrame implements Runnable {
    private final int SCREEN_WIDTH = 800;
    private final int SCREEN_HEIGHT = 800;
    
    private boolean isRunning;
    private Vector<Drawable> drawable;
    private AAListener listener;
    
    public AsteroidAttack() {
        super("Asteroid Attack");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setLocationRelativeTo(null);
        
        drawable = new Vector<>();
        listener = new AAListener();
        
        this.setVisible(true);
    }
    } // AsteroidAttack();
    
    @Override
    public void run() {
        while (isRunning) {
            BufferStrategy bs = getBufferStrategy();
            if (bs == null) {
                createBufferStrategy(3);
                continue;
            }
            
            Graphics g = bs.getDrawGraphics();
            render(g);
            g.dispose();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            if (bs != null) {
                bs.show();
            }
            
        } // while(Running);
    } // run ();
    
    public void start() {
        this.addMouseListener(listener);
        this.addKeyListener(listener);
        isRunning = true;
        Thread t = new Thread(this);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    } // start ();
    
    public void stop() {
        isRunning = false;
    } // stop ();
    
    public void render(Graphics g) {
        if (listener.space_pressed) {
            // Fire Nuke...
        }

        if (listener.mouse_clicked) {
            g.drawLine(listener.mouse_position.x, listener.mouse_position.y, 0, 0);
        }
        
        for (Drawable d : drawable) {
            d.draw(g);
        }
    } // draw ();
    
    public void addDrawable(Drawable d) {
        drawable.add(d);
    } // addDrawable (Drawable);
    
    public void removeDrawable(Drawable d) {
        drawable.remove(d);
    } // removeDrawable (Drawable);
} // AsteroidAttack;
