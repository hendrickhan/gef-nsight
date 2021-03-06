/*******************************************************************************
 * Copyright (c) 2004, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.gef.examples.ediagram.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.RetargetAction;

import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.DeleteRetargetAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.gef.ui.actions.ZoomInRetargetAction;
import org.eclipse.gef.ui.actions.ZoomOutRetargetAction;

import org.eclipse.gef.examples.ediagram.EDiagramImages;

/**
 * @author Pratik Shah
 * @since 3.1
 */
public class EDiagramActionBarContributor 
	extends ActionBarContributor
{

protected void buildActions() {
	addRetargetAction(new UndoRetargetAction());
	addRetargetAction(new RedoRetargetAction());
	addRetargetAction(new DeleteRetargetAction());
	addRetargetAction(new ZoomInRetargetAction());
	addRetargetAction(new ZoomOutRetargetAction());
	RetargetAction action = new RetargetAction(
			GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY, 
			null, IAction.AS_CHECK_BOX);
	action.setImageDescriptor(
			EDiagramImages.getImageDescriptor(EDiagramImages.SNAP));
	action.setDisabledImageDescriptor(
			EDiagramImages.getImageDescriptor(EDiagramImages.SNAP_DISABLED));
	action.setToolTipText("Enable Snap To Geometry");
	addRetargetAction(action);
}

public void contributeToToolBar(IToolBarManager toolBarManager) {
	super.contributeToToolBar(toolBarManager);
	toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
	toolBarManager.add(getAction(ActionFactory.REDO.getId()));
	toolBarManager.add(getAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY));
}

protected void declareGlobalActionKeys() {
	addGlobalActionKey(ActionFactory.PRINT.getId());
	addGlobalActionKey(ActionFactory.SELECT_ALL.getId());
}

}
