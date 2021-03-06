/*
 * TCSS 305
 * Assignment 6a - Tetris
 */
package gui;


import action.ColorChooserAction;
import action.ToolAction;

import com.sun.glass.events.KeyEvent;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.WindowEvent;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.KeyStroke;

/**
 * Creates the menu bar.
 * 
 * @author Connor Lundberg
 * @version 5/11/2016
 */
public class MyMenuBar extends JMenuBar
{
    /** The default draw color. */
    public static final Color UW_PURPLE = new Color(51, 0, 111);
    
    /** The default fill color. */
    public static final Color UW_GOLD = new Color(232, 211, 162);
    
    /** The clear button constant for property changes. */
    public static final String CLEAR = "clear";
    
    /** The default line width. */
    private static final int LINE_WIDTH = 1;

    /** The max thickness. */
    private static final int THICKNESS_MAX = 20;

    /** The thickness slider spacing. */
    private static final int THICKNESS_SPACING = 5;

    /**
     * Auto-generated serial ID.
     */
    private static final long serialVersionUID = -7863806568418316202L;
    
    /** If the filled check box is marked. */
    private static boolean myIsFilled;

    /** If the shape can draw. */
    private boolean myCanDraw;

    /** The thickness slider. */
    private JSlider mySlider;

    /** The image. */
    private ImageIcon myIcon;

    /** The draw color. */
    private Color myDrawColor;

    /** The fill color. */
    private Color myFillColor;

    /** The clear menu item. */
    private JMenuItem myClearItem;

    /**
     * Creates the menu bar.
     * 
     * @param theFrame The Frame
     * @param theMenuLabels The menu labels
     * @param theToolActions The tool actions
     * @param theIcon The icon
     * @param theToolBar The tool bar
     */
    public MyMenuBar(final JFrame theFrame, final String[] theMenuLabels,
                     final List<ToolAction> theToolActions,
                     final ImageIcon theIcon, final MyToolBar theToolBar)
    {
        super();

        new ButtonGroup();

        myIcon = theIcon;
        
        myDrawColor = UW_PURPLE;
        myFillColor = UW_GOLD;
        
        buildFileMenu(theFrame, this, theMenuLabels);
        buildOptionsMenu(this, theMenuLabels, 
                         theToolActions.get(2).getTool().getClass().getSimpleName());
        buildToolsMenu(this, theMenuLabels, theToolActions);
        buildHelpMenu(this, theMenuLabels);
    }

    /**
     * Builds the Help menu.
     * 
     * @param theMenuBar The menu bar to add to
     * @param theMenuLabels The labels to use
     */
    private void buildHelpMenu(final JMenuBar theMenuBar, final String[] theMenuLabels)
    {
        final JMenu helpMenu = new JMenu(theMenuLabels[theMenuLabels.length - 1]);
        helpMenu.setMnemonic(KeyEvent.VK_H);

        final JMenuItem about = new JMenuItem("About...");
        about.setMnemonic(KeyEvent.VK_A);
        about.addActionListener((theEvent) ->
        {

            javax.swing.JOptionPane.showMessageDialog(this,
                                                      "TCSS 305 PowerPaint\n"
                                                            + "Spring 2016\nConnor Lundberg",
                                                      "About", JOptionPane.INFORMATION_MESSAGE,
                                                      myIcon);
        });

        helpMenu.add(about);

        theMenuBar.add(helpMenu);
    }

    /**
     * Builds the Tools menu.
     * 
     * @param theMenuBar The menu bar to add to
     * @param theMenuLabels The labels to add
     * @param theToolActions The actions to link to
     */
    private void buildToolsMenu(final JMenuBar theMenuBar, final String[] theMenuLabels,
                                final List<ToolAction> theToolActions)
    {
        final JMenu toolsMenu = new JMenu(theMenuLabels[2]);
        toolsMenu.setMnemonic(KeyEvent.VK_T);
        final ButtonGroup buttonGroup = new ButtonGroup();
        
        for (final ToolAction toolAction : theToolActions)
        {
            final JRadioButtonMenuItem radioButton = 
                            new JRadioButtonMenuItem(toolAction);
            radioButton.setText(toolAction.getTool().getClass().getSimpleName());

            buttonGroup.add(radioButton);
            toolsMenu.add(radioButton);
        }

        theMenuBar.add(toolsMenu);
    }

    /**
     * Returns myCanDraw.
     * 
     * @return myCanDraw
     */
    public boolean getCanDraw()
    {
        return myCanDraw;
    }

