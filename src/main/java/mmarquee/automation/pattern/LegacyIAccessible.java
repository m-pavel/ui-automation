/*
 * Copyright 20117 inpwtepydjuf@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mmarquee.automation.pattern;

import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.OleAuto;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;
import mmarquee.automation.AutomationException;
import mmarquee.automation.uiautomation.patterns.IUIAutomationLegacyIAccessiblePattern;
import mmarquee.automation.uiautomation.patterns.IUIAutomationLegacyIAccessiblePatternConverter;

public class LegacyIAccessible extends BasePattern {

    /**
     * Constructor for the value pattern
     */
    public LegacyIAccessible() {
        this.IID = IUIAutomationLegacyIAccessiblePattern.IID;
    }

    /**
     * The raw pattern.
     */
    private IUIAutomationLegacyIAccessiblePattern rawPattern;

    /**
     * Gets the pattern
     * @return The pattern
     * @throws AutomationException Something went wrong getting the pattern
     */
    private IUIAutomationLegacyIAccessiblePattern getPattern() throws AutomationException {
        if (this.rawPattern != null) {
            return this.rawPattern;
        } else {
            PointerByReference pbr = new PointerByReference();

            WinNT.HRESULT result0 = this.getRawPatternPointer(pbr);

            if (COMUtils.SUCCEEDED(result0)) {
                return this.convertPointerToInterface(pbr);
            } else {
                throw new AutomationException(result0.intValue());
            }
        }
    }

    /**
     * Converts a pointer to the appropriate interface.
     * @param unknown The pointer
     * @return The converted interface
     */
    public IUIAutomationLegacyIAccessiblePattern convertPointerToInterface(PointerByReference unknown) {
        return IUIAutomationLegacyIAccessiblePatternConverter.PointerToInterface(unknown);
    }

    /**
     * Gets the current value.
     * @return The current name
     * @throws AutomationException Automation issue
     */
    public String getCurrentValue() throws AutomationException {
        PointerByReference sr = new PointerByReference();

        final int res = this.getPattern().getCurrentName(sr);
        if (res != 0) {
            throw new AutomationException(res);
        }

        return sr.getValue().getWideString(0);
    }

    /**
     * Sets the current value.
     * @param value The value
     * @throws AutomationException Automation issue
     */
    public void setCurrentValue(String value) throws AutomationException {
        WTypes.BSTR sysAllocated = OleAuto.INSTANCE.SysAllocString(value);

        try {
            final int res = this.getPattern().setValue(sysAllocated);
            if (res != 0) {
                throw new AutomationException(res);
            }
        } finally {
            OleAuto.INSTANCE.SysFreeString(sysAllocated);
        }
    }
}
