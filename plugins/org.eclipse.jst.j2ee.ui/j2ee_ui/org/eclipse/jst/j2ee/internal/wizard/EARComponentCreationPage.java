/*
 * Created on Mar 17, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.eclipse.jst.j2ee.internal.wizard;

import org.eclipse.jst.j2ee.application.operations.J2EECreationDataModel;
import org.eclipse.jst.j2ee.internal.earcreation.EARComponentCreationDataModel;
import org.eclipse.jst.j2ee.internal.plugin.J2EEUIMessages;
import org.eclipse.jst.j2ee.internal.plugin.J2EEUIPlugin;
import org.eclipse.jst.j2ee.internal.plugin.J2EEUIPluginIcons;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wst.common.frameworks.operations.WTPOperationDataModel;

public class EARComponentCreationPage extends J2EEModuleCreationPage {

	private static final int SIZING_TEXT_FIELD_WIDTH = 250;
	
	/**
	 * @param model
	 * @param pageName
	 */
	public EARComponentCreationPage(EARComponentCreationDataModel  model, String pageName) {
		super(model, pageName);
		setTitle(J2EEUIMessages.getResourceString(J2EEUIMessages.EAR_COMPONENT_MAIN_PG_TITLE));
		setDescription(J2EEUIMessages.getResourceString(J2EEUIMessages.EAR_COMPONENT_MAIN_PG_DESC));
		setImageDescriptor(J2EEUIPlugin.getDefault().getImageDescriptor(J2EEUIPluginIcons.EAR_WIZ_BANNER));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jst.j2ee.internal.internal.internal.ui.wizard.J2EEModuleCreationPage#createTopLevelComposite(org.eclipse.swt.widgets.Composite)
	 */
	protected void addToAdvancedComposite(Composite advanced) {
		super.addToAdvancedComposite(advanced);
	}
	
	EARComponentCreationDataModel getEARProjectCreationDataModel() {
		return (EARComponentCreationDataModel) model;
	}

	//TODO: utility to handle additions
	protected String[] getValidationPropertyNames() {
		return new String[]{J2EECreationDataModel.PROJECT_NAME, 
				J2EECreationDataModel.MODULE_NAME, 
				J2EECreationDataModel.J2EE_MODULE_VERSION, 
				WTPOperationDataModel.NESTED_MODEL_VALIDATION_HOOK};
	}

	public void dispose() {
		super.dispose();
	}
}