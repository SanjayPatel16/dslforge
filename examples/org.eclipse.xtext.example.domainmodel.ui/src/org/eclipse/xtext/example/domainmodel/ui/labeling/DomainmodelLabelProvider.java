/*
* generated by Xtext
*/
package org.eclipse.xtext.example.domainmodel.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
public class DomainmodelLabelProvider extends XbaseLabelProvider {

	@Inject
	public DomainmodelLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}
}
