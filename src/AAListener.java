
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * 
 * Program Name: AAListener.java
 * @author Paul Magbor, Daniel Krauskopf
 * Purpose: A Mouse and Keyboard Listener for the Asteroid Attack game.
 * Date 13-Aug-2016
 */
public class AAListener implements MouseListener, KeyListener, MouseMotionListener {
    public boolean space_pressed;
    public boolean mouse_clicked;
    public Point laser_position;
    
    public Point mouse_postion;

    public AAListener() {
        space_pressed = false;
        mouse_clicked = false;
        laser_position = new Point(0, 0);
        mouse_postion = new Point(0, 0);
    } // AAListener();

    @Override
    public void mouseClicked(MouseEvent e) {
    } // mouseClicked (MouseEvent);

    @Override
    public void mousePressed(MouseEvent e) {
        laser_position.setLocation(e.getPoint());
        mouse_clicked = true;
    } // mousePressed (MouseEvent);

    @Override
    public void mouseReleased(MouseEvent e) {
        mouse_clicked = false;
        laser_position.setLocation(0, 0);
    } // mouseReleased (MouseEvent);

    @Override
    public void mouseEntered(MouseEvent e) {
    } // mouseEntered (MouseEvent);

    @Override
    public void mouseExited(MouseEvent e) {
    } // mouseExited (MouseEvent);

    @Override
    public void keyTyped(KeyEvent e) {
    } // keyTyped (KeyEvent);

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            space_pressed = true;
        }
    } // keyPressed (KeyEvent);

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            space_pressed = false;
        }
    } // keyReleased (KeyEvent);

    @Override
    public void mouseDragged(MouseEvent e) {
    } // mouseDragged (mouseEvent);

    @Override
    public void mouseMoved(MouseEvent e) {
        mouse_postion.move(e.getX(), e.getY());
    } // mouseMoved (MouseEvent);
} // AAListener;
