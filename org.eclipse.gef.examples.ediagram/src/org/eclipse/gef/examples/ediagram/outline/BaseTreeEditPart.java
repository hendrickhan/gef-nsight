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
package org.eclipse.gef.examples.ediagram.outline;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gef.editparts.AbstractTreeEditPart;


public abstract class BaseTreeEditPart extends AbstractTreeEditPart {
	protected Adapter modelListener = new AdapterImpl() {
		public void notifyChanged(Notification msg) {
			if (msg.getEventType() != Notification.RESOLVE
					&& msg.getEventType() != Notification.REMOVING_ADAPTER)
				handlePropertyChanged(msg);
		}
	};
	public BaseTreeEditPart(EObject model) {
		super(model);
	}
	public void activate() {
		super.activate();
		((EObject)getModel()).eAdapters().add(modelListener);
	}
	public void deactivate() {
		((EObject)getModel()).eAdapters().remove(modelListener);
		super.deactivate();
	}
	protected abstract void handlePropertyChanged(Notification msg);
}