    /**
     * Builds the Options Menu and its items.
     * 
     * @param theMenuBar The menu bar to add to
     * @param theMenuLabels The labels to add
     * @param theString The string to set
     */
    private void buildOptionsMenu(final JMenuBar theMenuBar, final String[] theMenuLabels, 
                                  final String theString)
    {
        final JMenu optionsMenu = new JMenu(theMenuLabels[1]);
        optionsMenu.setMnemonic(KeyEvent.VK_O);

        final JMenu subMenu = new JMenu("Thickness");
        subMenu.setMnemonic(KeyEvent.VK_T);
        subMenu.add(createJSlider());

        optionsMenu.add(subMenu);

        optionsMenu.addSeparator();

        final MyImage drawIcon = new MyImage(myDrawColor);
        final JMenuItem chooseDraw = new JMenuItem("Draw Color...");
        final ColorChooserAction drawChooser = new ColorChooserAction(myDrawColor);
        chooseDraw.setIcon(drawIcon);
        chooseDraw.addActionListener((theEvent) ->
        {
            drawChooser.actionPerformed(theEvent);
            myDrawColor = drawChooser.getColor();
            drawIcon.setColor(myDrawColor);
        });

        chooseDraw.setMnemonic(KeyEvent.VK_D);
        optionsMenu.add(chooseDraw);    
        
        
       
        final JMenuItem chooseFill = new JMenuItem("Fill Color...");
        final ColorChooserAction fillChooser = new ColorChooserAction(myFillColor);
        final MyImage fillIcon = new MyImage(myFillColor);
        chooseFill.setIcon(fillIcon);
        chooseFill.addActionListener((theEvent) ->
        {
            fillChooser.actionPerformed(theEvent);
            myFillColor = fillChooser.getColor();
            fillIcon.setColor(myFillColor);
        });
        chooseFill.setMnemonic(KeyEvent.VK_F);
        optionsMenu.add(chooseFill);

        optionsMenu.addSeparator();

        final JCheckBoxMenuItem fill = new JCheckBoxMenuItem("Fill");
        fill.addActionListener((theEvent) ->
        {
            System.out.println("fill is selected: " + fill.isSelected());
            myIsFilled = fill.isSelected();

        });
        fill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
        optionsMenu.add(fill);

        theMenuBar.add(optionsMenu);
    }
    
    /**
     * Returns the myIsFilled value.
     * 
     * @return The myIsFilled value
     */
    public static boolean getMyIsFilled()
    {
        return myIsFilled;
    }

    /**
     * Returns the draw color value.
     * 
     * @return The draw color value
     */
    public Color getDrawColor()
    {
        return myDrawColor;
    }

    /**
     * Returns the fill color value.
     * 
     * @return The fill color value
     */
    public Color getFillColor()
    {
        return myFillColor;
    }

    /**
     * Creates the thickness JSlider.
     * 
     * @return The JSlider for thickness
     */
    private JSlider createJSlider()
    {
        mySlider = new JSlider();
        mySlider.setMinimum(0);
        mySlider.setMaximum(THICKNESS_MAX);
        mySlider.setMajorTickSpacing(THICKNESS_SPACING);
        mySlider.setMinorTickSpacing(1);
        mySlider.createStandardLabels(THICKNESS_SPACING);
        mySlider.setPaintTicks(true);
        mySlider.setPaintLabels(true);
        mySlider.setValue(LINE_WIDTH);

        return mySlider;
    }

    /**
     * Returns the Slider's current thickness.
     * 
     * @return The thickness
     */
    public int getThickness()
    {
        return mySlider.getValue();
    }

    /**
     * Builds the File menu and its items.
     * 
     * @param theFrame The frame
     * @param theMenuBar The menu bar to add to
     * @param theMenuLabels The menu labels to add
     */
    private void buildFileMenu(final JFrame theFrame, final JMenuBar theMenuBar, 
                               final String[] theMenuLabels)
    {
        final JMenu fileMenu = new JMenu(theMenuLabels[0]);
        fileMenu.setMnemonic(KeyEvent.VK_F);

        myClearItem = new JMenuItem("Clear");
        myClearItem.addActionListener((theEvent) ->
        {
            firePropertyChange(MyPanel.CLEAR_SHAPES, false, true);
        });
        myClearItem.setMnemonic(KeyEvent.VK_C);
        myClearItem.setEnabled(false);

        final JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener((theEvent) ->
        {
            theFrame.dispatchEvent(new WindowEvent(theFrame, WindowEvent.WINDOW_CLOSING));
        });
        exitItem.setMnemonic(KeyEvent.VK_X);

        fileMenu.add(myClearItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        theMenuBar.add(fileMenu);
    }
    
    /**
     * Sets the clear menu item to whatever the value is.
     *  
     * @param theValue The value to change to
     */
    public void setClearItem(final boolean theValue)
    {
        myClearItem.setEnabled(theValue);
    }
    
    /**
     * Creates a new Image that will be used for the Icon 
     * for the JColorChoosers.
     * 
     * @author Connor Lundberg
     * @version 5/18/2016
     */
    public class MyImage implements Icon
    {
        /**
         * The size of the shape.
         */
        private static final int THE_SIZE = 15;
        
        /**
         * The color.
         */
        private Color myColor;
        
        /**
         * Creates the image.
         * 
         * @param theColor The color to set
         */
        public MyImage(final Color theColor)
        {
            myColor = theColor;
        }
        
        @Override
        public int getIconHeight()
        {
            return THE_SIZE;
        }

        @Override
        public int getIconWidth()
        {
            return THE_SIZE;
        }

        @Override
        public void paintIcon(final Component theComp, final Graphics theGraphics, 
                              final int theX, final int theY)
        {
            theGraphics.setColor(myColor);
            theGraphics.fill3DRect(theX, theY, getIconWidth(), getIconHeight(), true);
        }
        
        /**
         * Sets the color.
         * 
         * @param theColor The new color
         */
        public void setColor(final Color theColor)
        {
            myColor = theColor;
        }

    }
    
}
