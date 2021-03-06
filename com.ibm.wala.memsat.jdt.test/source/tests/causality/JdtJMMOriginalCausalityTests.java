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
package tests.causality;

import java.io.IOException;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.ibm.wala.ide.tests.util.EclipseTestUtil;
import com.ibm.wala.memsat.Options;
import com.ibm.wala.memsat.jdt.test.JdtTestUtil;
import com.ibm.wala.memsat.tests.MiniaturTestsPlugin;
import com.ibm.wala.types.MethodReference;

import test.causality.JMMOriginalCausalityTests;

public class JdtJMMOriginalCausalityTests extends JMMOriginalCausalityTests {

	@Override
	protected Options getOptions(int maxSpeculations, Set<MethodReference> special) {
		Options options = super.getOptions(maxSpeculations, special);
		options.setEclipseProjectName(JdtTestUtil.PROJECT_NAME);
		return options;
	}

	@BeforeClass
	public static void beforeClass() throws IOException {
		EclipseTestUtil.importZippedProject(MiniaturTestsPlugin.getDefault(), JdtTestUtil.PROJECT_NAME, JdtTestUtil.PROJECT_ZIP, new NullProgressMonitor());
	}

	@AfterClass
	public static void afterClass() {
		EclipseTestUtil.destroyProject(JdtTestUtil.PROJECT_NAME);
	}

}
