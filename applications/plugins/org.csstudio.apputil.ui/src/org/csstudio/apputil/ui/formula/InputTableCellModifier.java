package org.csstudio.apputil.ui.formula;

import org.csstudio.platform.logging.CentralLogger;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Item;

/** Table cell modifier for tables with InputTableItem data.
 *  @author Kay Kasemir
 */
public class InputTableCellModifier implements ICellModifier
{
    private final TableViewer viewer;
    
    InputTableCellModifier(final TableViewer viewer)
    {
        this.viewer = viewer;
    }
    
	/** Variable name can change. */
	public boolean canModify(final Object element, final String col_title)
	{
        return col_title.equals(InputTableHelper.Column.VARIABLE.getTitle());
    }

	/** @return Returns the original cell value. */
    public Object getValue(final Object element, final String col_title)
    {
        InputItem entry = (InputItem) element;
        try
        {
            InputTableHelper.Column col = InputTableHelper.findColumn(col_title);
            return InputTableHelper.getText(entry, col);
        }
        catch (Exception ex)
        {
            CentralLogger.getInstance().error("Error", ex); //$NON-NLS-1$
        }
        return null;
    }

	/** Editor finished and tries to update element's property. */
	public void modify(Object element, final String property,
	        final Object value)
    {
        if (value == null)
            return;
        if (!property.equals(InputTableHelper.Column.VARIABLE.getTitle()))
            return;
        try
        {   // Note that it is possible for an SWT Item to be passed
            // instead of the model element.
            if (element instanceof Item)
                element = ((Item) element).getData();
            
            // Edit existing item
            final String new_var_name = (String) value;
            final InputItem entry = (InputItem) element;
            entry.setVariableName(new_var_name);
            viewer.refresh(element);
        }
        catch (Exception ex)
        {
            CentralLogger.getInstance().error("Error", ex); //$NON-NLS-1$
        }
    }
}
