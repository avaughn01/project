/*
 * Copyright Brian Ricks, PhD, 2016. bricks at unomaha.edu
 */

package project;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
/* The class JPanel
*/
public class AndrewPanel extends JPanel implements MouseListener, MouseMotionListener
{
    /**
    /* Default constructor
    */
    
    List<PuzzlePiece> pieces = new ArrayList<PuzzlePiece>();
    
    Point lastMouseLocation = null;
    
    public static int width = 100;
    public static int height = 100;
    
    public AndrewPanel()
    {
            this.setPreferredSize(new Dimension(400, 400));
            
            pieces.add(new PuzzlePiece());
            
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
        // I want to change this to a regular for loop, do not like enhanced for loops
        for(PuzzlePiece piece : pieces)
        {
            g.fillArc(piece.x, piece.y, width, height, 0, 360);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
        lastMouseLocation = e.getPoint();
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // sort of works, lots of lag involved, possible wrong logic causing it to not work as well
        if ( e.getX() <= pieces.get(0).x + width/2 && e.getX() >= pieces.get(0).x - width/2 
                && e.getY() <= pieces.get(0).y + height/2 && e.getY() >= pieces.get(0).y - height/2 ) 
        {
            int diffX = lastMouseLocation.x - e.getPoint().x;
            int diffY = lastMouseLocation.y - e.getPoint().y;
        
            pieces.get(0).x -= diffX;
            pieces.get(0).y -= diffY;

        
        
            lastMouseLocation = e.getPoint();
            repaint();
       
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       
    }
    
    
    
    
}