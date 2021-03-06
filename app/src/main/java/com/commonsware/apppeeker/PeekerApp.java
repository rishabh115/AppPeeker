/*
 Copyright (c) 2017 CommonsWare, LLC
 Licensed under the Apache License, Version 2.0 (the "License"); you may not
 use this file except in compliance with the License. You may obtain a copy
 of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
 by applicable law or agreed to in writing, software distributed under the
 License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 OF ANY KIND, either express or implied. See the License for the specific
 language governing permissions and limitations under the License.
 */

package com.commonsware.apppeeker;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.util.Log;

public class PeekerApp extends Application {
  public static boolean INSTANTIATE_ACTIVITY_CALLED=false;

  public Activity instantiateActivity(ClassLoader cl, String className, Intent intent) {
    INSTANTIATE_ACTIVITY_CALLED=true;
    Log.wtf("AppPeeker", "instantiateActivity() called!");

    return null;
  }
}
