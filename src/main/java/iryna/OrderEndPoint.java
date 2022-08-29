package iryna;

import com.google.gson.Gson;
import okhttp3.*;
import java.io.IOException;


public class OrderEndPoint {
    public Order getOrderId(Long orderId) throws IOException {
        Gson gson = new Gson();
        Request request = new Request.Builder()
                .delete()
                .url("https://petstore.swagger.io/v2/store/order/" + orderId)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        Order newOrder = gson.fromJson(response.body().string(), Order.class);
        return newOrder;
    }

        public Inventory getInventory()throws IOException {
            Gson gson = new Gson();
            Request request = new Request.Builder()
                    .delete()
                    .url("https://petstore.swagger.io/v2/store/inventory")
                    .build();
            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();
            Inventory newInventory = gson.fromJson(response.body().string(),Inventory.class);
            return newInventory;
        }
    public Order createOrder(Order order) throws IOException {
        Gson gson = new Gson();
        String jsonString = gson.toJson(order);

        RequestBody requestBody = RequestBody.create(jsonString, MediaType.parse("applicatoion/json"));

        Request request = new Request.Builder()
                .post(requestBody)
                .url("https://petstore.swagger.io/v2/store/order")
                .build();

        Response response = new OkHttpClient().newCall(request).execute();
        if (response.code() != 200) {
            throw new RuntimeException("Request failed: " + response.body().string());
        }
        Order order1 = gson.fromJson(response.body().string(), Order.class);

        return order1;
    }

    public void deleteOrder(Long orderId) throws IOException {
        Request request = new Request.Builder()
                .delete()
                .url("https://petstore.swagger.io/v2/store/order/" + orderId)
                .build();

          new OkHttpClient().newCall(request).execute();
    }
}

