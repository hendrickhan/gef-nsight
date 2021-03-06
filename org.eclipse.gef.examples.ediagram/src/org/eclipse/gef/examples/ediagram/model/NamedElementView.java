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
package org.eclipse.gef.examples.ediagram.model;

import org.eclipse.emf.ecore.ENamedElement;

/**
 * @author Pratik Shah
 * @since 3.1
 * @model
 */
public interface NamedElementView 
	extends Node{

	/**
	 * @model
	 */
	ENamedElement getENamedElement();

	/**
	 * Sets the value of the '{@link org.eclipse.gef.examples.ediagram.model.NamedElementView#getENamedElement <em>ENamed Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ENamed Element</em>' reference.
	 * @see #getENamedElement()
	 * @generated
	 */
	void setENamedElement(ENamedElement value);

}
