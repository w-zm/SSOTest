package com.example.wzm.ssotest.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.wzm.ssotest.Authenticator;

/**
 * Created by wzm on 2016/5/11.
 */
public class AccountService extends Service {
    private Authenticator mAuthenticator;

    public AccountService() {
        mAuthenticator = new Authenticator(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mAuthenticator.getIBinder();
    }
}
