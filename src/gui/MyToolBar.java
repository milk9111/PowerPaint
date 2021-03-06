
package gui;

import action.ToolAction;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import tools.Tool;

/**
 * Creates my ToolBar.
 * 
 * @author Connor Lundberg
 * @version 5/11/2016
 */
public class MyToolBar extends JToolBar
{
    /**
     * Auto-generated serial ID.
     */
    private static final long serialVersionUID = 523391518557742779L;
    
    

    /** If the mouse can draw. */
    private boolean myCanDraw;

    /** The toggle button group. */
    private ButtonGroup myToggleButtonGroup;

    /** The currently selected Tool. */
    private Tool myCurrentTool;

    /**
     * Creates the tool bar.
     * 
     * @param theToolActions The labels to use
     */
    public MyToolBar(final List<ToolAction> theToolActions)
    {
        super();
        myToggleButtonGroup = new ButtonGroup();

        createToolBar(theToolActions);
        
    }

    /**
     * Creates the menu bar.
     * 
     * @param theToolActions The map of tool actions to link to
     */
    private void createToolBar(final List<ToolAction> theToolActions)
    {
        myCurrentTool = theToolActions.get(0).getTool();
        myCanDraw = true;
        //System.out.println(theToolActions);
        for (final ToolAction toolAction : theToolActions)
        {
            final JToggleButton tempButton = createButton(toolAction);
            tempButton.addActionListener((theEvent) ->
            {
                
                myCurrentTool = toolAction.getTool();
                myCurrentTool.setIsFilled(MyMenuBar.getMyIsFilled());
                //tempButton.firePropertyChange("fill2", myCurrentTool.isFilled(), 
                //                              tempButton.isSelected());
            });
            myToggleButtonGroup.add(tempButton);
            add(tempButton);
        }
    }

    /**
     * Adds buttons to the given component.
     * 
     * @param theToolAction The action to link to
     *  
     * @return The created toggle button
     */
    private JToggleButton createButton(final ToolAction theToolAction)
    {
        final JToggleButton tempButton = new JToggleButton();
        tempButton.setAction(theToolAction);
        tempButton.setText(theToolAction.getTool().getClass().getSimpleName());
        // TODO change to dynamic mnemonics
        //tempButton.setMnemonic(theTool.getClass().getSimpleName().charAt(0));

        return tempButton;
    }

    /**
     * Returns the currently used tool.
     * 
     * @return The currently used tool
     */
    public Tool getCurrentTool()
    {
        return myCurrentTool;
    }

    /**
     * Returns the button group.
     * 
     * @return The button group
     */
    public ButtonGroup getButtonGroup()
    {
        return myToggleButtonGroup;
    }

    /**
     * Returns the myCanDraw field.
     * 
     * @return myCanDraw
     */
    public boolean getCanDraw()
    {
        return myCanDraw;
    }
}
