/**
 * <copyright>
 * </copyright>
 *
 * $Id: ApplicationResourceImpl.java,v 1.2 2007/05/21 17:37:59 jsholl Exp $
 */
package org.eclipse.jst.javaee.application.internal.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.jst.javaee.application.Application;
import org.eclipse.jst.javaee.application.ApplicationDeploymentDescriptor;
import org.eclipse.jst.javaee.core.JEEXMLLoadImpl;
import org.eclipse.wst.common.internal.emf.resource.IRootObjectResource;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.eclipse.jst.javaee.application.internal.util.ApplicationResourceFactoryImpl
 * @generated
 */
public class ApplicationResourceImpl extends XMLResourceImpl implements IRootObjectResource {
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public ApplicationResourceImpl(URI uri) {
		super(uri);
	}
	protected XMLLoad createXMLLoad() {
		 return new JEEXMLLoadImpl(createXMLHelper());
	}

	
	protected XMLHelper createXMLHelper() {
		
		return new EarXMLHelperImpl(this);
	}
	/**
	 * Return the first element in the EList.
	 */
	public EObject getRootObject() {
		if (contents == null || contents.isEmpty())
			return null;
		Object root = getContents().get(0);
		if(root == null){
			return null;
		}
		return (EObject)((ApplicationDeploymentDescriptor)getRootObject()).getApplication();
	}
	/**
	 * Return the ear
	 */
	public Application getApplication() {
		return (Application)getRootObject();
	}

} //ApplicationResourceImpl
