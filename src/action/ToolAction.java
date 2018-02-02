
package action;


import gui.MyPanel;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import tools.Tool;

/**
 * An Action for the Direction Buttons.
 * 
 * Actions are used when 2 or more components have the SAME behavior. This may
 * happen when you have functionality both in a ToolBar AND Menu. In this
 * example, the North/Up button is found in both the ToolBar and the Menu.
 * Instead of duplicating code for each, we use an Action to represent the state
 * of North/Up and the action performed when up is clicked.
 * 
 * https://docs.oracle.com/javase/tutorial/uiswing/misc/action.html
 * 
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/AbstractAction.html
 * 
 * @author Charles Bryan
 * @version Autumn 2015
 */
public class ToolAction extends AbstractAction
{

    /**
     * 
     */
    private static final long serialVersionUID = -2193928786463255262L;

    /** The direction for this action. */
    private final Tool myTool;

    /**
     * Creates the ToolAction.
     * 
     * @param theTool The Tool.
     */
    public ToolAction(final Tool theTool)
    {
        super(theTool.getClass().getSimpleName());
        
        myTool = theTool;
        putValue(SHORT_DESCRIPTION, myTool.getClass().getSimpleName());

        final int keyCode =
                        KeyStroke.getKeyStroke
                        (myTool.getClass().getSimpleName().charAt(0), 0).getKeyCode();
        putValue(MNEMONIC_KEY, keyCode);

        putValue(SELECTED_KEY, true);
    }
    
    /**
     * Gets the ToolAction's Tool.
     * 
     * @return The Tool
     */
    public Tool getTool()
    {
        return myTool;
    }


    @Override
    public void actionPerformed(final ActionEvent theEvent)
    {
        MyPanel.setTool(myTool);
    }

}
