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
package org.eclipse.rap.incubator.texteditor.demo.parts;

import org.eclipse.rap.incubator.texteditor.demo.IWorkbenchConstants;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * Configures the perspective layout. This class is contributed 
 * through the plugin.xml.
 */
public class BasicWorkbenchPerspective implements IPerspectiveFactory {
	
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
		layout.addPerspectiveShortcut(IWorkbenchConstants.ID_PERSPECTIVE);
		layout.setFixed(true);
		layout.addStandaloneView(IWorkbenchConstants.NAVIGATOR_VIEW_ID, true, IPageLayout.LEFT, 0.25f, editorArea);
		layout.getViewLayout(IWorkbenchConstants.NAVIGATOR_VIEW_ID).setCloseable(false);	
	}
}