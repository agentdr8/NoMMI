package com.dr8.xposed.nommi;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class Mod implements IXposedHookLoadPackage, IXposedHookZygoteInit {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        String targetpkg = "com.android.phone";
        if (loadPackageParam.packageName.equals(targetpkg)) {
            Object[] obj = new Object[6];
            obj[0] = "com.android.internal.telephony.Phone";
            obj[1] = Context.class;
            obj[2] = "com.android.internal.telephony.MmiCode";
            obj[3] = Message.class;
            obj[4] = AlertDialog.class;
//            obj[4] = "com.htc.widget.HtcAlertDialog";
            obj[5] = XC_MethodReplacement.DO_NOTHING;
            String targetcls = ".PhoneUtils";
            findAndHookMethod(targetpkg + targetcls, loadPackageParam.classLoader, "displayMMIComplete", obj);
            String TAG = "NoMMI";
            Log.w(TAG, "Bypassing MMI screen");
        }
    }

    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {

    }
}
