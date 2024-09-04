package com.mavis.util;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

public class OkHttpUtils {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final OkHttpClient client = new OkHttpClient();

    /**
     * 发送 POST 请求
     *
     * @param url      请求地址
     * @param bodyData 请求体数据,可以是 Map 或 JSON 字符串
     * @return 响应结果
     */
    public static String doPost(String url, Object bodyData) {
        RequestBody requestBody;
        if (bodyData instanceof Map) {
            requestBody = RequestBody.create(JSON, new Gson().toJson(bodyData));
        } else if (bodyData instanceof String) {
            requestBody = RequestBody.create(JSON, (String) bodyData);
        } else {
            throw new IllegalArgumentException("请求参数必须是Map或JSON");
        }
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("错误代码:" + response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String doPostWithHeaders(String url, Object bodyData, Map<String, String> headers) {
        RequestBody requestBody;
        if (bodyData instanceof Map) {
            requestBody = RequestBody.create(JSON, new Gson().toJson(bodyData));
        } else if (bodyData instanceof String) {
            requestBody = RequestBody.create(JSON, (String) bodyData);
        } else {
            throw new IllegalArgumentException("请求参数必须是Map或JSON");
        }
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            request = request.newBuilder().addHeader(entry.getKey(), entry.getValue()).build();
        }
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("错误代码:" + response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}