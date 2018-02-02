
package gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tools.Tool;

/**
 * Creates the PowerPaintGUI panel.
 * 
 * @author Connor Lundberg
 * @version 5/11/2016
 */
public class MyPanel extends JPanel implements MouseListener
{
    /** The tool not to fill (Line will not do it already). */
    public static final String DONT_FILL = "Pencil";
    
    /** The string constant for clearing the shapes. */
    public static final String CLEAR_SHAPES = "clear shapes";
    
    /** Drawing Panel preferred size. */
    private static final Dimension DRAWING_PANEL_SIZE = new Dimension(600, 300);

    /**
     * Auto-generated serial ID.
     */
    private static final long serialVersionUID = -5768044540221686839L;
    
    /** The current tool. */
    private static Tool myTool;

    /** The frame. */
    private final JFrame myFrame;

    /** A list of all the drawn shapes that will be repainted. */
    private final List<Tool> myDrawnShapes;

    /** The tool bar. */
    private final MyToolBar myToolBar;
    
    /** The menu bar. */
    private final MyMenuBar myMenuBar;
    

    /**
     * Creates the panel.
     * 
     * @param theFrame The frame to attach to
     * @param theFirstTool The first tool selected
     * @param theMenuBar The menu bar to reference
     * @param theToolBar The tool bar to reference
     * 
     */
    public MyPanel(final JFrame theFrame, final Tool theFirstTool, final MyToolBar theToolBar, 
                   final MyMenuBar theMenuBar)
    {
        super();

        myFrame = theFrame;

        new ButtonGroup();

        setTool(theFirstTool);
        
        myDrawnShapes = new ArrayList<Tool>();

        myToolBar = theToolBar;

        myMenuBar = theMenuBar;

        setDrawingPanel();
    }

    /**
     * Sets the drawing panel.
     */
    private void setDrawingPanel()
    {
        setLayout(new BorderLayout());
        setPreferredSize(DRAWING_PANEL_SIZE);
        setBackground(Color.WHITE);

        addMouseMotionListener(new MyMouseInputAdapter());
        addMouseListener(this);
   
        myFrame.add(this, BorderLayout.CENTER);
    }
    
    /**
     * Clears all shapes.
     */
    public void clearShapes()
    {
        myDrawnShapes.clear();
        myTool.setWidth(0);
        firePropertyChange(MyMenuBar.CLEAR, true, false);
        repaint();
    }
    
    /**
     * Sets the current tool.
     * 
     * @param theTool The new current tool
     */
    public static void setTool(final Tool theTool)
    {
        myTool = theTool;
    }

    /**
     * Returns the list of DrawnShapes.
     * 
     * @return The drawn shapes
     */
    public List<Tool> getDrawnShapes()
    {
        return myDrawnShapes;
    }

    /**
     * Paints the current path.
     * 
     * @param theGraphics The graphics context to use for painting.
     */
    public void paintComponent(final Graphics theGraphics)
    {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);

        
        for (final Tool tool : myDrawnShapes)
        {
            if (tool.isFilled())
            {
                g2d.setColor(tool.getFillColor());
                g2d.fill(tool.getShape());
            }
            g2d.setColor(tool.getBorderColor());
            g2d.setStroke(new BasicStroke(tool.getWidth()));
            g2d.draw(tool.getShape());

        }

        if (myTool.isFilled())
        {
            g2d.setColor(myMenuBar.getFillColor());
            g2d.fill(myTool.getShape());
        }
        g2d.setColor(myMenuBar.getDrawColor());
        
        if (myMenuBar.getThickness() > 0)
        {
            g2d.setStroke(new BasicStroke(myMenuBar.getThickness()));
            g2d.draw(myTool.getShape());
        } 
    }

    @Override
    public void mouseClicked(final MouseEvent theEvent)
    {
    }

    @Override
    public void mouseEntered(final MouseEvent theEvent)
    {
        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    }

    @Override
    public void mouseExited(final MouseEvent theEvent)
    {
    }

    @Override
    public void mousePressed(final MouseEvent theEvent)
    {

    }

    @Override
    public void mouseReleased(final MouseEvent theEvent)
    {
        if (myToolBar.getCanDraw() && myMenuBar.getThickness() > 0)
        {
            try
            {
                if (myTool.getClass().getSimpleName().equals(DONT_FILL))
                {
                    myTool.setIsFilled(false);
                }
                else
                {
                    myTool.setIsFilled(MyMenuBar.getMyIsFilled());
                }
                myTool.setDrawColor(myMenuBar.getDrawColor());
                myTool.setFillColor(myMenuBar.getFillColor());
                myTool.setWidth(myMenuBar.getThickness());
                myDrawnShapes.add(myTool.clone());
                
                firePropertyChange(MyMenuBar.CLEAR, false, true);
            }
            catch (final CloneNotSupportedException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * Inner class to handle Mouse Motion events.
     * 
     * @author Connor Lundberg
     * @version 5/6/2016
     */
    class MyMouseInputAdapter implements MouseMotionListener
    {
        @Override
        public void mouseDragged(final MouseEvent theEvent)
        {
            if (myToolBar.getCanDraw() && myMenuBar.getThickness() > 0)
            {
                myTool.setCurrentPoint(theEvent.getPoint());
                myTool.paint();
                repaint();
            }
        }

        @Override
        public void mouseMoved(final MouseEvent theEvent)
        {
            if (myToolBar.getCanDraw() && myMenuBar.getThickness() > 0)
            {   
                if (myTool.getClass().getSimpleName().equals(DONT_FILL))
                {
                    myTool.setIsFilled(false);
                }
                else
                {
                    myTool.setIsFilled(MyMenuBar.getMyIsFilled());
                }
                myTool.setInitialPoint(theEvent.getPoint());
            }
        }
    }
}
