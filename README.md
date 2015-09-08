# NoMMI
Xposed module to block MMI alert windows

Should work on most AOSP roms, and even skinned OEM roms as long as the dialer/phone app (com.android.phone) has the *displayMMIComplete()* method.
May require slight alteration to the parameters depending on if the rom uses skinned alert dialogs. See line [27](https://github.com/agentdr8/NoMMI/blob/master/nommi_mod/src/main/java/com/dr8/xposed/nommi/Mod.java#L27) for an example (to support HTC Sense)

Requires the [Xposed Framework](http://forum.xda-developers.com/xposed)

Tested on Lollipop 5.0.x and 5.1.x
