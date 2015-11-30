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
package org.eclipse.rap.incubator.styledtext;

import java.util.EventListener;

import org.eclipse.rap.json.JsonObject;

public interface IClientRequestListener extends EventListener {
	
	void reparse(JsonObject properties);
	
	void validate(JsonObject properties);
	
	void save(JsonObject properties);
}