/******************************************************************************
 * Copyright (c) 2009 - 2015 IBM Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *****************************************************************************/
/**
 * 
 */
package com.ibm.wala.memsat.translation.sequential;

import com.ibm.wala.memsat.representation.ExpressionFactory;
import com.ibm.wala.memsat.translation.MethodTranslation;
import com.ibm.wala.memsat.translation.Translation;

import kodkod.ast.Formula;
import kodkod.instance.Bounds;

/**
 * Stores the translation of a single Wala method to Kodkod data structures.
 * 
 * @specfield method: CGNode // method that was translated
 * @specfield factory: ExpressionFactory // expression factory used for translation
 * @specfield bounds: Bounds // bounds generated by the translator
 * @specfield formula: Formula // the formula generated by the translator
 * @specfield context: MethodTranslation // translations of this.method's heap state, assertions, assumptions, etc.
 * 
 * @author Emina Torlak
 */
public final class SequentialTranslation implements Translation<MethodTranslation> {
	private final Formula formula;
	private final Bounds bounds;
	private final ExpressionFactory factory;
	private final MethodTranslation context;
	/**
	 * Constructs a translation from the given objects.
	 */
	SequentialTranslation(Formula formula, Bounds bounds, ExpressionFactory factory, MethodTranslation methodTranslation) {
		this.formula=formula;
		this.bounds=bounds;
		this.factory=factory;
		this.context=methodTranslation;
	}
	
	/**
	 * Returns the factory used for allocating relations to 
	 * unknown values (initial heap state, entry method arguments, etc.)
	 * and constants.
	 * @return this.factory
	 */
	public  ExpressionFactory factory() { return factory; }
	/**
	 * Returns this.bounds.
	 * @return this.bounds
	 */
	public  Bounds bounds() { return bounds; }
	/**
	 * Returns the formula constraining the initial and final 
	 * states of this.method's heap.
	 * @return this.formula
	 */
	public  Formula formula() { return formula; }
	/**
	 * Returns the translation context for this.formula and this.bounds.  The context
	 * contains additional information about the results of the translation]
	 * process, and it depends on whether this translation object was generated
	 * by a concurrent or a sequential translator. 
	 * @return translation context for this method.
	 */
	public MethodTranslation context() { return context; }
	
}
