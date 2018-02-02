package action;

import java.awt.Color;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

/**
 * The Color chooser action class.
 * 
 * @author Connor Lundberg
 * @version 5/16/2016
 */
public class ColorChooserAction extends AbstractAction 
{
    /**
     * Auto-generated ID.
     */
    private static final long serialVersionUID = 2773364947929804745L;
    
    /** The color. */
    private Color myColor;

    /**
     * ColorChooserAction constructor that takes a color.
     * 
     * @param theColor The default color
     */
    public ColorChooserAction(final Color theColor)
    {
        super();
        
        myColor = theColor;         
    }


    @Override
    public void actionPerformed(final ActionEvent theEvent)
    {
        myColor = JColorChooser.showDialog(null, "Select a color...", null);  
    }
    
    /**
     * Returns the color.
     * 
     * @return The color
     */
    public Color getColor()
    {
        return myColor;
    }

}
