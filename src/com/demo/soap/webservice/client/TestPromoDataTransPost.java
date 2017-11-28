package com.demo.soap.webservice.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 促销新老数据迁移工具类,
 * 不好使,最后还是用的postMan
 */
public class TestPromoDataTransPost {

    public static void main(String[] args) {

        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpPost postRequest = new HttpPost("http://team2-promo-web-web.dockeruat.lefile.cn/transSingle.jhtm");

        HttpEntity requestEntity = new StringEntity("173e855f-0dc0-40d4-853f-6184cb7217d7","UTF-8");

        //封装表单提交的参数内容,以名值对的方式
//        List<NameValuePair> paramList = new ArrayList<>();
//        paramList.add(new BasicNameValuePair("authdata","{\"level\":3,\"fas\":[\"a5188481-db6c-4572-8e7d-76b9c327a76a\",\"a36d6451-2320-4c14-93c0-187242c37298\",\"7d6361a0-12b3-11e7-815a-0050569f690d\",\"b4877aba-1390-11e7-815a-0050569f690d\",\"7102f80a-e544-4631-9f98-71c9e9296a5d\",\"a5188481-db6c-4572-8e7d-76b9c327a76a\"],\"email\":\"wangrq1@lenovo.com\",\"shops\":[\"5\",\"11\",\"10\",\"13\",\"8\",\"12\",\"14\",\"15\",\"9\",\"7\",\"1\",\"4\",\"3\"],\"user\":\"wangrq1\"}"));
//        paramList.add(new BasicNameValuePair("promoId","173e855f-0dc0-40d4-853f-6184cb7217d7"));

        try {
            //封装表单提交的实体对象,并设置编码集
           // HttpEntity requestEntity = new UrlEncodedFormEntity(paramList,"UTF-8");

            postRequest.setEntity(requestEntity);


            CloseableHttpResponse executeRsponse = client.execute(postRequest);

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

            EntityUtils.consume(requestEntity);

            client.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
}
