/**
 * <copyright>
 *
 * Copyright (c) 2015 PlugBee. All rights reserved.
 * 
 * This program and the accompanying materials are made available 
 * under the terms of the Eclipse Public License v1.0 which 
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Amine Lajmi - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.rap.incubator.texteditor.demo;

import static org.eclipse.rap.rwt.RWT.getClient;

import org.eclipse.rap.incubator.texteditor.demo.presentation.BasicPresentationWorkbenchAdvisor;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.application.EntryPoint;
import org.eclipse.rap.rwt.client.service.StartupParameters;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.internal.util.PrefUtil;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * Basic Workbench UI entry point
 * 
 * @author Amine Lajmi
 *
 */
public class BasicWorkbench implements EntryPoint {

	private static final String DEMO_PRESENTATION = "org.eclipse.rap.incubator.texteditor.demo.presentation";

	public int createUI() {
	    StartupParameters service = getClient().getService( StartupParameters.class );
	    String parameter = service.getParameter("level");
	    System.out.println("level=" + parameter);
	    
		//RWT.getRequest().getParameter("level");
		ScopedPreferenceStore prefStore = (ScopedPreferenceStore) PrefUtil.getAPIPreferenceStore();
		String keyPresentationId = IWorkbenchPreferenceConstants.PRESENTATION_FACTORY_ID;
		String presentationId = prefStore.getString(keyPresentationId);
		WorkbenchAdvisor worbenchAdvisor = new BasicWorkbenchAdvisor();
		if (DEMO_PRESENTATION.equals(presentationId)) {
			worbenchAdvisor = new BasicPresentationWorkbenchAdvisor();
		}
		Display display = PlatformUI.createDisplay();
		int result = PlatformUI.createAndRunWorkbench(display, worbenchAdvisor);
		display.dispose();
		return result;
	}
}