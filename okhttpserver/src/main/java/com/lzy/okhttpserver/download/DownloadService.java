package com.lzy.okhttpserver.download;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;

import com.lzy.okhttputils.OkHttpUtils;

import java.util.List;

public class DownloadService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private static DownloadManager DOWNLOAD_MANAGER;

    /** start 方式开启服务，保存全局的下载管理对象 */
    public static DownloadManager getDownloadManager() {
        Context context = OkHttpUtils.getContext();
        if (!DownloadService.isServiceRunning(context)) context.startService(new Intent(context, DownloadService.class));
        if (DownloadService.DOWNLOAD_MANAGER == null) DownloadService.DOWNLOAD_MANAGER = DownloadManager.getInstance();
        return DOWNLOAD_MANAGER;
    }

    public static boolean isServiceRunning(Context context) {
        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(Integer.MAX_VALUE);
        if (serviceList == null || serviceList.size() == 0) return false;
        for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).service.getClassName().equals(DownloadService.class.getName())) {
                isRunning = true;
                break;
            }
        }
        return isRunning;
    }
}