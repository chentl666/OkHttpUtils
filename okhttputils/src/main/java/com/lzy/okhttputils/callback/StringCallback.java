package com.lzy.okhttputils.callback;

import java.io.IOException;

import okhttp3.Response;

public abstract class StringCallback extends AbsCallback<String> {

    @Override
    public String parseNetworkResponse(Response response) throws Exception {
        return response.body().string();
    }
}
