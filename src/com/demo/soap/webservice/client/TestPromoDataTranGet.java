package com.demo.soap.webservice.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 促销新老数据迁移工具类
 * 不好使
 */
public class TestPromoDataTranGet {

    public static void main(String[] args) {

        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpGet getRequest = new HttpGet("http://team2-promo-web-web.dockeruat.lefile.cn/transSingle.jhtm?promoId=173e855f-0dc0-40d4-853f-6184cb7217d7");

        try {

            CloseableHttpResponse executeRsponse = client.execute(getRequest);

            if(executeRsponse == null){
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>请求响应为空!!>>>>>>>>>>>>>>>>>>>>>>>");
            }
            if(executeRsponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = executeRsponse.getEntity();
                System.out.println("响应结果>>>>>>>>>>>>>>>>"+entity.toString());
                System.out.println(EntityUtils.toString(entity));
            }else{
                System.out.println(executeRsponse.getStatusLine().getStatusCode());
            }

            executeRsponse.close();
            client.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
}
