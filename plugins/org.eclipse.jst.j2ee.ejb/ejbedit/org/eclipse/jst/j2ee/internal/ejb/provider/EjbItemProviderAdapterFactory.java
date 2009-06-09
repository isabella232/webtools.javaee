/*******************************************************************************
 * Copyright (c) 2003, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jst.j2ee.internal.ejb.provider;



import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.Disposable;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.jst.j2ee.ejb.EjbPackage;
import org.eclipse.jst.j2ee.ejb.internal.util.EjbAdapterFactory;


/**
 * This is the factory that is used to provide the interfaces needed to support
 * {@link org.eclipse.jface.viewers.Viewer}s. The adapters generated by this factory convert EMF
 * adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}. The adapters
 * also support property sheets, see {@link org.eclipse.ui.views.properties}. Note that most of the
 * adapters are shared among multiple instances.
 */
public class EjbItemProviderAdapterFactory extends EjbAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 */
	protected ComposedAdapterFactory parentAdapterFactory;
	/**
	 * This is used to implement {@link #IDisposable}.
	 */
	protected Disposable disposable = new Disposable();
	/**
	 * This is used to implement {@link #IChangeNotifier}.
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by
	 * {@link #isFactoryForType isFactoryForType}.
	 */
	protected Collection supportedTypes = new ArrayList();
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.MethodPermission}
	 * instances.
	 */
	protected MethodPermissionItemProvider methodPermissionItemProvider;
	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.eclipse.jst.j2ee.internal.internal.ejb.AssemblyDescriptor}instances.
	 */
	protected AssemblyDescriptorItemProvider assemblyDescriptorItemProvider;
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.MethodTransaction}
	 * instances.
	 */
	protected MethodTransactionItemProvider methodTransactionItemProvider;
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.EnterpriseBean}
	 * instances.
	 */
	protected EnterpriseBeanItemProvider enterpriseBeanItemProvider;
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.Session}
	 * instances.
	 */
	protected SessionItemProvider sessionItemProvider;
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.MessageDriven}
	 * instances.
	 */
	protected MessageDrivenItemProvider messageDrivenItemProvider;
	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.eclipse.jst.j2ee.internal.internal.ejb.MessageDrivenDestination}instances.
	 */
	protected MessageDrivenDestinationItemProvider messageDrivenDestinationItemProvider;
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.Entity}instances.
	 */
	protected EntityItemProvider entityItemProvider;
	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.eclipse.jst.j2ee.internal.internal.ejb.ContainerManagedEntity}instances.
	 */
	protected ContainerManagedEntityItemProvider containerManagedEntityItemProvider;
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.CMPAttribute}
	 * instances.
	 */
	protected CMPAttributeItemProvider cmpAttributeItemProvider;
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.CMRField}
	 * instances.
	 */
	protected CMRFieldItemProvider cmrFieldItemProvider;
	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.eclipse.jst.j2ee.internal.internal.ejb.EJBRelationshipRole}instances.
	 */
	protected EJBRelationshipRoleItemProvider ejbRelationshipRoleItemProvider;
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.EJBRelation}
	 * instances.
	 */
	protected EJBRelationItemProvider ejbRelationItemProvider;
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.Relationships}
	 * instances.
	 */
	protected RelationshipsItemProvider relationshipsItemProvider;
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.EJBJar}instances.
	 */
	protected EJBJarItemProvider eJBJarItemProvider;
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.RoleSource}
	 * instances.
	 */
	protected RoleSourceItemProvider roleSourceItemProvider;
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.Query}instances.
	 */
	protected QueryItemProvider queryItemProvider;
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.QueryMethod}
	 * instances.
	 */
	protected QueryMethodItemProvider queryMethodItemProvider;
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.MethodElement}
	 * instances.
	 */
	protected MethodElementItemProvider methodElementItemProvider;
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.ExcludeList}
	 * instances.
	 */
	protected ExcludeListItemProvider excludeListItemProvider;
	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.EJBMethodCategory}
	 * instances.
	 */
	protected EJBMethodCategoryItemProvider ejbMethodCategoryItemProvider;

	/**
	 * This constructs an instance.
	 */
	public EjbItemProviderAdapterFactory() {
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemPropertySource.class);
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(ITableItemLabelProvider.class);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		adaptContainerIfNecessary((EObject) notifier, type);
		return super.adapt(notifier, this);
	}

	@Override
	public Object adapt(Object object, Object type) {
		// This is a kludge to deal with enumerators, which crash the doSwitch.
		//
		if (object instanceof EObject && ((EObject) object).eClass() == null) {
			return null;
		}

		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class) || (((Class) type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	@Override
	public Adapter adaptNew(Notifier target, Object adapterType) {
		Adapter adapter = super.adaptNew(target, adapterType);
		disposable.add(adapter);
		return adapter;
	}

	/**
	 * This adds a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.AssemblyDescriptor}.
	 */
	@Override
	public Adapter createAssemblyDescriptorAdapter() {
		if (assemblyDescriptorItemProvider == null) {
			assemblyDescriptorItemProvider = new AssemblyDescriptorItemProvider(this);
		}

		return assemblyDescriptorItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.CMPAttribute}.
	 */
	@Override
	public Adapter createCMPAttributeAdapter() {
		if (cmpAttributeItemProvider == null) {
			cmpAttributeItemProvider = new CMPAttributeItemProvider(this);
		}

		return cmpAttributeItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.CMRField}.
	 */
	@Override
	public Adapter createCMRFieldAdapter() {
		if (cmrFieldItemProvider == null) {
			cmrFieldItemProvider = new CMRFieldItemProvider(this);
		}

		return cmrFieldItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.ContainerManagedEntity}.
	 */
	@Override
	public Adapter createContainerManagedEntityAdapter() {
		if (containerManagedEntityItemProvider == null) {
			containerManagedEntityItemProvider = new ContainerManagedEntityItemProvider(this);
		}

		return containerManagedEntityItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.EJBJar}.
	 */
	@Override
	public Adapter createEJBJarAdapter() {
		if (eJBJarItemProvider == null) {
			eJBJarItemProvider = new EJBJarItemProvider(this);
		}

		return eJBJarItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.EJBMethodCategory}.
	 */
	@Override
	public Adapter createEJBMethodCategoryAdapter() {
		if (ejbMethodCategoryItemProvider == null) {
			ejbMethodCategoryItemProvider = new EJBMethodCategoryItemProvider(this);
		}

		return ejbMethodCategoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.EJBJar}instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EJBJarItemProvider ejbJarItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.EJBRelation}.
	 */
	@Override
	public Adapter createEJBRelationAdapter() {
		if (ejbRelationItemProvider == null) {
			ejbRelationItemProvider = new EJBRelationItemProvider(this);
		}

		return ejbRelationItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.EJBRelationshipRole}.
	 */
	@Override
	public Adapter createEJBRelationshipRoleAdapter() {
		if (ejbRelationshipRoleItemProvider == null) {
			ejbRelationshipRoleItemProvider = new EJBRelationshipRoleItemProvider(this);
		}

		return ejbRelationshipRoleItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.EnterpriseBean}.
	 */
	@Override
	public Adapter createEnterpriseBeanAdapter() {
		if (enterpriseBeanItemProvider == null) {
			enterpriseBeanItemProvider = new EnterpriseBeanItemProvider(this);
		}

		return enterpriseBeanItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.Entity}.
	 */
	@Override
	public Adapter createEntityAdapter() {
		if (entityItemProvider == null) {
			entityItemProvider = new EntityItemProvider(this);
		}

		return entityItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.ExcludeList}.
	 */
	@Override
	public Adapter createExcludeListAdapter() {
		if (excludeListItemProvider == null) {
			excludeListItemProvider = new ExcludeListItemProvider(this);
		}

		return excludeListItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.MessageDriven}.
	 */
	@Override
	public Adapter createMessageDrivenAdapter() {
		if (messageDrivenItemProvider == null) {
			messageDrivenItemProvider = new MessageDrivenItemProvider(this);
		}

		return messageDrivenItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.MessageDrivenDestination}.
	 */
	@Override
	public Adapter createMessageDrivenDestinationAdapter() {
		if (messageDrivenDestinationItemProvider == null) {
			messageDrivenDestinationItemProvider = new MessageDrivenDestinationItemProvider(this);
		}

		return messageDrivenDestinationItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.MethodElement}.
	 */
	@Override
	public Adapter createMethodElementAdapter() {
		if (methodElementItemProvider == null) {
			methodElementItemProvider = new MethodElementItemProvider(this);
		}

		return methodElementItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.MethodPermission}.
	 */
	@Override
	public Adapter createMethodPermissionAdapter() {
		if (methodPermissionItemProvider == null) {
			methodPermissionItemProvider = new MethodPermissionItemProvider(this);
		}

		return methodPermissionItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.MethodTransaction}.
	 */
	@Override
	public Adapter createMethodTransactionAdapter() {
		if (methodTransactionItemProvider == null) {
			methodTransactionItemProvider = new MethodTransactionItemProvider(this);
		}

		return methodTransactionItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.Query}.
	 */
	@Override
	public Adapter createQueryAdapter() {
		if (queryItemProvider == null) {
			queryItemProvider = new QueryItemProvider(this);
		}

		return queryItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.QueryMethod}.
	 */
	@Override
	public Adapter createQueryMethodAdapter() {
		if (queryMethodItemProvider == null) {
			queryMethodItemProvider = new QueryMethodItemProvider(this);
		}

		return queryMethodItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.eclipse.jst.j2ee.internal.internal.ejb.ActivationConfigProperty}instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected ActivationConfigPropertyItemProvider activationConfigPropertyItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.ActivationConfigProperty}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createActivationConfigPropertyAdapter() {
		if (activationConfigPropertyItemProvider == null) {
			activationConfigPropertyItemProvider = new ActivationConfigPropertyItemProvider(this);
		}

		return activationConfigPropertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.jst.j2ee.internal.internal.ejb.ActivationConfig}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ActivationConfigItemProvider activationConfigItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.ActivationConfig}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createActivationConfigAdapter() {
		if (activationConfigItemProvider == null) {
			activationConfigItemProvider = new ActivationConfigItemProvider(this);
		}

		return activationConfigItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.Relationships}.
	 */
	@Override
	public Adapter createRelationshipsAdapter() {
		if (relationshipsItemProvider == null) {
			relationshipsItemProvider = new RelationshipsItemProvider(this);
		}

		return relationshipsItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.RoleSource}.
	 */
	@Override
	public Adapter createRoleSourceAdapter() {
		if (roleSourceItemProvider == null) {
			roleSourceItemProvider = new RoleSourceItemProvider(this);
		}

		return roleSourceItemProvider;
	}

	/**
	 * This creates an adapter for a {@link org.eclipse.jst.j2ee.internal.internal.ejb.Session}.
	 */
	@Override
	public Adapter createSessionAdapter() {
		if (sessionItemProvider == null) {
			sessionItemProvider = new SessionItemProvider(this);
		}

		return sessionItemProvider;
	}

	public void dispose() {
		disposable.dispose();
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	@Override
	public boolean isFactoryForType(Object type) {
		return super.isFactoryForType(type) || supportedTypes.contains(type);
	}

	/**
	 * This removes a listener.
	 * 
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier}and to {@link #parentAdapterFactory}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	protected void adaptContainerIfNecessary(EObject eObj, Object type) {
		if (eObj == null || eObj.eContainer() == null)
			return;
		EClass theEClass = eObj.eClass();
		if (theEClass.eContainer() == modelPackage) {
			switch (theEClass.getClassifierID()) {
				case EjbPackage.CMP_ATTRIBUTE :
					adapt(eObj.eContainer(), type);
					break;
			}
		}
	}

}
