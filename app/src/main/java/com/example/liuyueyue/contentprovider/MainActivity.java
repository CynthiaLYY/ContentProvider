package com.example.liuyueyue.contentprovider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import static android.provider.ContactsContract.*;
import static android.provider.ContactsContract.CommonDataKinds.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*ContentResolver cr = getContentResolver();
        Cursor c = cr.query(Contacts.CONTENT_URI,
                new String[]{Contacts._ID, Contacts.DISPLAY_NAME},null,null,null);
        //根据联系人id查询出联系人电话号码
        if(c!=null){
            while(c.moveToNext()){
                int id = c.getInt(c.getColumnIndex("_id"));
                Log.i("info","_id:"+id);
                Log.i("info","name:"+c.getString(c.getColumnIndex("display_name")));
                Cursor c1 = cr.query(Phone.CONTENT_URI, new String[]{Phone.NUMBER,
                               Phone.CONTENT_TYPE}, Phone.CONTACT_ID+"="+id,null,null);
                if(c1!=null){
                    while (c1.moveToNext()){
                        int type = c1.getColumnIndex(Phone.TYPE);
                        if(type == Phone.TYPE_HOME){
                            Log.i("info","家庭电话"+c1.getString(c1.getColumnIndex(Phone.NUMBER)));
                        }else if(type == Phone.TYPE_MOBILE){
                            Log.i("info","手机"+c1.getString(c1.getColumnIndex(Phone.NUMBER)));
                        }
                    }
                    c1.close();
                }
                //根据联系人id取出联系人的邮箱地址
                Cursor c2 = cr.query(Email.CONTENT_URI,
                        new String[]{Email.DATA, Email.TYPE}, Email.CONTACT_ID+"="+id,null,null);
                if(c2!=null){
                    while(c2.moveToNext()){
                        int type = c2.getInt(c2.getColumnIndex(Email.DATA));
                        if(type == Email.TYPE_WORK){
                            Log.i("info","工作邮箱："+c2.getString(c2.getColumnIndex(Email.DATA)));
                        }
                    }
                    c2.close();
                }
            }
            c.close();
        }*/
        ContentResolver cr = getContentResolver();
        //向联系人中插入数据
        ContentValues values = new ContentValues();
        Uri uri = cr.insert(RawContacts.CONTENT_URI,values);
       Long raw_contact_id =  ContentUris.parseId(uri);
        values.clear();
        //插入人名
        values.put(StructuredName.RAW_CONTACT_ID,raw_contact_id);
        values.put(StructuredName.DISPLAY_NAME,"张三");
        values.put(StructuredName.MIMETYPE,StructuredName.CONTENT_ITEM_TYPE);
        uri = cr.insert(Data.CONTENT_URI,values);
        //插入电话信息
        values.clear();
        values.put(Phone.RAW_CONTACT_ID,raw_contact_id);
        values.put(Phone.NUMBER,"13250567478");
        values.put(Phone.MIMETYPE,Phone.CONTENT_ITEM_TYPE);
        uri = cr.insert(Data.CONTENT_URI,values);
    }


}
