/*
 * Copyright 2017 inpwtepydjuf@gmail.com
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
package mmarquee.automation.uiautomation.conditions;

import com.sun.jna.platform.win32.Guid;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

/**
 * Exposes properties and methods that UI Automation client applications can use to retrieve information
 * about AND-based property condition.
 *
 * @author Mark Humphreys
 * Date 26/12/2017
 */
public interface IUIAutomationAndCondition extends IUIAutomationCondition {
    /**
     * The interface IID for QueryInterface et al
     */
    Guid.IID IID = new Guid.IID(
            "{A7D0AF36-B912-45FE-9855-091DDC174AEC}");

    int getChildCount(Integer childCount);
    int getChildren(/* SAFEARRAY */ PointerByReference childArray);
    int getChildrenAsNativeArray(/* SAFEARRAY */ PointerByReference childArray, IntByReference count);
}
