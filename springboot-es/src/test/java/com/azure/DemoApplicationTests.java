package com.azure;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    @Test
    void createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("index2");
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    @Test
    void existIndex() throws IOException {
        GetIndexRequest request1 = new GetIndexRequest("index2");
        GetIndexRequest request2 = new GetIndexRequest("index3");
        Boolean response1 = client.indices().exists(request1, RequestOptions.DEFAULT);
        Boolean response2 = client.indices().exists(request2, RequestOptions.DEFAULT);
        System.out.println(response1);
        System.out.println(response2);
    }

    @Test
    void deleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("index2");
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());
    }
}
