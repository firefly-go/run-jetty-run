/*
 * $Id$
 * $HeadURL$
 *
 * ==============================================================================
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package runjettyrun;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.EnvironmentTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.sourcelookup.SourceLookupTab;
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaArgumentsTab;
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaClasspathTab;
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaJRETab;

public class JettyLaunchConfigurationTabGroup extends
		AbstractLaunchConfigurationTabGroup {

	public JettyLaunchConfigurationTabGroup() {
	}

	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		JavaClasspathTab jct = new JavaClasspathTab(){
			public void initializeFrom(ILaunchConfiguration configuration) {
				super.initializeFrom(configuration);
				fClasspathViewer.expandToLevel(3);
			}
		};

		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new RunJettyRunTab(), new JavaArgumentsTab(), new JavaJRETab(),
				jct, new SourceLookupTab(),
				new EnvironmentTab(), new CommonTab() };
		setTabs(tabs);
	}
}