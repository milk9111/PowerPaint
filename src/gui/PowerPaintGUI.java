
package gui;

import action.ToolAction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import tools.Ellipse;
import tools.Line;
import tools.Pencil;
import tools.Rectangle;
import tools.Tool;

/**
 * This is the PowerPaintGUI class that makes the window and handles the events.
 * 
 * @author Connor Lundberg
 * @version 5/3/2016
 */
public class PowerPaintGUI extends JFrame
{
    /** An array of menu labels. */
    private static final String[] MENU_LABELS = {"File", "Options", "Tools", "Help"};

    /** the initial point. */
    private static final Point INITIAL_POINT = new Point(-1000, -500);

    /** The default draw color (UW Purple). */
    private static final Color DEFAULT_DRAW_COLOR = new Color(51, 0, 111);

    /** The default draw color (UW Gold). */
    private static final Color DEFAULT_FILL_COLOR = new Color(232, 211, 1);

    /** Auto-generated serial ID. */
    private static final long serialVersionUID = -6870003831272220140L;

    /** Default line width. */
    private static final int LINE_WIDTH = 1;

    /** The icon displayed. */
    private final ImageIcon myIcon;

    /** The list of tools to use. */
    private final List<Tool> myTools;

    /** The tool actions. */
    private final List<ToolAction> myToolActions;


    /** The panel. */
    private MyPanel myPanel;

    /**
     * Default constructor.
     */
    public PowerPaintGUI()
    {
        super();

        myIcon = new ImageIcon("images/pencil.gif");

        myTools = new ArrayList<Tool>();
        myTools.add(new Pencil(INITIAL_POINT, INITIAL_POINT, LINE_WIDTH, DEFAULT_DRAW_COLOR));
        myTools.add(new Line(INITIAL_POINT, INITIAL_POINT, LINE_WIDTH, DEFAULT_DRAW_COLOR));
        myTools.add(new Rectangle(INITIAL_POINT, INITIAL_POINT, LINE_WIDTH, DEFAULT_DRAW_COLOR,
                                  DEFAULT_FILL_COLOR, false));
        myTools.add(new Ellipse(INITIAL_POINT, INITIAL_POINT, LINE_WIDTH, DEFAULT_DRAW_COLOR,
                                DEFAULT_FILL_COLOR, false));

        myToolActions = new ArrayList<ToolAction>();

    }

    /**
     * The start method that sets up the entire GUI.
     */
    public void start()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("PowerPaint");
        setLayout(new BorderLayout());
        setJFrame();
        setIconImage(myIcon.getImage());

        for (final Tool tool : myTools)
        {
            myToolActions.add(new ToolAction(tool));
        }

        final MyToolBar toolBar = new MyToolBar(myToolActions);
        final MyMenuBar menuBar = 
                        new MyMenuBar(this, MENU_LABELS, myToolActions, myIcon, toolBar);
        
        myPanel = new MyPanel(this, myTools.get(0), toolBar, menuBar);

        setJMenuBar(menuBar);
        add(toolBar, BorderLayout.SOUTH);

        myPanel.addPropertyChangeListener(new PropertyChangeListener()
        {
            
            @Override
            public void propertyChange(final PropertyChangeEvent theEvent)
            {
                
                if (MyMenuBar.CLEAR.equals(theEvent.getPropertyName()))
                {
                    System.out.println("inside myPanel");
                    System.out.println(theEvent.getSource());
                    System.out.println();
                    menuBar.setClearItem((boolean) theEvent.getNewValue());
                }
                

            }
        });

        menuBar.addPropertyChangeListener(new PropertyChangeListener()
        {

            @Override
            public void propertyChange(final PropertyChangeEvent theEvent)
            {
                
                if (MyPanel.CLEAR_SHAPES.equals(theEvent.getPropertyName()))
                {
                    System.out.println("inside menuBar");
                    System.out.println(theEvent.getSource());
                    System.out.println();
                    myPanel.clearShapes();
                }
            }

        });

        setLocation(0, 0);
        pack();
        setVisible(true);
    }

    /**
     * Sets the JFrame.
     */
    private void setJFrame()
    {
        pack();
        setMinimumSize(getSize());
    }
}
