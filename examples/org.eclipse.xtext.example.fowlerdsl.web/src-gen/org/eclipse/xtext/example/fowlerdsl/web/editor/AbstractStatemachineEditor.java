/**
 * @Generated by DSLFORGE
 */
package org.eclipse.xtext.example.fowlerdsl.web.editor;

import org.dslforge.styledtext.BasicText;
import org.dslforge.xtext.common.BasicXtextEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.example.fowlerdsl.web.editor.widget.Statemachine;
import org.eclipse.xtext.example.fowlerdsl.web.internal.Activator;

public abstract class AbstractStatemachineEditor extends BasicXtextEditor {

	public AbstractStatemachineEditor() {
		super();
		setLanguageName(Activator.LANGUAGE_NAME);
		setInjector(Activator.getInstance().getInjector(Activator.LANGUAGE_NAME));
	}
	
	@Override
	protected BasicText createWidget(Composite parent, Font font) {
		Statemachine statemachineWidget = new Statemachine(parent, SWT.FILL);
		GridData textLayoutData = new GridData();
		textLayoutData.horizontalAlignment = SWT.FILL;
		textLayoutData.verticalAlignment = SWT.FILL;
		textLayoutData.grabExcessHorizontalSpace = true;
		textLayoutData.grabExcessVerticalSpace = true;
		statemachineWidget.setLayoutData(textLayoutData);
		statemachineWidget.setFont(font);
		statemachineWidget.setEditable(true);
		return statemachineWidget;
	}
}