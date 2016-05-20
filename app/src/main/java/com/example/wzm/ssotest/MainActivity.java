package com.example.wzm.ssotest;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.wzm.ssotest.adapter.AccountAdapter;
import com.example.wzm.ssotest.service.AccountService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("haha", "onCreate");

//        AccountManager accountManager = (AccountManager) getSystemService(ACCOUNT_SERVICE);
        AccountManager accountManager = AccountManager.get(this);
        Account[] accounts = accountManager.getAccounts();
        AccountAdapter adapter = new AccountAdapter(this, accounts);


        //Account[] account = AccountManager.get(this).getAccountsByType("com.wzm");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();
//        AccountManager.get(this).getAuthToken(accounts[1], "Manage your tasks", null, this, new AccountManagerCallback<Bundle>() {
//            @Override
//            public void run(AccountManagerFuture<Bundle> future) {
//                try
//                {
//                    Log.d("#", "&&&&&&&&&&&&" + future.getResult().getString(AccountManager.KEY_AUTHTOKEN) + "&&&&&&&&&&&&&&&&&&");
//                }
//                catch (Exception e)
//                {
//                    Log.e("hahaha", e.getMessage(), e);
//                }
//            }
//        }, null);
//        String token = accountManager.getUserData(accounts[0], AccountManager.KEY_AUTHTOKEN);
//        Log.e("haha", token);
        ListView lv = (ListView) findViewById(R.id.lv);
        if (lv != null) {
            lv.setAdapter(adapter);
        }

        startService(new Intent(this, AccountService.class));
    }
}
