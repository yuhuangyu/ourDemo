package com.test.accounts;

import android.accounts.Account;
import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.test.pushlive.LiveService;

/**
 * Created by Administrator on 2018/1/29 0029.
 */

public class SyncService extends Service {
    SyncAdapter syncAdapter;

    private static final String TAG = "sdk";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return syncAdapter.getSyncAdapterBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        syncAdapter = new SyncAdapter(getApplicationContext(), true);
    }

    static class SyncAdapter extends AbstractThreadedSyncAdapter {

        Context context;
        public SyncAdapter(Context context, boolean autoInitialize) {
            super(context, autoInitialize);
            this.context = context;
        }

        @Override
        public void onPerformSync(Account account, Bundle extras, String authority,
                                  ContentProviderClient provider, SyncResult syncResult) {
            Log.e(TAG,"同步账户");
            //与互联网 或者 本地数据库同步账户
            Intent service = new Intent(context,LiveService.class);
            context.startService(service);
        }
    }
}
