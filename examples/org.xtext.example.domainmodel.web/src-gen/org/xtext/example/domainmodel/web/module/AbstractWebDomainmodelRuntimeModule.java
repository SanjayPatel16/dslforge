/**
 * @Generated by DSLFORGE
 */
package org.xtext.example.domainmodel.web.module;

import org.dslforge.xtext.common.shared.SharedModule;

import com.google.inject.Binder;

public abstract class AbstractWebDomainmodelRuntimeModule extends SharedModule {

	@Override
	public void configure(Binder binder) {
		System.out.println("[DSLFORGE] - Configuring module " + this.getClass().getName());
		super.configure(binder);
	}
}
	