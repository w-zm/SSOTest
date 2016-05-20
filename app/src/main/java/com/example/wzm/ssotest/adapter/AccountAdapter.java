package com.example.wzm.ssotest.adapter;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by wzm on 2016/5/11.
 */
public class AccountAdapter extends BaseAdapter {
    private Account[] accounts;
    private Context mContext;

    public AccountAdapter(Context context, Account[]accounts) {
        this.mContext = context;
        this.accounts = accounts;
    }

    @Override
    public int getCount() {
        return accounts == null ? 0 : accounts.length;
    }

    @Override
    public Object getItem(int position) {
        return accounts[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(mContext);
        String s = accounts[position].name + " | " + accounts[position].type + "";
        tv.setText(s);
        return tv;
    }
}
