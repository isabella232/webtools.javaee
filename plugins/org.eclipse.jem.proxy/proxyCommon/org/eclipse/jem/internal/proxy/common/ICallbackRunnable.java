/*******************************************************************************
 * Copyright (c) 2001, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/*


 */
package org.eclipse.jem.internal.proxy.common;

/**
 * Users would implement this as a runnable to 
 * send a callback request.
 */
public interface ICallbackRunnable {
	
	/**
	 * The actual run code.
	 */
	public Object run(ICallbackHandler handler) throws CommandException;

}
