import iryna.Inventory;
import iryna.OrderEndPoint;
import org.testng.Assert;
import org.testng.annotations.Test;
import iryna.Order;

import java.io.IOException;


        public class OrderTest {
            @Test
            public void getOrderIdTest() throws IOException {
                Order orderOne = new Order();
                orderOne.setId(5L);
                OrderEndPoint orderEndPoint = new OrderEndPoint();

                Order orderTwo=orderEndPoint.createOrder(orderOne);
                orderEndPoint.getOrderId(5L);
                Assert.assertEquals(orderOne.getId(),orderTwo.getId());
            }
            @Test
            public void getInventoryTest() {

                Inventory inventory = new Inventory();
                inventory.setSold(7);
                inventory.setPending(9);
                Assert.assertEquals(inventory.getSold(),7);
                Assert.assertEquals(inventory.getPending(),9);
            }
        @Test
        public void orderCreationTest() throws IOException {
            Order order = new Order();
            order.setId(456L);
            order.setPetId(987L);
            order.setQuantity(5);

            OrderEndPoint orderEndPoint = new OrderEndPoint();
            Order order1 = orderEndPoint.createOrder(order);

            Assert.assertEquals(order, order1);


        }
        @Test
        public void deleteOrderTest() throws IOException {
            Order order = new Order();
            order.setId(456L);
            order.setPetId(987L);
            OrderEndPoint orderEndPoint = new OrderEndPoint();
            orderEndPoint.deleteOrder(order.getId());
            Order deletedOrder = orderEndPoint.getOrderId(4L);
        Assert.assertNull(deletedOrder.getId());
        }
    }

