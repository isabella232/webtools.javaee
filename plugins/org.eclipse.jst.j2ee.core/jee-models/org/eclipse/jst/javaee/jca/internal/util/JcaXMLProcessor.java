/**
 * <copyright>
 * </copyright>
 *
 * $Id: JcaXMLProcessor.java,v 1.1 2009/10/15 18:52:02 canderson Exp $
 */
package org.eclipse.jst.javaee.jca.internal.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.eclipse.jst.javaee.jca.internal.metadata.JcaPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class JcaXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JcaXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		JcaPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the JcaResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new JcaResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new JcaResourceFactoryImpl());
		}
		return registrations;
	}

} //JcaXMLProcessor
