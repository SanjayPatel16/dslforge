/**
 * @Generated by DSLFORGE
 */
package org.eclipse.sphinx.examples.xtext.hummingbird.web.editor;

import org.dslforge.styledtext.BasicText;
import org.dslforge.xtext.common.BasicXtextEditor;
import org.eclipse.sphinx.examples.xtext.hummingbird.web.editor.widget.Hummingbird;
import org.eclipse.sphinx.examples.xtext.hummingbird.web.internal.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public abstract class AbstractHummingbirdEditor extends BasicXtextEditor {

	public AbstractHummingbirdEditor() {
		super();
		setLanguageName(Activator.LANGUAGE_NAME);
		setInjector(Activator.getInstance().getInjector(Activator.LANGUAGE_NAME));
	}
	
	@Override
	protected BasicText createWidget(Composite parent, Font font) {
		Hummingbird hummingbirdWidget = new Hummingbird(parent, SWT.FILL);
		GridData textLayoutData = new GridData();
		textLayoutData.horizontalAlignment = SWT.FILL;
		textLayoutData.verticalAlignment = SWT.FILL;
		textLayoutData.grabExcessHorizontalSpace = true;
		textLayoutData.grabExcessVerticalSpace = true;
		hummingbirdWidget.setLayoutData(textLayoutData);
		hummingbirdWidget.setFont(font);
		hummingbirdWidget.setEditable(true);
		return hummingbirdWidget;
	}
}
