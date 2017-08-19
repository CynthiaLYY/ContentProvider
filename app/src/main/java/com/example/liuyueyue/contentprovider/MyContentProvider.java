package com.example.liuyueyue.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by liuyueyue on 2017/8/16.
 */

public class MyContentProvider extends ContentProvider {

    //在ContentProvide创建后被调用
    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    //根据url查询出selection指定条件所匹配的全部记录，并且可以指定查询那些列，以什么方式排列
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return null;
    }

    @Nullable
    @Override
    //返回当前url的mini类型，如果url对应的数据可能包括多条记录
    //那么mini类型字符串就是以vnd.android.dir/开头
    //如果url对应的数据只有一条，该mini类型字符串就是以vvd.android.cursor.item/开头
    public String getType(@NonNull Uri uri) {
        return null;


    }

    @Nullable
    @Override
    //根据url增加Values记录
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    //根据url删除selection指定的记录
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    //根据url修改selection指定的条件所匹配的全部记录
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] selection) {
        return 0;
    }
}
